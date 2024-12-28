package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Boj7662_이중우선순위큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st ;
        StringBuilder answer = new StringBuilder();

        while(t-- > 0) {
            int q = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            while(q-- > 0) {
                st = new StringTokenizer(br.readLine());
                char oper = st.nextToken().charAt(0);
                int n = Integer.parseInt(st.nextToken());

                if (oper=='I') {
                    //.getOrDefault
                    Integer value = treeMap.get(n);
                    if (value==null){
                        treeMap.put(n,1);
                    } else {
                        treeMap.put(n, value+1);
                    }
                }
                else if (oper=='D'){

                    if (treeMap.isEmpty()) continue;
                    Integer key;
                    if (n==1) {
                        key = treeMap.lastKey();
                    } else {
                        key = treeMap.firstKey();
                    }
                    Integer value = treeMap.get(key);

                    //.getOrDefault
                    if (value == 1) {
                        treeMap.remove(key);
                    } else {
                        treeMap.put(key, value-1);
                    }
                }
            }
            if (treeMap.isEmpty()) {
                answer.append("EMPTY").append("\n");
            } else {
                int max = treeMap.lastKey();
                int min = treeMap.firstKey();
                answer.append(max).append(" ").append(min).append("\n");
            }
        }

        System.out.println(answer);
    }
}
