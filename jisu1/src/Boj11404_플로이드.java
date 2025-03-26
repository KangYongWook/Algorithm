import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Boj11404_플로이드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] costArr = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            costArr[a][b] = costArr[a][b] == 0 ? c : Math.min(costArr[a][b], c);
        }

        for (int k = 0; k < n; k++) { // 경유지
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (k == i || i == j || k == j) continue;
                    if (costArr[i][k] != 0 && costArr[k][j] != 0) { // 경유가 가능한 경우
                        int sum = costArr[i][k] + costArr[k][j];
                        costArr[i][j] = costArr[i][j] == 0 ? sum : Math.min(costArr[i][j], sum);
                    }
                }
            }
        }

        Arrays.stream(costArr)
                .map(row -> Arrays.stream(row)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" ")))
                .forEach(System.out::println);

    }

}
