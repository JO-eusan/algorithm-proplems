import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int H = scanner.nextInt();
        int M = scanner.nextInt();

        if(M>=45)
        {
            System.out.printf("%d %d", H, M-45);
        }
        else
        {
            if(H==0)
                System.out.printf("%d %d", 24-1, 60-(45-M));
            else
                System.out.printf("%d %d", H-1, 60-(45-M));
        }

        scanner.close();
    }
    
}