import java.util.ArrayList;

public class UserPlayer extends Player {

    public UserPlayer(String name) {
        super(name);
    }

    @Override
    ArrayList<CardsCollection> takeCardFromEnemy() {
        return null;
    }

    @Override
    ArrayList<CardsCollection> putCardOnGameTable() {
        return null;
    }

    @Override
    void countYourCards() {

    }

    @Override
    void displayCardList() {

    }

    @Override
    void displayTheMostPowerfulCard() {

    }

    @Override
    void displayTheWeakestCard() {

    }
}