import java.util.HashMap;
import java.util.Map;

/**
 * Created by Workstation on 05/03/16.
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

    private static final Map<String, Colour> lookup = new HashMap<String, Colour>();

    static {
        for (Colour colour : Colour.values()) {
            lookup.put(colour.getRepresentation(), colour);
        }
    }

    private final String representation;

    Colour(String representation) {
        this.representation = representation;
    }

    private String getRepresentation() {
        return representation;
    }

    public static Colour get(String representation) {
        return lookup.get(representation);
    }
}
