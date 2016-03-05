import java.util.List;

/**
 * Created by Workstation on 05/03/16.
 */
public class FeedbackRow implements Row {
    private List<Peg> sequenceOfPegs;

    public FeedbackRow(List<Peg> sequenceOfPegs) {
        this.sequenceOfPegs = sequenceOfPegs;
    }


    public int getNumberOfElements() {
        return sequenceOfPegs.size();
    }
}
