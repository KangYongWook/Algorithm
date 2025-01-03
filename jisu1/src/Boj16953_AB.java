import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj16953_AB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int size = 1000000001;
        boolean[] visited = new boolean[size];
        Queue<Change> que = new LinkedList<>();
        que.add(new Change(a, 1));
        visited[a] = true;

        int answer = -1;
        while (!que.isEmpty()) {
            Change ch = que.poll();
            if (ch.number == b) {
                answer = ch.count;
                break;
            }

            // 4%에서 틀렸습니다 -> int를 long으로 형변환
            long next = ch.number * 2;
            if (1 <= next && next < size && !visited[(int)next]) {
                visited[(int)next] = true;
                que.add(new Change(next, ch.count + 1));
            }

            next = (ch.number * 10) + 1;
            if (1 <= next && next < size && !visited[(int)next]) {
                visited[(int)next] = true;
                que.add(new Change(next, ch.count + 1));
            }
        }

        System.out.println(answer);
    }

    static class Change {
        long number;
        int count;

        public Change(long number, int count) {
            this.number = number;
            this.count = count;
        }
    }
}
