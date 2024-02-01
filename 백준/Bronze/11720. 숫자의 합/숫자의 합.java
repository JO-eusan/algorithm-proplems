import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String tmp = scanner.nextLine();
        int N = Integer.parseInt(tmp);

        String s = scanner.nextLine();

        int sum = 0;
        for(int i=0; i<N; i++)
        {
            sum += (int)(s.charAt(i) - '0');
        }

        System.out.print(sum);

        scanner.close();
    }
}