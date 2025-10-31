import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String result = "";
        List<String> points = new ArrayList<>();

        for(int i = 0; i < 36; i++) {
            String point = br.readLine();
            if (points.contains(point)) {
                result = "Invalid";
            }
            if (i != 0 && !isDistance(point, points.get(points.size() - 1))) {
                result = "Invalid";
            }
            points.add(point);
        }

        String firstPoint = points.get(0);
        String lastPoint = points.get(points.size() - 1);
        if (!isDistance(firstPoint, lastPoint)) {
            result = "Invalid";
        }

        System.out.println(result == "" ? "Valid" : result);
    }

    private static boolean isDistance(String point1, String point2) {
        int X1 = 6 - Integer.parseInt(String.valueOf(point1.charAt(1)));
        int Y1 = point1.charAt(0) - 'A';
        int X2 = 6 - Integer.parseInt(String.valueOf(point2.charAt(1)));
        int Y2 = point2.charAt(0) - 'A';

        double distance = Math.pow(X1 - X2, 2) + Math.pow(Y1 - Y2, 2);
        if (distance != 5) {
            return false;
        }
        return true;
    }
}