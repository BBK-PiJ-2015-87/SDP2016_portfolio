import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Workstation on 05/03/16.
 */
public class RowComparatorTest {
    RowComparator comparator;
    Generator generator;


    @Before
    public void setUp() throws Exception {
        generator = new ColouredPegsGenerator();
        comparator = new RowComparator();
//        List<Peg> allMatch = new RowImpl(generator.generate("RRRR"));
    }

    @Test
    public void shouldReturnAllBlackWhenAllPegsPosAndColourMatches() throws Exception {
        Row coded = new RowImpl(generator.generate("RRRR"));
        Row guess = new RowImpl(generator.generate("RRRR"));

        Row feedback = comparator.feedback(guess, coded);

        assertEquals("BlackBlackBlackBlack", feedback.toString());
    }

    @Test
    public void shouldReturnBlackWhichMatches() throws Exception {
        Row coded = new RowImpl(generator.generate("RRRR"));
        Row guess = new RowImpl(generator.generate("BBRR"));

        Row feedback = comparator.feedback(guess, coded);

        assertEquals("BlackBlack", feedback.toString());
    }


}