package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj9251_LCS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String colString = br.readLine(); // 기준 (열)
        String rowString = br.readLine(); // (행)

        int colSize = colString.length();
        int rowSize = rowString.length();

        // index = 0 은 사용하지 않음 1~size 까지 사용
        int[][] dp = new int[rowSize+1][colSize+1];
        for (int row = 1; row <= rowString.length(); row++) {
            for (int col = 1; col <= colString.length(); col++) {

                // 문자비교할때만 인덱스-1을 해줘야한다
                // dp를 위해 Index 1 부터 값을 넣어줘야하기 때문 (index 0 에 값이 비어져있어야한다)
                if (rowString.charAt(row-1) == colString.charAt(col-1)) {
                    // 1%에서 틀림 dp[row][col-1] 로 했기 때문
                    // 이전 대각선에 값을 가져와야함
                    dp[row][col] = dp[row-1][col-1]+1;
                } else {
                    // 위 혹은 왼쪽에서 큰 값을 넣는다
                    dp[row][col] = Math.max(dp[row][col-1],dp[row-1][col]);
                }
            }
        }

        System.out.println(dp[rowSize][colSize]);
    }
}

/*
MWMHWCM
CMPOFVF
결과 : 3
정답 : 2
 */