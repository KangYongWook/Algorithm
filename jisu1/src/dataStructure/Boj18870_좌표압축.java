package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Boj18870_좌표압축 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] seq = new int[n];

        TreeSet<Integer> set = new TreeSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
            set.add(seq[i]);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for (int s : set) {
            map.put(s, idx++);
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < seq.length; i++) {
            answer.append(map.get(seq[i])).append(" ");
        }
        System.out.println(answer);
    }
}
