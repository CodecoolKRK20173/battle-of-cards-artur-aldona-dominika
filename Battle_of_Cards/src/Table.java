import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;
import java.util.Collections;

public class Table {
    
    private XMLParser xml = new XMLParser();
    private List<Card> cards;

    public Table() throws ParserConfigurationException, SAXException, IOException {


        //this.cards = xml.CardParser(xml.loadXMLDocument("C:\\Users\\aldon\\Desktop\\battle-of-cards-artur-aldona-dominika\\Battle_of_Cards\\src\\resources\\DragonLeague.xml"));

        

    // 914715d597c6a368a84401c7b92cdd1c9cf02c74

        this.cards = xml.CardParser(xml.loadXMLDocument("/home/samurai/IdeaProjects/battle-of-cards-artur-aldona-dominika/Battle_of_Cards/src"));
    }

    public List<Card> getCards() {
        return cards;
    }

    public void shuffle() {

        Collections.shuffle(this.cards);
    }
}