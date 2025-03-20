package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj9935_문자열폭발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine(); //"addsd4"
        String bomb = br.readLine(); // "C4"
        int len = bomb.length();

        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            sb.append(ch);
            if (ch == bomb.charAt(len - 1)
                    && sb.length() >= len
                    && sb.substring(sb.length() - len, sb.length()).equals(bomb)) {
                sb.delete(sb.length() - len, sb.length());
            }
        }

        if (sb.toString().isEmpty()) {
            sb = new StringBuilder("FRULA");
        }
        System.out.println(sb);

    }
}
