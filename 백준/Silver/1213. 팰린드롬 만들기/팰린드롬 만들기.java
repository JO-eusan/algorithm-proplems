import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String name = br.readLine();
        Map<String, Integer> alphabet = new LinkedHashMap<>();

        /* 알파벳 별 총 개수 저장 */
        for(char c = 'A'; c <= 'Z'; c++) {
            alphabet.putIfAbsent(String.valueOf(c), 0);
        }
        for(int i = 0; i < name.length(); i++) {
            alphabet.put(String.valueOf(name.charAt(i)), alphabet.get(String.valueOf(name.charAt(i))) + 1);
        }

        /* 팰린드롬 불가능 경우 예외 처리 */
        int oddCounter = 0;
        for(String alph : alphabet.keySet()) {
            if (alphabet.get(alph) % 2 == 1) {
                oddCounter++;
            }
        }

        /* 팰린드롬 제작 */
        int index = 0;
        String[] pallindrom = new String[name.length()];
        for(String alph : alphabet.keySet()) {
            int counter = alphabet.get(alph);
            
            for(int i = index; i < index + counter / 2; i++) {
                pallindrom[i] = alph;
                pallindrom[name.length() - i - 1] = alph;
            }

            if (counter % 2 == 1) {
                pallindrom[name.length() / 2] = alph;
            }
            index += counter / 2;
        }

        String result = "";
        for(String pall : pallindrom) {
            result += pall;
        }

        if (oddCounter > 1) {
            result = "I'm Sorry Hansoo";
        }

        System.out.println(result);
    }   
}