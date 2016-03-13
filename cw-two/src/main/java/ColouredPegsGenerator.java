import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Workstation on 05/03/16.
 */
public class ColouredPegsGenerator implements Generator {

    public List<Peg> generate(String input) {
        return Stream.of(input.split(""))
            .map(abbreviation -> Colour.get(abbreviation))
            .map(PegImpl::new)
            .collect(Collectors.toList());
    }
}
