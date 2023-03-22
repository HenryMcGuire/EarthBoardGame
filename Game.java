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

                int action = getPlayerChoice("", new String[]{}, "Player " + (i + 1) + ", choose an action (1-" + Integer.toString(ACTIONS.length) + "): ", 1, ACTIONS.length);

                System.out.println();
                
                switch(action) {
                    case PLANT:
                        boolean triggerEnd = activePlant(i);

                        if (triggerEnd) {
                            System.out.println("Player " + (i + 1) + ", has completed their tableau. The game will end after this round of moves is completed.");
                            play = false;
                        }

                        for (int j = i + 1; j < i + playerCount; j++) {
                            triggerEnd = secondaryPlant(j % playerCount);

                            if (triggerEnd) {
                                System.out.println("Player " + (i + 1) + ", has completed their tableau. The game will end after this round of moves is completed.");
                                play = false;
                            }
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

    private static int getPlayerChoice(String header, ArrayList<Card> cards, String prompt, int min, int max) {
        int choice;

        while (true) {
            if (!header.equals("")) {
                System.out.println(header);
            }

            for (int i = 0; i < cards.size(); i++) {
                System.out.println((i + 1) + ". " + cards.get(i).toString());
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
    private static boolean activePlant(int playerIndex) {
        Player player = players.get(playerIndex);
        boolean triggerEnd = false;

        for (int i = 0; i < 2; i++) {
            triggerEnd = plantCard(playerIndex);

            if (triggerEnd) {
                break;
            }
        }

        ArrayList<Card> cardChoices = new ArrayList<Card>();
 
        for (int i = 0; i < 4; i++) {
            cardChoices.add(drawCard(earthCards));
        }

        int cardIndex = getPlayerChoice("Player " + (playerIndex + 1) + "'s choices for cards: ", cardChoices, "Player " + (playerIndex + 1) + ", select a card(1-4 or): ", 1, 4);
        Card cardSelection = cardChoices.get(cardIndex - 1);
        player.addCardToHand(cardSelection);

        // Add unselected cards back to deck
        for (Card c : cardChoices) {
            if (c != cardSelection) {
                earthCards.add(c);
            }
        }

        System.out.println();
        System.out.println(player.toString());
        return triggerEnd;
    }

    // Plant one card, or draw one card
    private static boolean secondaryPlant(int playerIndex) {
        Player player = players.get(playerIndex);

        int secondaryAction = getPlayerChoice("Secondary Plant Action List", new String[]{"Plant 1 Card", "+1 card"}, "Player " + (playerIndex + 1) + ", choose an action (1-" + 2 + "): ", 1, 2);

        if (secondaryAction == 1) {
            boolean triggerEnd = plantCard(playerIndex);
            System.out.println();
            System.out.println(player.toString());
            return triggerEnd;
        } 
        else {
            player.addCardToHand(drawCard(earthCards));
            System.out.println();
            System.out.println(player.toString());
        }

        return false;
    }

    // Handles the procedure of planting
    private static boolean plantCard(int playerIndex) {
        Player player = players.get(playerIndex);

        if (player.tableauFull()) {
            System.out.println("Unable to plant. Tableau is full!");
            return true;
        }

        ArrayList<Card> cardChoices = new ArrayList<Card>();

        for (Card c : player.getHandList()) 
        {
            if (c.getPlantCost() <= player.getSoil()) {
                cardChoices.add(c);
            }
        }

        if (cardChoices.size() == 0) {
            System.out.println("Player " + (playerIndex + 1) + ", you have no cards to plant.");
            return false;
        }

        int cardIndex = getPlayerChoice("Player " + (playerIndex + 1) + "'s choices for cards to plant: ", cardChoices, "Player " + (playerIndex + 1) + ", select a card(1-" +  cardChoices.size() + " or 0 to pass): ", 0, cardChoices.size());

        if (cardIndex == 0) {
            return false;
        }
        else {
            while (true) {
                Card cardSelection = cardChoices.get(cardIndex - 1);
                int tableauIndex = getPlayerChoice("", new String[]{}, "Player " + (playerIndex + 1) + ", select the tableau index to plant the card: ", 1, 16);
                int x = (tableauIndex - 1) % 4;
                int y = (tableauIndex - 1) / 4;

                if (player.getTableauCard(x, y) == null) {
                    player.tableauAdd(cardSelection, x, y);
                    player.handRemove(cardSelection);
                    player.addSoil(cardSelection.getPlantCost() * -1);
                    break;
                }
                else {
                    System.out.println("Tableau index already contains a card. Retry!");
                    // Need to implement ability to shift the tableau
                }
            }
        }

        return player.tableauFull();
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
        applySprouts(playerIndex, 6);
    }
    
    // +2 sprouts or +2 soil
    private static void secondaryWater(int playerIndex) {
        Player player = players.get(playerIndex);

        int secondaryAction = getPlayerChoice("Secondary Grow Action List", new String[]{"+2 cards", "+2 growth tokens"}, "Player " + (playerIndex + 1) + ", choose an action (1-" + 2 + "): ", 1, 2);

        if (secondaryAction == 1) {
            applySprouts(playerIndex, 2);
            System.out.println();
            System.out.println(player.toString());
        } 
        else {
            player.addSoil(2);
            System.out.println();
            System.out.println(player.toString());
        }
    }

    // Handles the procedure to apply sprouts to tableau cards
    private static void applySprouts(int playerIndex, int numSprouts) {
        Player player = players.get(playerIndex);
        ArrayList<Card> cardChoices = player.getSproutCards();

        if (cardChoices.size() == 0) {
            System.out.println("Player " + (playerIndex + 1) + ", you have no cards to sprout.");
            return;
        }

        int totalSprouts = player.getTotalSprouts();

        if (totalSprouts >= 3) {
            ArrayList<Card> subCards = new ArrayList<Card>(); // Sprout cards that contain sprouts

            for (Card c : cardChoices) {
                if (c.getNumSprouts() > 0) {
                    totalSprouts += c.getNumSprouts();
                    subCards.add(c);
                }
            }

            int totalRemoved = 0;
            int option = getPlayerChoice("Player " + (playerIndex + 1) + "'s choices for cards to remove sprouts: ", subCards, "Player " + (playerIndex + 1) + ", would you like remove any sprouts?(0 for no, 1 for yes): ", 0, 1);

            if (option == 1) {
                while(true) {
                    subCards.clear();
                    for (Card c : cardChoices) {
                        if (c.getNumSprouts() > 0) {
                            subCards.add(c);
                        }
                    }

                    if (totalSprouts - totalRemoved > 0) {
                        System.out.println("There are no remaining sprouts to remove. Player " + (playerIndex + 1) + ", you will gain " + (totalRemoved / 3 * 2) + " soil.");
                        break;
                    }

                    int cardIndex = getPlayerChoice("Player " + (playerIndex + 1) + "'s choices for cards to remove sprouts: ", subCards, "Player " + (playerIndex + 1) + ", select a card(1-" +  subCards.size() + "): ", 1, subCards.size());
                    Card cardSelection = subCards.get(cardIndex - 1);

                    int removalCount = getPlayerChoice("", new String[]{}, "Player " + (playerIndex + 1) + ", how many sprouts would you like to remove?(1-" +  cardSelection.getNumSprouts() + "): ", 1, cardSelection.getNumSprouts());

                    cardSelection.addSprouts(removalCount * -1);
                    totalRemoved += removalCount;

                    option = getPlayerChoice("", new String[]{}, "Player " + (playerIndex + 1) + ", you will gain " + (totalRemoved / 3 * 2) + " soil. Do you want to continue removing sprouts?(0 for no, 1 for yes): ", 0, 1);

                    if (option == 0) {
                        break;
                    }
                }

                player.addSoil(totalRemoved / 3 * 2);
            }
        }

        int emptySpots = 0;

        for (Card c : cardChoices) {
            emptySpots = c.getMaximumSprouts() - c.getNumSprouts();
        }

        while (true) {
            if (numSprouts <= 0) {
                System.out.println("There are no remaining sprouts to add.");
                break;
            }
            
            ArrayList<Card> subCards = new ArrayList<Card>(); // Sprout cards that contain sprouts

            for (Card c : cardChoices) {

                if (c.getMaximumSprouts() - c.getNumSprouts() > 0) {
                    emptySpots += c.getNumSprouts();
                    subCards.add(c);
                }
            }

            if (emptySpots <= 0) {
                System.out.println("There are no remaining spots for sprouts.");
                break;
            }

            int cardIndex = getPlayerChoice("Player " + (playerIndex + 1) + "'s choices for cards to add sprouts: ", subCards, "Player " + (playerIndex + 1) + ", you have " + numSprouts + " to add. Select a card(1-" + subCards.size() + "): ", 1, subCards.size());
            Card cardSelection = subCards.get(cardIndex);

            int empty = cardSelection.getMaximumSprouts() - cardSelection.getNumSprouts();
            int max = Integer.min(empty, numSprouts);

            int addCount = getPlayerChoice("", new String[]{}, "Player " + (playerIndex + 1) + ", how many sprouts would you like to add?(1-" +  max + "): ", 1, max);

            cardSelection.addSprouts(addCount);
            numSprouts -= addCount;
        }
    }
    
    // +4 cards to hand from deck, +2 growth tokens on tableau cards
    private static void activeGrow(int playerIndex) {
        Player player = players.get(playerIndex);

        for (int i = 0; i < 4; i++) {
            player.addCardToHand(drawCard(earthCards));
        }

        for (int i = 0; i < 2; i++) {
            applyGrowth(playerIndex);
        }

        System.out.println(player.toString());
        System.out.println();
    }
    
    // +2 cards to hand from deck or +2 growth tokens
    private static void secondaryGrow(int playerIndex) {
        Player player = players.get(playerIndex);

        int secondaryAction = getPlayerChoice("Secondary Grow Action List", new String[]{"+2 cards", "+2 growth tokens"}, "Player " + (playerIndex + 1) + ", choose an action (1-" + 2 + "): ", 1, 2);

        if (secondaryAction == 1) {
            for (int i = 0; i < 2; i++) {
                player.addCardToHand(drawCard(earthCards));
            }
            
            System.out.println();
            System.out.println(player.toString());
        } 
        else {
            for (int i = 0; i < 2; i++) {
                applyGrowth(playerIndex);
            }

            System.out.println();
            System.out.println(player.toString());
        }
    }

    // Handles procedure of applying growth
    private static void applyGrowth(int playerIndex) {
        Player player = players.get(playerIndex);
        ArrayList<Card> cardChocies = player.getGrowthCards();

        if (cardChocies.size() == 0) {
            System.out.println("Player " + (playerIndex + 1) + ", you have no cards to grow.");
            return;
        }

        int cardIndex = getPlayerChoice("Player " + (playerIndex + 1) + "'s choices for cards to grow: ", cardChocies, "Player " + (playerIndex + 1) + ", select a card(1-" +  cardChocies.size() + "): ", 1, cardChocies.size());

        Card cardSelection = cardChocies.get(cardIndex - 1);
        cardSelection.addGrowth(1);
    }

    // Activate all cards for players[playerIndex] that action is related to color
    private static void activateCards(int playerIndex, String color) {

    }
    
    private final static int MAXPOINTS = 1,
            MAXSOIL = 2,
            MAXHAND = 3,
            MAXGROWTH = 4,
            MAXSPROUTS = 5,
            MAXCOMPOST = 6;

    // Determines the winners and returns the player's index
    private static ArrayList<Integer> getWinners() {
        ArrayList<Integer> winnerIndexes = new ArrayList<>();

        for (int i = 0; i < players.size(); i++) {
            winnerIndexes.add(i);
        }

        // Points
        winnerIndexes = getWinnersByCategory(winnerIndexes, MAXPOINTS);
        
        if (winnerIndexes.size() == 1) {
            return winnerIndexes;
        }

        // Soil
        winnerIndexes = getWinnersByCategory(winnerIndexes, MAXSOIL);
        
        if (winnerIndexes.size() == 1) {
            return winnerIndexes;
        }

        // Hand Size
        winnerIndexes = getWinnersByCategory(winnerIndexes, MAXHAND);
        
        if (winnerIndexes.size() == 1) {
            return winnerIndexes;
        }

        // Growth
        winnerIndexes = getWinnersByCategory(winnerIndexes, MAXGROWTH);
        
        if (winnerIndexes.size() == 1) {
            return winnerIndexes;
        }

        // Sprouts
        winnerIndexes = getWinnersByCategory(winnerIndexes, MAXSPROUTS);
        
        if (winnerIndexes.size() == 1) {
            return winnerIndexes;
        }

        // Compost
        winnerIndexes = getWinnersByCategory(winnerIndexes, MAXCOMPOST);
        
        if (winnerIndexes.size() == 1) {
            return winnerIndexes;
        }

        return winnerIndexes;
    }


    // Returns list of winners according to category given
    private static ArrayList<Integer> getWinnersByCategory(ArrayList<Integer> indexesToCheck, int category) {
        int maxVal = 0;

        for (int i : indexesToCheck) {
            int valToCheck = 0;

            if (category == MAXPOINTS) {
                maxVal = Integer.max(maxVal, players.get(i).getScore());
            }
            else if (category == MAXSOIL) {
                maxVal = Integer.max(maxVal, players.get(i).getSoil());
            }
            else if (category == MAXHAND) {
                maxVal = Integer.max(maxVal, players.get(i).getHandList().size());
            }
            else if (category == MAXGROWTH) {
                maxVal = Integer.max(maxVal, players.get(i).getTotalGrowth());
            }
            if (category == MAXSPROUTS) {
                maxVal = Integer.max(maxVal, players.get(i).getTotalSprouts());
            }
            else if (category == MAXCOMPOST) {
                maxVal = Integer.max(maxVal, players.get(i).getCompost());
            }
        }

        ArrayList<Integer> winnerIndexes = new ArrayList<>();

        for (int i : indexesToCheck) {
            int valToCheck = 0;

            if (category == MAXPOINTS) {
                valToCheck = players.get(i).getScore();
            }
            else if (category == MAXSOIL) {
                valToCheck = players.get(i).getSoil();
            }
            else if (category == MAXHAND) {
                valToCheck = players.get(i).getHandList().size();
            }
            else if (category == MAXGROWTH) {
                valToCheck = players.get(i).getTotalGrowth();
            }
            if (category == MAXSPROUTS) {
                valToCheck = players.get(i).getTotalSprouts();
            }
            else if (category == MAXCOMPOST) {
                valToCheck = players.get(i).getCompost();
            }

            if (valToCheck == maxVal) {
                winnerIndexes.add(i);
            }
        }

        return winnerIndexes;
    }

}