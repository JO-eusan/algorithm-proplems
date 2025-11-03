import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String cards = br.readLine();
        Map<String, List<String>> savedCards = new LinkedHashMap<>();
        savedCards.put("P", new ArrayList<>());
        savedCards.put("K", new ArrayList<>());
        savedCards.put("H", new ArrayList<>());
        savedCards.put("T", new ArrayList<>());

        for(int i = 0; i < cards.length(); i += 3) {
            String card = cards.substring(i, i + 3);
            String shape = card.substring(0, 1);
            String number = card.substring(1, 3);

            List<String> savedCard = savedCards.get(shape);
            if (savedCard.contains(number)) {
                System.out.println("GRESKA");
                return;
            }

            savedCard.add(number);
            savedCards.put(shape, savedCard);
        }

        for(String key : savedCards.keySet()) {
            System.out.print(13 - savedCards.get(key).size() + " ");
        }
    }
}