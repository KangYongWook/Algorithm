import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj6064_카잉달력 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        StringTokenizer st;
        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            long year = -1;
            for (int mi = x; mi <= m*n; mi+=m) {
                int currentY = (mi%n==0)?n:mi%n;
                if (currentY == y){
                    year = mi;
                    break;
                }
            }
            answer.append(year).append("\n");
        }
        System.out.println(answer);
    }
}
