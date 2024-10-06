package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj16139_인간컴퓨터상호작용 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 200000; i++) {
            int c = 'a'+(int)(Math.random()*26);
            sb.append((char)c);
        }
        s = sb.toString();
        System.out.println(s);
        // 누적합 [행,알파벳소문자 누적][열,문자열]
        int colSize = s.length()+1;
        int[][]countArr = new int[26][colSize];
        for (int i = 0; i < s.length(); i++) {
            int row = s.charAt(i)-'a';
            for (int j = i+1; j < colSize; j++) {
                countArr[row][j]++;
            }
        }

        int q = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int alpha = st.nextToken().charAt(0)-'a';
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken())+1;
            answer.append(countArr[alpha][end]-countArr[alpha][start]).append("\n");
        }
        System.out.println(answer);
    }
}
