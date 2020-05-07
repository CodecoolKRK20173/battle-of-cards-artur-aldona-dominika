import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {


        View printCards = new View();
        printCards.Menu();
        printCards.printCards();
        Engine gameStart = new Engine();
        gameStart.start();

        Engine engine = new Engine();
        engine.start();
//        Prints print = new Prints();
//        print.Menu();
//        View printCards = new View();
//        printCards.printCards();
//        Engine gameStart = new Engine();
//        gameStart.start();
//        XMLParser test = new XMLParser();
//        test.loadXMLDocument("C:\\Users\\aldon\\Desktop\\battle-of-cards-artur-aldona-dominika\\Battle_of_Cards\\src\\resources\\DragonLeague.xml");
    }
}
