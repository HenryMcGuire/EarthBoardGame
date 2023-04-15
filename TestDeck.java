import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.Test;

public class TestDeck {
    Deck deck;

    @Test
    public void testInitilization() {
        deck = new Deck();
        assertTrue(deck.isEmpty());

        try {
            deck = new Deck("climate.csv");
            assertFalse(deck.isEmpty());
            deck = new Deck("earth.csv");
            assertFalse(deck.isEmpty());
            deck = new Deck("fauna.csv");
            assertFalse(deck.isEmpty());
            deck = new Deck("island.csv");
            assertFalse(deck.isEmpty());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testDraw() {
        deck = new Deck();
        Card c1 = new Card("Test", "Flora");
        Card c2 = new Card("ing", "Flora");
        deck.add(c1);
        deck.add(c2);

        Card c = deck.draw();
        assertTrue(c == c1 || c == c2);
        assertFalse(deck.contains(c));
    }

    @Test
    public void testAdd() {
        deck = new Deck();
        Card c = new Card("Test", "Flora");
        assertFalse(deck.contains(c));
        deck.add(c);
        assertTrue(deck.contains(c));
    }

    @Test
    public void testSize() {
        deck = new Deck();
        assertTrue(deck.size() == 0);

        Card c = new Card("Test", "Flora");
        int count = 10;
        
        for (int i = 0; i < count; i++) {
            deck.add(c);
        }

        assertTrue(deck.size() == count);
    }

    @Test
    public void testIsEmpty() {
        deck = new Deck();
        Card c = new Card("Test", "Flora");
        assertTrue(deck.isEmpty());
        deck.add(c);
        assertFalse(deck.isEmpty());
    }

    @Test
    public void testContains() {
        deck = new Deck();
        Card c = new Card("Test", "Flora");
        assertFalse(deck.contains(c));
        deck.add(c);
        assertTrue(deck.contains(c));
    }
}
