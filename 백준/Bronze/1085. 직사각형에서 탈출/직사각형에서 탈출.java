import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        String[] numbers = s.split(" ");
        
        int x = Integer.parseInt(numbers[0]);
        int y = Integer.parseInt(numbers[1]);
        int w = Integer.parseInt(numbers[2]);
        int h = Integer.parseInt(numbers[3]);

        int min = x;
        if(y < min)
            min = y;
        if(w-x < min)
            min = w-x;
        if(h-y < min)
            min = h-y;
        System.out.print(min);
        
        scanner.close();
    }    
}