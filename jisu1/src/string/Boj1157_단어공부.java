package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class Boj1157_단어공부 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        word = word.toUpperCase(Locale.ROOT);
        int[] countingAlpa = new int[27];

        for (char ch : word.toCharArray()) {
            countingAlpa[ch - 'A']++;
        }

        int max = -1;
        char singleAlpa = 'A';
        boolean sameMaxFlag = false;

        for (int i = 0; i < 27; i++) {
            if (max < countingAlpa[i]) {
                max = countingAlpa[i];
                singleAlpa = (char) ('A' + i);
                sameMaxFlag = false;
            } else if (max == countingAlpa[i]) {
                sameMaxFlag = true;
            }
        }

        if (sameMaxFlag) System.out.println("?");
        else System.out.println(singleAlpa);

    }
}
