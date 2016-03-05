import java.util.List;

/**
 * Created by Workstation on 05/03/16.
 */
public class RowImpl implements Row {
    private List<Peg> pegs;

    RowImpl(List<Peg> pegs) {
        this.pegs = pegs;
    }

    @Override
    public int getNumberOfElements() {
        return 0;
    }
}
