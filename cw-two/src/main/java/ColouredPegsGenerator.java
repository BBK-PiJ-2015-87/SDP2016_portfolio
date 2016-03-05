import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Workstation on 05/03/16.
 */
public class ColouredPegsGenerator implements Generator {

    public List<Peg> generate(String input) {
        return Arrays.asList(input.split("")).stream()
            .map(abbreviation -> Colour.get(abbreviation))
            .map(PegImpl::new)
            .collect(Collectors.toList());
    }
}
