import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class XMLParser {

    public Document loadXMLDocument(String xmlPath) throws SAXException, IOException, ParserConfigurationException{

        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("DragonLeague.xml");
        document.getDocumentElement().normalize();
        return document;
    }

//    public List<View> CardParser(Document document) {
//        List<View> cards = new ArrayList<>();
//        NodeList nodeList = document.getElementsByTagName("Dragon");
//        for (int i = 0; i < nodeList.getLength(); i++) {
//            Node tempNode = nodeList.item(i);
//            Element tempElement = (Element) tempNode;
//            Node attributeNode = tempElement.getElementsByTagName("Attribute").item(0);
//            Element attributeElement = (Element) attributeNode;
//            cards.add(new View(attributeElement.getAttribute("name"), Integer.parseInt(attributeElement.getAttribute(("intelligence"))), Integer.parseInt(attributeElement.getAttribute(("strength"))), Integer.parseInt(attributeElement.getAttribute(("endurance"))),
//                    Integer.parseInt(attributeElement.getAttribute(("agility")))));
//        }
//        return cards;
//    }
}