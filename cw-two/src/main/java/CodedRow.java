import java.util.List;

/**
 * Created by Workstation on 05/03/16.
 */
public class CodedRow implements Row {
    private List<Peg> sequenceOfPegs;

    public CodedRow(List<Peg> sequenceOfPegs) {
        this.sequenceOfPegs = sequenceOfPegs;
    }


    public int getNumberOfElements() {
        return sequenceOfPegs.size();
    }
}
