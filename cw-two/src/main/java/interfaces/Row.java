package interfaces;

import java.util.List;

/**
 * Created by Rustam Drake and Vladimirs Ivanovs on 05/03/16.
 */
public interface Row {
    int getNumberOfElements();

    List<Peg> elements();
}
