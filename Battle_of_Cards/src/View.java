import com.github.tomaslanger.chalk.Chalk;
import com.jakewharton.fliptables.FlipTable;
import org.apache.commons.lang3.StringUtils;
import org.xml.sax.SAXException;
import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class View {

    void Menu() {
        String[] headers = {ansi().fg(RED).a("WELCOME IN DRAGON LEAGUE") + "" + ansi().reset() + "\n" +
                ansi().fg(RED).a("CHOOSE AN OPTION:       ").bold().toString() + "" + ansi().reset()};
        String[][] data = {{"1. SEE ALL OF CARDS\n2. LET'S PLAY!"}};
        System.out.print(FlipTable.of(headers, data));
        //switch 1 --> printCards();
        //switch 2 --> play();
    }

    void printCards() throws IOException, SAXException, ParserConfigurationException {

        Table listOfCards = new Table();
        for (int i = 0; i < listOfCards.getCards().size(); i++) {
            String player = StringUtils.center("PLAYER", 41);
            String datas = listOfCards.getCards().get(i).toString();

            String[] headers = {Chalk.on(player).bold().magenta().toString()};
            String[][] data = {{datas.toString()}};
            System.out.print(FlipTable.of(headers, data));
        }
    }
}
//imie karty na srodku

//input imie uzytkownika
//dla playera 1-karta player 1 -->
//porownanie do karty player 2 - print obu kart obok siebie
