import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        final int width = 100;
        int[][] paper = new int[width][width];

        int N = scanner.nextInt();
        for(int i=0; i<N; i++)
        {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            for(int j=x; j<x+10; j++)
            {
                for(int k=y; k<y+10; k++)
                    paper[j][k] = 1;
            }
        }

        // 넓이 계산
        int result = 0;
        for(int i=0; i<width; i++)
        {
            for(int j=0; j<width; j++)
                result += paper[i][j];
        }
        System.out.print(result);

        scanner.close();
    }    
}