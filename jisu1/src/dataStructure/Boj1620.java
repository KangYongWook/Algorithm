package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 숫자로 찾기 용도
        String[] pocketmonArr = new String[n+1];
        // 문자로 찾기 용도
        HashMap<String,Integer> pMap = new HashMap<>();

        for (int i = 1; i < pocketmonArr.length; i++) {
            String pocketmon = br.readLine();
            pocketmonArr[i] = pocketmon;
            pMap.put(pocketmon,i);
        }

        StringBuilder answer = new StringBuilder();
        while(m-- > 0){
            String mi = br.readLine();
            if (Character.isDigit(mi.charAt(0))){
                answer.append(pocketmonArr[Integer.parseInt(mi)]).append("\n");
            } else {
                answer.append(pMap.get(mi)).append("\n");
            }
        }

        System.out.println(answer);

    }
}
