import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.next();
        int count_time = 0;

        for(int i=0; i<S.length(); i++)
        {
            char tmp = S.charAt(i);
            
            switch(tmp)
            {
                case 'A':
                case 'B':
                case 'C':
                    count_time += 3;
                    break;
                case 'D':
                case 'E':
                case 'F':
                    count_time += 4;
                    break;
                case 'G':
                case 'H':
                case 'I':
                    count_time += 5;
                    break;
                case 'J':
                case 'K':
                case 'L':
                    count_time += 6;
                    break;
                case 'M':
                case 'N':
                case 'O':
                    count_time += 7;
                    break;
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                    count_time += 8;
                    break;
                case 'T':
                case 'U':
                case 'V':
                    count_time += 9;
                    break;
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                    count_time += 10;
                    break;
            }

        }

        System.out.print(count_time);

        scanner.close();
    }
}