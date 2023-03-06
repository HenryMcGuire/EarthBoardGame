public class Card {
    private String name;
    private String type;
    private int plant_cost;
	private int victory_value;
	private String habitable_elements; 
	private String scientific_name;
	private String growth_space;
	private String maximum_growth_number;
	private String canopy_completion_vp;
	private int ability_color;
	private String ability1;
	private String ability2;
	private String flavour_text;

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
    	int plant_cost;
    	int victory_value;
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
    	String scientific_name;
    	int ability_color;
    	String ability;
    	String flavour_text;
    }
    
    public void IslandCard() { //Creates attributes for a Island-type card.
    	String scientific_name;
    	int ability_color;
    	String ability;
    	String flavour_text;
    }
    
    public void ClimateCard() { //Creates attributes for a Climate-type card.
    	String scientific_name;
    	int ability_color;
    	String ability;
    	String flavour_text;
    }
    
    public void EarthCard() { //Creates attributes for a Earth-type card.
    	int plant_cost;
    	int victory_value;
    	String habitable_elements; 
    	String scientific_name;
    	int ability_color;
    	String ability1;
    	String ability2;
    	String flavour_text;
    }
    
    public void EcosystemCard() { //Creates attributes for a Ecosystem-type card.
    	String scientific_name;
    	int ability_color;
    	String ability;
    	String flavour_text;
    }
    
    public void EventCard() { //Creates attributes for a Event-type card.
    	String scientific_name;
    	int ability_color;
    	String ability;
    	String flavour_text;
    }
    
    @Override
    public String toString() {
        if(type == "Flora") {
        	return "Name: " + name + "\n" + "Type: " + type + "\n" + "Plant cost: " +
        	plant_cost + "\n" + "Victory value: " + victory_value + "\n" + "Habitable elements: "
        	+ habitable_elements + "\n" + "Scientific name: " + scientific_name + "\n" +
        	"Growth space: " + growth_space + "\n" + "Maximum growth number: " + 
        	maximum_growth_number + " \n" + "Canopy completion victory points" + 
        	canopy_completion_vp + "\n" + "Ability color " + ability_color + "\n" +  
        	"Ability One: " + ability1 + "\n" + "Ability Two:" + ability2 + "\n" +
        	"Flavour Text: " + flavour_text + "\n";
        }
        else if(type == "Fauna") {
        	return "Name: " + name + "\n" + "Type: " + type + "\n" + "Plant cost: " +
                	plant_cost + "\n" + "Victory value: " + victory_value + "\n" + "Habitable elements: "
                	+ habitable_elements + "\n" + "Scientific name: " + scientific_name + "\n" +
                	"Growth space: " + growth_space + "\n" + "Maximum growth number: " + 
                	maximum_growth_number + " \n" + "Canopy completion victory points" + 
                	canopy_completion_vp + "\n" + "Ability color " + ability_color + "\n" +  
                	"Ability One: " + ability1 + "\n" + "Ability Two:" + ability2 + "\n" +
                	"Flavour Text: " + flavour_text + "\n";
        }
        else if(type == "Island") {
        	return "Name: " + name + "\n" + "Type: " + type + "\n" + "Plant cost: " +
                	plant_cost + "\n" + "Victory value: " + victory_value + "\n" + "Habitable elements: "
                	+ habitable_elements + "\n" + "Scientific name: " + scientific_name + "\n" +
                	"Growth space: " + growth_space + "\n" + "Maximum growth number: " + 
                	maximum_growth_number + " \n" + "Canopy completion victory points" + 
                	canopy_completion_vp + "\n" + "Ability color " + ability_color + "\n" +  
                	"Ability One: " + ability1 + "\n" + "Ability Two:" + ability2 + "\n" +
                	"Flavour Text: " + flavour_text + "\n";
        }
        else if(type == "Climate") {
        	return "Name: " + name + "\n" + "Type: " + type + "\n" + "Plant cost: " +
                	plant_cost + "\n" + "Victory value: " + victory_value + "\n" + "Habitable elements: "
                	+ habitable_elements + "\n" + "Scientific name: " + scientific_name + "\n" +
                	"Growth space: " + growth_space + "\n" + "Maximum growth number: " + 
                	maximum_growth_number + " \n" + "Canopy completion victory points" + 
                	canopy_completion_vp + "\n" + "Ability color " + ability_color + "\n" +  
                	"Ability One: " + ability1 + "\n" + "Ability Two:" + ability2 + "\n" +
                	"Flavour Text: " + flavour_text + "\n";
        }
        else if(type == "Earth") {
        	return "Name: " + name + "\n" + "Type: " + type + "\n" + "Plant cost: " +
                	plant_cost + "\n" + "Victory value: " + victory_value + "\n" + "Habitable elements: "
                	+ habitable_elements + "\n" + "Scientific name: " + scientific_name + "\n" +
                	"Growth space: " + growth_space + "\n" + "Maximum growth number: " + 
                	maximum_growth_number + " \n" + "Canopy completion victory points" + 
                	canopy_completion_vp + "\n" + "Ability color " + ability_color + "\n" +  
                	"Ability One: " + ability1 + "\n" + "Ability Two:" + ability2 + "\n" +
                	"Flavour Text: " + flavour_text + "\n";
        }
        else if(type == "Ecosystem") {
        	return "Name: " + name + "\n" + "Type: " + type + "\n" + "Plant cost: " +
                	plant_cost + "\n" + "Victory value: " + victory_value + "\n" + "Habitable elements: "
                	+ habitable_elements + "\n" + "Scientific name: " + scientific_name + "\n" +
                	"Growth space: " + growth_space + "\n" + "Maximum growth number: " + 
                	maximum_growth_number + " \n" + "Canopy completion victory points" + 
                	canopy_completion_vp + "\n" + "Ability color " + ability_color + "\n" +  
                	"Ability One: " + ability1 + "\n" + "Ability Two:" + ability2 + "\n" +
                	"Flavour Text: " + flavour_text + "\n";
        }
        else if(type == "Event") {
        	return "Name: " + name + "\n" + "Type: " + type + "\n" + "Plant cost: " +
                	plant_cost + "\n" + "Victory value: " + victory_value + "\n" + "Habitable elements: "
                	+ habitable_elements + "\n" + "Scientific name: " + scientific_name + "\n" +
                	"Growth space: " + growth_space + "\n" + "Maximum growth number: " + 
                	maximum_growth_number + " \n" + "Canopy completion victory points" + 
                	canopy_completion_vp + "\n" + "Ability color " + ability_color + "\n" +  
                	"Ability One: " + ability1 + "\n" + "Ability Two:" + ability2 + "\n" +
                	"Flavour Text: " + flavour_text + "\n";
        }
        else {
        	return "Name: " + name + "\n" + "Type: " + type + "\n" + "Plant cost: " +
                	plant_cost + "\n" + "Victory value: " + victory_value + "\n" + "Habitable elements: "
                	+ habitable_elements + "\n" + "Scientific name: " + scientific_name + "\n" +
                	"Growth space: " + growth_space + "\n" + "Maximum growth number: " + 
                	maximum_growth_number + " \n" + "Canopy completion victory points" + 
                	canopy_completion_vp + "\n" + "Ability color " + ability_color + "\n" +  
                	"Ability One: " + ability1 + "\n" + "Ability Two:" + ability2 + "\n" +
                	"Flavour Text: " + flavour_text + "\n";
        }
    }
}
