import java.util.Arrays;
import java.util.Scanner;

public class Boj2448_별찍기 {
    static int n;
    static char[][] star;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int col = (n/3)*5+((n/3)-1);
//        System.out.println(col);
        star = new char[n][col];
        for (int i = 0; i < n; i++) {
            Arrays.fill(star[i],' ');
        }

        int drawRow = 0;
        int drawCol = col/2;
//        drawArray(drawRow, drawCol/2);
        recursive(0, col/2,n);
        print();

    }

    static void drawArray(int drawRow, int drawCol) {
        for (int i = 0; i < n/3; i++) {
            draw(drawRow,drawCol); // 11/2 = 5
            int next = 6;
            if (i%4==1){
//                System.out.println(i);
                draw(drawRow,drawCol+(next*1));
            } else if (i%4==2){
                draw(drawRow,drawCol+(next*2));
            } else if (i%4==3) {
                draw(drawRow,drawCol+(next*1));
                draw(drawRow,drawCol+(next*2));
                draw(drawRow,drawCol+(next*3));
            }

            drawRow +=3;
            drawCol -=3;
        }
        print();
    }

    static void recursive(int row, int col, int n) {
        // n = 3 -> * 시작점 1개
        // n = 6 -> (n=3기준으로) * 시작점 3개
        // n = 12 -> (n=6기준으로) * 시작점 3개
        // n = 24 -> (n=12기준으로) * 시작점 3개
        if (n==3){
            draw(row, col);
        } else {
            recursive(row, col, n/2);
            recursive(row+n/2, col - n/2, n/2);
            recursive(row+n/2, col + n/2, n/2);
        }
    }

    static void draw(int row, int col) {
        star[row][col] = '*'; // 2,8
        star[row+1][col-1] = '*';
        star[row+1][col+1] = '*';
        for (int i = col-2; i <= col+2; i++) {
            star[row+2][i] = '*';
        }
    }

    static void print(){
        StringBuilder drawStar = new StringBuilder();
        for (int i = 0; i < star.length; i++) {
            for (int j = 0; j < star[0].length; j++) {
                drawStar.append(star[i][j]);
            }
            drawStar.append("\n");
        }
        System.out.print(drawStar);
    }

    static void test() {
        StringBuilder sb = new StringBuilder();
        int blankStart = 0;
        int minusBlank = 6;

        for (int i = 0; i < n/3; i++) {
            // 1층
            for (int k = 0; k < i+1; k++) {
                for (int j = blankStart; j < n - 1; j++) {
                    sb.append(" "); // 2->5
                }
                sb.append("*");
                for (int j = blankStart; j < n; j++) {
                    sb.append(" "); // 2->5
                }
            }
            sb.append("\n");

            // 2층
            for (int k = 0; k < i+1; k++) {
                for (int j = blankStart; j < n - 2; j++) {
                    sb.append(" ");
                }
                sb.append("* *");
                for (int j = blankStart; j < n-1; j++) {
                    sb.append(" ");
                }
            }
            sb.append("\n");

            // 3층
            for (int k = 0; k < i+1; k++) {
                for (int j = blankStart; j < n - 3; j++) {
                    sb.append(" ");
                }
                sb.append("*****");
                for (int j = blankStart; j < n-2; j++) {
                    sb.append(" ");
                }
            }
            sb.append("\n");

            blankStart += 3;
        }


        System.out.println(sb);
    }
}
