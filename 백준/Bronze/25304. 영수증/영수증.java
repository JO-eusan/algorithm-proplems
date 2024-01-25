import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int total = scanner.nextInt();
        int N = scanner.nextInt();

        // 종류마다 가격과 개수 입력하고 가격 계산
        int sum = 0; // 계산할 합에 대한 변수
        for(int i=0; i < N; i++) 
        {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            sum += (a*b);
        }

        if(total == sum)
            System.out.println("Yes");
        else
            System.out.println("No");

        scanner.close();
    }
}