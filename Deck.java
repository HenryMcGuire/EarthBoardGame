import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * Deck
 * 
 * A deck of cards.
 */
public class Deck {
    private ArrayList<Card> cards;
    private int size;

    /*
     * Default constructor.
     */
    public Deck() {
        cards = new ArrayList<>();
        size = 0;
    }

    /*
     * Constructs a new deck.
     * 
     * @param filename The filename containing cards of the required type.
     */
    public Deck(String filename) throws IOException {
        cards = new ArrayList<>();
        String filepath = System.getProperty("user.dir") + filename;

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 2) {
                    String name = values[0].trim();
                    String type = values[1].trim();
                    Card card = new Card(name, type);
                    add(card);
                }
            }
        }
    }

    /*
     * Draws a random card from cards.
     * 
     * @return The random card selected.
     */
    public Card draw() {
        int index = (int) (Math.random() * size);
        Card card = cards.get(index);
        cards.remove(index);
        size--;
        return card;
    }

    /*
     * Adds card to cards.
     * 
     * @param The card to add to cards.
     */
    public void add(Card c) {
        cards.add(c);
        size++;
    }

    /*
     * Returns the size of the deck.
     * 
     * @return The size of the deck.
     */
    public int size() {
        return size;
    }

    /*
     * Determines whether or not the deck is empty.
     * 
     * @return Whether the deck is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /*
     * Determines whether or not the deck contains a card.
     * 
     * @param c The card to match.
     * @return Whether or not the deck contains c
     */
    public boolean contains(Card c) {
        for (Card card : cards) {
            if (card == c) {
                return true;
            }
        }

        return false;
    }
}
