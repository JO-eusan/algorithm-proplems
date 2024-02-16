import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 10진수
        int B = scanner.nextInt(); // 바꿀 진수
        String str = "";

        while(N != 0)
        {
            if((0 <= (N%B)) && ((N%B) < 10))
                str = N%B + str;
            else
                str = (char)('A'-10 + (N%B)) + str;
            N /= B; 
        }

        System.out.print(str);

        scanner.close();
    }    
}