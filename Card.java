//
// Group 3
// 03/03/23
// Earth Board Game
//

public class Card {
	private String name;
	private String type;
	private int plant_cost;
	private int victory_value;
	private String habitable_elements;
	private String scientific_name;
	private int growth_space;
	private int maximum_growth_number;
	private int numSprouts;
	private int maxSprouts;
	private String canopy_completion_vp;
	private int ability_color; // See in Game.java GREEN, RED, BLUE, etc...
	private String ability1;
	private String ability2;
	private String flavour_text;

	public Card(String n, String t) { // Default constructor for Card Class.
		name = n;
		type = t;
		if (type == "Flora") {
			FloraCard();
		} else if (type == "Fauna") {
			FaunaCard();
		} else if (type == "Island") {
			IslandCard();
		} else if (type == "Climate") {
			ClimateCard();
		} else if (type == "Earth") {
			EarthCard();
		} else if (type == "Ecosystem") {
			EcosystemCard();
		} else if (type == "Event") {
			EventCard();
		} else {
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

	public void FloraCard() { // Creates attributes for a Flora-type card.
		int plant_cost;
		int victory_value;
		String habitable_elements;
		String scientific_name;
		int growth_space;
		int maximum_growth_number;
		int numSprouts;
		int maxSprouts;
		String canopy_completion_vp;
		int ability_color;
		String ability1;
		String ability2;
		String flavour_text;
	}

	public void FaunaCard() { // Creates attributes for a Fauna-type card.
		String scientific_name;
		int ability_color;
		String ability;
		String flavour_text;
	}

	public void IslandCard() { // Creates attributes for a Island-type card.
		String scientific_name;
		int ability_color;
		String ability;
		String flavour_text;
	}

	public void ClimateCard() { // Creates attributes for a Climate-type card.
		String scientific_name;
		int ability_color;
		String ability;
		String flavour_text;
	}

	public void EarthCard() { // Creates attributes for a Earth-type card.
		int plant_cost;
		int victory_value;
		String habitable_elements;
		String scientific_name;
		int ability_color;
		String ability1;
		String ability2;
		String flavour_text;
	}

	public void EcosystemCard() { // Creates attributes for a Ecosystem-type card.
		String scientific_name;
		int ability_color;
		String ability;
		String flavour_text;
	}

	public void EventCard() { // Creates attributes for a Event-type card.
		String scientific_name;
		int ability_color;
		String ability;
		String flavour_text;
	}

	@Override
	public String toString() {
		if (type == "Flora") {
			return "Name: " + name + "\n" + "Type: " + type + "\n" + "Plant cost: " +
					plant_cost + "\n" + "Victory value: " + victory_value + "\n" + "Habitable elements: "
					+ habitable_elements + "\n" + "Scientific name: " + scientific_name + "\n" +
					"Growth space: " + growth_space + "\n" + "Maximum growth number: " +
					maximum_growth_number + " \n" + "Canopy completion victory points" +
					canopy_completion_vp + "\n" + "Ability color " + ability_color + "\n" +
					"Ability One: " + ability1 + "\n" + "Ability Two:" + ability2 + "\n" +
					"Flavour Text: " + flavour_text + "\n";
		} else if (type == "Fauna") {
			return "Name: " + name + "\n" + "Scientific name: " + scientific_name + "\n" +
					"Ability color " + ability_color + "\n" + "Ability One: " + ability1 + "\n" +
					"Ability Two:" + ability2 + "\n" + "Flavour Text: " + flavour_text + "\n";
		} else if (type == "Island") {
			return "Name: " + name + "\n" + "Scientific name: " + scientific_name + "\n" +
					"Ability color " + ability_color + "\n" + "Ability One: " + ability1 + "\n" +
					"Ability Two:" + ability2 + "\n" + "Flavour Text: " + flavour_text + "\n";
		} else if (type == "Climate") {
			return "Name: " + name + "\n" + "Scientific name: " + scientific_name + "\n" +
					"Ability color " + ability_color + "\n" + "Ability One: " + ability1 + "\n" +
					"Ability Two:" + ability2 + "\n" + "Flavour Text: " + flavour_text + "\n";
		} else if (type == "Earth") {
			return "Name: " + name + "\n" + "Type: " + type + "\n" + "Plant cost: " +
					plant_cost + "\n" + "Victory value: " + victory_value + "\n" + "Habitable elements: "
					+ habitable_elements + "\n" + "Scientific name: " + scientific_name + "\n" +
					"Growth space: " + growth_space + "\n" + "Maximum growth number: " +
					maximum_growth_number + " \n" + "Canopy completion victory points" +
					canopy_completion_vp + "\n" + "Ability color " + ability_color + "\n" +
					"Ability One: " + ability1 + "\n" + "Ability Two:" + ability2 + "\n" +
					"Flavour Text: " + flavour_text + "\n";
		} else if (type == "Ecosystem") {
			return "Name: " + name + "\n" + "Scientific name: " + scientific_name + "\n" +
					"Ability color " + ability_color + "\n" + "Ability One: " + ability1 + "\n" +
					"Ability Two:" + ability2 + "\n" + "Flavour Text: " + flavour_text + "\n";
		} else if (type == "Event") {
			return "Name: " + name + "\n" + "Scientific name: " + scientific_name + "\n" +
					"Ability color " + ability_color + "\n" + "Ability One: " + ability1 + "\n" +
					"Ability Two:" + ability2 + "\n" + "Flavour Text: " + flavour_text + "\n";
		} else {
			return "This card doesn't fit neatly into any categories.";
		}
	}

	public String getName() {
		return name;
	}

	public int getPlantCost() {
		return plant_cost;
	}

	@Override
	public boolean equals(Object o) { // This provides a better version of the default equals method in object.
		if (o == null || !(o instanceof Card)) {
			return false;
		}

		Card c = (Card) o;

		return this.name.equals(c.getName());
	}

	public int getMaximumGrowth() {
		return maximum_growth_number;
	}

	public int getGrowth() {
		return growth_space;
	}

	public void addGrowth(int val) {
		growth_space += val;
	}

	public void setGrowth(int val) {
		growth_space = val;
	}

	public int getSprouts() {
		return numSprouts;
	}

	public int getMaxSprouts() {
		return maxSprouts;
	}

	public void setMaximumGrowth(int val) {
		maximum_growth_number = val;
	}

	public void addSprouts(int val) {
		numSprouts += val;
	}

	public void setSprouts(int val) {
		numSprouts = val;
	}

	public int getAbilityColor() {
		return ability_color;
	}

	public void ability() {
		// This depends on the card in question.
	}
}
