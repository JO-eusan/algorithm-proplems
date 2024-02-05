import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextLine())
        {
            String S = scanner.nextLine();
            System.out.println(S);
        }

        scanner.close();
    }
}