import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

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

//        return "NAME: " + getName() + "     \n" +
//                "INTELLIGENCE: " + getIntelligence() + "\n" +
//                 "STRENGTH: " + getStrength() + "\n" +
//                "ENDURANCE: " + getEndurance() + "\n" +
//                "AGILITY:      " + getAgility();

        String format = String.format("NAME:%1$s%nINTELLIGENCE:%2$d%nSTRENGTH:%3$d%n", getName(), getIntelligence(), getStrength());
        return format;

    }

    @Override
    public int compareTo(Card o) {
        return this.getName().compareTo(o.getName());
    }
}


