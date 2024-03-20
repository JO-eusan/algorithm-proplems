import java.util.*;

class Main 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        
        System.out.print((int)Math.sqrt(N));

        scanner.close();
    }    
}