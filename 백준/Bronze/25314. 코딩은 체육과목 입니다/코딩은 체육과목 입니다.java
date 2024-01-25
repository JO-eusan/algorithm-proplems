import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        for(int i=0; i < (N/4); i++)
        {
            System.out.print("long ");
        }
        System.out.println("int");

        scanner.close();
    }
}