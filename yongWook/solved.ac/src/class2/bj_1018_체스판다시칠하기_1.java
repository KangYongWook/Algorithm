package class2;

import java.util.Scanner;

public class bj_1018_ü���Ǵٽ�ĥ�ϱ�_1 {

	/** 1�ð� �ɸ� **/
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		String inputRow = "";
		String allBoard[][] = new String[N][M];
		String startBlackBoard[][] = new String[8][8];
		String startWhiteBoard[][] = new String[8][8];
		int result = Integer.MAX_VALUE;
		
		
		for (int i = 0; i < N; i++) {
			inputRow = sc.next();
			for (int j = 0; j < M; j++) {
				allBoard[i][j] = inputRow.substring(j,j+1);
			}
		}
		
		makeCompareBoard(startBlackBoard, "B", "W"); // �� ��ŸƮ ����
		makeCompareBoard(startWhiteBoard, "W", "B"); // ȭ��Ʈ ��Ÿ ����
		
		int min1 = 0;
		int min2 = 0;
		for (int i = 0; i < N - 7; i++) {
			for (int j = 0; j < M - 7; j++) {
				min1 = compareBoard( allBoard, startBlackBoard, i, j);
				min2 = compareBoard( allBoard, startWhiteBoard, i, j);
				result = Math.min(min1,min2);
			}
		}

		System.out.println(result);

	}

	/** ���Ͽ� �ּҰ����� ���ϴ� �޼ҵ�**/
	public static int compareBoard(String[][] allboard, String[][] compareBoard,int startCol, int startRow) {
		
		int cnt  = 0 ;
		for (int i = startCol; i < startCol+8; i++) {
			for (int j = startRow; j < startRow+8; j++) {
					if(!allboard[i][j].equals( compareBoard[i-startCol][j-startRow] )) {
						cnt++;
					}
			}
		}
		return cnt;
	}
	public static void makeCompareBoard(String board[][], String start, String end) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i % 2 == 0) { // ¦���϶�
					if (j % 2 == 0)
						board[i][j] = start;
					else {
						board[i][j] = end;
					}
				} else {
					if (j % 2 == 0)
						board[i][j] = end;
					else {
						board[i][j] = start;
					}
				}

			}
		}

	}
}
