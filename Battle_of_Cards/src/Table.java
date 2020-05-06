import java.util.List;
import java.util.Collections;

public class Table {
    
    private XMLParser xml = new XMLParser();
    private List<Card> cards;

    public Table() {
        this.cards = xml.CardParser(xml.loadXMLDocument("src/resources/DragonLeague.xml"));
    }

    public List<Card> getCards() {
        return cards;
    }

    public void shuffle() {

        Collections.shuffle(this.cards);
    }
}