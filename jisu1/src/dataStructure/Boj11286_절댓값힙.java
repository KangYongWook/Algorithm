package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Boj11286_절댓값힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> prio = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) == Math.abs(o2)){
                    return o1-o2;
                }
                return Math.abs(o1) - Math.abs(o2);
            }
        });

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (prio.isEmpty()) {
                    answer.append("0\n");
                } else {
                    answer.append(prio.poll()).append("\n");
                }
            } else {
                prio.add(x);
            }
        }

        System.out.println(answer);

    }
}
