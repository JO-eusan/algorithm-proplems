import java.util.*;

public class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        for(int i=0; i<T; i++)
        {
            int quarter = 0, dime = 0, nickel = 0, penny = 0;
            int C = scanner.nextInt();

            quarter = C/25;
            C %= 25;

            dime = C/10;
            C %= 10;

            nickel = C/5;
            C %= 5;

            penny = C;

            System.out.printf("%d %d %d %d\n", quarter, dime, nickel, penny);
            
        }

        scanner.close();
    }    
}