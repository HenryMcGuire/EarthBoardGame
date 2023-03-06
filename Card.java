public class Card {
    private String name;
    private String type;

    public Card(String n, String t) { //Default constructor for Card Class.
        name = n;
        type = t;
        if(type == "Flora") {
        	FloraCard();
        }
        else if(type == "Fauna") {
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
        else if(type == "Ecosystem") {
        	EcosystemCard();
        }
        else if(type == "Event") {
        	EventCard();
        }
        else {
        	System.out.println("Card has an invalid type.");
        	System.out.println("Only valid card types are: ");
        	System.out.println("Flora");
        	System.out.println("Fauna");
        	System.out.println("Island");
        	System.out.println("Climate");
        	System.out.println("Earth");
        	System.out.println("Ecosystem");
        	System.out.println("Event");
        }
    }
    
    public void FloraCard() { //Creates attributes for a Flora-type card.
    	String plant_cost;
    	String victory_value;
    	String habitable_elements; 
    	String scientific_name;
    	String growth_space;
    	String maximum_growth_number;
    	String canopy_completion_vp;
    	int ability_color;
    	String ability1;
    	String ability2;
    	String flavour_text;
    }
    
    public void FaunaCard() { //Creates attributes for a Fauna-type card.
    	String victory_value; 
    	String scientific_name;
    	int ability_color;
    	String ability;
    	String flavour_text;
    }
    
    public void IslandCard() { //Creates attributes for a Island-type card.
    	String victory_value; 
    	String scientific_name;
    	int ability_color;
    	String ability;
    	String flavour_text;
    }
    
    public void ClimateCard() { //Creates attributes for a Climate-type card.
    	String victory_value; 
    	String scientific_name;
    	int ability_color;
    	String ability;
    	String flavour_text;
    }
    
    public void EarthCard() { //Creates attributes for a Earth-type card.
    	String plant_cost;
    	String victory_value;
    	String habitable_elements; 
    	String scientific_name;
    	int ability_color;
    	String ability1;
    	String ability2;
    	String flavour_text;
    }
    
    public void EcosystemCard() { //Creates attributes for a Ecosystem-type card.
    	String victory_value; 
    	String scientific_name;
    	int ability_color;
    	String ability;
    	String flavour_text;
    }
    
    public void EventCard() { //Creates attributes for a Event-type card.
    	String victory_value; 
    	String scientific_name;
    	int ability_color;
    	String ability;
    	String flavour_text;
    }
    
    @Override
    public String toString() {
        return name + " " + type;
    }
}
