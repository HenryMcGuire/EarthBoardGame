import java.util.Scanner;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

/*
 * Game
 * 
 * Handles the game flow of EARTH.
 */
public class Game {
    private static Deck faunaDeck;
    private static Deck islandDeck;
    private static Deck climateDeck;
    private static Deck earthDeck;

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

    public final static int GREEN = 1,
            RED = 2,
            BLUE = 3,
            YELLOW = 4,
            MULTI = 5,
            BLACK = 6,
            BROWN = 7;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintStream out = new PrintStream(System.out);

        // Intro
        out.println("Welcome to ");
        out.println("");
        out.println("  ______              _____    _______   _    _ ");
        out.println(" |  ____|     /\\     |  __ \\  |__   __| | |  | |");
        out.println(" | |__       /  \\    | |__) |    | |    | |__| |");
        out.println(" |  __|     / /\\ \\   |  _  /     | |    |  __  |");
        out.println(" | |____   / ____ \\  | | \\ \\     | |    | |  | |");
        out.println(" |______| /_/    \\_\\ |_|  \\_\\    |_|    |_|  |_|");
        out.println("");
        out.println("For game information visit: https://www.youtube.com/watch?v=GQ9rFntr5s4");
        out.println("");

        ArrayList<Player> players = new ArrayList<>();

        // Prompt for player count
        int playerCount = getChoice(in, out, "", new String[] {}, "Please enter the number of players(2-5): ", 2, 5);

        out.println();

        // Initialization of cards
        try {
            faunaDeck = new Deck("fauna.csv");
            islandDeck = new Deck("island.csv");
            climateDeck = new Deck("climate.csv");
            earthDeck = new Deck("earth.csv");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        // Pick and display fauna
        int faunaCount = 4;
        Card[] fauna = new Card[faunaCount];
        out.println("Fauna Cards: ");

        for (int i = 0; i < faunaCount; i++) {
            Card toAdd = faunaDeck.draw();
            fauna[i] = toAdd;
            out.println(toAdd.toString());
        }

        out.println();

        // Player setup
        int islandCount = 2; // Number of island cards that a player can choose from
        int climateCount = 2; // Number of climate cards that a player can choose from

        for (int i = 0; i < playerCount; i++) {
            ArrayList<Card> islandChoices = new ArrayList<>();
            ArrayList<Card> climateChoices = new ArrayList<>();

            for (int j = 0; j < islandCount; j++) {
                islandChoices.add(islandDeck.draw());
            }

            for (int j = 0; j < climateCount; j++) {
                climateChoices.add(climateDeck.draw());
            }

            int islandIndex = getCardChoice(in, out, "Player " + (i + 1) + "'s choices for island cards: ",
                    islandChoices, "Player " + (i + 1) + ", select an island card(1 or 2): ", 1, islandCount);
            Card islandSelection = islandChoices.get(islandIndex - 1);

            // Add unselected cards back to deck
            for (Card c : islandChoices) {
                if (c != islandSelection) {
                    islandDeck.add(c);
                }
            }

            out.println();

            int climateIndex = getCardChoice(in, out, "Player " + (i + 1) + "'s choices for climate cards: ",
                    climateChoices, "Player " + (i + 1) + ", select a climate card(1 or 2): ", 1, climateCount);
            Card climateSelection = climateChoices.get(climateIndex - 1);

            // Add unselected cards back to deck
            for (Card c : climateChoices) {
                if (c != climateSelection) {
                    climateDeck.add(c);
                }
            }

            out.println();

            players.add(new Player(islandSelection, climateSelection, i));
        }

        for (int i = 0; i < playerCount; i++) {
            out.println("Player " + (i + 1) + " " + players.get(i).toString());
        }

        out.println();

        // Player actions
        boolean play = true;

        while (play) {
            for (int i = 0; i < playerCount; i++) {
                // List actions
                // Player choose action
                Player active = players.get(i);

                out.println("Action List");

                for (String action : ACTIONS) {
                    out.println(action);
                }

                int action = getChoice(in, out, "", new String[] {},
                        "Player " + (i + 1) + ", choose an action (1-" + Integer.toString(ACTIONS.length) + "): ", 1,
                        ACTIONS.length);

                out.println();

                switch (action) {
                    case PLANT:
                        boolean triggerEnd = activePlant(in, out, active);

                        if (triggerEnd) {
                            out.println("Player " + (i + 1)
                                    + ", has completed their tableau. The game will end after this round of moves is completed.");
                            play = false;
                        }

                        for (int j = i + 1; j < i + playerCount; j++) {
                            triggerEnd = secondaryPlant(in, out, players.get(j % playerCount));

                            if (triggerEnd) {
                                out.println("Player " + (j % playerCount + 1)
                                        + ", has completed their tableau. The game will end after this round of moves is completed.");
                                play = false;
                            }
                        }

                        break;
                    case COMPOST:
                        activeCompost(out, active);

                        for (int j = i + 1; j < i + playerCount; j++) {
                            Player secondary = players.get(j % playerCount);
                            secondaryCompost(in, out, secondary);
                        }

                        break;
                    case WATER:
                        activeWater(in, out, active);

                        for (int j = i + 1; j < i + playerCount; j++) {
                            Player secondary = players.get(j % playerCount);
                            secondaryWater(in, out, secondary);
                        }

                        break;
                    case GROW:
                        activeGrow(in, out, active);

                        for (int j = i + 1; j < i + playerCount; j++) {
                            Player secondary = players.get(j % playerCount);
                            secondaryGrow(in, out, secondary);
                        }

                        break;
                }

                out.println();

                // NEED TO ADD IMPLEMENTATION OF SCORING VIA FAUNA CARDS

                for (int j = i; j < i + playerCount; j++) {
                    Player player = players.get(j % playerCount);
                    out.println("Player " + (j % playerCount + 1) + " it is your turn to activate cards.");
                    activateCards(in, out, player, action);
                    out.println();
                }

                out.println();
            }
        }

        out.println("Game completed!");

        // Determine winner
        ArrayList<Integer> winnerIndexes = getWinners(players);

        for (int i = 0; i < winnerIndexes.size(); i++) {
            out.println("Congratulations Player " + (winnerIndexes.get(i) + 1) + "! You won!");
        }

        in.close();
        out.close();
    }

    // Outputs options to the user and returns the users selection
    protected static int getChoice(Scanner in, PrintStream out, String header, String[] options, String prompt, int min,
            int max) {
        int choice;

        while (true) {
            if (!header.equals("")) {
                out.println(header);
            }

            for (int i = 0; i < options.length; i++) {
                out.println((i + 1) + ". " + options[i]);
            }

            out.print(prompt);
            choice = in.nextInt();

            if (validChoice(choice, min, max)) {
                break;
            } 
            else {
                out.println("Invalid input! Try again!");
            }
        }

        return choice;
    }

    // Outputs card options to the user and returns the users selection
    protected static int getCardChoice(Scanner in, PrintStream out, String header, ArrayList<Card> cards, String prompt,
            int min, int max) {
        int choice;

        while (true) {
            if (!header.equals("")) {
                out.println(header);
            }

            for (int i = 0; i < cards.size(); i++) {
                out.println((i + 1) + ". " + cards.get(i).toString());
            }

            out.print(prompt);
            choice = in.nextInt();

            if (validChoice(choice, min, max)) {
                break;
            } 
            else {
                out.println("Invalid input! Try again!");
            }
        }

        return choice;
    }

    private static boolean validChoice(int choice, int min, int max) {
        return choice >= min && choice <= max;
    }

    // Plant up to two cards to tableau, must spend soil in upper left of
    // card(flaura and terrain cards, not event)
    // Draw 4 Earth cards and select 1 for hand, discard 3
    protected static boolean activePlant(Scanner in, PrintStream out, Player player) {
        boolean triggerEnd = false;

        for (int i = 0; i < 2; i++) {
            triggerEnd = plantCard(in, out, player);

            if (triggerEnd) {
                break;
            }
        }

        ArrayList<Card> cardChoices = new ArrayList<Card>();

        for (int i = 0; i < 4; i++) {
            cardChoices.add(earthDeck.draw());
        }

        int cardIndex = getCardChoice(in, out, player.getName() + "'s choices for cards: ", cardChoices,
                player.getName() + ", select a card(1-4 or): ", 1, 4);
        Card cardSelection = cardChoices.get(cardIndex - 1);
        player.addCardToHand(cardSelection);

        // Add unselected cards back to deck
        for (Card c : cardChoices) {
            if (c != cardSelection) {
                earthDeck.add(c);
            }
        }

        out.println();
        out.println(player.toString());
        return triggerEnd;
    }

    // Plant one card, or draw one card
    protected static boolean secondaryPlant(Scanner in, PrintStream out, Player player) {

        int secondaryAction = getChoice(in, out, "Secondary Plant Action List",
                new String[] { "Plant 1 Card", "+1 card" }, player.getName() + ", choose an action (1-" + 2 + "): ", 1,
                2);

        if (secondaryAction == 1) {
            boolean triggerEnd = plantCard(in, out, player);
            out.println();
            out.println(player.toString());
            return triggerEnd;
        } 
        else {
            player.addCardToHand(earthDeck.draw());
            out.println();
            out.println(player.toString());
        }

        return false;
    }

    // Handles the procedure of planting
    private static boolean plantCard(Scanner in, PrintStream out, Player player) {
        if (player.tableauFull()) {
            out.println("Unable to plant. Tableau is full!");
            return true;
        }

        ArrayList<Card> cardChoices = new ArrayList<Card>();

        for (Card c : player.getHandList()) {
            if (c.getPlantCost() <= player.getSoil()) {
                cardChoices.add(c);
            }
        }

        if (cardChoices.size() == 0) {
            out.println(player.getName() + ", you have no cards to plant.");
            return false;
        }

        int cardIndex = getCardChoice(in, out, player.getName() + "'s choices for cards to plant: ", cardChoices,
                player.getName() + ", select a card(1-" + cardChoices.size() + " or 0 to pass): ", 0,
                cardChoices.size());

        if (cardIndex == 0) {
            return false;
        } 
        else {
            while (true) {
                Card cardSelection = cardChoices.get(cardIndex - 1);
                int tableauIndex = getChoice(in, out, "", new String[] {},
                        player.getName() + ", select the tableau index to plant the card: ", 1, 16);
                int x = (tableauIndex - 1) % 4;
                int y = (tableauIndex - 1) / 4;

                if (player.getTableauCard(x, y) == null) {
                    player.tableauAdd(cardSelection, x, y);
                    player.handRemove(cardSelection);
                    player.addSoil(cardSelection.getPlantCost() * -1);
                    break;
                } 
                else {
                    out.println("Tableau index already contains a card. Retry!");
                    // Need to implement ability to shift the tableau
                }
            }
        }

        return player.tableauFull();
    }

    // +5 soil +2 compost cards from deck
    protected static void activeCompost(PrintStream out, Player player) {
        player.addSoil(5);
        // CHANGE TO STORING COMPOSTED CARDS
        earthDeck.draw();
        earthDeck.draw();
        player.addCompost(2);

        out.println();
        out.println(player.toString());
    }

    // +2 soil or +2 compost cards from deck
    protected static void secondaryCompost(Scanner in, PrintStream out, Player player) {
        int secondaryAction = getChoice(in, out, "Secondary Compost Action List",
                new String[] { "+2 soil", "+2 compost" }, player.getName() + ", choose an action (1-2) ", 1, 2);

        if (secondaryAction == 1) {
            player.addSoil(2);
            out.println();
            out.println(player.toString());
        } 
        else {
            player.addCompost(2);
            // CHANGE TO STORING COMPOSTED CARDS
            earthDeck.draw();
            earthDeck.draw();

            out.println();
            out.println(player.toString());
        }
    }

    // Gain up to 6 sprouts to be placed on tableau cards, those that cannot be
    // placed are lost
    // 3 sprouts can be converted from tableau cards to +2 soil
    protected static void activeWater(Scanner in, PrintStream out, Player player) {
        applySprouts(in, out, player, 6);
    }

    // +2 sprouts or +2 soil
    protected static void secondaryWater(Scanner in, PrintStream out, Player player) {
        int secondaryAction = getChoice(in, out, "Secondary Grow Action List",
                new String[] { "+2 cards", "+2 growth tokens" }, player.getName() + ", choose an action (1-2: ", 1, 2);

        if (secondaryAction == 1) {
            applySprouts(in, out, player, 2);
            out.println();
            out.println(player.toString());
        } 
        else {
            player.addSoil(2);
            out.println();
            out.println(player.toString());
        }
    }

    // Handles the procedure to apply sprouts to tableau cards
    private static void applySprouts(Scanner in, PrintStream out, Player player, int numSprouts) {
        ArrayList<Card> cardChoices = player.getSproutCards();

        if (cardChoices.size() == 0) {
            out.println(player.getName() + ", you have no cards to sprout.");
            return;
        }

        int totalSprouts = player.getSprouts();

        if (totalSprouts >= 3) {
            ArrayList<Card> subCards = new ArrayList<Card>(); // Sprout cards that contain sprouts

            for (Card c : cardChoices) {
                if (c.getSprouts() > 0) {
                    totalSprouts += c.getSprouts();
                    subCards.add(c);
                }
            }

            int totalRemoved = 0;
            int option = getCardChoice(in, out, player.getName() + "'s choices for cards to remove sprouts: ", subCards,
                    player.getName() + ", would you like remove any sprouts?(0 for no, 1 for yes): ", 0, 1);

            if (option == 1) {
                while (true) {
                    subCards.clear();
                    for (Card c : cardChoices) {
                        if (c.getSprouts() > 0) {
                            subCards.add(c);
                        }
                    }

                    if (totalSprouts - totalRemoved > 0) {
                        out.println("There are no remaining sprouts to remove. " + player.getName() + ", you will gain "
                                + (totalRemoved / 3 * 2) + " soil.");
                        break;
                    }

                    int cardIndex = getCardChoice(in, out,
                            player.getName() + "'s choices for cards to remove sprouts: ", subCards,
                            player.getName() + ", select a card(1-" + subCards.size() + "): ", 1, subCards.size());
                    Card cardSelection = subCards.get(cardIndex - 1);

                    int removalCount = getChoice(in, out, "", new String[] {}, player.getName()
                            + ", how many sprouts would you like to remove?(1-" + cardSelection.getSprouts() + "): ", 1,
                            cardSelection.getSprouts());

                    cardSelection.addSprouts(removalCount * -1);
                    totalRemoved += removalCount;

                    option = getChoice(in, out, "", new String[] {},
                            player.getName() + ", you will gain " + (totalRemoved / 3 * 2)
                                    + " soil. Do you want to continue removing sprouts?(0 for no, 1 for yes): ",
                            0, 1);

                    if (option == 0) {
                        break;
                    }
                }

                player.addSoil(totalRemoved / 3 * 2);
            }
        }

        int emptySpots = 0;

        for (Card c : cardChoices) {
            emptySpots = c.getMaxSprouts() - c.getSprouts();
        }

        while (true) {
            if (numSprouts <= 0) {
                out.println("There are no remaining sprouts to add.");
                break;
            }

            ArrayList<Card> subCards = new ArrayList<Card>(); // Sprout cards that contain sprouts

            for (Card c : cardChoices) {

                if (c.getMaxSprouts() - c.getSprouts() > 0) {
                    emptySpots += c.getSprouts();
                    subCards.add(c);
                }
            }

            if (emptySpots <= 0) {
                out.println("There are no remaining spots for sprouts.");
                break;
            }

            int cardIndex = getCardChoice(
                    in, out, player.getName() + "'s choices for cards to add sprouts: ", subCards, player.getName()
                            + ", you have " + numSprouts + " to add. Select a card(1-" + subCards.size() + "): ",
                    1, subCards.size());
            Card cardSelection = subCards.get(cardIndex);

            int empty = cardSelection.getMaxSprouts() - cardSelection.getSprouts();
            int max = Integer.min(empty, numSprouts);

            int addCount = getChoice(in, out, "", new String[] {},
                    player.getName() + ", how many sprouts would you like to add?(1-" + max + "): ", 1, max);

            cardSelection.addSprouts(addCount);
            numSprouts -= addCount;
        }
    }

    // +4 cards to hand from deck, +2 growth tokens on tableau cards
    protected static void activeGrow(Scanner in, PrintStream out, Player player) {
        for (int i = 0; i < 4; i++) {
            player.addCardToHand(earthDeck.draw());
        }

        for (int i = 0; i < 2; i++) {
            applyGrowth(in, out, player);
        }

        out.println(player.toString());
        out.println();
    }

    // +2 cards to hand from deck or +2 growth tokens
    protected static void secondaryGrow(Scanner in, PrintStream out, Player player) {
        int secondaryAction = getChoice(in, out, "Secondary Grow Action List",
                new String[] { "+2 cards", "+2 growth tokens" },
                player.getName() + ", choose an action (1-" + 2 + "): ", 1, 2);

        if (secondaryAction == 1) {
            for (int i = 0; i < 2; i++) {
                player.addCardToHand(earthDeck.draw());
            }

            out.println();
            out.println(player.toString());
        } 
        else {
            for (int i = 0; i < 2; i++) {
                applyGrowth(in, out, player);
            }

            out.println();
            out.println(player.toString());
        }
    }

    // Handles procedure of applying growth
    private static void applyGrowth(Scanner in, PrintStream out, Player player) {
        ArrayList<Card> cardChocies = player.getMaxGrowthCards();

        if (cardChocies.size() == 0) {
            out.println(player.getName() + ", you have no cards to grow.");
            return;
        }

        int cardIndex = getCardChoice(in, out, player.getName() + "'s choices for cards to grow: ", cardChocies,
                player.getName() + ", select a card(1-" + cardChocies.size() + "): ", 1, cardChocies.size());

        Card cardSelection = cardChocies.get(cardIndex - 1);
        cardSelection.addGrowth(1);
    }

    // Activate all cards for players[playerIndex] that action is related to color
    protected static void activateCards(Scanner in, PrintStream out, Player player, int action) {
        int option = getChoice(in, out, "", new String[] {},
                player.getName() + " would you like to activate cards on player card(1) or tableau(2) first?)", 1, 2);

        if (option == 1) {
            activateCard(player, player.getIsland(), action);
            activateCard(player, player.getClimate(), action);
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Card tableauCard = player.getTableauCard(i, j);

                if (tableauCard != null) {
                    activateCard(player, tableauCard, action);
                }
            }
        }

        if (option == 2) {
            activateCard(player, player.getClimate(), action);
            activateCard(player, player.getIsland(), action);
        }
    }

    private static void activateCard(Player player, Card c, int action) {
        if (c.getAbilityColor() == action) {
            // Implement activation of cards
        }
    }

    // Possible argument values for getWinnersByCategory
    private final static int MAXPOINTS = 1,
            MAXSOIL = 2,
            MAXHAND = 3,
            MAXGROWTH = 4,
            MAXSPROUTS = 5,
            MAXCOMPOST = 6;

    // Determines the winners and returns the player's index
    protected static ArrayList<Integer> getWinners(ArrayList<Player> players) {
        ArrayList<Integer> winnerIndexes = new ArrayList<>();

        for (int i = 0; i < players.size(); i++) {
            winnerIndexes.add(i);
        }

        // Points
        winnerIndexes = getWinnersByCategory(players, winnerIndexes, MAXPOINTS);

        if (winnerIndexes.size() == 1) {
            return winnerIndexes;
        }

        // Soil
        winnerIndexes = getWinnersByCategory(players, winnerIndexes, MAXSOIL);

        if (winnerIndexes.size() == 1) {
            return winnerIndexes;
        }

        // Hand Size
        winnerIndexes = getWinnersByCategory(players, winnerIndexes, MAXHAND);

        if (winnerIndexes.size() == 1) {
            return winnerIndexes;
        }

        // Growth
        winnerIndexes = getWinnersByCategory(players, winnerIndexes, MAXGROWTH);

        if (winnerIndexes.size() == 1) {
            return winnerIndexes;
        }

        // Sprouts
        winnerIndexes = getWinnersByCategory(players, winnerIndexes, MAXSPROUTS);

        if (winnerIndexes.size() == 1) {
            return winnerIndexes;
        }

        // Compost
        winnerIndexes = getWinnersByCategory(players, winnerIndexes, MAXCOMPOST);

        if (winnerIndexes.size() == 1) {
            return winnerIndexes;
        }

        return winnerIndexes;
    }

    // Returns list of winners according to category given
    private static ArrayList<Integer> getWinnersByCategory(ArrayList<Player> players, ArrayList<Integer> indexesToCheck,
            int category) {
        int maxVal = 0;

        for (int i : indexesToCheck) {
            switch (category) {
                case MAXPOINTS:
                    maxVal = Integer.max(maxVal, players.get(i).getScore());
                    break;
                case MAXSOIL:
                    maxVal = Integer.max(maxVal, players.get(i).getSoil());
                    break;
                case MAXHAND:
                    maxVal = Integer.max(maxVal, players.get(i).getHandList().size());
                    break;
                case MAXGROWTH:
                    maxVal = Integer.max(maxVal, players.get(i).getTotalGrowth());
                    break;
                case MAXSPROUTS:
                    maxVal = Integer.max(maxVal, players.get(i).getSprouts());
                    break;
                case MAXCOMPOST:
                    maxVal = Integer.max(maxVal, players.get(i).getCompost());
                    break;
            }
        }

        ArrayList<Integer> winnerIndexes = new ArrayList<>();

        for (int i : indexesToCheck) {
            int valToCheck = 0;

            switch (category) { // depends on the category involved.
                case MAXPOINTS:
                    valToCheck = players.get(i).getScore();
                    break;
                case MAXSOIL:
                    valToCheck = players.get(i).getSoil();
                    break;
                case MAXHAND:
                    valToCheck = players.get(i).getHandList().size();
                    break;
                case MAXGROWTH:
                    valToCheck = players.get(i).getTotalGrowth();
                    break;
                case MAXSPROUTS:
                    valToCheck = players.get(i).getSprouts();
                    break;
                case MAXCOMPOST:
                    valToCheck = players.get(i).getCompost();
                    break;
            }

            if (valToCheck == maxVal) {
                winnerIndexes.add(i);
            }
        }

        return winnerIndexes;
    }

}