import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        String[] tmp = s.split(" ");

        int[] sticks = new int[tmp.length];
        for(int i=0; i<tmp.length; i++)
            sticks[i] = Integer.parseInt(tmp[i]);

        Arrays.sort(sticks); // 정렬

        if(sticks[2] < sticks[0]+sticks[1])
            System.out.print(sticks[0] + sticks[1] + sticks[2]);
        else
        {
            while(sticks[2] >= sticks[0]+sticks[1])
                sticks[2] -= 1;
            System.out.print(sticks[0] + sticks[1] + sticks[2]);
        }

        scanner.close();
    }    
}