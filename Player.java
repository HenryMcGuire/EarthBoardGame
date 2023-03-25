import java.util.ArrayList;

public class Player {

	// represents hand, dynamic
	ArrayList<Card> handList = new ArrayList<Card>();
	// represents tableau, rigid positions and sizes
	Card[][] tableauList = new Card[4][4];
	private Card island = null;
	private Card climate = null;
	private Card ecosystem = null;
	private Card event = null;
	int sproutCount;
	private int soil = 0;
	private int compost = 0;
	private int tableauTotal = 0;
	private int score = 0; //

	// constructor that takes two arguments
	Player() {
		// default does nothing
	}

	Player(Card island, Card climate) {
		this.island = island;
		this.climate = climate;
	}

	Player(Card island, Card climate, Card ecosystem) {
		this.island = island;
		this.climate = climate;
		this.ecosystem = ecosystem;
	}

	// first turn that resolves island ability
	void firstTurn() {
		// for loop that draws the amount of cards as given by island
		soil += 0; // placeholder. will add soil as given by island
	}

	// if the card is already constructed, this can add it to the hand manually
	void addCardToHand(Card newCard) {
		this.handList.add(newCard);
	}

	// plant up to two cards from hand to tableau
	// first card can be anywhere, subsequent cards must be adjacent to another card
	// planting requires paying soil cost
	// asks user for which card to pick from hand, then coordinates for where to put
	// it
	// increments tableau total for each card planted
	// then draws 4 cards SEPARATE from drawCard() function, asks user which they
	// want to keep
	// adds the chosen card to handlist and deletes the other 3
	void plantAction() {
		// TODO: user input
	}

	// gain 5 soil and 2 compost, doesn't draw any cards
	void compostAction() {
		this.soil += 5;
		this.compost += 2;
	}

	// gain 6 temporary getNumSprouts() that can be placed on open sprout spaces
	// player chooses where to put getNumSprouts() and how many until they run out,
	// until there's no more sprout spaces, or they decide to end early
	// remaining temporary getNumSprouts() are lost
	void waterAction() {
		this.soil += 2;
		int tempgetSprouts = 6;
		// TODO: user input
	}

	// draw 4 cards
	// gain 2 temporary getMaximumGrowth() tokens, user chooses a valid card on
	// tableau to place getMaximumGrowth() and how many
	// input continues until they run out or there are no more getMaximumGrowth()
	// spaces
	void growAction() {
		// Climate is a placeholder for a random card here.
		addCardToHand(climate);
		addCardToHand(climate);
		addCardToHand(climate);
		addCardToHand(climate);
		int tempgetMaxGrowth = 2;
		// TODO: user input
	}

	// choose a card within the tableau, return card reference

	// if the card is already constructed, this can add it to the hand manually
	void drawCard(Card newCard) {
		this.handList.add(newCard);
	}

	// choose a card within the tableau, return card reference
	Card getTableauCard(int x, int y) {
		return tableauList[x][y];
	}

	// choose a card within the hand, return card reference
	Card getHandCard(int x) {
		return handList.get(x);
	}

	ArrayList<Card> getHandList() {
		return handList;
	}

	Card getIsland() {
		return this.island;
	}

	Card getClimate() {
		return this.climate;
	}

	void setEvent(Card e) {
		this.event = e;
		// TODO: trigger event ability
	}

	Card getEvent() {
		return this.event;
	}

	void setEcosystem(Card e) {
		this.ecosystem = e;
	}

	Card getEcosystem() {
		return this.ecosystem;
	}

	// scan and count the getNumSprouts()
	void countgetSprouts() {
		// TODO: iterate through tableau and count getNumSprouts() on cards
	}

	// get sprout count, return value
	int getNumSprouts() {
		return sproutCount;
	}

	// remove card from hand by index

	// scan and count the sprouts
	void countSprouts() {
		// TODO: iterate through tableau and count sprouts on cards
	}

	// get sprout count, return value
	int getSprouts() {
		return sproutCount;
	}

	// remove card from hand

	void handRemove(int x) {
		handList.remove(x);
	}

	// remove card from hand by Card
	void handRemove(Card val) {
		handList.remove(val);
	}

	// returns whether the tableau is full or not
	boolean tableauFull() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (tableauList[i][j] == null) {
					return false;
				}
			}
		}

		return true;
	}

	// remove a card from tableau
	// add a card to tableau
	void tableauAdd(Card card, int x, int y) {
		tableauList[x][y] = card;
	}

	// remove a card from tableau
	void tableauRemove() {

	}

	// add getNumSprouts() to a card
	// requires coordinates and amount
	void addgetSprouts(int amount, int x, int y) {
		tableauList[x][y].setNumSprouts(tableauList[x][y].getNumSprouts() + amount);
		if (tableauList[x][y].getNumSprouts() > tableauList[x][y].getMaximumSprouts()) {
			tableauList[x][y].setNumSprouts(tableauList[x][y].getMaximumSprouts());
		}
	}

	// subtract getNumSprouts() from a card
	// requires coordinates and amount
	void removegetSprouts(int amount, int x, int y) {
		tableauList[x][y].setNumSprouts(tableauList[x][y].getNumSprouts() - amount);
		if (tableauList[x][y].getNumSprouts() < 0) {
			tableauList[x][y].setNumSprouts(0);
		}
	}
	// placeholder code, adjust with card class if necessary

	// add getMaximumGrowth() to a card
	// requires coordinates and amount
	void addgetMaxGrowth(int amount, int x, int y) {
		tableauList[x][y].setMaximumGrowth(tableauList[x][y].getMaximumGrowth() + amount);
		if (tableauList[x][y].getMaximumGrowth() > tableauList[x][y].getMaximumGrowth()) {
			tableauList[x][y].setMaximumGrowth(tableauList[x][y].getMaximumGrowth());
		}
	}

	// remove getMaximumGrowth() from a card
	// requires coordinates and amount
	void removegetMaxGrowth(int amount, int x, int y) {
		tableauList[x][y].setMaximumGrowth(tableauList[x][y].getMaximumGrowth() - amount);
		if (tableauList[x][y].getMaximumGrowth() < 0) {
			tableauList[x][y].setMaximumGrowth(0);
		}
	}

	public void addSoil(int value) {
		soil += value;
	}

	// add sprouts to a card
	// requires coordinates and amount
	void addSprouts(int amount, int x, int y) {
		tableauList[x][y].sprouts += amount;
		if (tableauList[x][y].sprouts > tableauList[x][y].sproutMax) {
			tableauList[x][y].sprouts = tableauList[x][y].sproutMax;
		}
	}

	// subtract sprouts from a card
	// requires coordinates and amount
	void removeSprouts(int amount, int x, int y) {
		tableauList[x][y].sprouts -= amount;
		if (tableauList[x][y].getNumSprouts() < 0) {
			tableauList[x][y].sprouts = 0;
		}
	}
	// placeholder code, adjust with card class if necessary

	// add growth to a card
	// requires coordinates and amount
	void addGrowth(int amount, int x, int y) {
		tableauList[x][y].getGrowthSpace() += amount;
		if (tableauList[x][y].getGrowthSpace() > tableauList[x][y].getGrowthSpace()) {
			tableauList[x][y].getGrowthSpace() = tableauList[x][y].getGrowthSpace();
		}
	}

	// remove growth from a card
	// requires coordinates and amount
	void removeGrowth(int amount, int x, int y) {
		tableauList[x][y].getGrowthSpace() -= amount;
		if (tableauList[x][y].getGrowthSpace() < 0) {
			tableauList[x][y].getGrowthSpace() = 0;
		}
	}

	public int getSoil() {
		return soil;
	}

	public void addCompost(int value) {
		compost += value;
	}

	public int getCompost() {
		return compost;
	}

	public int getTotal() {
		return tableauTotal;
	}

	public int getScore() {
		// TODO: Tallying score by iterating through tableau
		return score;
	}

	// resolve abilities
	// takes an action color as an argument, called upon when other players do their
	// action
	// iterates through the tableau checking if that card matches the action color
	// asks user if they'd like to use the ability when it finds a valid card
	// may be obsolete from what game.java uses
	void resolveAbilities(int action) {
		// 1 = plant action 2 = compost action 3 = water action 4 = grow action
		switch (action) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
		}
	}

	// use an ability
	// input 1 argument for a hand position
	void useAbility(int x) {
		handList.get(x).ability(); // placeholder call, change to whatever the real class uses
	}

	// input 2 arguments for a tableau position
	void useAbility(int x, int y) {
		tableauList[x][y].ability(); // placeholder call, change to whatever the real class uses
	}

	@Override
	public String toString() {
		String str = "Tableau: \n";
		// tableau should appear like:
		// "Name, Name, ____, Name"
		// "____, Name, Name, ____" etc.
		for (int r = 0; r < 4; r++) { // row
			for (int c = 0; r < 4; c++) { // column
				if (tableauList[r][c] != null) {
					str += tableauList[r][c].getName();
				} else {
					str += "____";
				}
				if (r < 3) {
					str += ", ";
				}
			}
			str += "\n";
		}
		// hand should appear like:
		// "Name, Name, Name, Name, Name"
		String str2 = "Hand: \n";
		for (int i = 0; i < handList.size(); i++) {
			str2 += handList.get(i).getName();
			if (i < handList.size() - 1) {
				str2 += ", ";
			}
		}
		// resources
		String str3 = ("Resources: " + soil + " Soil, " + compost + " Compost, " + sproutCount + " Sprouts");
		return str + str2 + str3;
	}

	// for printing card information in the player's hand
	public String toString(int x) {
		return handList.get(x).toString();
	}

	// for printing card information in the player's tableau
	public String toString(int x, int y) {
		return tableauList[x][y].toString();
	}

	// returns list of cards that can have getMaximumGrowth() applied
	public ArrayList<Card> getMaxGrowthCards() {
		ArrayList<Card> getMaxGrowthCards = new ArrayList<Card>();

		for (Card[] row : tableauList) {
			for (Card c : row) {
				if (c.getMaximumGrowth() > 0 && c.getMaximumGrowth() > c.getMaximumGrowth()) {
					getMaxGrowthCards.add(c);
				}
			}
		}

		return getMaxGrowthCards;
	}

	// returns the total number of getMaximumGrowth() on tableau cards
	public int getTotalGrowth() {
		int totalgetMaxGrowth = 0;

		for (Card[] row : tableauList) {
			for (Card c : row) {
				totalgetMaxGrowth += c.getMaximumGrowth();
			}
		}

		return totalgetMaxGrowth;
	}

	// returns list of cards that can have getNumSprouts() applied
	public ArrayList<Card> getSproutCards() {
		ArrayList<Card> sproutCards = new ArrayList<Card>();

		for (Card[] row : tableauList) {
			for (Card c : row) {
				if (c.getMaximumSprouts() > 0 && c.getMaximumSprouts() > c.getNumSprouts()) {
					sproutCards.add(c);
				}
			}
		}

		return sproutCards;
	}

	// returns the total number of getNumSprouts() on tableau cards
	public int getTotalSprouts() {
		int totalgetSprouts = 0;

		for (Card[] row : tableauList) {
			for (Card c : row) {
				totalgetSprouts += c.getNumSprouts();
			}
		}

		return totalgetSprouts;
	}
}
