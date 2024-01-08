import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();

        int line_3 = A*(B%10);
        int line_4 = A*(B%100/10);
        int line_5 = A*(B/100);

        System.out.println(line_3);
        System.out.println(line_4);
        System.out.println(line_5);
        System.out.println(line_3 + line_4*10 + line_5*100);

        scanner.close();

    }
}