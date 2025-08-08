package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2195_문자열복사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String p = br.readLine();

        int answer = 0;
        // 위치를 찾는다 했음
        for (int pi = 0; pi < p.length(); pi++) {
            int fromIdx = 0;
            int maxSameLen = 0;
            while (true) {
                // si 인덱싱 추출 []
                int i = s.indexOf(p.charAt(pi), fromIdx);
                if (i == -1) break;

                // 부분수열 찾는데 길이가 가장 긴걸 선택해야함
                int sameLen = 0;

                // 임시 pi 값과 임시 si 값
                int temPi = pi;
                int si = i;

                // si와 temPi값을 비교하면서 동일하면 인덱싱 ++ 함
                while (si < s.length()
                        && temPi < p.length()
                        && p.charAt(temPi) == s.charAt(si)) {
                    temPi++;
                    si++;
                    sameLen++;
                }
                maxSameLen = Math.max(maxSameLen, sameLen);
                fromIdx = i + 1; // si 부분문자열에서 시작하는 인덱싱 찾기위해 fromIdx 값 세팅
            }
            pi += maxSameLen-1;
            answer++;
        }

        System.out.println(answer);

    }
}

/*
aababcefcefd
aabcefd
3
정답 : 2

xy0z
zzz0yyy0xxx
 */