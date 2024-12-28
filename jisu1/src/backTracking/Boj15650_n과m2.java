package backTracking;

import java.util.Scanner;

public class Boj15650_n과m2 {
    static int n, m;
    static StringBuilder answer;
    static boolean[] visited;
    static int[] box;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[n + 1];
        answer = new StringBuilder();
        box = new int[m];

        dfs(box, 0, 0);

        System.out.println(answer);

    }

    // 수열 담을 박스, 왼쪽 박스의 숫자보다 커야하므로(중복제거), 박스에 담을 인덱스 및 리턴하기 위한 횟수 체크용
    private static void dfs(int[] box, int left, int cnt) {
        if (cnt == m) {
            for (int b : box) {
                answer.append(b).append(" ");
            }
            answer.append("\n");
            return;
        }

        for (int i = left + 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                box[cnt] = i;
                dfs(box, i, cnt + 1);
                visited[i] = false;
            }
        }
    }

}
