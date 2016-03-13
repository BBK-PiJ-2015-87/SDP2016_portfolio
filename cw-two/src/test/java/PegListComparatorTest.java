import interfaces.Colour;
import interfaces.Generator;
import interfaces.Peg;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Workstation on 05/03/16.
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
        white = new PegImpl(Colour.WHITE);

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
        result.stream().allMatch(p -> p.getColour().equals(Colour.WHITE));
    }

    @Test
    public void allPegsShouldMatchIfDifferentSize(){
        coded = generator.generate("BPR");
        guess = generator.generate("BBPPRRYY");

        result = comparator.findResult(coded, guess);

        assertThat(result.stream().filter(p -> p.equals(Colour.WHITE)).count(), is(1));
        assertThat(result.stream().filter(p -> p.equals(Colour.BLACK)).count(), is(1));
    }

    /**
    @Test
    public void noPegsShouldMatch(){
        coded = generator.generate("BBBBPPYY");
        guess = generator.generate("OOOGGO");

        result = comparator.findMatchedColour(coded, guess);
        result2 = comparator.findMatchedColour(guess, coded);

        assertThat(result.size(), is(0));
        assertThat(result2.size(), is(0));
    }

    //

    @Test
    public void shouldReturnBlackWhichMatches() throws Exception {
        coded = generator.generate("BBBBPPYY");
        guess = generator.generate("BBBBYYPP");

        feedback = comparator.findMaychedOnlyByColour(coded, guess);

        assertThat(feedback.stream().filter(peg -> peg.equals(black)).count(), is(4L));
        assertThat(feedback.stream().filter(peg -> peg.equals(white)).count(), is(4L));
    }

    @Test
    public void shouldReturnCorrectMatches() throws Exception {
//        coded = generator.generate("BRGBPOOY");
//        guess = generator.generate("YBGBOYPP");

        coded = generator.generate("YYGGGGGG");
        guess = generator.generate("YYBBBBBB");


        feedback = comparator.findMaychedOnlyByColour(coded, guess);
        System.out.println(feedback);

        assertThat(feedback.stream().filter(peg -> peg.equals(black)).count(), is(2L));
        assertThat(feedback.stream().filter(peg -> peg.equals(white)).count(), is(4L));
    }
    **/
}