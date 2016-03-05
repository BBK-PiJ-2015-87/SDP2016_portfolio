import java.util.List;

/**
 * Created by Workstation on 05/03/16.
 */
public interface Generator {

    List<Peg> generate(String input);

    default String generate(){
        return null;
    }
}
