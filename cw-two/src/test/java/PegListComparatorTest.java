import interfaces.Colour;
import interfaces.Generator;
import interfaces.Peg;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static interfaces.Colour.BLACK;
import static interfaces.Colour.WHITE;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by Rustam Drake and Vladimirs Ivanovs on 05/03/16.
 */
public class PegListComparatorTest {
    Generator generator;
    PegListComparator comparator;

    List<Peg> coded, guess, feedback, colours, result, result2;
    Map<Peg,Long> frequency;
    Peg red, blue, yellow, green, purple, orange, black, white;

    @Before
    public void setUp() throws Exception {
        generator = new PegsListGenerator();
        comparator = new PegListComparator();

        red = new PegImpl(Colour.RED);
        blue = new PegImpl(Colour.BLUE);
        yellow = new PegImpl(Colour.YELLOW);
        green = new PegImpl(Colour.GREEN);
        purple = new PegImpl(Colour.PURPLE);
        orange = new PegImpl(Colour.ORANGE);
        black = new PegImpl(Colour.BLACK);
        white = new PegImpl(WHITE);

        coded = null;
        guess = null;
    }

    @Test
    public void shouldCountFrequencyCorrectly(){
        coded = generator.generate("RRBBBYYYY");

        frequency = comparator.frequency(coded);

        assertThat(frequency.size(), is(3));
        assertThat(frequency.get(red), is(2L));
        assertThat(frequency.get(blue), is(3L));
        assertThat(frequency.get(yellow), is(4L));
    }

    @Test
    public void shouldGenerateAllWhitePegs(){
        coded = generator.generate("PRGOBY");
        guess = generator.generate("YBOGRP");

        result = comparator.findResult(coded, guess);

        assertThat(result.size(), is(6));
        result.stream().allMatch(p -> p.getColour().equals(WHITE));
    }

    @Test
    public void shouldGenerateAllBlackPegs(){
        coded = generator.generate("BBOOPPGG");
        result = comparator.findResult(coded, coded);

        assertThat(result.size(), is(8));
        result.stream().allMatch(p -> p.getColour().equals(Colour.BLACK));
    }

    @Test
    public void noPegsShouldMatch(){
        coded = generator.generate("BBBBPPYY");
        guess = generator.generate("OOOGGOOO");

        result = comparator.findResult(coded, guess);

        assertTrue(result.isEmpty());
    }

    @Test
    public void shouldReturnBlackWhichMatches() throws Exception {
        coded = generator.generate("BBBBPPYY");
        guess = generator.generate("BBBBYYPP");

        feedback = comparator.findResult(coded, guess);

        assertThat(feedback.stream().filter(peg -> peg.getColour().equals(WHITE)).count(), is(4L));
        assertThat(feedback.stream().filter(peg -> peg.getColour().equals(BLACK)).count(), is(4L));
    }

}