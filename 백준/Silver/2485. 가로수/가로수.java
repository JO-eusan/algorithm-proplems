import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int[] trees = new int[N];
        int[] sub_dis = new int[N-1];

        for(int i=0; i<trees.length; i++)
            trees[i] = scanner.nextInt();

        for(int i=0; i<sub_dis.length; i++)
            sub_dis[i] = trees[i+1] - trees[i];
        
        // 거리의 차 최대 공약수 구하기
        // 최소값 찾기
        int min = sub_dis[0];
        for(int i=1; i<sub_dis.length; i++)
        {
            if(sub_dis[i] < min)
                min = sub_dis[i];
        }
        // sub_dis값들을 한번씩 훑으면서 공약수 찾기
        int max_div = 1;
        for(int i=2; i<=min; i++)
        {
            for(int j=0; j<sub_dis.length; j++)
            {
                if(sub_dis[j]%i != 0)
                    break;
                if(j == sub_dis.length-1)
                    max_div = i;
            }
        }

        // 추가할 나무 개수 세기
        int count = 0;
        for(int i=0; i<sub_dis.length; i++)
        {
            count += sub_dis[i]/max_div - 1;
        }
        System.out.print(count);

        scanner.close();
    }    
}