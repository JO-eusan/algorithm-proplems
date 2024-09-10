import java.io.*;

public class Main{

    public static int recursion(String s, int l, int r){
        count++;

        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }

    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }

    static int count; // 재귀 호출 횟수를 위한 전역 변수

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            String str = br.readLine();

            count = 0;
            bw.write(isPalindrome(str) + " " + count + "\n");
        }

        bw.flush();
        bw.close();
    }
}