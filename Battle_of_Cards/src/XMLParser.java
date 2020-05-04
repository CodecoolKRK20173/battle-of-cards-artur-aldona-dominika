import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class XMLParser {

    public Document loadXMLDocument(String xmlPath) throws SAXException, IOException, ParserConfigurationException{

        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlPath);
        document.getDocumentElement().normalize();
        return document;
    }
}
