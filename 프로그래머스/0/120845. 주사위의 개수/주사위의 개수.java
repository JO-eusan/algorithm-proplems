class Solution {
    public int solution(int[] box, int n) {
        int answer = 0;
        
        int[] numbers = new int[3];
        numbers[0] = box[0] / n;
        numbers[1] = box[1] / n;
        numbers[2] = box[2] / n;
        
        answer = numbers[0] * numbers[1] * numbers[2];
        return answer;
    }
}