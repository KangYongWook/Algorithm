package backTracking;

import java.util.Scanner;

public class Boj15652_n과m4 {
    static int n, m;
    static StringBuilder answer;
    static int[] box;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        answer = new StringBuilder();
        box = new int[m];

        dfs(1, 0);

        System.out.println(answer);

    }

    // 왼쪽 박스의 숫자보다 같거나 커야하므로(중복제거), 박스에 담을 인덱스 및 리턴하기 위한 횟수 체크용
    private static void dfs(int left, int cnt) {
        if (cnt == m) {
            for (int b : box) {
                answer.append(b).append(" ");
            }
            answer.append("\n");
            return;
        }

        for (int i = left; i <= n; i++) {
            box[cnt] = i;
            dfs(i, cnt + 1);
        }
    }

}
