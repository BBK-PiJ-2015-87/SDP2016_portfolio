import java.util.Scanner;

/**
 * Created by Rustam Drake and Vladimirs Ivanovs on 13/03/16.
 */
public class InputReader {

    public void read(){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        while (input.endsWith("stop")) {
            validate(input, 4);
            //do stuff
        }
    }


    private void validate(String input, int rowNumber){
        if (input.trim().length() != rowNumber) throw new IllegalArgumentException();
    }

}
