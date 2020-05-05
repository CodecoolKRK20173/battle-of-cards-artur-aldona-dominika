public class Card {

    private String name;
    private int intelligence;
    private int strength;
    private int endurance;
    private int agility;

    public Card(String name, int intellingence, int strength, int endurance,  int agility) {
        this.name = name;
        this.intelligence = intellingence;
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
}