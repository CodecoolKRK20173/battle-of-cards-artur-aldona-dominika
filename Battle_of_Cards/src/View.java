import com.github.tomaslanger.chalk.Chalk;
import com.jakewharton.fliptables.FlipTable;
import org.apache.commons.lang3.StringUtils;
import org.xml.sax.SAXException;
import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class View {

    public void Menu() {

        AsciiArts art = new AsciiArts();
        String[] headers =
                        {String.format(ansi().fg(GREEN).bold().a("%1$s") + " " + ansi().reset() + "\n" +
                                        art.centaur() + "\n" +
                        ansi().fg(GREEN).bold().a("\t%2$s\t   ") + "" + ansi().reset(),
                        "WELCOME IN DRAGON LEAGUE", "CHOOSE AN OPTION: ").toString()};

        String[][] data =
                        {{String.format(ansi().bold().fg(GREEN).a("\t%1$s\t   ") + "" + ansi().reset()+ "\n" +
                        ansi().bold().fg(GREEN).a("\t%2$s\t\t   ") + "" + ansi().reset() + "\n" +
                        ansi().bold().fg(GREEN).a("\t%3$s\t\t   ") + "" + ansi().reset() + "\n" +
                        ansi().bold().fg(GREEN).a("\t%4$s\t\t\t") + "" + ansi().reset(),
                        "1. SEE ALL OF CARDS",
                        "2. LET'S PLAY!","3. SHOW SCORES ", "4. EXIT ").toString()}};

        System.out.print(FlipTable.of(headers, data).toString());
//        System.out.println(art.youWon());
    }

    public void printCards() throws IOException, SAXException, ParserConfigurationException {

        Table listOfCards = new Table();
        Engine name = new Engine();
        for (int i = 0; i < listOfCards.getCards().size(); i++) {
            String player = StringUtils.center(name.getUserInput().toUpperCase(), 50);
            String datas = listOfCards.getCards().get(i).toString();

            String[] headers = {Chalk.on(player).bold().magenta().toString()};
            String[][] data = {{datas}};

                System.out.print(FlipTable.of(headers, data));

        }
    }
}
