package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj11399_ATM_Prio {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> prio = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            prio.add(Integer.parseInt(st.nextToken()));
        }

        int answer = 0;
        int time = 0;
        while (!prio.isEmpty()) {
            time +=prio.poll();
            answer+=time;
        }

        System.out.println(answer);
    }
}
