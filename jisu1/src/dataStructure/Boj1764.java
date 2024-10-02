package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Boj1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();
        while (n-- > 0) {
            set.add(br.readLine());
        }

        TreeSet<String> dup = new TreeSet<>();
        while (m-- > 0){
            String mi = br.readLine();
            if (set.contains(mi)){
                dup.add(mi);
            }
        }

        StringBuilder answer = new StringBuilder();
        answer.append(dup.size()).append("\n");
        Iterator<String> dIt = dup.iterator();
        while (dIt.hasNext()) {
            answer.append(dIt.next()).append("\n");
        }

        System.out.println(answer);

    }
}
