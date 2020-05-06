import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {


    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        Prints print = new Prints();
        print.Menu();
        View printCards = new View();
        printCards.printCards();
        Engine gameStart = new Engine();
        gameStart.start();
    }
}
