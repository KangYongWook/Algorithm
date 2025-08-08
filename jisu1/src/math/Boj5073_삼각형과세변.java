package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj5073_삼각형과세변 {
    static int numArr[];

    public static void main(String[] args) throws IOException {
        StringBuilder answer = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            numArr = new int[3];
            for (int i = 0; i < 3; i++) {
                numArr[i] = Integer.parseInt(st.nextToken());
            }

            if (numArr[0] == 0 && numArr[1] == 0 && numArr[2] == 0) break;

            boolean[] widthSame = new boolean[3];
            widthSame[0] = numArr[0] == numArr[1];
            widthSame[1] = numArr[1] == numArr[2];
            widthSame[2] = numArr[2] == numArr[0];

            int sameFlagCnt = 0;
            for (int i = 0; i < 3; i++) {
                if (widthSame[i] == true) {
                    sameFlagCnt++;
                }
            }

            if (sameFlagCnt==3) {
                // 정삼각형
                answer.append("Equilateral").append("\n");
                continue;
            }

            if (checkScalene() == true) {
                if (sameFlagCnt==1) {
                    answer.append("Isosceles").append('\n');

                } else {
                    answer.append("Scalene").append("\n");
                }
            } else {
                answer.append("Invalid").append("\n");
            }

        }

        System.out.println(answer);
    }

    static boolean checkScalene() {
        int max = -1;
        int maxIndex = -1;
        for (int i = 0; i < 3; i++) {
            if (max < numArr[i]) {
                max = numArr[i];
                maxIndex = i;
            }
        }

        if (maxIndex == 0) {
            return numArr[0] < numArr[1] + numArr[2];

        } else if (maxIndex == 1) {
            return numArr[1] < numArr[0] + numArr[2];

        } else if (maxIndex == 2) {
            return numArr[2] < numArr[1] + numArr[0];

        }

        return true;
    }
}
