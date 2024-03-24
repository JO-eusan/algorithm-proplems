import java.util.*;

class Main 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        
        int a_1 = scanner.nextInt();
        int a_0 = scanner.nextInt();

        int c = scanner.nextInt();
        int n_0 = scanner.nextInt();

        scanner.close();

        if((a_1*n_0 + a_0) <= (c * n_0) && c>=a_1)
            System.out.print(1);
        else
            System.out.print(0);
    }    
}