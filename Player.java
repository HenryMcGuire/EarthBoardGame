public class Player {
    private Card island;
    private Card climate;

    public Player(Card i, Card c) {
        island = i;
        climate = c;
    }

    @Override
    public String toString() {
        return island + " " + climate;
    }
}
