import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj1967_트리의지름 {
    static LinkedList<Node>[] graph;
    static boolean[] visited;
    static int answer, startNode;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        graph = new LinkedList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }

//        int weight = 0;
//        int startNode = 0;
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[p].add(new Node(c, w));
            graph[c].add(new Node(p, w));

//            if (weight < w) {
//                weight = w;
//                startNode = c;
//            }
        }

        visited = new boolean[n+1];
        dfs(1,0);

        answer =  0;
        visited = new boolean[n+1];
        dfs(startNode, 0);
        System.out.println(answer);

    }

    static void dfs(int curr,int cost) {
        visited[curr] = true;
        if (answer < cost) {
            answer = cost;
            startNode = curr;
        }

        for (Node next : graph[curr]){
            if (!visited[next.vertex]) {
                dfs(next.vertex, cost + next.weight);
            }
        }
    }

    static class Node{
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

    }
}

/*
4
1 2 3
1 3 1
1 4 2

5
1 2 3
1 3 4
1 4 5
1 5 6
 */