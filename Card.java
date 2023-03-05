public class Card {
    private String name;
    private String type;

    public Card(String n, String t) {
        name = n;
        type = t;
    }
    
    @Override
    public String toString() {
        return name + " " + type;
    }
}
