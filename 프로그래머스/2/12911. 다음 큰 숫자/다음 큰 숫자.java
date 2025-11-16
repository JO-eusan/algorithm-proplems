class Solution {
    public int solution(int n) {
        int target = findOne(n);
        int candidate = n + 1;
        
        while(findOne(candidate) != target) {
            candidate++;
        }
        return candidate;
    }
    
    private int findOne(int number) {
        int count = 0;
        while(number / 2 != 1) {
            if(number % 2 == 1) {
                count++;
            }
            number /= 2;
        }
        return count + 1 + number % 2;
    }
}