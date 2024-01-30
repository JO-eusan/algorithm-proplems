import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        final int student_number = 30;
        int[] students = new int[student_number]; // 0~29 (총 30명)

        for(int i=0; i<student_number-2; i++)
        {
            int number = scanner.nextInt();
            students[number-1] = 1;
        }

        for(int i=0; i<student_number; i++)
        {
            if(students[i] == 0)
                System.out.println(i+1);
        }

        scanner.close();
    }
}