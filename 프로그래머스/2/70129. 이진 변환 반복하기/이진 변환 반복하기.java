class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        String binaryCode = s;
        
        while(true) {
            answer[0]++;
            int result = 0;
            for(int i=0; i<binaryCode.length(); i++) {
                if(binaryCode.charAt(i) == '1') {
                    result++;
                } else {
                    answer[1]++;
                }
            }
            
            if(result == 1) {
                break;
            }
        
            String newBinaryCode = "1";
            while(result / 2 != 1) {
                newBinaryCode += result % 2;
                result /= 2;
            }
            newBinaryCode += String.valueOf(result % 2);
            binaryCode = newBinaryCode;
        }
        return answer;
    }
}