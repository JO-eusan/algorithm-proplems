import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String S = scanner.next();

        int result = 1;

        for(int i=0; i<(S.length()/2); i++)
        {
            if(S.charAt(i) == S.charAt(S.length()-i-1))
                continue;
            else
            {
                result = 0;
                break;
            }
        }

        System.out.print(result);

        scanner.close();
    }
}