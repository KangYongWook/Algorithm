package backTracking;

import java.util.Arrays;
import java.util.Scanner;

public class Boj9663_NQUEEN {

    static int[] chess;
    static int n;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        // queen 하나를 놓으면 수직, 수평, 대각선에 놓을 수 없음...
        chess = new int[n];
        dfs(0);
        System.out.println(answer);

    }

    static void dfs(int depth) {
        if (depth == n) {
            answer++;
            return;
        }
        for (int i = 0; i < n; i++) {
           chess[depth] = i;
           if (possible(depth)){
               dfs(depth+1);
           }
        }
    }

    static boolean possible(int row) {
        for (int i = 0; i < row; i++) {
            // 행에 일치하는게 있는지
            if(chess[i] == chess[row]){
                return false;
            }
            // 대각선에 일치하는게 있는지
            else if (Math.abs(row-i)==Math.abs(chess[row]-chess[i])) {
                return false;
            }
        }
        return true;
    }

    static void mydfs(int depth) {
        if (depth == n) {
            answer++;
            return;
        }
        for (int i = 0; i < n; i++) {
            chess[depth] = i;
            if (possible(depth)){
                dfs(depth+1);
            }
        }
    }

//    static void change(int r, int c, boolean state) {
//        // 행 불가
//        for (int i = c + 1; i < n; i++) {
//            if (check[r][i] != state) {
//                check[r][i] = state;
//            }
//        }
//
//        // 열 불가
//        for (int i = r + 1; i < n; i++) {
//            if (check[i][c] != state) {
//                check[i][c] = state;
//            }
//        }
//
//        // 오른쪽 아래 대각선 불가
//        int diagonalCol = c;
//        for (int i = r + 1; i < n; i++) {
//            diagonalCol++;
//            if (diagonalCol == n) {
//                break;
//            }
//            if (check[i][diagonalCol] != state) {
//                check[i][diagonalCol] = state;
//            }
//        }
//
//        // 왼쪽 아래 대각선 불가
//        diagonalCol = c;
//        for (int i = r + 1; i < n; i++) {
//            diagonalCol--;
//            if (diagonalCol < 0) {
//                break;
//            }
//            if (check[i][diagonalCol] != state) {
//                check[i][diagonalCol] = state;
//            }
//        }
//    }
}
