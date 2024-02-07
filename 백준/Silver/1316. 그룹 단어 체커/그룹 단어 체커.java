import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String tmp = scanner.next();
        int N = Integer.parseInt(tmp);

        int count = 0; // 그룹넘버를 세기 위한 변수
        count: for(int i=0; i<N; i++)
        {
            String S = scanner.next();

            for(int j=0; j<S.length()-1; j++) // 이때, j는 문자가 반복되는 구간의 마지막 index로 이용
            {
                if(S.charAt(j) != S.charAt(j+1))
                {
                    // 중복 찾기
                    for(int k=j+1; k<S.length(); k++)
                    {
                        if(S.charAt(j) == S.charAt(k))
                            continue count;
                    }
                }
            }
            count++;
        }

        System.out.print(count);

        scanner.close();
    }    
}