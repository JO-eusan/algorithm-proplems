import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        final int N = 10;
        int[] number = new int[N]; // 10개
        int count = 0; // 서로 다른 나머지의 경우의 수

        for(int i=0; i<N; i++)
        {
            int tmp = scanner.nextInt();
            number[i] = tmp % 42;
        }

        count : for(int i=0; i<N; i++)
        {
            for(int j=i+1; j<N; j++)
            {
                if(number[i] == number[j])
                    continue count;
            }

            count++;
        }

        System.out.println(count);

        scanner.close();
    }
}