package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1543_문서검색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String doc = br.readLine();
        String word = br.readLine();

        int answer = 0;
        int sameCount = 0;

        int wordIdx = 0;

        for (int docIdx = 0; docIdx < doc.length(); docIdx++) {
            if (doc.charAt(docIdx) == word.charAt(wordIdx)) {
                sameCount++;
                wordIdx++;
            } else {
                docIdx = docIdx-wordIdx;
                sameCount = 0;
                wordIdx = 0;
            }

            if (sameCount == word.length()) {
                answer++;
                sameCount = 0;
                wordIdx = 0;
            }
        }

        System.out.println(answer);
    }
}
