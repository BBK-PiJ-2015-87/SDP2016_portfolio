import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Workstation on 05/03/16.
 */
public class RowComparatorTest {
    Generator generator;
    RowComparator comparator;
    List<Peg> coded, guess, feedback;
    Map<Peg, Long> result, result2;
    Peg red, blue, yellow, green, purple, orange, black, white;
    List<Peg> colours;

    @Before
    public void setUp() throws Exception {
        generator = new ColouredPegsGenerator();
        comparator = new RowComparator();
        red = new PegImpl(Colour.RED);
        blue = new PegImpl(Colour.BLUE);
        yellow = new PegImpl(Colour.YELLOW);
        green = new PegImpl(Colour.GREEN);
        purple = new PegImpl(Colour.PURPLE);
        orange = new PegImpl(Colour.ORANGE);
        black = new PegImpl(Colour.BLACK);
        white = new PegImpl(Colour.WHITE);

        coded = null;
        guess = null;
    }

    @Test
    public void shouldCountFrequencyCorrectly(){
        coded = generator.generate("RRBBBYYYY");

        result = comparator.frequency(coded);

        assertThat(result.size(), is(3));
        assertThat(result.get(red), is(2L));
        assertThat(result.get(blue), is(3L));
        assertThat(result.get(yellow), is(4L));
    }

    @Test
    public void shouldCountNumberOfColourMatchedPegsCorrectly(){
        coded = generator.generate("PRBBBYYY");
        guess = generator.generate("PPPRRRBY");

        result = comparator.findMatchedOnlyByColour(coded, guess);
        colours = Arrays.asList(red, blue, purple, yellow);

        assertThat(result.size(), is(4));
        colours.stream().forEach(color -> assertThat(result.get(color), is(1L)));
    }

    @Test
    public void allPegsShouldMatchIfDifferentSize(){
        coded = generator.generate("BPR");
        guess = generator.generate("BBPPRRYY");

        result = comparator.findMatchedOnlyByColour(coded, guess);
        result2 = comparator.findMatchedOnlyByColour(guess, coded);

        colours = Arrays.asList(blue, purple, red);

        assertThat(result.size(), is(3));
        assertThat(result2.size(), is(3));
        colours.stream().forEach(color -> assertThat(result.get(color), is(1L)));
        colours.stream().forEach(color -> assertThat(result2.get(color), is(1L)));
    }

    @Test
    public void noPegsShouldMatch(){
        coded = generator.generate("BBBBPPYY");
        guess = generator.generate("OOOGGO");

        result = comparator.findMatchedOnlyByColour(coded, guess);
        result2 = comparator.findMatchedOnlyByColour(guess, coded);

        assertThat(result.size(), is(0));
        assertThat(result2.size(), is(0));
    }

    //

    @Test
    public void shouldReturnBlackWhichMatches() throws Exception {
        coded = generator.generate("BBBBPPYY");
        guess = generator.generate("BBBBYYPP");

        feedback = comparator.feedback(coded, guess);

        assertThat(feedback.stream().filter(peg -> peg.equals(black)).count(), is(4L));
        assertThat(feedback.stream().filter(peg -> peg.equals(white)).count(), is(4L));
    }

    @Test
    public void shouldReturnCorrectMatches() throws Exception {
        coded = generator.generate("BRGBPOOY");
        guess = generator.generate("YBGBOYPP");


        feedback = comparator.feedback(coded, guess);
        System.out.println(feedback);

        assertThat(feedback.stream().filter(peg -> peg.equals(black)).count(), is(2L));
        assertThat(feedback.stream().filter(peg -> peg.equals(white)).count(), is(4L));
    }
}