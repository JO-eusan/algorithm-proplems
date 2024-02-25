import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] number = new int[N+1];

        number[0] = 4;

        for(int i=1; i<=N; i++)
        {
            if(i == 1)
                number[i] = (int)(2*number[i-1] + Math.pow(4, i-1));
            else 
                number[i] = number[i-1] + (int)((Math.pow(2,i-1)+1)*Math.pow(2,i) + Math.pow(4,i-1)); 
        }
        System.out.print(number[N]);

        scanner.close();
    }
}