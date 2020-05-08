import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Scanner;

public class  Engine {

    private Scanner scanner = new Scanner(System.in);
    Table table = new Table();

    private String firstPlayerName;
    private String secondPlayerName;

    UserPlayer userPlayer1 = new UserPlayer(firstPlayerName);
    UserPlayer userPlayer2 = new UserPlayer(secondPlayerName);

    View view = new View();

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


    public void start() {
        int menuOption;

        do {
            while (true) {
                clearScreen();
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
                    System.out.println("New game");
                    break;
                case 2:
                    clearScreen();
                    System.out.println("Battle cards");
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


    public String playerNameUserSetup(){
        System.out.println("Enter Player 1 name: ");
        firstPlayerName = scanner.nextLine();
        System.out.println("Enter Player 2 name: ");
        secondPlayerName = scanner.nextLine();
        return firstPlayerName + secondPlayerName;
    }


    public void printUserName(UserPlayer userPlayerObject){
        System.out.println(userPlayerObject.getName());
    }

}