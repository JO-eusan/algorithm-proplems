import java.io.*;

public class Main {

    static int K;
    static int count = 0; // 현재 선택된 숫자
    static int[] tmp;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] first_line = br.readLine().split(" ");
        int N = Integer.parseInt(first_line[0]);
        K = Integer.parseInt(first_line[1]); // 전역 변수로 설정하여 재귀 호출 시 확인

        String[] second_line = br.readLine().split(" ");
        int[] A = new int[N];
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(second_line[i]);
        }

        tmp = new int[A.length];
        merge_sort(A, 0, A.length - 1);
        System.out.print(-1);
    }

    public static void merge_sort(int[] A, int p, int r) {
        if(p < r) {
            int q = (p + r) / 2;
            merge_sort(A, p, q); // 전반부 정렬
            merge_sort(A, q + 1, r); // 후반부 정렬

            merge(A, p, q, r);
        }
    }

    public static void merge(int[] A, int p, int q, int r) {
        
        int i = p; // left-sub의 최소값
        int j = q + 1; // right-sub의 최소값
        int t = 0; // 현재 결과 배열의 위치

        while(i <= q && j <= r) {
            if(A[i] <= A[j]) // left-sub의 최소값이 더 작다면 그 값을 결과 배열에 저장
                tmp[t++] = A[i++];
            else // right-sub의 최소값이 더 작다면 그 값을 결과 배열에 저장
                tmp[t++] = A[j++];
        }

        while(i <= q) { // 왼쪽 배열 부분이 남은 경우
            tmp[t++] = A[i++];
        }

        while(j <= r) { // 오른쪽 배열 부분이 남은 경우
            tmp[t++] = A[j++];
        }

        i = p; t = 0; 
        while(i <= r) { // tmp 결과를 A에 저장
            A[i++] = tmp[t++];

            if(++count == K) {
                System.out.print(A[i-1]);
                System.exit(0);
            }
        }
    }
}