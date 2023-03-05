//
// Group 3
// 03/03/23
// Earth Board Game
//

import java.util.Scanner;
import java.util.ArrayList;

public class Game {
    
    private static ArrayList<Player> players = new ArrayList<>();
    private static ArrayList<Card> fauna = new ArrayList<>();

    private static ArrayList<Card> faunaCards = new ArrayList<>();
    private static ArrayList<Card> islandCards = new ArrayList<>();
    private static ArrayList<Card> climateCards = new ArrayList<>();
    private static ArrayList<Card> earthCards = new ArrayList<>();

    public static void main(String[] args) {
        // Intro
        System.out.println("Welcome to ");
        System.out.println("");
        System.out.println("  ______              _____    _______   _    _ ");
        System.out.println(" |  ____|     /\\     |  __ \\  |__   __| | |  | |");
        System.out.println(" | |__       /  \\    | |__) |    | |    | |__| |");
        System.out.println(" |  __|     / /\\ \\   |  _  /     | |    |  __  |");
        System.out.println(" | |____   / ____ \\  | | \\ \\     | |    | |  | |");
        System.out.println(" |______| /_/    \\_\\ |_|  \\_\\    |_|    |_|  |_|");
        System.out.println("");
        System.out.println("For game information visit: https://www.youtube.com/watch?v=GQ9rFntr5s4");
        System.out.println("");

        Scanner stdin = new Scanner(System.in);

        // Prompt for player count
        int playerCount;

        while (true) {
            System.out.print("Please enter the number of players(2-5): ");
            playerCount = stdin.nextInt();
            
            if (playerCount >= 2 && playerCount <= 5) {
                break;
            }
            else {
                System.out.println("Invalid input! Try again!");
            }
        }

        System.out.println();

        // Initialization of cards
        initializeCards();

        // Pick and display fauna
        System.out.println("Fauna Cards: ");

        for (int i = 0; i < 4; i++) {
            int fi = (int)(Math.random() * faunaCards.size());
            Card toAdd = faunaCards.get(fi);
            fauna.add(toAdd);
            faunaCards.remove(fi);
            System.out.println(toAdd.toString());
        }

        System.out.println();
        
        // Player setup
        for (int i = 0; i < playerCount; i++) {
            Card[] islandChoices = new Card[2];
            Card[] climateChoices = new Card[2];

            int iOne = (int)(Math.random() * islandCards.size());
            islandChoices[0] = islandCards.get(iOne);
            islandCards.remove(iOne);
            
            int iTwo = (int)(Math.random() * islandCards.size());
            islandChoices[1] = islandCards.get(iTwo);
            islandCards.remove(iTwo);

            int cOne = (int)(Math.random() * climateCards.size());
            climateChoices[0] = climateCards.get(cOne);
            climateCards.remove(cOne);
            
            int cTwo = (int)(Math.random() * climateCards.size());
            climateChoices[1] = climateCards.get(cTwo);
            climateCards.remove(cTwo);

            System.out.println("Player " + (i + 1) + "'s choices for island and climate cards: ");
            System.out.println("Island Cards: ");

            for (int j = 0; j < islandChoices.length; j++) {
                System.out.println((j + 1) + ". " + islandChoices[j].toString());
            }

            System.out.println("Climate Cards: ");

            for (int j = 0; j < climateChoices.length; j++) {
                System.out.println((j + 1) + ". " + climateChoices[j].toString());
            }

            Card islandSelection;
            Card climateSelection;

            while (true) {
                System.out.print("Player " + (i + 1) + ", select an island card(1 or 2): ");
                int islandIndex = stdin.nextInt();
                
                if (islandIndex >= 1 && islandIndex <= 2) {
                    islandSelection = islandChoices[islandIndex - 1];

                    for (Card c : islandChoices) {
                        if (c != islandSelection) {
                            islandCards.add(c);
                        }
                    }

                    break;
                }
                else {
                    System.out.println("Invalid input! Try again!");
                }
            }

            while (true) {
                System.out.print("Player " + (i + 1) + ", select a climate card(1 or 2): ");
                int climateIndex = stdin.nextInt();
                
                if (climateIndex >= 1 && climateIndex <= 2) {
                    climateSelection = climateChoices[climateIndex - 1];

                    for (Card c : climateChoices) {
                        if (c != climateSelection) {
                            islandCards.add(c);
                        }
                    }

                    break;
                }
                else {
                    System.out.println("Invalid input! Try again!");
                }
            }
            
            players.add(new Player(islandSelection, climateSelection));

            System.out.println();
        }

        for (int i = 0; i < playerCount; i++) {
            System.out.println("Player " + (i + 1) + " " + players.get(i).toString());
        }

        System.out.println();

        // Player actions
        while (true) {
            for (int i = 0; i < playerCount; i++) {
                // List actions
                // Player choose action
            }
        }

    }

    // Set decks of cards
    private static void initializeCards() {
        /* To be added
        for (Card c : cards) {
            switch(c.getType()) {
                case "Fauna":
                    faunaCards.add(c);
                    break;
                case "Island":
                    islandCards.add(c);
                    break;
                case "Climate":
                    climateCards.add(c);
                    break;
                case "Earth":
                    earthCards.add(c);
                    break;
            }
        }
        */
        // Hardcoded
        // Fauna
        faunaCards.add(new Card("Pale-Billed Woodpecker", "Fauna"));
        faunaCards.add(new Card("King Penguin", "Fauna"));
        faunaCards.add(new Card("King Penguin", "Fauna"));
        faunaCards.add(new Card("Brown Bear", "Fauna"));
        faunaCards.add(new Card("Kingfisher", "Fauna"));
        faunaCards.add(new Card("Siberian Tiger", "Fauna"));
        faunaCards.add(new Card("Red-Eyed Tree Frog", "Fauna"));
        faunaCards.add(new Card("European Mole", "Fauna"));

        // Island
        islandCards.add(new Card("Barren", "Island"));
        islandCards.add(new Card("Metis Shoal Island", "Island"));
        islandCards.add(new Card("Whakaari", "Island"));
        islandCards.add(new Card("New Guinea", "Island"));
        islandCards.add(new Card("Hawai'i", "Island"));
        islandCards.add(new Card("Maui", "Island"));
        islandCards.add(new Card("O'ahu", "Island"));
        islandCards.add(new Card("Mindanao", "Island"));
        islandCards.add(new Card("Majoraca", "Island"));
        islandCards.add(new Card("Euboea", "Island"));
        islandCards.add(new Card("Viti Levu", "Island"));

        // Climate
        climateCards.add(new Card("Semi-Arid", "Climate"));
        climateCards.add(new Card("Oceanic", "Climate"));
        climateCards.add(new Card("Dry Winter Subpolar Oceanic", "Climate"));
        climateCards.add(new Card("Dry Winter Subtropical Highland", "Climate"));
        climateCards.add(new Card("Desert", "Climate"));
        climateCards.add(new Card("Tundra", "Climate"));
        climateCards.add(new Card("Rainforest", "Climate"));
        climateCards.add(new Card("Tropical Savanna", "Climate"));
        climateCards.add(new Card("Boreal", "Climate"));
        climateCards.add(new Card("Mediterranean", "Climate"));
        climateCards.add(new Card("Tropical Oasis", "Climate"));

        // Earth 
        earthCards.add(new Card("Canary Island Palm", "Earth"));
        earthCards.add(new Card("Reed Canary Grass", "Earth"));
        earthCards.add(new Card("Red Cage Fungus", "Earth"));
        earthCards.add(new Card("Venus Fly Trap", "Earth"));
        earthCards.add(new Card("Milk-Cap", "Earth"));
        earthCards.add(new Card("Sensitive Plant", "Earth"));
        earthCards.add(new Card("Giant Puffball", "Earth"));
        earthCards.add(new Card("Shaggy Mane", "Earth"));
        earthCards.add(new Card("Dragon Sprouts", "Earth"));
        earthCards.add(new Card("Avocado Tree", "Earth"));
        earthCards.add(new Card("Dwarf Willow", "Earth"));

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                earthCards.add(earthCards.get(i));
            }
        }
    }
}