import java.util.*;
 
class Main {
	public static void main(String[] args) {
    
		Scanner scanner = new Scanner(System.in);
        
		final int N = 9;
        int[][] numbers = new int[N][N];

        int max_number = 0;
        int max_row = 0;
        int max_col = 0;

        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++) 
                numbers[i][j] = scanner.nextInt();
        
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                if(numbers[i][j] > max_number)
                {
                    max_number = numbers[i][j];
                    max_row = i;
                    max_col = j;
                }
            }
        }

        System.out.println(max_number);
        System.out.printf("%d %d", max_row+1, max_col+1);

        scanner.close();
	}
}