
import org.xml.sax.SAXException;
import java.awt.Font;
import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import org.apache.commons.lang3.StringUtils;
import static org.fusesource.jansi.Ansi.Color.*;
import static org.fusesource.jansi.Ansi.ansi;

public class Card implements Comparable<Card> {

    private String name;
    private int intelligence;
    private int strength;
    private int endurance;
    private int agility;

    public Card(String name, int intelligence, int strength, int endurance,  int agility) {
        this.name = name;
        this.intelligence = intelligence;
        this.strength = strength;
        this.endurance = endurance;
        this.agility = agility;
    }

    public String getName() {
        return name;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public int getEndurance() {
        return endurance;
    }


    public int getAgility() {
        return agility;
    }

    @Override
    public String toString() {
        AsciiArts art = new AsciiArts();
        String gryphon = art.gryphon();
        String name = "NAME: ";
        String intelligence = "\t\tINTELLIGENCE:";
        String strength = "\t\tSTRENGTH:";
        String endurance = "\t\tENDURANCE:";
        String agility = "\t\tAGILITY:";
        String format = String.format(ansi().fg(MAGENTA).bold().a("%1$35s") + "\t\t\t    " + ansi().reset() + "\n" + gryphon +
                        ansi().fg(GREEN).a(intelligence) + "" + ansi().fg(MAGENTA).a("%2$27d\t") + "" + ansi().reset() + "\n" +
                        ansi().fg(GREEN).a(strength) + "" + ansi().fg(MAGENTA).a("%3$31d\t") + "" + ansi().reset() + "\n" +
                        ansi().fg(GREEN).a(endurance) + "" + ansi().fg(MAGENTA).a("%4$30d\t") + "" + ansi().reset() + "\n" +
                        ansi().fg(GREEN).a(agility) + "" + ansi().fg(MAGENTA).a("%5$32d\t") + "" + ansi().reset(),
                        getName(), getIntelligence(),
                        getStrength(), getEndurance(), getAgility());
        return format;
    }

    @Override
    public int compareTo(Card o) {
        return this.getName().compareTo(o.getName());
    }
}