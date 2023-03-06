import java.util.ArrayList;

public class Player {
    private Card island;
    private Card climate;

    private ArrayList<Card> hand = new ArrayList<>();

    private int soil = 0;
    private int compost = 0;

    private int points = 0;

    public Player(Card i, Card c) {
        island = i;
        climate = c;
    }

    @Override
    public String toString() {
        return island + " " + climate;
    }

    public void addSoil(int count) {
        soil += count;
    }

    public void addCompost(int count) {
        compost += count;
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public void addPoints(int count) {
        points += count;
    }

    public int getSoil() {
        return soil;
    }

    public int getCompost() {
        return compost;
    }

    public int getPoints() {
        return points;
    }
}
