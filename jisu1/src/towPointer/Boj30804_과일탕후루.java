package towPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj30804_과일탕후루 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] tangfruit = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tangfruit[i]  = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = -1; // right은 계속 직진을 해야함.
        HashMap<Integer,Integer> tangMap = new HashMap<>();
        int answer = Integer.MIN_VALUE;
        while (++right<n) {
            Integer count = tangMap.get(tangfruit[right]);
            tangMap.put(tangfruit[right], count == null ? 1 : count+1 );

            // 과일종류가 2개가 될때까지 삭제를 해야함
            // 반례 5 5 2 4 2 2
            while(tangMap.size()>2) {
                count = tangMap.get(tangfruit[left]);
                if (count == 1) {
                    tangMap.remove(tangfruit[left]);
                } else {
                    tangMap.put(tangfruit[left],count-1);
                }
                left++;
            }

            answer = Math.max(answer, right-left+1);
        }

        System.out.println(answer);
    }
}


/*
10
1 2 1 1 1 1 1 3 3 3
답 : 8

 */