public class Card {
    private String name;
    private String type;

    public Card(String n, String t) { //Default constructor for Card Class.
        name = n;
        type = t;
        if(type == "Fauna") {
        	FaunaCard();
        }
        else if(type == "Island") {
        	IslandCard();
        }
        else if(type == "Climate") {
        	ClimateCard();
        }
        else if(type == "Earth") {
        	EarthCard();
        }
        else {
        	System.out.println("Card has an invalid type.");
        	System.out.println("Only valid card types are: ");
        	System.out.println("Fauna");
        	System.out.println("Island");
        	System.out.println("Climate");
        	System.out.println("Earth");
        }
    }
    
    public void FaunaCard() { //Creates attributes for a Fauna-type card.
    	
    }
    
    public void IslandCard() { //Creates attributes for a Island-type card.
    	
    }
    
    public void ClimateCard() { //Creates attributes for a Climate-type card.
    	
    }
    
    public void EarthCard() { //Creates attributes for a Earth-type card.
    	
    }
    
    @Override
    public String toString() {
        return name + " " + type;
    }
}
