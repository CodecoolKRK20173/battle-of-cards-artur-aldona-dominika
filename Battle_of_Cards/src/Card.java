
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.fusesource.jansi.Ansi.Color.*;
import static org.fusesource.jansi.Ansi.ansi;

public class Card implements Comparable<Card>{

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

        String name = "NAME: ";
        String intelligence = "INTELLIGENCE: ";
        String strength = "STRENGTH: ";
        String endurance = "ENDURANCE: ";
        String agility = "AGILITY: ";
        String format = String.format(ansi().fg(GREEN).a(name) + "" + ansi().fg(YELLOW).a("%1$35s") + "" + ansi().reset() + "\n" +
                        ansi().fg(GREEN).a(intelligence) + "" + ansi().fg(YELLOW).a("%2$27d") + "" + ansi().reset() + "\n" +
                        ansi().fg(GREEN).a(strength) + "" + ansi().fg(YELLOW).a("%3$31d") + "" + ansi().reset() + "\n" +
                        ansi().fg(GREEN).a(endurance) + "" + ansi().fg(YELLOW).a("%4$30d") + "" + ansi().reset() + "\n" +
                        ansi().fg(GREEN).a(agility) + "" + ansi().fg(YELLOW).a("%5$32d") + "" + ansi().reset(),
                        getName(), getIntelligence(),
                        getStrength(), getEndurance(), getAgility());

        return format;
    }

    @Override
    public int compareTo(Card o) {
        return this.getName().compareTo(o.getName());
    }
}