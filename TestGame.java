import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

//You may need to install Jupiter/Junit into your XML file for the repos to run this.

public class TestGame {

    String input;
    Scanner in;
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    String utf8 = StandardCharsets.UTF_8.name();

    @Test
    public void testGetChoice() throws IOException {
        input = "1\n" + "0\n";
        in = new Scanner(input);

        int choice;

        try (PrintStream out = new PrintStream(baos, true, utf8)) {
            choice = Game.getChoice(in, out, "", new String[] {}, "Enter 0: ", 0, 0);
        }

        String output = baos.toString(utf8);

        assertTrue(choice == 0);
        assertTrue(output.toString().contains("Invalid input! Try again!"));
    }

    @Test
    public void testGetCardChoice() throws IOException {
        input = "1\n" + "0\n";
        in = new Scanner(input);

        Card c = new Card("Test", "Flora");
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(c);

        int choice;

        try (PrintStream out = new PrintStream(baos, true, utf8)) {
            choice = Game.getCardChoice(in, out, "", cards, "Enter 0: ", 0, 0);
        }

        String output = baos.toString(utf8);

        assertTrue(choice == 0);
        assertTrue(output.toString().contains("Invalid input! Try again!"));
    }

    @Test
    public void testDrawCard() {
        ArrayList<Card> deck = new ArrayList<>();
        Card c1 = new Card("Test", "Flora");
        Card c2 = new Card("ing", "Flora");
        deck.add(c1);
        deck.add(c2);

        Card c = Game.drawCard(deck);
        assertTrue(c == c1 || c == c2);
        assertFalse(deck.contains(c));
    }

    // Active plant needed

    // secondary plant needed

    @Test
    public void testActiveCompost() throws IOException {
        Player p = new Player();

        try (PrintStream out = new PrintStream(baos, true, utf8)) {
            Game.activeCompost(out, p);
        }

        assertTrue(p.getSoil() == 5);
        assertTrue(p.getCompost() == 2);
    }

    @Test
    public void testSecondaryCompost() throws IOException {
        Player p = new Player();

        input = "1\n";
        in = new Scanner(input);

        try (PrintStream out = new PrintStream(baos, true, utf8)) {
            Game.secondaryCompost(in, out, p);
        }

        assertTrue(p.getSoil() == 2);
        assertTrue(p.getCompost() == 0);

        input = "2\n";
        in = new Scanner(input);

        try (PrintStream out = new PrintStream(baos, true, utf8)) {
            Game.secondaryCompost(in, out, p);
        }

        assertTrue(p.getSoil() == 2);
        assertTrue(p.getCompost() == 2);
    }

    // Active water needed

    // secondary water needed

    // Active grow needed

    // secondary grow neeed

    // activate cards needed

    @Test
    public void testGetWinners() {
        Player p1 = new Player();
        Player p2 = new Player();
        ArrayList<Player> players = new ArrayList<>();
        players.add(p1);
        players.add(p2);

        ArrayList<Integer> winners = new ArrayList<>();
        // All same
        winners = Game.getWinners(players);
        assertTrue(winners.contains(0));
        assertTrue(winners.contains(1));

        // Different score
        p1.addScore(1);
        winners = Game.getWinners(players);
        assertTrue(winners.contains(0));
        assertFalse(winners.contains(1));

        // Same score
        p2.addScore(1);
        winners = Game.getWinners(players);
        assertTrue(winners.contains(0));
        assertTrue(winners.contains(1));

        // Different soil
        p1.addSoil(1);
        winners = Game.getWinners(players);
        assertTrue(winners.contains(0));
        assertFalse(winners.contains(1));

        // Same soil
        p2.addSoil(1);
        winners = Game.getWinners(players);
        assertTrue(winners.contains(0));
        assertTrue(winners.contains(1));

        // Different hand size
        Card c = new Card("Test", "Earth");
        p1.addCardToHand(c);
        winners = Game.getWinners(players);
        assertTrue(winners.contains(0));
        assertFalse(winners.contains(1));

        // Same hand size
        p2.addCardToHand(c);
        winners = Game.getWinners(players);
        assertTrue(winners.contains(0));
        assertTrue(winners.contains(1));

        // Need to add Growth
        // Need to add Sprouts

        // Different compost
        p1.addCompost(1);
        winners = Game.getWinners(players);
        assertTrue(winners.contains(0));
        assertFalse(winners.contains(1));

        // Same compost
        p2.addCompost(1);
        winners = Game.getWinners(players);
        assertTrue(winners.contains(0));
        assertTrue(winners.contains(1));
    }
}