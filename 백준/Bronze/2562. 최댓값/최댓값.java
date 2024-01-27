import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int[] A = new int[9]; 

        for(int i=0; i<9; i++)
        {
            A[i] = scanner.nextInt();
        }

        int index = 0;
        for(int i=1; i<9; i++)
        {
            if(A[i]>A[index])
                index = i;
        }
        
        System.out.println(A[index]);
        System.out.println(index+1);

        scanner.close();
    }    
}