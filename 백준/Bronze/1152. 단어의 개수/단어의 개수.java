import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String S = scanner.nextLine();
        String[] arr = S.split(" ");

        int count = 0;
        for(int i=0; i< arr.length; i++)
        {
            if(arr[i].length() == 0)
                continue;
            count++;
        }

        System.out.print(count);

        scanner.close();
    }
}