package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st ;
        StringBuilder answer = new StringBuilder();

        HashSet<Integer> set = new HashSet<>();
        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            String oper = st.nextToken();
            int num = 0;
            switch (oper) {
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    set.add(num);
                    break;

                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    set.remove(num);
                    break;

                case "check":
                    num = Integer.parseInt(st.nextToken());
                    if (set.contains(num)){
                        answer.append("1").append("\n");
                    } else {
                        answer.append("0").append("\n");
                    }
                    break;

                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    if (set.contains(num)){
                        set.remove(num);
                    } else {
                        set.add(num);
                    }
                    break;

                case "all":
                    for (int i = 1; i < 21; i++) {
                        set.add(i);
                    }
                    break;

                case "empty":
                    set.clear();
                    break;
            }
        }
        System.out.println(answer);
    }
}
