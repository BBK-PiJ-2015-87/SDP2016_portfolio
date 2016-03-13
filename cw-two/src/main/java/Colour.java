import java.util.HashMap;
import java.util.Map;

/**
 * Representation of colours.
 *
 * Created by Rustam Drake and Vladimirs Ivanovs on 05/03/16.
 */
public enum Colour {

    BLUE ("B"),
    GREEN("G"),
    ORANGE("O"),
    PURPLE("P"),
    RED("R"),
    YELLOW("Y"),
    BLACK("Black"),
    WHITE("White");

    //Lookup map to get values from colour representations
    private static final Map<String, Colour> lookup = new HashMap<String, Colour>();

    //initialise lookup map
    static {
        for (Colour colour : Colour.values()) {
            lookup.put(colour.getAbbreviation(), colour);
        }
    }

    private final String abbreviation;

    Colour(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public static Colour get(String abbreviation) {
        return lookup.get(abbreviation);
    }
}
