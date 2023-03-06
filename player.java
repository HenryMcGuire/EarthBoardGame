//represents a single player
//has a two dimensional array representing the card tableau
//has a one dimensional array representing the player's hand
//has functions for each of the possible player actions, takes user input from driver
//keeps track of all player resources and points
//for now, compost cards get deleted and simply increments the compost attribute
//calls functions from the card class to perform abilities
//has an independent variable tracking the amount of sprouts, updated by iterating through the card tableau and fetching sprout values from the card class

import java.util.ArrayList;

public class player {

	//integer objects are a placeholder, full version will use the card object class
	ArrayList<Integer> handList = new ArrayList();
	//represents the entire tableau
	ArrayList<ArrayList<Integer>> tableauList = new ArrayList();
	//represents each individual row
	ArrayList<Integer> row1 = new ArrayList();
	ArrayList<Integer> row2 = new ArrayList();
	ArrayList<Integer> row3 = new ArrayList();
	ArrayList<Integer> row4 = new ArrayList();
	tableauList.add(row1);
	tableauList.add(row2);
	tableauList.add(row3);
	tableauList.add(row4);
	Integer island = null;
	Integer climate = null;
	int sproutCount;
	int soil;
	int compost;
	int tableauTotal;
	int score;
	
	//constructor that takes two arguments
	
	player(){
		
	}
	
	player(Integer island, Integer climate){
		this.island = island;
		this.climate = climate;
	}
	
	//first turn that resolves island ability
	void firstTurn() {
		//for loop that draws the amount of cards as given by island
		soil+=0; //placeholder. will add soil as given by island
	}
	
	//draw a card and add it to hand
	
	void drawCard() {
		Integer newCard = null;
		//TODO: Use card constructor
		this.handList.add(newCard);
	}
	
	//plant action
	void plantAction() {
		
	}
	
	void compostAction() {
		
	}
	
	void waterAction() {
		
	}
	
	//grow action
	void growAction() {
		
	}
	
	//compost action
	
	//water action
	
	//grow action
	
	//choose a card within the tableau, return card reference
	//uses tableau position method
	void chooseTableauCard() {
		
	}
	
	//choose a card within the hand, return card reference
	
	void chooseHandCard() {
		
	}
	
	//scan and count the sprouts
	
	void countSprouts() {
		
	}
	
	//get sprout count, return value
	
	int getSprouts() {
		
		return 0;
	}
	
	//choose a position within the tableau
	
	//remove card from hand
	
	
	
	//remove a card from tableau
	void tableauRemove() {
		
	}
	
	//add a card to tableau
	void tableauAdd() {
		
	}
	
	//uses remove from hand function
	
	//add sprouts to a card
	//requires coordinates
	
	//subtract sprouts from a card
	//requires coordinates
	
	//resolve abilities
	//takes an action color as an argument, called upon when other players do their action
	//iterates through the tableau checking if that card matches the action color
	//asks user if they'd like to use the ability when it finds a valid card
	void resolveAbilities(int action) {
		//1 = plant action 2 = compost action 3 = water action 4 = grow action
		
	}
	
	//use an ability
	//can be in either the hand or tableau, requires coordinates
	
	//removes card from specified coordinate, deletes it, and adds a compost point
	void compostCard() {
		
	}
	
	//delete a card from memory
	void deleteCard() {
		
	}
	
	//toString() method that prints out the player's entire tableau,
	//the player's entire hand, and all of their resources
	public String toString() {
		//for each loop
		
		return "placeholder";
	}
}
