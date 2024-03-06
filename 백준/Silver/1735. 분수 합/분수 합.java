import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int A1 = scanner.nextInt();
        int B1 = scanner.nextInt();
        int A2 = scanner.nextInt();
        int B2 = scanner.nextInt();

        int down = B1*B2; // 분모
        int up = A1*B2 + A2*B1; // 분자

        int min = (down<up) ? down : up;

        int max_dv = 1;
        for(int i=2; i<=min; i++) // 최대 공약수 찾기
        {
            if(down%i == 0 && up%i == 0)
                max_dv = i;
        }

        System.out.printf("%d %d", up/max_dv, down/max_dv);

        scanner.close();
    }    
}