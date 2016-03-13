import java.util.Objects;

/**
 * Created by Workstation on 05/03/16.
 */
public class PegImpl implements Peg {
    public Colour colour;

    public PegImpl(Colour colour) {
        this.colour = colour;
    }

    @Override
    public Colour getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return colour.toString();
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
