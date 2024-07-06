class Solution {
    public long solution(String numbers) {
        long answer = 0;
        String result = "";
        
        int idx = 0;
        while(idx < numbers.length()) {
            char tmp = numbers.charAt(idx);
            switch(tmp) {
                case 'z':
                    result += "0";
                    idx += 4;
                    break;
                case 'o':
                    result += "1";
                    idx += 3;
                    break;
                case 't':
                    if(numbers.charAt(idx+1) == 'w') {
                        result += "2";
                        idx += 3;
                        break;
                    }
                    else {
                        result += "3";
                        idx += 5;
                        break;
                    }
                case 'f':
                    if(numbers.charAt(idx+1) == 'o') {
                        result += "4";
                        idx += 4;
                        break;
                    }
                    else {
                        result += "5";
                        idx += 4;
                        break;
                    }
                case 's':
                    if(numbers.charAt(idx+1) == 'i') {
                        result += "6";
                        idx += 3;
                        break;
                    }
                    else {
                        result += "7";
                        idx += 5;
                        break;
                    }
                case 'e':
                    result += "8";
                    idx += 5;
                    break;
                case 'n':
                    result += "9";
                    idx += 4;
                    break;
            }
        }
        
        answer = Long.parseLong(result);
        return answer;
    }
}