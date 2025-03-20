import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10830_행렬제곱 {

    static int n, mod;
    static long b;
    static int[][] matrix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        b = Long.parseLong(st.nextToken());
        mod = 1000;

        matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] answer = matrix;
        if (b > 1){
            answer = divide(b);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 80% 실패 이유
                sb.append(answer[i][j]%1000).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    public static int[][] divide(long b) {
        // 5일경우 2*2*1
        // productMatrix() -> 2번 곱한거
        // productMatrix() * productMatrix() -> 4번 곱한거
        // 한번 더를 어떻게 곱할지....

        int[][] producted;
        if (b == 2) {
            return productMatrix(matrix, matrix);
        } else if (b == 3) {
            return productMatrix(productMatrix(matrix, matrix), matrix);
        } else {
            int[][] divideMatrix = divide(b/2);
            producted = productMatrix(divideMatrix,divideMatrix);
            if (b%2==1){
                producted = productMatrix(producted, matrix);
            }
        }

        return producted;

    }

    public static int[][] productMatrix(int[][] standard, int[][] matrix) {
//        answer[0][0] = matrix[0][0] * matrix[0][0] + matrix[0][1] * matrix[1][0];
//        answer[0][1] = matrix[0][0] * matrix[0][1] + matrix[0][1] * matrix[1][1];
//        answer[1][0] = matrix[1][0] * matrix[0][0] + matrix[1][1] * matrix[1][0];
//        answer[1][1] = matrix[1][0] * matrix[0][1] + matrix[1][1] * matrix[1][1];
        int[][] answer = new int[n][n];
        // 행열 곱
        for (int i = 0; i < n; i++) { // 행
            for (int j = 0; j < n; j++) { // 열
                int count = 0;
                while(count < n) {
                    answer[i][j] += standard[i][count] * matrix[count][j];
                    count++;
                }
                answer[i][j] %= mod;
            }
        }

        return answer;
    }
}

/*
2 1
1000 1000
1000 1000

2 2
1000 1000
1000 1000
 */