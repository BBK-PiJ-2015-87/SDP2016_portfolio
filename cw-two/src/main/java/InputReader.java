/**
 * Created by Rustam Drake and Vladimirs Ivanovs on 13/03/16.
 */
public class InputReader {



    private void validate(String input, int rowNumber){
        if (input.trim().length() != rowNumber) throw new IllegalArgumentException();
    }

}
