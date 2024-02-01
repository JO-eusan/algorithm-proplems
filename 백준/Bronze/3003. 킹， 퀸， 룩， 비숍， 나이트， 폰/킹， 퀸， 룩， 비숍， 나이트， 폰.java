import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int king = scanner.nextInt();
        int queen = scanner.nextInt();
        int look = scanner.nextInt();
        int bshop = scanner.nextInt();
        int knite = scanner.nextInt();
        int pon = scanner.nextInt();

        System.out.printf("%d %d %d %d %d %d", 1-king, 1-queen, 2-look, 2-bshop, 2-knite, 8-pon);
    
        scanner.close();
    }
}