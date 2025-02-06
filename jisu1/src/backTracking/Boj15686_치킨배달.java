package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj15686_치킨배달 {
    static int[] chickenCombiArr;
    static int m;
    static List<Position> houseList;
    static List<Position> chickenList;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        houseList = new ArrayList<>();
        chickenList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int info = Integer.parseInt(st.nextToken());
                if (info == 1) {
                    houseList.add(new Position(i+1, j+1));
                }

                if (info == 2) {
                    chickenList.add(new Position(i+1, j+1));
                }
            }
        }

        // 1. 치킨집 M개씩 조합하기
        // 2. 치킨집 조합하면서 최단 거리 찾기
        chickenCombiArr = new int[m];
        combination(0,0);
        System.out.println(answer);
        
    }

    private static void combination(int index,int start) {
        if (index==m){
//            Arrays.stream(chickenCombiArr).forEach(c->System.out.print(c+" "));
//            System.out.println();
            int totalSum = 0;
            for(Position house : houseList) {
                int minDistance = Integer.MAX_VALUE;
                for (int c : chickenCombiArr) {
                    Position chicken = chickenList.get(c);
                    int cal = Math.abs(house.x-chicken.x) + Math.abs(house.y-chicken.y);
                    minDistance = Math.min(cal, minDistance);
                }
                totalSum += minDistance;
            }
            answer = Math.min(answer, totalSum);
            return;
        }

        for (int i = start; i <chickenList.size() ; i++) {
                chickenCombiArr[index] = i;
                combination(index+1, i+1);
            }
    }

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
