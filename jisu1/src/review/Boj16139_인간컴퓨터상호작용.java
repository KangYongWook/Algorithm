package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj16139_인간컴퓨터상호작용 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        // 누적합 [행,알파벳소문자 누적][열,문자열]
        int[][]countArr = new int[26][s.length()];
        for (int i = 0; i < s.length(); i++) {
            int row = s.charAt(i);
            for (int j = 0; j < s.length(); j++) {

            }
        }

        int q = Integer.parseInt(br.readLine());
    }
}
