import java.util.ArrayList;

public abstract class Player {

    protected String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }


    abstract ArrayList<CardsCollection> takeCardFromEnemy();
    abstract ArrayList<CardsCollection> putCardOnGameTable();
    abstract void countYourCards();
    abstract void displayCardList();
    abstract void displayTheMostPowerfulCard();
    abstract void displayTheWeakestCard();


}