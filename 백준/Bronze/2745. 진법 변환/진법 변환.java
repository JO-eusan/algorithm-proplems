import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        char[] number = new char[36]; // 0~Z까지 해당되는 숫자 index와 대응된 배열
        for(int i=0; i<36; i++)
        {
            if(i<10)
                number[i] = (char)('0'+ i);
            else
                number[i] = (char)('A'+(i-10));
        }

        String N = scanner.next();
        int B = scanner.nextInt();

        int result = 0;
        for(int i=0; i<N.length(); i++)
        {
            for(int j=0; j<number.length; j++)
            {
                if(N.charAt(i) == number[j])
                {
                    result += j*Math.pow(B, N.length()-1-i);
                    break;
                }
            }
        }
       
        System.out.print(result);

        scanner.close();
    }    
}