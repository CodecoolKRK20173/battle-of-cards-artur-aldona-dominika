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

    public UserPlayer(String firstPlayerName) {
        super(firstPlayerName);
    }
    //zrobilam ten konstruktor bo nie wiem co mialo byc w tym pierwszym jako argument-a potrzebowalam sprawdzic czy dziala

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

}