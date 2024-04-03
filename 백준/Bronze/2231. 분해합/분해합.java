import java.util.*;

class Main 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int constructor = 0;
        for(int i=1; i<=N; i++)
        {
            int isConst = i;

            int digit = 1;
            while(i/digit != 0)
            {
                isConst += ((i%(digit*10))/digit);
                digit *= 10;
            }

            if(isConst == N)
            {
                constructor = i;
                break;
            }
        }

        System.out.print(constructor);

        scanner.close();
    }    
}