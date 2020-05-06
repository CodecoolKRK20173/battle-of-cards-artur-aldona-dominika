import java.util.List;

public class UserPlayer extends Player {

    public UserPlayer(String name) {
        super(name);
    }

    Card card;
    Table table;
    public int userChoosedAtribiute; // Input class will input user choice
    public List<Card> playerCardsSet;
    public boolean isPlayerTurnToPutCardOnTable;

    @Override
    protected int chooseAtribiuteToPlay() {
        int userChoice = 1; // tutaj uzyje klasy Input

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
    protected boolean setPlayerTurn(boolean Turn) {
        return isPlayerTurnToPutCardOnTable = Turn;
    }

    @Override
    protected void addCardToPlayerCardSet(Card card) {
        playerCardsSet.add(card);
    }

    @Override
    protected void playerGameTurn() {
    // jesli playerCardsSet dostanie dwie karty to setPlayerTurn(True)
        // jesli playerCardsSet nie dostanie karty po odjeciu jednej karty z playerCardsSet
        // to setPlayerTurn(False)
    }
}