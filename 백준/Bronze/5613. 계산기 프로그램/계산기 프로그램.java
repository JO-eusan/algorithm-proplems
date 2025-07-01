import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        String tmp = br.readLine();
        int result = Integer.parseInt(tmp);

        String currentOperator = null;

        do {
            currentOperator = br.readLine();

            if (currentOperator.equals("+")) {
                result += Integer.parseInt(br.readLine());
            } else if (currentOperator.equals("-")) {
                result -= Integer.parseInt(br.readLine());
            } else if (currentOperator.equals("*")) {
                result *= Integer.parseInt(br.readLine());
            } else if (currentOperator.equals("/")) {
                result /= Integer.parseInt(br.readLine());
            } 

        } while (!currentOperator.equals("="));

        System.out.println(result);
    }
}