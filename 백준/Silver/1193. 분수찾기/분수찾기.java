import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int X = scanner.nextInt();

        int line = 0;
        int sum_number = 0;
        while(X > sum_number)
        {
            line++;
            sum_number += line;
        }
        int index = X - (sum_number-line);
        
        if(line%2 == 0) // 짝수
        {
            int up = 1, down = line;
            for(int i=1; i<index; i++)
            {
                up++;
                down--;
            }
            System.out.printf("%d/%d", up, down);
        }
        else if(line%2 == 1) // 홀수
        {
            int up = line, down = 1;
            for(int i=1; i<index; i++)
            {
                up--;
                down++;
            }
            System.out.printf("%d/%d", up, down);
        }
        
        scanner.close();
    }    
}