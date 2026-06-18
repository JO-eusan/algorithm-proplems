import java.util.*;

class Solution {

    /*
     * 2~9진법 후보를 모두 확인
     * 결과가 존재하는 식으로 진법 후보 제거
     * X 식은 남은 진법들에서 계산 후 같은 값이면 확정, 아니면 ?
     */

    public String[] solution(String[] expressions) {
        boolean[] candidate = new boolean[10];
        Arrays.fill(candidate, true);

        List<String> neededCalculate = new ArrayList<>();

        // 진법 후보 찾기
        for(String ex : expressions) {
            String[] tokens = ex.split(" ");

            String num1 = tokens[0];
            String num2 = tokens[2];
            String op = tokens[1];
            String result = tokens[4];

            // 등장하는 숫자 중 최대 digit + 1
            int minBase = getMinBase(num1, num2, result);

            // 해당 진법보다 작은 진법 제거
            for(int base = 2; base < minBase; base++) {
                candidate[base] = false;
            }

            if(result.equals("X")) {
                neededCalculate.add(ex);
                continue;
            }

            // 결과가 있는 식으로 진법 후보 검증
            for(int base = 2; base <= 9; base++) {
                if(!candidate[base]) {
                    continue;
                }

                int a = toDecimal(num1, base);
                int b = toDecimal(num2, base);
                int c = toDecimal(result, base);

                int value = calculate(a, b, op);

                if(value != c) {
                    candidate[base] = false;
                }
            }
        }

        String[] answer = new String[neededCalculate.size()];


        // X 계산
        for(int i=0; i<neededCalculate.size(); i++) {
            String[] tokens = neededCalculate.get(i).split(" ");

            String num1 = tokens[0];
            String num2 = tokens[2];
            String op = tokens[1];

            Set<String> results = new HashSet<>();

            for(int base = 2; base <= 9; base++) {
                if(!candidate[base]) {
                    continue;
                }

                int a = toDecimal(num1, base);
                int b = toDecimal(num2, base);

                int value = calculate(a, b, op);
                // 진법 결과로 저장해야 함
                results.add(toBase(value, base));
            }

            String result;

            if(results.size() == 1) {
                result = results.iterator().next();
            } else {
                result = "?";
            }
            answer[i] = num1 + " " + op + " " + num2 + " = " + result;
        }

        return answer;
    }


    private int getMinBase(String num1, String num2, String result) {
        int base = 2;

        for(char c : num1.toCharArray()) {
            base = Math.max(base, c - '0' + 1);
        }
        for(char c : num2.toCharArray()) {
            base = Math.max(base, c - '0' + 1);
        }
        if(!result.equals("X")) {

        for(char c : result.toCharArray()) {

            base = Math.max(base, c - '0' + 1);

        }
    }

        return base;
    }


    // 진법 -> 10진법
    private int toDecimal(String num, int base) {
        int result = 0;

        for(char c : num.toCharArray()) {

            result = result * base + (c - '0');
        }

        return result;
    }


    // 10진법 -> 해당 진법
    private String toBase(int value, int base) {
        if(value == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        while(value > 0) {
            sb.append(value % base);
            value /= base;
        }

        return sb.reverse().toString();
    }


    private int calculate(int a, int b, String op) {
        if(op.equals("+")) {
            return a + b;
        }

        return a - b;
    }
}