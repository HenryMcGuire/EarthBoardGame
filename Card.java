//includes card object constructor
//all types of cards are in this class, separated by an integer variable denoting what kind of card it is
//has many parameters for every possible attribute a card can have, such as color, resource cost, resource gain, trunks, etc.
//some parameters will be left at 0 or empty dependent on the card type
//all functions will check the card type first to only perform actions relevant to that card
//for construction, references the cardList file which contains all possible cards and picks one at random
//contains an in-depth toString() function that displays all the information of the card without displaying irrelevant data
//can use a template for cards that have simple abilities so the same function can be called just with different values based on the card parameters

public class Card {
    private String name;
    private String type;
    public int sprouts;
    public int sproutMax;
    public int growth;
    public int growthMax;


    public Card(String n, String t) {
        name = n;
        type = t;
    }
    

    void ability() {
    	
    }

    @Override
    public String toString() {
        return name + " " + type;
    }
}
