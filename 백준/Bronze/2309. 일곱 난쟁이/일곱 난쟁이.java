import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static List<Integer> length = new ArrayList<>();
    private static List<Integer> result = new ArrayList<>();
    private static boolean found = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int i = 0; i < 9; i++) {
            length.add(Integer.parseInt(br.readLine()));
        }

        findShortPeople(new ArrayList<>(), 0);

        Collections.sort(result);
        for(int p : result) {
            System.out.println(p);
        }
    }

    private static void findShortPeople(List<Integer> pickedPeople, int start) {
        if (found) {
            return;
        }
        if (pickedPeople.size() == 7) {
            int sum = pickedPeople.stream().mapToInt(Integer::intValue).sum();
            if (sum == 100) {
                result = new ArrayList<>(pickedPeople);
                found = true;
            }
            return;
        }

        for(int i = start; i < length.size(); i++) {
            if (!pickedPeople.contains(length.get(i))) {
                pickedPeople.add(length.get(i));
                findShortPeople(pickedPeople, i + 1);
                pickedPeople.remove(pickedPeople.size() - 1);
            }
        }
    }
}