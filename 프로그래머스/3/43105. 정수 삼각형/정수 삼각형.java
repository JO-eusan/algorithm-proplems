class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        //누적 합을 위한 배열 -> triangle과 동일한 크기
        int[][] sum = new int[triangle.length][];
        for(int i=0; i<triangle.length; i++) {
            sum[i] = new int[triangle[i].length];
        }
        
        //start
        sum[0][0] = triangle[0][0];
        
        for(int i=1; i<triangle.length; i++) {
            
            sum[i][0] = sum[i-1][0] + triangle[i][0];
            
            for(int j=1; j<sum[i].length-1; j++) {
                int num1 = sum[i-1][j-1] + triangle[i][j];
                int num2 = sum[i-1][j] + triangle[i][j];
                
                sum[i][j] = Math.max(num1, num2);
            }
            
            sum[i][sum[i].length - 1] 
                = sum[i-1][sum[i-1].length - 1] + triangle[i][sum[i].length - 1];
        }
        
        //마지막 배열의 최대값이 정답
        answer = sum[triangle.length - 1][0];
        for(int i=1; i<sum[triangle.length - 1].length; i++) {
            if(sum[triangle.length - 1][i] > answer)
                answer = sum[triangle.length - 1][i];
        }
        
        return answer;
    }
}