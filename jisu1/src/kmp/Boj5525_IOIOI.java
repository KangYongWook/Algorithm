package kmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj5525_IOIOI {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();

        StringBuilder pattern = new StringBuilder("I");
        for (int i = 0; i < n; i++) {
            pattern.append("OI");
        }

//        int start = 0;
//        int len = pn.length();
//        int end = start+len;
//        int answer = 0;
//
//        while(end<=s.length()){
//            String temp = s.substring(start,end);
//            if (temp.equals(pn.toString())){
//                    start += 2;
//                    answer++;
//            } else {
//                start++;
//            }
//            end = start+len;
//        }

        int answer = kmp(s.toCharArray(), pattern.toString().toCharArray());
        System.out.println(answer);
    }

    public static int kmp(char[] str, char[] pattern){
        // jump 가능한 개수 배열
        int[] pi = getPi(pattern);
        int answer = 0;

        // 패턴의 시작 인덱스 위치
        int j = 0;
        // 문자열의 시작 인덱스 위치
        for (int i = 0; i < str.length; i++) {

            /*
             앞전까지 일치했다가 불일치한 경우
             */
            while (j>0 && str[i] != pattern[j]) {
                // jump할 수 있는 j 위치
                j = pi[j-1];
            }

            /*
             일치한 경우
             예시) str = OOIOIOIOIIOII
             i = 2 이고 j = 0 일때 일치
             */
            if (str[i] == pattern[j]){

                if (j == pattern.length-1) {
                    /*
                    i = 6 , j = 4 , pi[4] = 2
                    패턴의 길이만큼 문자열과 패턴이 동일! -> answer +1
                    j = 2 동일 문자열개수 변경
                     */
                    answer++;
                    j=pi[j];
                } else {
                    // 다음 패턴 비교하기 위해 +1
                    j++;
                }
            }
        }

        return answer;
    }

    // 패턴 내부에서 jump 가능한 개수 찾는 메소드
    public static int[] getPi(char[] pattern) {
        int[] pi = new int[pattern.length];
        // j = 접두사위치 i = 접미사위치
        int j = 0;

        /*
        패턴 길이가 2인 것 for문을 돈다고 이해
        i = 0 -> I -> 0
        i = 1 -> I"O" -> 0
        i = 2 -> IO"I" -> 1
        i = 3 -> IOI"O" -> 2
        i = 4 -> IOIO"I" -> 3

        IOII
        pi = {0,0,1,0}
        i = 5 ->
        */
        for (int i = 1; i < pi.length; i++) {
            /*
            앞전까지 일치했다가 현재 불일치한경우
            j의 일치개수가 0보다 큰 상황
            j는 i의 문자와 같은 위치가 있는 곳까지 돌아간다 (없으면 0까지 이동)
             */
            while (j>0 && pattern[i] != pattern[j]) {
                j = pi[j-1];

            }

            /*
            일치하는경우
            접두사와 접미사가 일치하면 pi(일치개수배열)에 값을 넣는다
                        i    j
            i = 2 -> pi[2] = 1
            i = 3 -> pi[3] = 2
            i = 4 -> pi[3] = 3
            접두사 j의 위치도 증가한다
             */
            if (pattern[i] == pattern[j]) {
                pi[i] = ++j;
            }
        }
        // pi = {0,0,1,2,3}
        return pi;
    }
}
