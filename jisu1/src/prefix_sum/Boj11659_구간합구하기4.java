    package prefix_sum;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.StringTokenizer;

    public class Boj11659_구간합구하기4 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            int[] prefixSum = new int[n+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                prefixSum[i] = Integer.parseInt(st.nextToken())+prefixSum[i-1];
            }

            StringBuilder answer = new StringBuilder();
            while (t-- > 0) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                answer.append(prefixSum[end]-prefixSum[start-1]).append("\n");
            }

            System.out.println(answer);

        }
    }
