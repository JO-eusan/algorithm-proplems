import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int i = 2;
        while(N != 1)
        {
            if(N%i == 0)
            {
                System.out.println(i);
                N /= i;
                i = 2;
                continue;
            }
            i++;
        }
        
        scanner.close();
    }    
}