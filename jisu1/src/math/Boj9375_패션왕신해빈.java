package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj9375_패션왕신해빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        while (t-- > 0) {
            int clothes = Integer.parseInt(br.readLine());
            HashMap<String,Integer> closet = new HashMap<>();

            for (int i = 0; i < clothes; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String kind = st.nextToken();
                Integer cnt = closet.get(kind);
                if (cnt == null) {
                    closet.put(kind,1);
                } else {
                    closet.put(kind,cnt+1);
                }
            }

            /**
             * 3가지 종류라고
             * 낱개 조합 A+B+C
             * 2벌 조합 (A*B)+(A*C)+(B*C)
             * 3벌 조합 (A*B*C)
             * ---------------------
             * A+B+C+(A*B)+(A*C)+(B*C)+(A*B*C) = ((A+1)*(B+1)*(C+1))-1
             * A+(A*B)+ B + (B*C) + C+ (A*C)+(A*B*C)
             * A(1+B)+B(1+C)+C(1+A)+(A*B*C)
             * n벌 조합 ...
             */
            int total = 1;
            for (int c : closet.values()){
                total = total * (c+1); /*옷을 안입는 경우를 +1 하기*/
            }

            /* 공집합인 경우의 수만 빼서 결과 도출*/
            answer.append(total-1).append("\n");
        }
        System.out.println(answer);
    }
}
