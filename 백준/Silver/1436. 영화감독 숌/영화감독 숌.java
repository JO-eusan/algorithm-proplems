import java.util.*;

class Main 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int n = 1; int currentNum = 666;
        while(n < N)
        {
            loop: for(int i = currentNum+1; ; i++)
            {
                int count = 0; int digit = 1;
                
                while(i/digit != 0)
                {
                    if((i%(digit*10))/digit == 6)
                    {
                        count++;

                        if(count == 3)
                        {
                            n++;
                            currentNum = i;
                            break loop;
                        }
                    }
                    else
                        count = 0;
                    digit *= 10;
                }

            }

        }

        System.out.print(currentNum);

        scanner.close();
    }
    
}