import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

;

/**
 * Created by Workstation on 05/03/16.
 */
public class RowComparator {

    public Row feedback(Row guess, Row coded) {
        List<Peg> pegs = IntStream.range(0, guess.elements().size())
                .boxed()
                .filter(i -> guess.elements().get(i).getColour().equals(coded.elements().get(i).getColour()))
                .map(num -> new PegImpl(Colour.BLACK))
                .collect(Collectors.toList());

        return new RowImpl(pegs);
    }
}
