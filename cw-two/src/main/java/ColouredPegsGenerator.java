import interfaces.Colour;
import interfaces.Generator;
import interfaces.Peg;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Rustam Drake and Vladimirs Ivanovs on 05/03/16.
 */
public class ColouredPegsGenerator implements Generator {

    /**
     * Generates list of colour pegs from colour list.
     *
     * @param colours string of abbreviations
     * @return
     */
    public List<Peg> generate(List<Colour> colours) {
        return colours.stream()
            .map(PegImpl::new)
            .collect(Collectors.toList());
    }

    @Override
    public List<Peg> generate(String colours) {
        return generate(convertStringToColours(colours));
    }

    /**
     * Converts string to a list of colours.
     *
     * @param input string of colout abbreviations
     * @return list of colours
     */
    public List<Colour> convertStringToColours(String input) {
        return Stream.of(input.split(""))
                .map(abbreviation -> Colour.get(abbreviation))
                .collect(Collectors.toList());
    }
}
