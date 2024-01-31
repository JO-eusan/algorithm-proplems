import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
    
        String S = scanner.nextLine();
        char c = S.charAt(0);

        System.out.print((int)c);

        scanner.close();
    }
}