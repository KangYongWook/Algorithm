package week0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2 {
    public static void main(String[] args) throws IOException {
        // 답지문자열
        // 제출자수
        // 제출자수만큼 제출답지문자열

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer = br.readLine();
        int len = answer.length();
        int submits = Integer.parseInt(br.readLine());
        String[] submitArr = new String[submits];
        for (int i = 0; i < submits; i++) {
            submitArr[i] = br.readLine();
        }

        boolean[][] compareArr = new boolean[submits][len];
        for (int i = 0; i < submits; i++) {
            for (int j = 0; j < len; j++) {
                compareArr[i][j] = (answer.charAt(j) == submitArr[i].charAt(j));
            }
        }

    }
}



