package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj9019_DSLR {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int before = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());
            boolean[] visited = new boolean[10000];
            Queue<Operation> que = new LinkedList<>();
            que.add(new Operation("",before));
            visited[before] = true;

            while(!que.isEmpty()) {
                Operation curr = que.poll();
                if (curr.num == after){
                    answer.append(curr.oper).append("\n");
                    break;
                }
                int change = operD(curr.num);
                if (!visited[change]) {
                    que.add(new Operation(curr.oper + "D", change));
                    visited[change] = true;
                }
                change = operS(curr.num);
                if (!visited[change]) {
                    que.add(new Operation(curr.oper + "S", change));
                    visited[change] = true;
                }
                change = operL(curr.num);
                if (!visited[change]) {
                    que.add(new Operation(curr.oper + "L", change));
                    visited[change] = true;
                }
                change = operR(curr.num);
                if (!visited[change]) {
                    que.add(new Operation(curr.oper + "R", change));
                    visited[change] = true;
                }
            }
        }
        System.out.println(answer);
    }

    private static int operR(int num) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int before = num;
        int j = 0;
        while(before!=0) {
            int mod = before % 10;
            deque.addFirst(mod);

            before = before / 10;
        }
        while (deque.size()!=4){
            deque.addFirst(0);
        }

        deque.addFirst(deque.removeLast());
        int after = 0;
        for (int i = 3; i >= 0; i--) {
            after += deque.poll()*(int)Math.pow(10,i);
        }
        return after;
    }

    private static int operL(int num) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int before = num;
        int j = 0;
        while(before!=0) {
            int mod = before % 10;
            deque.addFirst(mod);

            before = before / 10;
        }
        while (deque.size()!=4){
            deque.addFirst(0);
        }

        deque.add(deque.poll());
        int after = 0;
        for (int i = 3; i >= 0; i--) {
            after += deque.poll()*(int)Math.pow(10,i);
        }
        return after;
    }

    private static int operS(int num) {
        num--;
        if (num == -1) {
            num = 9999;
        }
        return num;
    }

    private static int operD(int num) {
        return (num*2)%10000;
    }


    static class Operation {
        String oper;
        int num;

        public Operation(String oper, int num) {
            this.oper = oper;
            this.num = num;
        }
    }
}
