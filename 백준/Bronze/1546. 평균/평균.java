import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
    
        int N = scanner.nextInt();
        int[] score = new int[N];
        float[] new_score = new float[N];

        for(int i=0; i<score.length; i++)
        {
            score[i] = scanner.nextInt();
        }

        int M = score[0];
        for(int i=1; i<score.length; i++)
        {
            if(score[i] > M)
                M = score[i];
        }

        float sum = 0;
        for(int i=0; i<score.length; i++)
        {
            new_score[i] = score[i] / (float)M * 100;
            sum += new_score[i];
        }

        System.out.print(sum/new_score.length);
        
        scanner.close();
    }
}