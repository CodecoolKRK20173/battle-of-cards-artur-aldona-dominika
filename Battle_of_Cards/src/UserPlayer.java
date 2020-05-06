import java.util.List;

public class UserPlayer extends Player {

    public UserPlayer(String name) {
        super(name);
    }

    Card card;
    Table table;
    int userChoosedAtribiute; // Input class will input user choice
    List<Card> playerCardsSet;

    @Override
    protected int chooseAtribiuteToPlay() {
        int userChoice = 1;

        switch (userChoosedAtribiute){
            case 1:
                userChoice = card.getIntelligence();
                break;
            case 2:
                userChoice = card.getStrength();
                break;
            case 3:
                userChoice = card.getEndurance();
                break;
            case 4:
                userChoice = card.getAgility();
                break;
        }
        return userChoice;
    }

    @Override
    protected List<Card> takeCardsFromTable() {
        return null;
    }
}