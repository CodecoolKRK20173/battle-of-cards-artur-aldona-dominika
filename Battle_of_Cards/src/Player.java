import java.util.List;

public abstract class Player {

    protected String name;

    public Player(String name) {
        this.name = name;
    }

    protected String getName(){
        return name;
    }

    protected abstract int chooseAtribiuteToPlay();
    protected abstract List<Card> takeCardsFromTable();

    // hand - lista kart ktore Player otrzymuje od table (16) pozniej bedzie wiecej, private
    // jesli do hand trafia dwie karty (wygrana) to jest ruch gracza (jakis boolean = True)
    // gracz ktory przegra nie dostaje dwoch kart (przegrana) to jest ruch przeciwnika (jakis boolean = Fase)
    // ....gracz decyduje jakim atrybutem bedzie rozgrywka np strengh (wywolanie metody jest w engine)
    // jesli przeciwnik wybral atrybut to gracz musi grac tym atrybutem
}