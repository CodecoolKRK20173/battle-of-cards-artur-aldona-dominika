import java.util.List;

public abstract class Player {

    public String name;
    private List<Card> playerCardsSet;

    public Player(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public abstract int chooseAtribiuteToPlay();
    public abstract boolean setPlayerTurn(boolean Turn);
    public abstract void addCardToPlayerCardSet(Card card);

}