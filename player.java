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
	ArrayList<Integer> handList = new ArrayList<Integer>();
	//represents the entire tableau
	ArrayList<ArrayList<Integer>> tableauList = new ArrayList<ArrayList<Integer>>();
	//represents each individual row
	ArrayList<Integer> row1 = new ArrayList<Integer>();
	ArrayList<Integer> row2 = new ArrayList<Integer>();
	ArrayList<Integer> row3 = new ArrayList<Integer>();
	ArrayList<Integer> row4 = new ArrayList<Integer>();
	Integer island = null;
	Integer climate = null;
	int sproutCount;
	int soil;
	int compost;
	
	//constructor that takes two arguments
	
	player(){
		
	}
	
	player(Integer island, Integer climate){
		this.island = island;
		this.climate = climate;
	}
	
	//draw a card and add it to hand
	
	void drawCard() {
		Integer newCard = null;
		//TODO: Use card constructor
		this.handList.add(newCard);
	}
	
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
	
	//add a card to tableau from hand
	void add() {
		
	}
	
	//uses remove from hand function
	
	//add sprouts to a card
	//requires coordinates
	
	//subtract sprouts from a card
	//requires coordinates
	
	//use an ability
	//can be in either the hand or tableau, requires coordinates
	
	
	//delete a card from memory
	
	//toString() method that prints out the player's entire tableau,
	//the player's entire hand, and all of their resources
	public String toString() {
		
		
		return "placeholder";
	}
}
