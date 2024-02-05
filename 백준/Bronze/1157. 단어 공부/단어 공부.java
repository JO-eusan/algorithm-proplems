import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String S = scanner.next();
        int[] alphabet = new int['Z'-'A'+1]; // 알파벳을 순서대로 나온 횟수 저장

        // 알파벳 숫자세기
        for(int i=0; i< S.length(); i++)
        {
            if('a'<=S.charAt(i) && S.charAt(i)<='z')
                alphabet[S.charAt(i)-'a']++;
            else if('A'<=S.charAt(i) && S.charAt(i)<='Z')
                alphabet[S.charAt(i)-'A']++;
        }

        // 최빈 알파벳 찾기
        int max_index = 0;
        for(int i=1; i<alphabet.length; i++)
        {
            if(alphabet[i] > alphabet[max_index])
                max_index = i;
        }

        // 중복 찾기
        char result = (char)('A' + max_index);
        for(int i=0; i<max_index; i++)
        {
            if(alphabet[i] == alphabet[max_index])
            {
                result = '?';
                break;
            }   
        }

        for(int i=max_index+1; i<alphabet.length; i++)
        {
            if(alphabet[i] == alphabet[max_index])
            {
                result = '?';
                break;
            }    
        }

        System.out.print(result);

        scanner.close();
    }
}