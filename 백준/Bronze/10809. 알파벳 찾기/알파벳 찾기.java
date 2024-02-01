import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String S = scanner.nextLine();
        int[] include = new int['z' - 'a' + 1];

        for(int i=0; i<S.length(); i++)
        {
            if(include[S.charAt(i)-'a'] == 0)
                include[S.charAt(i) - 'a'] = i+1; // 'a'의 경우에는 0을 출력하므로 조건식 걸림 방지로 +1
            else
                continue;
        }

        for(int i=0; i<include.length; i++)
        {
            if(include[i] == 0)
                include[i] = -1;
            else
                include[i] -= 1;
            System.out.printf("%d ", include[i]);
        }

        scanner.close();
    }
}