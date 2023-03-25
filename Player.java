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
		//default does nothing
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
	
	//if the card is already constructed, this can add it to the hand manually
	void drawCard(Card newCard) {
		this.handList.add(newCard);
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
		for(Card[] r : tableauList){
			for(Card c : r){
				
			}
		}
		//TODO: iterate through tableau and count sprouts on cards
	}
	
	//get sprout count, return value
	int getSprouts() {
		return sproutCount;
	}
	
	//add card to hand
    void addCardToHand(Card card) {
		handList.add(card);
	}

	//remove card from hand at specified coordinate
	void handRemove(int x) {
		handList.remove(x);
	}

	//remove card from hand from specified reference
	void handRemove(Card card) {
		handList.remove(card);
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
		Card temp = tableauList[x][y];
		temp.addSprouts(amount);
		if(temp.getNumSprouts() > temp.getMaximumSprouts()) {
			int difference = temp.getNumSprouts() - temp.getMaximumSprouts();
			temp.addSprouts((difference*-1));
		}
		//prevents adding sprouts over maximum
	}
	
	//subtract sprouts from a card
	//requires coordinates and amount
	void removeSprouts(int amount, int x, int y) {
		Card temp = tableauList[x][y];
		temp.addSprouts((amount*-1));
		if(temp.getNumSprouts() < 0) {
			temp.addSprouts((temp.getNumSprouts()*-1));
		}
		//prevents subtracting sprouts below 0
	}
	
	//add growth to a card
	//requires coordinates and amount
	void addGrowth(int amount, int x, int y) {
		Card temp = tableauList[x][y];
		temp.addGrowth(amount);
		if(temp.getGrowthSpace() > temp.getMaximumGrowth()) {
			int difference = temp.getGrowthSpace() - temp.getMaximumGrowth();
			temp.addGrowth((difference*-1));
		}
		//prevents adding growth over maximum
	}
	
	//remove growth from a card
	//requires coordinates and amount
	void removeGrowth(int amount, int x, int y) {
		Card temp = tableauList[x][y];
		temp.addGrowth((amount*-1));
		if(temp.getGrowthSpace() < 0) {
			temp.addGrowth((temp.getGrowthSpace()*-1));
		}
		//prevents subtracting growth below 0
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
    //may be obsolete from what game.java uses
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

	//toString() method that prints out the player's entire tableau,
	//the player's entire hand, and all of their resources
	@Override
	public String toString() {
		String str = "Tableau: \n";
		//tableau should appear like:
		// "Name, Name, ____, Name"
		// "____, Name, Name, ____" etc.
		for(int r = 0; r<4; r++) { //row
			for (int c = 0; r<4; c++) { //column
				if(tableauList[r][c]!= null) {
					str+=tableauList[r][c].getName();
				}
				else {
					str+="____";
				}
				if(r < 3) {
					str+=", ";
				}
			}
			str += "\n";
		}
		//hand should appear like:
		// "Name, Name, Name, Name, Name"
		String str2 = "Hand: \n";
		for(int i=0; i<handList.size(); i++) {
			str2+=handList.get(i).getName();
			if(i<handList.size()-1) {
				str2+=", ";
			}
		}
		//resources
		String str3 = ("Resources: " +soil+" Soil, " +compost+ " Compost, " +sproutCount+ " Sprouts");
		return str+str2+str3;
	}
	
	//for printing card information in the player's hand
	public String toString(int x) {
		return handList.get(x).toString();
	}
	
	//for printing card information in the player's tableau
	public String toString(int x, int y) {
		return tableauList[x][y].toString();
	}


}

