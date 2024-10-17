package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Boj1927_최소힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> prio = new PriorityQueue<>();
        StringBuilder answer = new StringBuilder();

        while(n-->0){
            int x = Integer.parseInt(br.readLine());
            if (x == 0){
                if (prio.isEmpty()){
                    answer.append("0").append("\n");
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
