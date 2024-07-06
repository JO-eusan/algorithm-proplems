class Solution {
    public String[] solution(String my_str, int n) {
        int size = 0;
        double s = (double)my_str.length()/n;
        if(s != (double)(my_str.length()/n))
            size = my_str.length()/n + 1;
        else
            size = my_str.length()/n;
        String[] answer = new String[size];
        for(int i=0; i<size; i++) {
            if(i == size-1)
                answer[i] = my_str.substring(n*i);
            else
                answer[i] = my_str.substring(n*i, n*(i+1));
        }
        
        return answer;
    }
}