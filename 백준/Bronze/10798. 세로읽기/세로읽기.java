import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        final int N = 5;
        char[][] characters = new char[N][];

        for(int i=0; i<N; i++)
        {
            String str = scanner.next();
            characters[i] = new char[str.length()];

            for(int j=0; j<str.length(); j++)
                characters[i][j] = str.charAt(j);
        }

        // 행별 최대 길이 찾기
        int max_length = characters[0].length;
        for(int i=1; i<N; i++)
        {
            if(characters[i].length > max_length)
                max_length = characters[i].length;
        }

        // 열로 출력
        for(int i=0; i<max_length; i++)
        {
            for(int j=0; j<N; j++)
            {
                if(i < characters[j].length)
                    System.out.print(characters[j][i]);
                else
                    continue;

            }
        }

        scanner.close();
    }    
}