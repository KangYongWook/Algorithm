package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1931_회의실배정2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Meeting> prio = new PriorityQueue<>(new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                if (o1.end == o2.end) return  o1.start- o2.start;
                return o1.end - o2.end;
            }
        });

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            prio.add(new Meeting(start,end));
        }

        int answer = 0;
        int endMeeting = -1;
        while(!prio.isEmpty()) {
            Meeting m = prio.poll();
            // 사용여부 확인
            if (endMeeting<=m.start) {
                endMeeting = m.end;
                answer++;
            }

        }
        System.out.println(answer);
    }

    static class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
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
*/