import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj17144_미세먼지안녕 {

    static int[][] room;
    static ArrayList<Pos> dustList = new ArrayList<Pos>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        room = new int[r][c];
        Pos air = null;
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());

                // 공기청정기
                if (room[i][j] == -1 && air == null) {
                    air = new Pos(i, j, 0);
                }

                if (room[i][j] > 0) {
                    dustList.add(new Pos(i, j, room[i][j]));
                }
            }
        }

        while (t-- > 0) {
            // 1. 미세먼지 확산
            spread();

            // 2. 위쪽 공기청정기, 반시계 순환 -> 덮어씌워야하므로 시계방향으로 순환하면서 먼지를 덮어씌운다
            int row = air.r;
            int col = air.c;
            // 위
            for (int i = row - 1; i > 0; i--) {
                room[i][col] = room[i - 1][col];
            }
            // 오른쪽
            for (int i = 0; i < c - 1; i++) {
                room[0][i] = room[0][i + 1];
            }
            // 아래
            for (int i = 0; i < row; i++) {
                room[i][c - 1] = room[i + 1][c - 1];
            }
            // 왼쪽
            for (int i = c - 1; i > 0; i--) {
                room[row][i] = room[row][i - 1];
            }
            room[row][col + 1] = 0;


            // 3. 아래쪽 공기청정기, 시계 순환 -> 반시계로 덮어씌우기
            row++;
            // 아래
            for (int i = row + 1; i < r - 1; i++) {
                room[i][col] = room[i + 1][col];
            }
            // 오른쪽
            for (int i = 0; i < c - 1; i++) {
                room[r - 1][i] = room[r - 1][i + 1];
            }
            // 위
            for (int i = r - 1; i > row - 1; i--) {
                room[i][c - 1] = room[i - 1][c - 1];
            }
            // 왼쪽
            for (int i = c - 1; i > 1; i--) {
                room[row][i] = room[row][i - 1];
            }
            room[row][col + 1] = 0;


//            Arrays.stream(room)
//                    .map(Arrays::toString)
//                    .forEach(System.out::println);


            // 먼지 구하기
            findDust();
        }


        // 4. 미세먼지 양 구하기
        int answer = Arrays.stream(room)
                .flatMapToInt(Arrays::stream)
                .filter(n -> n > 0)
                .sum();

        System.out.println(answer);

    }

    static void findDust() {
        dustList.clear();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (room[i][j] > 0) {
                    dustList.add(new Pos(i, j, room[i][j]));
                }
            }
        }
    }

    static void spread() {
        for (Pos dust : dustList) {
            int amount = dust.amount / 5;
            if (amount == 0) continue;
            for (int j = 0; j < 4; j++) {
                int xi = dust.r + dx[j];
                int yi = dust.c + dy[j];

                if (xi < 0 || xi >= r || yi < 0 || yi >= c || room[xi][yi] == -1) continue;

                // 아래 코드 때문에 초기의 먼지를 객체에 저장해놔야한다.
                room[dust.r][dust.c] -= amount;
                room[xi][yi] += amount;
            }
        }
    }

    static class Pos {
        int r;
        int c;
        int amount;

        public Pos(int r, int c, int amount) {
            this.r = r;
            this.c = c;
            this.amount = amount;
        }
    }
}
