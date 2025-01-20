import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String expression = br.readLine();
        String[] maxNumbers = expression.split("-");
        
        int sum = 0;
        for(int i=0; i<maxNumbers.length; i++) {
            String[] operands = maxNumbers[i].split("\\+");

            int tmp = 0;
            for(int j=0; j<operands.length; j++) {
                tmp += Integer.parseInt(operands[j]);
            }

            if(i == 0) {
                sum += tmp;
            } else {
                sum -= tmp;
            }
        }
        bw.write(String.valueOf(sum));

        bw.flush();
        bw.close();
    }
}