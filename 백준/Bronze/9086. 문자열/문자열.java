import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
    
        String tmp = scanner.nextLine();
        int T = Integer.parseInt(tmp);

        for(int i=0; i<T; i++)
        {
            String S = scanner.nextLine();

            char start = S.charAt(0);
            char end = S.charAt(S.length()-1);
            System.out.printf("%c%c\n", start, end);
        }

        scanner.close();
    }
}