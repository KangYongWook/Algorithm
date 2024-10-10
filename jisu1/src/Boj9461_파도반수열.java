import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj9461_파도반수열 {
    public static void main(String[] args) throws IOException {
        /* int -> long 으로 바꿔서 풀어서 성공
        * 값의 범위를 어떻게 풀기 전에 알 수 있을까  */
        long[] triangle = new long[101];
        // 초기값
        triangle[1] = 1;
        triangle[2] = 1;
        triangle[3] = 1;
        triangle[4] = 2;
        triangle[5] = 2;

        for (int i = 6; i < 101; i++) {
            triangle[i] = triangle[i-1]+triangle[i-5];
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            answer.append(triangle[n]).append("\n");
        }
        System.out.println(answer);
    }
}
