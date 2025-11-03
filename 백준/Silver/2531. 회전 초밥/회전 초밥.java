import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        List<Integer> numbers = new ArrayList<>();
        for(int n = 0; n < N; n++) {
            numbers.add(Integer.parseInt(br.readLine()));
        }

        int maxCounter = 0;
        Map<Integer, Integer> categories = new HashMap<>();
        categories.put(c, 1);
        for(int i = 0; i < N + k - 1; i++) {
            int category = numbers.get(i % N);
            if (i < k) {
                if (categories.containsKey(category)) {
                    categories.put(category, categories.get(category) + 1);
                } else {
                    categories.put(category, 1);
                }
            } else {
                int previousCategory = numbers.get((i - k) % N);
                int counter = categories.get(previousCategory);
                if (counter - 1 == 0) {
                    categories.remove(previousCategory);
                } else {
                    categories.put(previousCategory, counter - 1);
                }

                if (categories.containsKey(category)) {
                    categories.put(category, categories.get(category) + 1);
                } else {
                    categories.put(category, 1);
                }
            }
            if (maxCounter < categories.size()) {
                maxCounter = categories.size();
            }
        }
        System.out.println(maxCounter);
    }
}