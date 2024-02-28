import java.util.*;

class Main 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int[] x = new int[N];
        int[] y = new int[N];

        // 값 입력해서 저장
        for(int i=0; i<N; i++)
        {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
        }

        // x,y좌표의 각 최대 및 최소 값 찾기
        int min_x=x[0], max_x=x[0], min_y=y[0], max_y=y[0];
        for(int i=1; i<N; i++)
        {
            if(min_x > x[i])
                min_x = x[i];
            if(max_x < x[i])
                max_x = x[i];
            if(min_y > y[i])
                min_y = y[i];
            if(max_y < y[i])
                max_y = y[i];
        }

        // 넓이 계산하기
        int length_x, length_y;
        if(max_x < 0 && min_x < 0)
            length_x = -max_x + min_x;
        else 
            length_x = max_x - min_x;

        if(max_y < 0 && min_y < 0)
            length_y = -max_y + min_y;
        else 
            length_y = max_y - min_y;

        System.out.print(length_x * length_y);
        
        scanner.close();
    }   
}