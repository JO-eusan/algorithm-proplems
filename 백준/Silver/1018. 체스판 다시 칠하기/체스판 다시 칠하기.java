import java.util.*;

class Main 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        char[][] board = new char[N][M];

        for(int i=0; i<N; i++)
        {
            String tmp = scanner.next();
            for(int j=0; j<M; j++)
                board[i][j] = tmp.charAt(j);
        }

        int min_changeCount = M*N;

        
        for(int startRow=0; startRow <= N-8; startRow++)
        {
            for(int startCol=0; startCol <= M-8; startCol++)
            {
                char startColor = 'B';
                int changeCount = 0;

                for(int i=startRow; i<startRow+8; i++)
                {
                    for(int j=startCol; j<startCol+8; j++)
                    {
                        if((startCol+startRow)%2 == (i+j)%2 && startColor != board[i][j])
                            changeCount++;
                        if((startCol+startRow)%2 != (i+j)%2 && startColor == board[i][j])
                            changeCount++;
                    }
                }
                
                if(min_changeCount > changeCount)
                    min_changeCount = changeCount;
            }
        }

        for(int startRow=0; startRow <= N-8; startRow++)
        {
            for(int startCol=0; startCol <= M-8; startCol++)
            {
                char startColor = 'W';
                int changeCount = 0;

                for(int i=startRow; i<startRow+8; i++)
                {
                    for(int j=startCol; j<startCol+8; j++)
                    {
                        if((startCol+startRow)%2 == (i+j)%2 && startColor != board[i][j])
                            changeCount++;
                        if((startCol+startRow)%2 != (i+j)%2 && startColor == board[i][j])
                            changeCount++;
                    }
                }
                
                if(min_changeCount > changeCount)
                    min_changeCount = changeCount;
            }
        }

        System.out.print(min_changeCount);

        scanner.close();
    }
    
}