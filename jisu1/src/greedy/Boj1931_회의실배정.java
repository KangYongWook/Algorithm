package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1931_회의실배정 {
    static boolean[] using;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Meeting> prio = new PriorityQueue<>(new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
//                if (o1.time == o2.time){
//                    if (o1.start == o2.start) {
//                        return o1.end - o2.end;
//                    }
//                    return o1.start - o2.start;
//                }
//                return o1.time-o2.time;
                if (o1.end == o2.end) return  o1.start- o2.start;
                return o1.end - o2.end;
            }
        });

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            prio.add(new Meeting(start,end,end-start));
            max = Math.max(end, max);
        }

        using = new boolean[max+1];
        int answer = 0;
        while(!prio.isEmpty()) {
            Meeting m = prio.poll();
            // 사용여부 확인
            if (isAbleMeeting(m)) {
                // 사용중 체크
                for (int i = m.start; i <= m.end; i++) {
                    using[i] = true;
                }

                // 회의실 개수 추가
                answer++;
            }

        }
        System.out.println(answer);
    }

    private static boolean isAbleMeeting(Meeting m) {
        for (int i = m.start; i <= m.end ; i++) {
            if (i==m.start && using[m.start]) {
                continue;
            }

//            if (i==m.end && using[m.end]) {
//                continue;
//            }

            if (using[i]) {
                return false;
            }
        }
        return true;
    }

    static class Meeting {
        int start;
        int end;
        int time;

        public Meeting(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }
}

/*
반례
3
4 4
3 4
2 4
 -----
 결과 1
 정답 2

5
1 3
3 5
0 1
5 7
7 9
*/