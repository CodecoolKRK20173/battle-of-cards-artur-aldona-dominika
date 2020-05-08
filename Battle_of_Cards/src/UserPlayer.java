import java.util.List;

public class UserPlayer extends Player {

    public UserPlayer(String name, List<Card> playerCardsSet) {
        super(name);
        this.playerCardsSet = playerCardsSet;
    }

    private int userChoosedAtribiute;
    private List<Card> playerCardsSet;
    private boolean isPlayerTurnToPutCardOnTable;
<<<<<<< HEAD
    private boolean starts = false;
    Card card;
    Table table;
    Engine engine;
=======
    Card card;
    Table table;
    Engine engine;

    public UserPlayer(String firstPlayerName) {
        super(firstPlayerName);
    }
    //zrobilam ten konstruktor bo nie wiem co mialo byc w tym pierwszym jako argument-a potrzebowalam sprawdzic czy dziala
>>>>>>> 61eb5e7218a108ff3138e877ef196e42bf5ae0be

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

    public void starts() {
        this.starts = true;
    }

    public void doesNotStart() {
        this.starts = false;
    }

    public boolean ifStarts() {
        return starts;
    }

    public List<Card> getHand() {
        return playerCardsSet;
    }

    @Override
    public boolean setPlayerTurn(boolean Turn) {
        return isPlayerTurnToPutCardOnTable = Turn;
    }

    @Override
    public void addCardToPlayerCardSet(Card card) {
        playerCardsSet.add(card);
    }

<<<<<<< HEAD
    public void wonTheRound() {
        Card tempCard = this.playerCardsSet.get(0);
        this.playerCardsSet.remove(tempCard);
        this.playerCardsSet.add(tempCard);
    }

    public void lostTheRound() {
        playerCardsSet.remove(0);
    }
=======
>>>>>>> 61eb5e7218a108ff3138e877ef196e42bf5ae0be
}