public abstract class Player {

    protected String name;

    public Player(String name) {
        this.name = name;
    }

    protected String getName(){
        return name;
    }

    protected abstract int chooseAtribiuteToPlay();
    protected abstract boolean setPlayerTurn(boolean Turn);
    protected abstract void addCardToPlayerCardSet(Card card);
    protected abstract void playerGameTurn();

}