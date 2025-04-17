import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Boj30585_사전순최대공통부분수열3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arrN = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] arrM = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arrM[i] = Integer.parseInt(st.nextToken());
        }

        int tmp;
        int[] arrTmp;
        if (n>m) {
            tmp = m;
            m = n;
            n = tmp;

            arrTmp = arrM;
            arrM = arrN;
            arrN = arrTmp;
        }

        ArrayDeque<Num> numList = new ArrayDeque<>();
        ArrayDeque<Num> tmpList = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arrN[i] == arrM[j]) {
                    while(!numList.isEmpty() && numList.getLast().value<arrM[j]) {
                        tmpList.addLast(numList.pollLast());
                    }

                    if (numList.isEmpty() || numList.getLast().idx<j){
                        numList.add(new Num(j, arrM[j]));
                        tmpList.clear();
                        break;

                    } else { // 원복
                       while (!tmpList.isEmpty()) {
                           numList.add(tmpList.poll());
                       }
                    }
                }
            }
        }

        System.out.println(numList.size());
        String collect = numList.stream()
                .map(num -> String.valueOf(num.value))
                .collect(Collectors.joining(" "));
        System.out.println(collect);

    }

    static class Num {
        int idx;
        int value;

        public Num(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}

/*
4
1 9 7 3
5
1 8 7 5 3
정답-===
2
7 3


2
100 100
2
100 100
정답===========
2
100 100

6
5 4 3 1 5 3
7
5 2 1 3 5 4 3
정답===========
3
5 5 3

5
2 2 2 2 2
5
1 2 1 1 1


8
4 2 9 6 8 9 10 9
5
6 7 6 9 8
----정답
2
9 8



10
9 8 7 6 5 1 2 3 4 5
8
1 3 5 7 9 6 5 4
 */