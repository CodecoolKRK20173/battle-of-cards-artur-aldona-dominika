import com.github.tomaslanger.chalk.Ansi;
import com.github.tomaslanger.chalk.Chalk;
import com.jakewharton.fliptables.FlipTable;
import org.apache.commons.lang3.StringUtils;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class View {

    void printCards() throws IOException, SAXException, ParserConfigurationException {

        Table listOfCards = new Table();

        for (int i = 0; i < listOfCards.getCards().size(); i++) {
            String player = StringUtils.center("PLAYER", 30);
            String datas = listOfCards.getCards().get(i).toString();

            String[] headers = {Chalk.on(player).bold().bgMagenta().toString()};

            String[][] data = {{Chalk.on(datas).yellow().bold().toString()}};

            System.out.printf(FlipTable.of(headers, data));
        }
    }
}

//input imie uzytkownika
//dla playera 1-karta player 1 -->
//randomowe wyswietlanie karty-karta playera 1-input ktora umiejetnosc wykorzystac
//porownanie do karty player 2 - print obu kart obok siebie
//mozliwosc zobaczenia wszystkich kart przed gra
//