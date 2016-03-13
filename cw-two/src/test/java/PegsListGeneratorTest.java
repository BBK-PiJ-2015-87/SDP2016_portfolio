import interfaces.Colour;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static interfaces.Colour.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Rustam Drake and Vladimirs Ivanovs on 05/03/16.
 */
public class PegsListGeneratorTest {
    PegsListGenerator generator;
    List<Colour> colours;

    @Before
    public void setUp() throws Exception {
        generator = new PegsListGenerator();
    }

    @Test
    public void shouldGenerateCorrectList() throws Exception {
        colours = Arrays.asList(BLUE, YELLOW, RED, PURPLE, GREEN, ORANGE);
        List<Colour> result = generator.convertStringToColours("BYRPGO");

        assertEquals(colours, generator.generate(result));
    }
}