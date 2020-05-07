import java.util.List;

public class UserPlayer extends Player {

    public UserPlayer(String name, List<Card> playerCardsSet) {
        super(name);
        this.playerCardsSet = playerCardsSet;
    }

    private int userChoosedAtribiute;
    private List<Card> playerCardsSet;
    private boolean isPlayerTurnToPutCardOnTable;
    Card card;
    Table table;
    Engine engine;

    @Override
    public int chooseAtribiuteToPlay() {
        int userChoice = Integer.parseInt(engine.getUserInput());

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
    public boolean setPlayerTurn(boolean Turn) {
        return isPlayerTurnToPutCardOnTable = Turn;
    }

    @Override
    public void addCardToPlayerCardSet(Card card) {
        playerCardsSet.add(card);
    }

    @Override
    public void playerGameTurn() {
//        int playerCardSetLenght = playerCardsSet.size();
//        int playerCardSetLenghtToIncrement = playerCardsSet.size();
//
//        if (playerCardSetLenght == playerCardSetLenghtToIncrement){
//            setPlayerTurn(true);
//        } else {
//            setPlayerTurn(false);
//        }

    }
}
