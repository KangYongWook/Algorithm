package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj1043_거짓말 {
    static int[] root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // union-find를 위해 루트노드
        root = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            root[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int knownCnt = Integer.parseInt(st.nextToken());
        if (knownCnt == 0) {
            System.out.println(m);
            return;
        }

        for (int i = 0; i < knownCnt; i++) {
            int know = Integer.parseInt(st.nextToken());

            root[know] = 0;
        }

        LinkedList<Integer>[] partyList = new LinkedList[m];
        //파티원
        for (int i = 0; i < m; i++) {
            partyList[i] = new LinkedList<>();

            // 파티원저장
            st = new StringTokenizer(br.readLine());
            int memberCnt = Integer.parseInt(st.nextToken());

            int prevMem = 0;
            for (int j = 0; j < memberCnt; j++) {
                int member = Integer.parseInt(st.nextToken());
                partyList[i].add(member);

                if (j >= 1) {
                    union(prevMem, member);
                }
                prevMem = member;
            }
        }

        int answer = 0;
        for (LinkedList<Integer> party : partyList) {
            boolean knownFlag = false;
            for (int member : party) {
                if (find(member) == 0) {
                    knownFlag = true;
                    break;
                }
            }
            if (!knownFlag) {
                answer++;
            }
        }

        System.out.println(answer);

    }

    static int find(int x) {
        if (root[x] == x) return x;
        return find(root[x]);
    }

    static void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);

        // rx-ry 자리바꿈
        if (ry == 0) {
            root[rx] = ry;
        } else {
            root[ry] = rx;
        }
    }
}
