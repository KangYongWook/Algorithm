package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj30805_사전순최대공통부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> listN = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            listN.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        List<Integer> listM = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            listM.add(Integer.parseInt(st.nextToken()));
        }

        // 입력값 받기 ...
        // 0. arrN과 arrM에서 가장 큰 값을 찾기
        StringBuilder answer = new StringBuilder();
        int maxNum = Math.max(listN.stream().max(Comparator.naturalOrder()).get(), listM.stream().max(Comparator.naturalOrder()).get());
        int cnt = 0;
        for (int i = maxNum; i > 0 ; i--) {
            while(true) {
                int idxForN = listN.indexOf(i);
                int idxForM = listM.indexOf(i);

                if (idxForN == -1 || idxForM == -1) break;

                answer.append(" ").append(i);
                cnt++;
                listN = listN.subList(idxForN+1, listN.size());
                listM = listM.subList(idxForM+1, listM.size());
            }

        }

        answer.delete(0,1);
        System.out.println(cnt);
        System.out.println(answer.toString());
    }
}

/*
2
100 100
2
100 100
정답===========
2
100 100

6
5 4 3 1 5 3
7
5 2 1 3 5 4 3
정답===========
3
5 5 3
 */