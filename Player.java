//
// Group 3
// 03/03/23
// Earth Board Game
//

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
	int growthCount;
	private int soil = 0;
	private int compost = 0;
	private int tableauTotal = 0;
	private int score = 0;
	private String name;

	// constructor that takes two arguments
	Player() {
		// default does nothing
	}

	Player(Card island, Card climate, int index) {
		this.island = island;
		this.climate = climate;
		this.name = "Player " + index;
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
		sproutCount = 0;
		for(Card[] r : tableauList){
			for(Card c : r){
				sproutCount += c.getSprouts();
			}
		}
	}

	//scan and count the growth
	void countGrowth() {
		growthCount = 0;
		for(Card[] r : tableauList){
			for(Card c : r){
				growthCount += c.getGrowth();
			}
		}
	}

	
	//get sprout count, return value
	int getSprouts() {
		this.countSprouts();
		return sproutCount;
	}

	//get growth count, return value
	int getTotalGrowth(){
		this.countGrowth();
		return growthCount;
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

	//return an arraylist reference to the cards in the player's hand
	public ArrayList<Card> getHandList(){
		return handList;
	}

	//return an arraylist reference to the tableau cards that have open sprout spots
	public ArrayList<Card> getSproutCards(){
		ArrayList<Card> sproutCards = new ArrayList<Card>();
		for(Card[] r : tableauList){
			for(Card c : r){
				if(c.getSprouts() < c.getMaxSprouts()){
					sproutCards.add(c);
				}
			}
		}
		return sproutCards;
	}

	//return an arraylist reference to the tableau cards that have open growth spots
	public ArrayList<Card> getMaxGrowthCards(){
		ArrayList<Card> growthCards = new ArrayList<Card>();
		for(Card[] r : tableauList){
			for(Card c : r){
				if(c.getGrowth() < c.getMaximumGrowth()){
					growthCards.add(c);
				}
			}
		}
		return growthCards;
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
		if(temp.getSprouts() > temp.getMaxSprouts()) {
			int difference = temp.getSprouts() - temp.getMaxSprouts();
			temp.addSprouts((difference*-1));
		}
		//prevents adding sprouts over maximum
	}
	
	//subtract sprouts from a card
	//requires coordinates and amount
	void removeSprouts(int amount, int x, int y) {
		Card temp = tableauList[x][y];
		temp.addSprouts((amount*-1));
		if(temp.getSprouts() < 0) {
			temp.addSprouts((temp.getSprouts()*-1));
		}
		//prevents subtracting sprouts below 0
	}
	
	//add growth to a card
	//requires coordinates and amount
	void addGrowth(int amount, int x, int y) {
		Card temp = tableauList[x][y];
		temp.addGrowth(amount);
		if(temp.getGrowth() > temp.getMaximumGrowth()) {
			int difference = temp.getGrowth() - temp.getMaximumGrowth();
			temp.addGrowth((difference*-1));
		}
		//prevents adding growth over maximum
	}
	
	//remove growth from a card
	//requires coordinates and amount
	void removeGrowth(int amount, int x, int y) {
		Card temp = tableauList[x][y];
		temp.addGrowth((amount*-1));
		if(temp.getGrowth() < 0) {
			temp.addGrowth((temp.getGrowth()*-1));
		}
		//prevents subtracting growth below 0
	}
	
	public int getSoil() {
        return soil;
    }

	public void addSoil(int value) {
		soil += value;
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
    	//TODO: Tallying score by iterating through tableau
        return score;
    }

	public boolean tableauFull() {
		for(Card[] r : tableauList){
			for(Card c : r){
				if (c == null){
					return false;
				}
			}
		}
		return true;
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
			for (int c = 0; c<4; c++) { //column
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

	public String getName(){
		return name;
	}


}

