import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj12851_숨바꼭질 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> que = new LinkedList<>();
        que.add(n);

        int[] visited = new int[100001];
        visited[n]++;

        int time = 0;
        int count = 0;
        int round = 0;

        while (time == 0) {
            int size = que.size();
            while (size-- > 0) {
                int curr = que.poll();
                if (curr == k) {
                    time = round;
                    count++;
                }

                for (int move : new int[]{curr - 1, curr + 1, curr * 2}) {
                    if (move >= 0 && move <= 100000) {
                        // 한번도 방문하지 않거나 ||  다음 방문건이 동일한건이 같은 초(Breadth)에 있을 경우만 추가해준다
                        if (visited[move] == 0 || visited[move] == visited[curr] + 1) {
                            que.add(move);
                            visited[move] = visited[curr] + 1;
                        }
                    }
                }
            }

            // 한 라운드(같은 초)에 있는 것들이 끝남...
            round++;

        }

        System.out.println(time);
        System.out.println(count);

    }
}

/*
0 0
정답
0
1

5 1000
정답
11
2

5 100000
정답
19
4

1 3
정답
2
2

 */