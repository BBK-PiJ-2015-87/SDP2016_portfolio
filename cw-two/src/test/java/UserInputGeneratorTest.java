import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Workstation on 05/03/16.
 */
public class UserInputGeneratorTest {
    UserInputGenerator generator;
    List<Peg> expected;

    @Before
    public void setUp() throws Exception {
        generator = new UserInputGenerator();
        expected = new ArrayList<Peg>( );
    }

    @Test
    public void shouldGenerateCorrectList() throws Exception {
        expected.add(new PegImpl(Colour.BLUE));
        expected.add(new PegImpl(Colour.YELLOW));
        expected.add(new PegImpl(Colour.RED));
        expected.add(new PegImpl(Colour.PURPLE));

        String input = "BYRP";
        assertEquals(expected, generator.generate(input));
    }
}