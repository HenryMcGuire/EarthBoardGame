//
// Group 3
// 03/03/23
// Earth Board Game
//

import java.util.Scanner;
import java.util.ArrayList;

public class Game {
    
    private static ArrayList<Player> players = new ArrayList<>();

    private static ArrayList<Card> faunaCards = new ArrayList<>();
    private static ArrayList<Card> islandCards = new ArrayList<>();
    private static ArrayList<Card> climateCards = new ArrayList<>();
    private static ArrayList<Card> earthCards = new ArrayList<>();
    
    public final static Scanner stdin = new Scanner(System.in);

    private final static int PLANT = 1,
            COMPOST = 2,
            WATER = 3,
            GROW = 4;


    private final static String[] ACTIONS = {
        PLANT + ". Plant",
        COMPOST + ". Compost",
        WATER + ". Water",
        GROW + ". Grow"
    };

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

        // Prompt for player count
        int playerCount = getPlayerChoice("", new String[]{}, "Please enter the number of players(2-5): ", 2, 5);

        System.out.println();

        // Initialization of cards
        initializeCards();

        // Pick and display fauna
        int faunaCount = 4;
        Card[] fauna = new Card[faunaCount];
        System.out.println("Fauna Cards: ");

        for (int i = 0; i < faunaCount; i++) {
            Card toAdd = drawCard(faunaCards);
            fauna[i] = toAdd;
            System.out.println(toAdd.toString());
        }

        System.out.println();
        
        // Player setup
        int islandCount = 2; // Number of island cards that a player can choose from
        int climateCount = 2; // Number of climate cards that a player can choose from

        for (int i = 0; i < playerCount; i++) {
            Card[] islandChoices = new Card[islandCount];
            Card[] climateChoices = new Card[climateCount];

            for (int j = 0; j < islandCount; j++) {
                islandChoices[j] = drawCard(islandCards);
            }

            for (int j = 0; j < climateCount; j++) {
                climateChoices[j] = drawCard(climateCards);
            }

            String[] islandChoicesAsString = new String[islandCount];

            for (int j = 0; j < islandCount; j++) {
                islandChoicesAsString[j] = islandChoices[j].toString();
            }

            int islandIndex = getPlayerChoice("Player " + (i + 1) + "'s choices for island cards: ", islandChoicesAsString, "Player " + (i + 1) + ", select an island card(1 or 2): ", 1, islandCount);
            Card islandSelection = islandChoices[islandIndex - 1];

            // Add unselected cards back to deck
            for (Card c : islandChoices) {
                if (c != islandSelection) {
                    islandCards.add(c);
                }
            }

            System.out.println();
            
            String[] climateChoicesAsString = new String[climateCount];

            for (int j = 0; j < climateCount; j++) {
                climateChoicesAsString[j] = climateChoices[j].toString();
            }

            int climateIndex = getPlayerChoice("Player " + (i + 1) + "'s choices for climate cards: ", climateChoicesAsString, "Player " + (i + 1) + ", select a climate card(1 or 2): ", 1, climateCount);
            Card climateSelection = climateChoices[climateIndex - 1];

            // Add unselected cards back to deck
            for (Card c : climateChoices) {
                if (c != climateSelection) {
                    climateCards.add(c);
                }
            }

            System.out.println();
            
            players.add(new Player(islandSelection, climateSelection));
        }

        for (int i = 0; i < playerCount; i++) {
            System.out.println("Player " + (i + 1) + " " + players.get(i).toString());
        }

        System.out.println();

        // Player actions
        boolean play = true;

        while (play) {
            for (int i = 0; i < playerCount; i++) {
                // List actions
                // Player choose action
                System.out.println("Action List");

                for (String action : ACTIONS) {
                    System.out.println(action);
                }

                Player active = players.get(i);
                int action = getPlayerChoice("", new String[]{}, "Player " + (i + 1) + ", choose an action (1-" + Integer.toString(ACTIONS.length) + "): ", 1, ACTIONS.length);

                System.out.println();
                
                switch(action) {
                    case PLANT:
                        activePlant(i);

                        for (int j = i + 1; j < i + playerCount; j++) {
                            secondaryPlant(j % playerCount);
                        }
                        
                        for (int j = i; j < i + playerCount; j++) {
                            activateCards(j, "Green");
                        }
                        break;
                    case COMPOST:
                        activeCompost(i);

                        for (int j = i + 1; j < i + playerCount; j++) {
                            secondaryCompost(j % playerCount);
                        }
                        
                        for (int j = i; j < i + playerCount; j++) {
                            activateCards(j, "Red");
                        }
                        break;
                    case WATER:
                        activeWater(i);

                        for (int j = i + 1; j < i + playerCount; j++) {
                            secondaryWater(j % playerCount);
                        }
                        
                        for (int j = i; j < i + playerCount; j++) {
                            activateCards(j, "Blue");
                        }
                        break;
                    case GROW:
                        activeGrow(i);

                        for (int j = i + 1; j < i + playerCount; j++) {
                            secondaryGrow(j % playerCount);
                        }
                        
                        for (int j = i; j < i + playerCount; j++) {
                            activateCards(j, "Yellow");
                        }
                        break;
                }

                System.out.println();
            }
        }

        // Determine winner
        ArrayList<Integer> winnerIndexes = getWinners();

        for (int i = 0; i < winnerIndexes.size(); i++) {
            System.out.println("Congratulations Player " + (winnerIndexes.get(i) + 1) + "! You won!");
        }


        stdin.close();
    }

    // Initializes all decks
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

    private static int getPlayerChoice(String header, String[] options, String prompt, int min, int max) {
        int choice;

        while (true) {
            if (!header.equals("")) {
                System.out.println(header);
            }

            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }
            
            System.out.print(prompt);
            choice = stdin.nextInt();
            
            if (choice >= min && choice <= max) {
                break;
            }
            else {
                System.out.println("Invalid input! Try again!");
            }
        }

        return choice;
    }

    // Returns a random card from the deck input
    // Card is removed from the deck
    private static Card drawCard(ArrayList<Card> deck) {
        int index = (int)(Math.random() * deck.size());
        Card card = deck.get(index);
        deck.remove(index);
        return card;
    }

    
    // Plant up to two cards to tableau, must spend soil in upper left of card(flaura and terrain cards, not event)
    // Draw 4 Earth cards and select 1 for hand, discard 3
    private static void activePlant(int playerIndex) {
        Player player = players.get(playerIndex);
        // NEED TO IMPLEMENT PLANTING

        Card[] cardChoices = new Card[4];
        String[] cardChoicesAsString = new String[4];
 
        for (int i = 0; i < cardChoices.length; i++) {
            cardChoices[i] = drawCard(earthCards);
            cardChoicesAsString[i] = cardChoices[i].toString();
        }

        int cardIndex = getPlayerChoice("Player " + (playerIndex + 1) + "'s choices for cards: ", cardChoicesAsString, "Player " + (playerIndex + 1) + ", select a card(1-4): ", 1, 4);
        Card cardSelection = cardChoices[cardIndex - 1];
        player.addCardToHand(cardSelection);

        // Add unselected cards back to deck
        for (Card c : cardChoices) {
            if (c != cardSelection) {
                earthCards.add(c);
            }
        }

        System.out.println();
        System.out.println(player.toString());
    }

    // Plant one card, or draw one card
    private static void secondaryPlant(int playerIndex) {
        Player player = players.get(playerIndex);

        int secondaryAction = getPlayerChoice("Secondary Plant Action List", new String[]{"Plant 1 Card", "+1 card"}, "Player " + (playerIndex + 1) + ", choose an action (1-" + 2 + "): ", 1, 2);

        if (secondaryAction == 1) {
            // NEED TO IMPLEMENT
            System.out.println();
            System.out.println(player.toString());
        } 
        else {
            player.addCardToHand(drawCard(earthCards));
            System.out.println();
            System.out.println(player.toString());
        }

    }

    // +5 soil +2 compost cards from deck
    private static void activeCompost(int playerIndex) {
        Player player = players.get(playerIndex);
        player.addSoil(5);
        drawCard(earthCards);
        drawCard(earthCards);
        player.addCompost(2);

        System.out.println(player.toString());
        System.out.println();
    }
    
    // +2 soil or +2 compost cards from deck
    private static void secondaryCompost(int playerIndex) {
        Player player = players.get(playerIndex);

        int secondaryAction = getPlayerChoice("Secondary Compost Action List", new String[]{"+2 soil", "+2 compost"}, "Player " + (playerIndex + 1) + ", choose an action (1-" + 2 + "): ", 1, 2);

        if (secondaryAction == 1) {
            player.addSoil(2);
            System.out.println();
            System.out.println(player.toString());
        } 
        else {
            player.addCompost(2);
            drawCard(earthCards);
            drawCard(earthCards);
            System.out.println();
            System.out.println(player.toString());
        }
    }
    
    // Gain up to 6 sprouts to be placed on tableau cards, those that cannot be placed are lost
    // 3 sprouts can be converted from tableau cards to +2 soil
    private static void activeWater(int playerIndex) {
        // NEED TO IMPLEMENT SPROUTS
    }
    
    // +2 sprouts or +2 soil
    private static void secondaryWater(int playerIndex) {
        Player player = players.get(playerIndex);

        int secondaryAction = getPlayerChoice("Secondary Grow Action List", new String[]{"+2 cards", "+2 growth tokens"}, "Player " + (playerIndex + 1) + ", choose an action (1-" + 2 + "): ", 1, 2);

        if (secondaryAction == 1) {
            // NEEED TO IMPLEMENT +2 Sprouts
            System.out.println();
            System.out.println(player.toString());
        } 
        else {
            player.addSoil(2);
            System.out.println();
            System.out.println(player.toString());
        }
    }
    
    // +4 cards to hand from deck, +2 growth tokens on tableau cards
    private static void activeGrow(int playerIndex) {
        Player player = players.get(playerIndex);

        player.addCardToHand(drawCard(earthCards));
        player.addCardToHand(drawCard(earthCards));
        player.addCardToHand(drawCard(earthCards));
        player.addCardToHand(drawCard(earthCards));

        // NEED TO IMPLEMENT GROWTH TOKENS
        System.out.println(player.toString());
        System.out.println();
    }
    
    // +2 cards to hand from deck or +2 growth tokens
    private static void secondaryGrow(int playerIndex) {
        Player player = players.get(playerIndex);

        int secondaryAction = getPlayerChoice("Secondary Grow Action List", new String[]{"+2 cards", "+2 growth tokens"}, "Player " + (playerIndex + 1) + ", choose an action (1-" + 2 + "): ", 1, 2);

        if (secondaryAction == 1) {
            player.addCardToHand(drawCard(earthCards));
            player.addCardToHand(drawCard(earthCards));
            System.out.println();
            System.out.println(player.toString());
        } 
        else {
            // NEED TO IMPLEMENT +2 Growth tokens
            System.out.println();
            System.out.println(player.toString());
        }
    }

    // Activate all cards for players[playerIndex] that action is related to color
    private static void activateCards(int playerIndex, String color) {

    }

    // Determines the winners and returns the player's index
    private static ArrayList<Integer> getWinners() {
        ArrayList<Integer> winnerIndexes = new ArrayList<>();

        for (int i = 0; i < players.size(); i++) {
            winnerIndexes.add(i);
        }

        ArrayList<Integer> indexesToRemove = new ArrayList<>();

        // Most points
        int maximumPoints = 0;

        for (int i = 0; i < winnerIndexes.size(); i++) {
            if (maximumPoints <= players.get(winnerIndexes.get(i)).getScore()) {
                maximumPoints = players.get(winnerIndexes.get(i)).getScore();
            }
        }

        for (int i = 0; i < winnerIndexes.size(); i++) {
            if (maximumPoints != players.get(winnerIndexes.get(i)).getScore())
            {
                indexesToRemove.add(i);
            }
        }

        for (int i = 0; i < indexesToRemove.size(); i++) {
            winnerIndexes.remove(indexesToRemove.get(i));
        }

        if (winnerIndexes.size() == 1) {
            return winnerIndexes;
        }

        // Soil
        int maximumSoil = 0;

        for (int i = 0; i < winnerIndexes.size(); i++) {
            if (maximumSoil <= players.get(winnerIndexes.get(i)).getSoil()) {
                maximumSoil = players.get(winnerIndexes.get(i)).getSoil();
            }
        }

        for (int i = 0; i < winnerIndexes.size(); i++) {
            if (maximumSoil != players.get(winnerIndexes.get(i)).getSoil())
            {
                indexesToRemove.add(i);
            }
        }

        for (int i = 0; i < indexesToRemove.size(); i++) {
            winnerIndexes.remove(indexesToRemove.get(i));
        }

        if (winnerIndexes.size() == 1) {
            return winnerIndexes;
        }
        // hand 
        // REQUIRES getHand or getHandCount in Player
        // growth
        // REQUIRES getGrowth in Player
        // sprouts
        // REQUIRES getSprouts in Player
        // composted cards
        int maximumCompost = 0;

        for (int i = 0; i < winnerIndexes.size(); i++) {
            if (maximumCompost <= players.get(winnerIndexes.get(i)).getCompost()) {
                maximumCompost = players.get(winnerIndexes.get(i)).getCompost();
            }
        }

        for (int i = 0; i < winnerIndexes.size(); i++) {
            if (maximumCompost != players.get(winnerIndexes.get(i)).getCompost())
            {
                indexesToRemove.add(i);
            }
        }

        for (int i = 0; i < indexesToRemove.size(); i++) {
            winnerIndexes.remove(indexesToRemove.get(i));
        }

        if (winnerIndexes.size() == 1) {
            return winnerIndexes;
        }

        return winnerIndexes;
    }
}