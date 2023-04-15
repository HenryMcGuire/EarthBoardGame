import static org.junit.jupiter.api.Assertions.*;
import java.beans.Transient;
import org.junit.Test;

public class TestCard {

    @Test
    public void testFloraCard() {
        String name = "Oak";
        String type = "Flora";
        Card card = new Card(name, type);
        assertTrue(Card.class);
    }

    @Test
    public void testFaunaCard() {
        String name = "Pale-Billed Woodpecker";
        String type = "Fauna";
        Card card = new Card(name, type);
        assertTrue(Card.class);
    }

    @Test
    public void testIslandCard() {
        String name = "Metis Shoal Island";
        String type = "Island";
        Card card = new Card(name, type);
        assertTrue(Card.class);
    }

    @Test
    public void testClimateCard() {
        String name = "Dry Winter Subpolar Oceanic";
        String type = "Climate";
        Card card = new Card(name, type);
        assertTrue(Card.class);
    }

    @Test
    public void testEarthCard() {
        String name = "Canary Island Palm";
        String type = "Earth";
        Card card = new Card(name, type);
        assertTrue(Card.class);
    }

    @Test
    public void testEcosystemCard() {
        String name = "Sahara Desert";
        String type = "Ecosystem";
        Card card = new Card(name, type);
        assertTrue(Card.class);
    }

    @Test
    public void testEventCard() {
        String name = "Hurricane";
        String type = "Event";
        Card card = new Card(name, type);
        assertTrue(Card.class);
    }

}
