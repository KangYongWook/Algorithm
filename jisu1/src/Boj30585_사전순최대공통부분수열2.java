import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Boj30585_사전순최대공통부분수열2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arrN = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] arrM = new int[m + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            arrM[i] = Integer.parseInt(st.nextToken());
        }

        List<String> list = new ArrayList<>();

        // 2차원배열의 0,0이 중요하다
        // 현재 자신의 인덱스까지 오기 전 단계에서 +1을 해줘야하기 때문이다
        String[][] dp = new String[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], "");
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (arrN[i] == arrM[j]) {
                    if (dp[i - 1][j - 1].isEmpty()) {
                        dp[i][j] = String.valueOf(arrM[j]);
                    } else {
                        // 5,3 5,5
                        String[] split = dp[i - 1][j - 1].split(" ");
                        int size = split.length - 1;
                        while (size >= 0) {
                            int splitNum = Integer.parseInt(split[size]);
                            if (splitNum < arrM[j]) {
                                size --;
                            } else {
                                break;
                            }
                        }
                        size++;
                        if (size < split.length) {
                            split[size] = String.valueOf(arrM[j]);
                            dp[i][j] = Arrays.stream(split).limit(size+1)
                                    .collect(Collectors.joining(" "));
                        } else {
                            dp[i][j] = dp[i - 1][j - 1].concat(" ").concat(String.valueOf(arrM[j]));
                        }
                    }
                } else {
                    dp[i][j] = dp[i][j - 1].compareTo(dp[i - 1][j]) > 0 ? dp[i][j - 1] : dp[i - 1][j];
                }
            }
        }

        int size = 0;
        if (dp[n][m].length()>0){
            size = dp[n][m].split(" ").length;
        }
        System.out.println(size);
        System.out.println(dp[n][m]);
    }
}

/*
2
100 100
2
100 100
정답===========
2
100 100

6
5 4 3 1 5 3
7
5 2 1 3 5 4 3
정답===========
3
5 5 3
 */