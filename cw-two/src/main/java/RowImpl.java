import interfaces.Peg;
import interfaces.Row;

import java.util.List;

/**
 * Created by Workstation on 05/03/16.
 */
public class RowImpl implements Row {
    private List<Peg> pegs;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Peg peg : pegs) {
            stringBuilder.append(peg.getColour().getAbbreviation());
        }
        return stringBuilder.toString();
    }

    RowImpl(List<Peg> pegs) {
        this.pegs = pegs;
    }

    @Override
    public int getNumberOfElements() {
        return 0;
    }

    @Override
    public List<Peg> elements() {
        return pegs;
    }

}
