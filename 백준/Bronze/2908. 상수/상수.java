import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String A = scanner.next();
        String B = scanner.next();

        for(int i=2; i>=0; i--)
        {
            if(A.charAt(i) == B.charAt(i))
                continue;
            else if(A.charAt(i) > B.charAt(i))
            {
                for(int j=2; j>=0; j--)
                {
                    System.out.print(A.charAt(j));
                }
                break;
            }    
            else if(A.charAt(i) < B.charAt(i))
            {
                for(int j=2; j>=0; j--)
                {
                    System.out.print(B.charAt(j));
                }
                break;
            }
        }

        scanner.close();
    }    
}