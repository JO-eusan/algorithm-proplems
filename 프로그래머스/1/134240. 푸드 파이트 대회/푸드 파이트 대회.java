class Solution {
    public String solution(int[] food) {
        String front = "";
        String rear = "";
        
        for(int i=1; i<food.length; i++) {
            for(int j=0; j<food[i]/2; j++) {
                front = front + String.valueOf(i);
                rear = String.valueOf(i) + rear;
            } 
        }
        
        return front + "0" + rear;
    }
}