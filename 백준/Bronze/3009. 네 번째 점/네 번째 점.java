import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int[] x = new int[4];
        int[] y = new int[4];

        for(int i=0; i<3; i++)
        {
            String s = scanner.nextLine();
            String[] numbers = s.split(" ");

            x[i] = Integer.parseInt(numbers[0]);
            y[i] = Integer.parseInt(numbers[1]);
        }
        
        if(x[0] != x[1] && x[0] != x[2])
            x[3] = x[0];
        else if(x[1] != x[0] && x[1] != x[2])
            x[3] = x[1];
        else if(x[2] != x[0] && x[2] != x[1])
            x[3] = x[2];

        if(y[0] != y[1] && y[0] != y[2])
            y[3] = y[0];
        else if(y[1] != y[0] && y[1] != y[2])
            y[3] = y[1];
        else if(y[2] != y[0] && y[2] != y[1])
            y[3] = y[2];
        
        System.out.printf("%d %d", x[3], y[3]);

        scanner.close();
    }    
}