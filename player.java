//represents a single player
//has a two dimensional array representing the card tableau
//has a one dimensional array representing the player's hand
//has functions for each of the possible player actions, takes user input from driver
//keeps track of all player resources and points
//for now, compost cards get deleted and simply increments the compost attribute
//calls functions from the card class to perform abilities
//has an independent variable tracking the amount of sprouts, updated by iterating through the card tableau and fetching sprout values from the card class

import java.util.ArrayList;

public class Player {

	//represents hand, dynamic
	ArrayList<Card> handList = new ArrayList<Card>();
	//represents tableau, rigid positions and sizes
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
	
	//constructor that takes two arguments
	
	Player(){
		
	}
	
	Player(Card island, Card climate){
		this.island = island;
		this.climate = climate;
	}
	
	Player(Card island, Card climate, Card ecosystem){
		this.island = island;
		this.climate = climate;
		this.ecosystem = ecosystem;
	}
	
	//first turn that resolves island ability
	void firstTurn() {
		//for loop that draws the amount of cards as given by island
		soil+=0; //placeholder. will add soil as given by island
	}
	
	//draw a card and add it to hand
	void drawCard() {
		Card newCard = new Card();
		this.handList.add(newCard);
	}
	
	//plant up to two cards from hand to tableau
	//first card can be anywhere, subsequent cards must be adjacent to another card
	//planting requires paying soil cost
	//asks user for which card to pick from hand, then coordinates for where to put it
	//increments tableau total for each card planted
	//then draws 4 cards SEPARATE from drawCard() function, asks user which they want to keep
	//adds the chosen card to handlist and deletes the other 3
	void plantAction() {
		//TODO: user input
	}
	
	//gain 5 soil and 2 compost, doesn't draw any cards
	void compostAction() {
		this.soil+=5;
		this.compost+=2;
	}
	
	//gain 6 temporary sprouts that can be placed on open sprout spaces
	//player chooses where to put sprouts and how many until they run out,
	//until there's no more sprout spaces, or they decide to end early
	//remaining temporary sprouts are lost
	void waterAction() {
		this.soil+=2;
		int tempSprouts = 6;
		//TODO: user input
	}
	
	//draw 4 cards
	//gain 2 temporary growth tokens, user chooses a valid card on tableau to place growth and how many
	//input continues until they run out or there are no more growth spaces
	void growAction() {
		drawCard();
		drawCard();
		drawCard();
		drawCard();
		int tempGrowth = 2;
		//TODO: user input
	}
	
	//choose a card within the tableau, return card reference
	Card getTableauCard(int x, int y) {
		return tableauList[x][y];
	}
	
	//choose a card within the hand, return card reference
	Card getHandCard(int x) {
		return handList.get(x);
	}
	
	Card getIsland(){
		return this.island;
	}
	
	Card getClimate() {
		return this.climate;
	}
	
	void setEvent(Card e) {
		this.event = e;
		//TODO: trigger event ability
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
	
	//scan and count the sprouts
	void countSprouts() {
		//TODO: iterate through tableau and count sprouts on cards
	}
	
	//get sprout count, return value
	int getSprouts() {
		
		return sproutCount;
	}
	
	//choose a position within the tableau
	
    public void addCardToHand(Card card) {
        handList.add(card);
    }

    //remove card from hand
	void handRemove(int x) {
		handList.remove(x);
	}

	//add a card to tableau
	void tableauAdd(Card card, int x, int y) {
		tableauList[x][y] = card;
	}
	
	//remove a card from tableau
	void tableauRemove() {
		
	}
	
	//add sprouts to a card
	//requires coordinates and amount
	void addSprouts(int amount, int x, int y) {
		tableauList[x][y].sprouts += amount;
		if(tableauList[x][y].sprouts > tableauList[x][y].sproutMax) {
			tableauList[x][y].sprouts = tableauList[x][y].sproutMax;
		}
	}
	
	//subtract sprouts from a card
	//requires coordinates and amount
	void removeSprouts(int amount, int x, int y) {
		tableauList[x][y].sprouts -= amount;
		if(tableauList[x][y].sprouts < 0) {
			tableauList[x][y].sprouts = 0;
		}
	}
	//placeholder code, adjust with card class if necessary
	
	//add growth to a card
	//requires coordinates and amount
	void addGrowth(int amount, int x, int y) {
		tableauList[x][y].growth += amount;
		if(tableauList[x][y].growth > tableauList[x][y].growthMax) {
			tableauList[x][y].growth = tableauList[x][y].growthMax;
		}
	}
	
	//remove growth from a card
	//requires coordinates and amount
	void removeGrowth(int amount, int x, int y) {
		tableauList[x][y].growth -= amount;
		if(tableauList[x][y].growth < 0) {
			tableauList[x][y].growth = 0;
		}
	}

    public void addSoil(int count) {
        soil += count;
    }

    public void addCompost(int count) {
        compost += count;
    }
		
	public int getSoil() {
        return soil;
    }

    public int getCompost() {
        return compost;
    }
	
    public int getTotal() {
        return tableauTotal;
    }

    public int getScore() {
    	//TODO: Tallying score by iterating through tableau
        return score;
    }
    
	//resolve abilities
	//takes an action color as an argument, called upon when other players do their action
	//iterates through the tableau checking if that card matches the action color
	//asks user if they'd like to use the ability when it finds a valid card
	void resolveAbilities(int action) {
		//1 = plant action 2 = compost action 3 = water action 4 = grow action
		switch(action) {
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
	
	//use an ability
	//input 1 argument for a hand position
	void useAbility(int x) {
		handList.get(x).ability(); //placeholder call, change to whatever the real class uses
	}
	
	//input 2 arguments for a tableau position
	void useAbility(int x, int y) {
		tableauList[x][y].ability(); //placeholder call, change to whatever the real class uses
	}
	
	//removes card from specified hand coordinate, deletes it, and adds a compost point
	void compostCard(int x) {
		Card temp = handList.get(x);
		handList.remove(x);
		deleteCard(temp);
		compost+=1;
	}
	
	//delete a card from memory
	void deleteCard(Card card) {
		//TODO
	}
	
	//toString() method that prints out the player's entire tableau,
	//the player's entire hand, and all of their resources
	@Override
	public String toString() {
		//for each loop
		//TODO
		return "placeholder";
	}
}