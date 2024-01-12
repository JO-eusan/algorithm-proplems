import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();

        int C = scanner.nextInt();

        int H = A + C/60;
        int M = B + C%60;

        if(M < 60)
        {
            if(H < 24)
                System.out.printf("%d %d", H, M);
            else
                System.out.printf("%d %d", H-24, M);
        }
        else
        {
            H += M/60;
            M = M%60;

            if(H < 24)
                System.out.printf("%d %d", H, M);
            else
                System.out.printf("%d %d", H-24, M);
        }


        scanner.close();
    }
    
}