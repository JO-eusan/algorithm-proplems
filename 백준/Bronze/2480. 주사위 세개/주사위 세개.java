import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        if((a != b) && (b != c) && (a != c))
        {
            int max_num = a;
            if(max_num < b)
            {
                if(b < c)
                    max_num = c;
                else
                    max_num = b;
            }
            else if(max_num < c)
            {
                if(c < b)
                    max_num = b;
                else
                    max_num = c;
            }
            System.out.println(max_num * 100);
        }
        else 
        {
            if((a == b) && (a == c))
            {
                System.out.println(10000+a*1000);
            }
            else
            {
                if((a == b) || (a == c))
                    System.out.println(1000 + 100*a);
                else if(b==c)
                    System.out.println(1000 + b*100);
            }
        }

        scanner.close();
    }
    
}
