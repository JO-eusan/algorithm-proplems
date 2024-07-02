class Solution {
    public int solution(int[] array) {
    
        int[] frequency = new int[1000];
        
        for(int i=0; i<array.length; i++)
            frequency[array[i]]++;
        
        /* 최빈값 찾기 */
        int max = 0;
        for(int i=0; i<1000; i++){
            if(frequency[i] > frequency[max])
                max = i;
        }
        
        /* 중복 찾기 */
        for(int i=0; i<1000; i++){
            if((i != max) && (frequency[i] == frequency[max]))
                return -1;
        }
        
        return max;
    }
}