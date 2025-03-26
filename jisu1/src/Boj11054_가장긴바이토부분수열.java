import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Boj11054_가장긴바이토부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] upDp = new int[n]; // 상승 수열
        int[] downDp = new int[n]; // 하강 수열
        for (int i = 0; i < n; i++) {
            upDp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    upDp[i] = Math.max(upDp[j]+1, upDp[i]);
                }
            }
        }

        for (int i = n-1; i >= 0; i--) {
            downDp[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    downDp[i] = Math.max(downDp[j]+1, downDp[i]);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(upDp[i]+downDp[i]-1, answer);
        }

        System.out.println(answer);

//        System.out.println(Arrays.stream(upDp).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
//        System.out.println(Arrays.stream(downDp).mapToObj(String::valueOf).collect(Collectors.joining(" ")));




    }
}
