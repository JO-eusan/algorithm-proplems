import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String T_tmp = scanner.next();
        int T = Integer.parseInt(T_tmp);

        for(int i=0; i<T; i++)
        {
            String R_tmp = scanner.next();
            String S = scanner.next();

            int R = Integer.parseInt(R_tmp);

            String P = "";
            for(int j=0; j<S.length(); j++)
            {   
                for(int k=0; k<R; k++)
                {
                    P += S.charAt(j);
                }
            }

            System.out.printf("%s\n", P);
        }

        scanner.close();
    }
}