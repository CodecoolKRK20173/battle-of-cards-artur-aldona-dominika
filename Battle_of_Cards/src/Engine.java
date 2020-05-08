import com.github.tomaslanger.chalk.Chalk;
import org.apache.commons.lang3.StringUtils;
import org.xml.sax.SAXException;
import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;
import com.jakewharton.fliptables.FlipTable;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.*;

public class  Engine {

    private Scanner scanner = new Scanner(System.in);
    Table table = new Table();

    View printCards = new View();
    UserPlayer firstPlayer;
    UserPlayer secondPlayer;



    public Engine() throws IOException, SAXException, ParserConfigurationException {
    }

    public String getUserInput() {
        String input = scanner.nextLine();
        System.out.println();
        return input;
    }

    void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


    public void start() throws ParserConfigurationException, SAXException, IOException {
        int menuOption;


        do {
            while (true) {
                clearScreen();
                printCards.Menu();
                System.out.print("Please select an option: ");
                try {
                    menuOption = Integer.parseInt(getUserInput());
                    break;
                } catch (NumberFormatException ne) {
                    System.out.println("Invalid input. Please try again!");
                }
            }
            switch (menuOption) {
                case 1:
                    printCards.printCards();
                    break;
                case 2:
                    clearScreen();
                    userPlayerSetup();
                    playerVsPlayer();
                    break;
                case 3:
                    clearScreen();
                    System.out.println("Scores");
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }
        while (menuOption != 0);
    }

    public void score() {
        String first = String.format(String.valueOf(ansi().fg(YELLOW).bold().a(this.firstPlayer.getName())));
        String second = String.format(String.valueOf(ansi().fg(YELLOW).bold().a(this.secondPlayer.getName())));
        System.out.println(first + ": " +
                this.firstPlayer.getHand().size() + ansi().reset()  + " | " + second + ": " +
                this.secondPlayer.getHand().size() + ansi().reset() + "\n");
    }

    public void userPlayerSetup() {

        System.out.println("Enter Player 1 name: ");
        String firstPlayerName = scanner.nextLine().toUpperCase();
        System.out.println("Enter Player 2 name: ");
        String secondPlayerName = scanner.nextLine().toUpperCase();

        firstPlayer = new UserPlayer(firstPlayerName, new ArrayList<>());
        secondPlayer = new UserPlayer(secondPlayerName, new ArrayList<>());

        firstPlayer.starts();

        table.shuffle();

        for (int i = 0; i < table.getCards().size(); i++) {
            if ((i + 1) % 2 == 1) {
                firstPlayer.addCardToPlayerCardSet(table.getCards().get(i));
            } else {
                secondPlayer.addCardToPlayerCardSet(table.getCards().get(i));
            }
        }
    }

    private UserPlayer round(UserPlayer firstPlayer, UserPlayer secondPlayer) {
        View card = new View();
        clearScreen();

        String player = StringUtils.center(firstPlayer.getName(), 50);
        String[] header = {Chalk.on(player).bold().magenta().toString()};
        String[][] data = {{firstPlayer.getHand().get(0).toString()}};
        List<Card> cardsToCompare = new ArrayList<>();
        int input;

        if (firstPlayer.getHand().size() != 0 && secondPlayer.getHand().size() != 0) {
            cardsToCompare.add(firstPlayer.getHand().get(0));
            cardsToCompare.add(secondPlayer.getHand().get(0));
        }
        while (true) {
            clearScreen();
            score();
            System.out.println(FlipTable.of(header, data));
            try {
                System.out.print("\n" + firstPlayer.getName() + " chooses an attribute: ");
                input = Integer.parseInt(getUserInput());
                if (input > 4) throw new NumberFormatException();
                break;
            } catch (NumberFormatException nfe) {
                continue;
            }
        }
        switch (input) {
            case 1:
                Collections.sort(cardsToCompare, intelligenceComparator);
                break;
            case 2:
                Collections.sort(cardsToCompare, strengthComparator);
                break;
            case 3:
                Collections.sort(cardsToCompare, enduranceComparator);
                break;
            case 4:
                Collections.sort(cardsToCompare, agilityComparator);
                break;
        }
        Card winnerCard = cardsToCompare.get(0);
        Card looserCard = cardsToCompare.get(1);


        String player1 = StringUtils.center(firstPlayer.getName(), 50);
        String player2 = StringUtils.center(secondPlayer.getName(), 50);
        String[] headers1 = {Chalk.on(player1).bold().magenta().toString()};
        String[][] data1 = {{winnerCard.toString()}};
        String[] headers2 = {Chalk.on(player2).bold().magenta().toString()};
        String[][] data2 = {{looserCard.toString()}};

        if (firstPlayer.getHand().get(0) == winnerCard) {
            firstPlayer.wonTheRound();
            secondPlayer.lostTheRound();
            firstPlayer.addCardToPlayerCardSet(looserCard);
            clearScreen();
            score();
            System.out.println(FlipTable.of(headers1, data1) + "\n" + FlipTable.of(headers2, data2));
            System.out.println("\n" + ansi().fg(BLUE).bold().a(firstPlayer.getName()) + " has won the round." + ansi().reset());
            promptEnterKey();
            return firstPlayer;
        } else {
            secondPlayer.wonTheRound();
            firstPlayer.lostTheRound();
            secondPlayer.addCardToPlayerCardSet(looserCard);
            secondPlayer.starts();
            firstPlayer.doesNotStart();
            clearScreen();
            score();
            System.out.println(FlipTable.of(headers2, data2) + "\n" + FlipTable.of(headers1, data1));
            System.out.println("\n" + ansi().fg(BLUE).bold().a(secondPlayer.getName()) + " has won the round." + ansi().reset());
            promptEnterKey();
            return secondPlayer;
        }
    }

    public void playerVsPlayer() {
        AsciiArts win = new AsciiArts();
        do {
            if (firstPlayer.ifStarts()) {
                round(firstPlayer, secondPlayer);
            } else {
                round(secondPlayer, firstPlayer);
            }

        } while (firstPlayer.getHand().size() != 0 && secondPlayer.getHand().size() != 0);

        if (secondPlayer.getHand().size() == 0) {
            System.out.println(firstPlayer.getName() + " has won the game!" + win.youWon());
        } else if (firstPlayer.getHand().size() == 0) {
            System.out.println(secondPlayer.getName() + " has won the game! + win.youWon()");
        }
        promptEnterKey();
    }

    void promptEnterKey () {
        System.out.println("\n Press \"ENTER\" to continue...");
        scanner.nextLine();
    }

    Comparator<Card> intelligenceComparator = new Comparator<Card>() {
        @Override
        public int compare(Card o1, Card o2) {
            if (o1.getIntelligence() < o2.getIntelligence()) {
                return 1;
            } else if ((o1.getIntelligence() > o2.getIntelligence())) {
                return -1;
            }
            return 0;
        }
    };

    Comparator<Card> strengthComparator = new Comparator<Card>() {
        @Override
        public int compare(Card o1, Card o2) {
            if (o1.getStrength() < o2.getStrength()) {
                return 1;
            } else if ((o1.getStrength() > o2.getStrength())) {
                return -1;
            }
            return 0;
        }
    };

    Comparator<Card> enduranceComparator = new Comparator<Card>() {
        @Override
        public int compare(Card o1, Card o2) {
            if (o1.getEndurance() < o2.getEndurance()) {
                return 1;
            } else if ((o1.getEndurance() > o2.getEndurance())) {
                return -1;
            }
            return 0;
        }
    };

    Comparator<Card> agilityComparator = new Comparator<Card>() {
        @Override
        public int compare(Card o1, Card o2) {
            if (o1.getAgility() < o2.getAgility()) {
                return 1;
            } else if ((o1.getAgility() > o2.getAgility())) {
                return -1;
            }
            return 0;
        }
    };

    public void printUserName(UserPlayer userPlayerObject){
        System.out.println(userPlayerObject.getName());
    }

}
