import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
    
        String S = scanner.nextLine();
        int i = scanner.nextInt();

        System.out.print(S.charAt(i-1));

        scanner.close();
    }
}