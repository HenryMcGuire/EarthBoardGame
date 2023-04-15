import java.util.ArrayList;

//
// Group 3
// 03/03/23
// Earth Board Game
//
public class Card {
	// Note this is all the possible values a card could have, whether or not a
	// given card has this in their value
	// is dependent on the type of the card in question.
	// i.e. some card types like Flora Cards will have quite a lot of types
	// while other card types like the Island Card type will have few types
	// instantialized.
	private String name;
	private String type;
	private String habitable_elements;
	private String scientific_name;
	private String canopy_completion_vp;
	private String ability1;
	private String ability2;
	private String flavour_text;
	private int plant_cost;
	private int victory_value;
	private int growth_space;
	private int maximum_growth_number;
	private int numSprouts;
	private int maxSprouts;
	private int ability_color;
	private int soil_count; // See in Game.java GREEN, RED, BLUE, etc...

	public Card(String n, String t) { // Default constructor for Card Class.
		name = n;
		type = t;
		if (type.equals("Flora")) {
			FloraCard(n, t);
		} else if (type.equals("Fauna")) {
			FaunaCard(n, t);
		} else if (type.equals("Island")) {
			IslandCard(n, t);
		} else if (type.equals("Climate")) {
			ClimateCard(n, t);
		} else if (type.equals("Earth")) {
			EarthCard(n, t);
		} else if (type.equals("Ecosystem")) {
			EcosystemCard(n, t);
		} else if (type.equals("Event")) {
			EventCard(n, t);
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

	public void FloraCard(String n, String t) { // Creates attributes for a Flora-type card.
		habitable_elements = "";
		scientific_name = "";
		canopy_completion_vp = "";
		ability1 = "";
		ability2 = "";
		flavour_text = "";
		plant_cost = (int) Math.random() * 10;
		soil_count = (int) Math.random() * 10;
		victory_value = (int) Math.random() * 10;
		growth_space = (int) Math.random() * 10;
		maximum_growth_number = (int) Math.random() * 10;
		numSprouts = (int) Math.random() * 10;
		maxSprouts = (int) Math.random() * 10;
		ability_color = (int) Math.random() * 10;
	}

	public void FaunaCard(String n, String t) { // Creates attributes for a Fauna-type card.
		scientific_name = "";
		ability1 = "";
		ability2 = "";
		flavour_text = "";
		ability_color = (int) Math.random() * 10;
	}

	public void IslandCard(String n, String t) { // Creates attributes for a Island-type card.
		scientific_name = "";
		ability1 = "";
		ability2 = "";
		flavour_text = "";
		ability_color = (int) Math.random() * 10;
	}

	public void ClimateCard(String n, String t) { // Creates attributes for a Climate-type card.
		scientific_name = "";
		ability1 = "";
		ability2 = "";
		flavour_text = "";
		ability_color = (int) Math.random() * 10;
	}

	public void EarthCard(String n, String t) { // Creates attributes for a Earth-type card.
		habitable_elements = "";
		scientific_name = "";
		ability1 = "";
		ability2 = "";
		flavour_text = "";
		plant_cost = (int) Math.random() * 10;
		victory_value = (int) Math.random() * 10;
		ability_color = (int) Math.random() * 10;
	}

	public void EcosystemCard(String n, String t) { // Creates attributes for a Ecosystem-type card.
		scientific_name = "";
		ability1 = "";
		ability2 = "";
		flavour_text = "";
		ability_color = (int) Math.random() * 10;
	}

	public void EventCard(String n, String t) { // Creates attributes for a Event-type card.
		scientific_name = "";
		ability1 = "";
		ability2 = "";
		flavour_text = "";
		ability_color = (int) Math.random() * 10;
	}

	@Override
	public String toString() {
		if (type.equals("Flora")) {
			return "Name: " + name + "\n" + "Type: " + type + "\n" + "Plant cost: " +
					plant_cost + "\n" + "Victory value: " + victory_value + "\n" + "Habitable elements: "
					+ habitable_elements + "\n" + "Scientific name: " + scientific_name + "\n" +
					"Growth space: " + growth_space + "\n" + "Maximum growth number: " +
					maximum_growth_number + " \n" + "Canopy completion victory points" +
					canopy_completion_vp + "\n" + "Ability color " + ability_color + "\n" +
					"Ability One: " + ability1 + "\n" + "Ability Two:" + ability2 + "\n" +
					"Flavour Text: " + flavour_text + "\n";
		} else if (type.equals("Fauna")) {
			return "Name: " + name + "\n" + "Scientific name: " + scientific_name + "\n" +
					"Ability color " + ability_color + "\n" + "Ability One: " + ability1 + "\n" +
					"Ability Two:" + ability2 + "\n" + "Flavour Text: " + flavour_text + "\n";
		} else if (type.equals("Island")) {
			return "Name: " + name + "\n" + "Scientific name: " + scientific_name + "\n" +
					"Ability color " + ability_color + "\n" + "Ability One: " + ability1 + "\n" +
					"Ability Two:" + ability2 + "\n" + "Flavour Text: " + flavour_text + "\n";
		} else if (type.equals("Climate")) {
			return "Name: " + name + "\n" + "Scientific name: " + scientific_name + "\n" +
					"Ability color " + ability_color + "\n" + "Ability One: " + ability1 + "\n" +
					"Ability Two:" + ability2 + "\n" + "Flavour Text: " + flavour_text + "\n";
		} else if (type.equals("Earth")) {
			return "Name: " + name + "\n" + "Type: " + type + "\n" + "Plant cost: " +
					plant_cost + "\n" + "Victory value: " + victory_value + "\n" + "Habitable elements: "
					+ habitable_elements + "\n" + "Scientific name: " + scientific_name + "\n" +
					"Growth space: " + growth_space + "\n" + "Maximum growth number: " +
					maximum_growth_number + " \n" + "Canopy completion victory points" +
					canopy_completion_vp + "\n" + "Ability color " + ability_color + "\n" +
					"Ability One: " + ability1 + "\n" + "Ability Two:" + ability2 + "\n" +
					"Flavour Text: " + flavour_text + "\n";
		} else if (type.equals("Ecosystem")) {
			return "Name: " + name + "\n" + "Scientific name: " + scientific_name + "\n" +
					"Ability color " + ability_color + "\n" + "Ability One: " + ability1 + "\n" +
					"Ability Two:" + ability2 + "\n" + "Flavour Text: " + flavour_text + "\n";
		} else if (type.equals("Event")) {
			return "Name: " + name + "\n" + "Scientific name: " + scientific_name + "\n" +
					"Ability color " + ability_color + "\n" + "Ability One: " + ability1 + "\n" +
					"Ability Two:" + ability2 + "\n" + "Flavour Text: " + flavour_text + "\n";
		} else {
			return "This card doesn't fit neatly into any categories.";
		}
	}

	@Override
	public boolean equals(Object o) { // This provides a better version of the default equals method in object.
		if (o == null || !(o instanceof Card)) {
			return false;
		}

		Card c = (Card) o;

		return this.name.equals(c.getName());
	}

	public String getName() {
		return name;
	}

	public void setName(String s) {
		name = s;
	}

	public int getPlantCost() {
		return plant_cost;
	}

	public void setPlantCost(int val) {
		plant_cost = val;
	}

	public void addPlantCost(int val) {
		plant_cost += val;
	}

	public void subtractPlantCost(int val) {
		plant_cost -= val;
	}

	public void multiplyPlantCost(int val) {
		plant_cost *= val;
	}

	public void dividePlantCost(int val) {
		plant_cost /= val;
	}

	public int getMaximumGrowth() {
		return maximum_growth_number;
	}

	public void setMaximumGrowth(int val) {
		maximum_growth_number = val;
	}

	public int getGrowth() {
		return growth_space;
	}

	public void setGrowth(int val) {
		growth_space = val;
	}

	public void addGrowth(int val) {
		growth_space += val;
	}

	public void subtractGrowth(int val) {
		growth_space -= val;
	}

	public void multiplyGrowth(int val) {
		growth_space *= val;
	}

	public void divideGrowth(int val) {
		growth_space /= val;
	}

	public int getSprouts() {
		return numSprouts;
	}

	public void setSprouts(int val) {
		numSprouts = val;
	}

	public void addSprouts(int val) {
		numSprouts += val;
	}

	public void subtractSprouts(int val) {
		numSprouts -= val;
	}

	public void multiplySprouts(int val) {
		numSprouts *= val;
	}

	public void divideSprouts(int val) {
		numSprouts /= val;
	}

	public int getAbilityColor() {
		return ability_color;
	}

	public int getMaxSprouts() {
		return maxSprouts;
	}

	public void setMaxSprouts(int val) {
		maxSprouts = val;
	}

	public void addMaxSprouts(int val) {
		maxSprouts += val;
	}

	public void subtractMaxSprouts(int val) {
		maxSprouts -= val;
	}

	public void multiplyMaxSprouts(int val) {
		maxSprouts *= val;
	}

	public void divideMaxSprouts(int val) {
		maxSprouts /= val;
	}

	public int getSoilCount() {
		return soil_count;
	}

	public void setSoilCount(int val) {
		soil_count = val;
	}

	public void addSoilCount(int val) {
		soil_count += val;
	}

	public void subtractSoilCount(int val) {
		soil_count -= val;
	}

	public void multiplySoilCount(int val) {
		soil_count *= val;
	}

	public void divideSoilCount(int val) {
		soil_count /= val;
	}

	public void ability() {
		// This depends on the card in question.

		// IMPORTANT: FAUNA CARDS DO NOT HAVE ABILITIES.
		if (type.equals("Fauna")) {
			System.out.println("Fauna cards do not have abilities.");
			System.out.println("Fauna cards are therefore not activated by any player.");
		} else if (type.equals("Island")) {
			System.out.print("You can activate your island card and then your climate card ");
			System.out.print("before or after you've activated your tableau - and you can ");
			System.out.println("each time depending on what is best for your current turn.");
			System.out.println("However, you cannot activate one card before your tableau and another after");
			System.out.print("You are never forced to activate your Island/Climate's ability - you may use ");
			System.out.println("or skip it at any time it is able to activate");
		} else if (type.equals("Climate")) {
			System.out.print("Climate cards give players another ability that can contribute to their strategy, ");
			System.out.print("so try to choose one that complements your island and helps towards ");
			System.out.println("Fauna and Ecosystem objectives");
			System.out.print("Climate cards give players another ability that can contribute to their strategy");
			System.out.print(", so try to choose one ");
			System.out.println("that complements your Island and helps towards Fauna and Ecosystem objectives.");
		} else if (type.equals("Earth")) {
			System.out.print("Collectively, all cards in the game are referred to as cards,");
			System.out.print("whereas only the Flora cards are referred to as Flora—this is ");
			System.out.print("especially important for Fauna and Ecosystem objectives.");
			System.out.print("Objectives that require “Flora” do not involve Terrain, Event, ");
			System.out.print("Island, or Climate cards.");
			System.out.print("Whereas objectives that require “cards” include all cards in a player’s tableau as well");
			System.out.println("as their Island and Climate cards.");
		} else if (type.equals("Terrain")) {
			System.out.print("Terrain cards, like Flora, are planted into your tableau during the Plant action.");
			System.out.print("They often do not gain resources, but instead they offer in-game passive effects ");
			System.out.println("or end-game scoring bonuses.");
		} else if (type.equals("Event")) {
			System.out.print("Event cards never count for Terrain, Ecosystem or Fauna objectives ");
			System.out.println("unless specifically stated on a card.");
		}
	}

	public void generateRandomCard() { // Generates a random card upon request.
		int rand = (int) (70 * Math.random());
		String n = "";
		String t = "";
		if (rand > 0 && rand <= 10) {
			FloraCard(n, t);
		} else if (rand > 10 && rand <= 20) {
			FaunaCard(n, t);
		} else if (rand > 20 && rand <= 30) {
			IslandCard(n, t);
		} else if (rand > 30 && rand <= 40) {
			ClimateCard(n, t);
		} else if (rand > 40 && rand <= 50) {
			EarthCard(n, t);
		} else if (rand > 50 && rand <= 60) {
			EcosystemCard(n, t);
		} else if (rand > 60 && rand <= 70) {
			EventCard(n, t);
		}
	}

	public void generateRandomDeck() {
		ArrayList<Card> card = new ArrayList<Card>();
		for (int i = 0; i < (int) (Math.random() * 100); i++) {
			generateRandomCard();
		}
	}
}
