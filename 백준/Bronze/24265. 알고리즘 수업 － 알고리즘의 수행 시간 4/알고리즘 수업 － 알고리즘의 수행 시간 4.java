import java.util.*;

class Main 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        
        long n = scanner.nextLong();

        System.out.println(n*(n-1)/2);
        System.out.println(2);

        scanner.close();
    }    
}