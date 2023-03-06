public class Card {
    private String name;
    private String type;
    public int sprouts;
    public int sproutMax;
    public int growth;
    public int growthMax;

    public Card() {

    }

    public Card(String n, String t) {
        name = n;
        type = t;
    }

    void ability() {

    }

    @Override
    public String toString() {
        return name + " " + type;
    }
}
