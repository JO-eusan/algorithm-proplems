import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int sum = 1;
        int number_room = 1;

        while(sum < N)
        {
            sum += 6*number_room;
            number_room ++;
        }
        System.out.print(number_room);

        scanner.close();
    }
}