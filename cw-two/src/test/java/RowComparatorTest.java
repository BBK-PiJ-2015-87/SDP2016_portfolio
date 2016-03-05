import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Workstation on 05/03/16.
 */
public class RowComparatorTest {
    Row guess, coded, feedback;
    RowComparator comparator;
    @Before
    public void setUp() throws Exception {
        Generator generator = new ColouredPegsGenerator();
        comparator = new RowComparator();
        String input1, input2;
        input1 = "RRRR";
        input2 = "RRRR";
        guess = new RowImpl(generator.generate(input1));
        coded = new RowImpl(generator.generate(input2));
    }

    @Test
    public void testFeedback() throws Exception {
        List<Peg> row = new ArrayList<>();
        row.add(new PegImpl(Colour.BLACK));
        row.add(new PegImpl(Colour.BLACK));
        row.add(new PegImpl(Colour.BLACK));
        row.add(new PegImpl(Colour.BLACK));
        assertEquals(row, comparator.feedback(guess, coded));
    }
}