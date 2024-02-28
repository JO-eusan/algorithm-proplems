import java.util.*;

class Main 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        int[] angle = new int[3];
        int sum = 0;
        
        // 각 입력받기
        for(int i=0; i<angle.length; i++)
        {
            angle[i] = scanner.nextInt();
            sum += angle[i];
        }
            
        if(sum != 180)
            System.out.print("Error");
        else
        {
            if(angle[0] == angle[1] && angle[1] == angle[2])
                System.out.print("Equilateral");
            else if(angle[0] == angle[1] || angle[0] == angle[2] || angle[1] == angle[2])
                System.out.print("Isosceles");
            else
                System.out.print("Scalene");
        }
        
        scanner.close();
    }   
}