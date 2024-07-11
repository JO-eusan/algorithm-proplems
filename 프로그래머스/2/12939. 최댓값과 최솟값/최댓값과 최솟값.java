class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] numbers_s = s.split(" ");
        int[] numbers = new int[numbers_s.length];
        for(int i=0; i<numbers.length; i++) 
            numbers[i] = Integer.parseInt(numbers_s[i]);
        
        int min = numbers[0];
        int max = numbers[0];
        for(int i=1; i<numbers.length; i++) {
            if(min > numbers[i])
                min = numbers[i];
            else if(max < numbers[i])
                max = numbers[i];
        }
        
        answer = String.valueOf(min) + " " + String.valueOf(max);
        
        return answer;
    }
}