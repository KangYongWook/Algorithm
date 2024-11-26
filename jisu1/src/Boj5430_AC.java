import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Boj5430_AC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < tc; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String x = br.readLine();
            String[] xArr = x.substring(1, x.length() - 1).split(",");

            ArrayDeque<String> deque = new ArrayDeque<>();
            for (int xi = 0; xi < n; xi++) {
                deque.add(xArr[xi]);
            }

            boolean reverseFlag = false;
            boolean errorFlag = false;
            for (char pi : p.toCharArray()) {
                if (pi == 'R') {
                    reverseFlag = !reverseFlag;
                } else {
                    if (!deque.isEmpty()) {
                        if (reverseFlag) {
                            deque.removeLast();
                        } else {
                            deque.removeFirst();
                        }
                    } else {
                        errorFlag = true;
                        break;
                    }
                }
            }

            if (errorFlag) {
                answer.append("error").append("\n");
            } else {
                StringBuilder strArr = new StringBuilder("[");
                while (!deque.isEmpty()) {
                    if (reverseFlag) {
                        strArr.append(deque.pollLast());
                    } else {
                        strArr.append(deque.pollFirst());
                    }

                    if (!deque.isEmpty()) {
                        strArr.append(",");
                    }
                }
                strArr.append("]");
                answer.append(strArr).append("\n");
            }
        }
        System.out.print(answer);
    }
}

/*
1
D
0
[]
 */