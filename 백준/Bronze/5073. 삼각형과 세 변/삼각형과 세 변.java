import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        while(true)
        {
            String s = scanner.nextLine();
            String[] tmp = s.split(" ");

            int[] lines = new int[tmp.length];
            for(int i=0; i<lines.length; i++)
                lines[i] = Integer.parseInt(tmp[i]);
            
            // EOF
            if(lines[0] == 0 && lines[1] == 0 && lines[2] == 0)
                break;
            
            Arrays.sort(lines); // 정렬

            // 삼각형 판단
            if(lines[2] >= lines[0] + lines[1])
                System.out.println("Invalid");
            else if(lines[0] == lines[1] && lines[1] == lines[2])
                System.out.println("Equilateral");
            else if(lines[0] == lines[1] || lines[0] == lines[2] || lines[1] == lines[2])
                System.out.println("Isosceles");
            else
                System.out.println("Scalene");
            
        }

        scanner.close();
    }    
}