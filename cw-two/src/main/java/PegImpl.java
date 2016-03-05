/**
 * Created by Workstation on 05/03/16.
 */
public class PegImpl implements Peg {
    private Colour colour;

    public PegImpl(Colour colour) {
        this.colour = colour;
    }

    public Colour getColour() {
        return colour;
    }
}
