import java.util.List;

public class Table {
    
    private XMLParser xml = new XMLParser();
    private List<Card> cards;

    public Table() {
        this.cards = xml.CardParser(xml.loadXMLDocument("src/resources/DragonLeague.xml"));
    }

}