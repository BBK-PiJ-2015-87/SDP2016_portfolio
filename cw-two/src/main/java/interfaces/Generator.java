package interfaces;

import java.util.List;

/**
 * Interface representing generator.
 *
 * Created by Rustam Drake and Vladimirs Ivanovs on 05/03/16.
 */
public interface Generator {

    List<Peg> generate(List<Colour> colours);

    List<Peg> generate(String colours);

    default String generate(){
        return null;
    }
}
