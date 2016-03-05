import java.util.Objects;

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

    @Override
    public String toString() {
        return "PegImpl{" +
                "colour=" + colour +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PegImpl peg = (PegImpl) o;
        return colour == peg.colour;
    }

    @Override
    public int hashCode() {
        return Objects.hash(colour);
    }
}
