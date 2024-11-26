import java.util.Scanner;

public class Boj1074_Z {
    static int visit;
    static int r, c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = (int) Math.pow(2, sc.nextInt());
        r = sc.nextInt();
        c = sc.nextInt();

        visit = 0;
        int x = 0, y = 0;
        divide(x, y, n / 2, 0);
        divide(x, y + n / 2, n / 2, 1);
        divide(x + n / 2, y, n / 2, 2);
        divide(x + n / 2, y + n / 2, n / 2, 3);

        System.out.println(visit);

    }

    private static void divide(int x, int y, int n, int idx) {
        // 사분면 범위가 아님
        if (x > r || r >= x + n || y > c || c >= y + n) {
            return;
        }
        if (n > 1) {
            // (int)Math.pow(n,2)*idx;
            // 현재 들어온 사분면의 첫번째 시퀀스 값
            visit += (int) Math.pow(n, 2) * idx;
            divide(x, y, n / 2, 0);
            divide(x, y + n / 2, n / 2, 1);
            divide(x + n / 2, y, n / 2, 2);
            divide(x + n / 2, y + n / 2, n / 2, 3);

        } else {
            // 누적된 방문 값에서 재귀를 탄 사분면 값을 더한다
        }
    }
}
/*
0 1 4 5 16 17 20 21
2 3 6 7 18 19 22 23
8 9 12 13 24 25 28 29
10 11 14 15 26 27 30 31
32 33 36 37 48 49 52 53
34 35 38 39 50 51 54 55
40 41 44 45 56 57 60 61
42 43 46 47 58 59 62 63
 */