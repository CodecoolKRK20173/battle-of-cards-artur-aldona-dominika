import java.util.List;

public class UserPlayer extends Player {

    public UserPlayer(String name) {
        super(name);
    }

    public int userChoosedAtribiute;
    public List<Card> playerCardsSet;
    public boolean isPlayerTurnToPutCardOnTable;
    Card card;
    Table table;
    Inputs inputs;

    @Override
    protected int chooseAtribiuteToPlay() {
        String userInput = inputs.getUserInput();
        int userChoice = Integer.parseInt(userInput);

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