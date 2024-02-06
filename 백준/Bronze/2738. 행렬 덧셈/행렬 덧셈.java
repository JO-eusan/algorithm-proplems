import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 행
        int M = scanner.nextInt(); // 열

        int[][] A = new int[N][M];
        int[][] B = new int[N][M];
        int[][] result = new int[N][M];

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
                A[i][j] = scanner.nextInt();
        }

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
                B[i][j] = scanner.nextInt();
        }

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
                result[i][j] = A[i][j] + B[i][j];
        }

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
                System.out.printf("%d ", result[i][j]);
            System.out.println();
        }

        scanner.close();
    }
}