import java.util.PriorityQueue;
import java.util.Scanner;

public class Boj11279_최대힙 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> prio = new PriorityQueue<>((o1, o2) -> o2-o1);
        StringBuilder sb = new StringBuilder();
        while(n-- > 0){
            int x = sc.nextInt();
            if (x==0){
                if (prio.isEmpty()){
                    sb.append("0\n");
                } else {
                    sb.append(prio.poll()).append("\n");
                }
            } else {
                prio.add(x);
            }
        }

        System.out.println(sb);
    }
}
