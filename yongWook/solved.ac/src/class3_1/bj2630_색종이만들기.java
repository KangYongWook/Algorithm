package class3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2630_색종이만들기 {
	
	static int whiteResult = 0 ;
	static int blackResult = 0 ;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		int map[][] = new int[t][t];
		StringTokenizer st;
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < t; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		_validation(map);
		
		System.out.println(whiteResult);
		System.out.println(blackResult);
		
	}
	
	private static void _validation(int[][] arr) {
		if(arr.length == 1) {
			if(arr[0][0] == 1) {
				blackResult++;
			}else {
				whiteResult++;
			}
			return;
		}
		
		int startColor = arr[0][0];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(arr[i][j] != startColor) {
					_validation(_createArr(arr, 0,0));
					_validation(_createArr(arr, arr.length/2,0));
					_validation(_createArr(arr, 0,arr.length/2));
					_validation(_createArr(arr, arr.length/2,arr.length/2));
					return;
				}
			}
		}
		
		if(startColor == 0) {
			whiteResult++;
		}else {
			blackResult++;
		}
		
	}
	
	private static int[][] _createArr(int arr[][], int startY, int startX){
		
		int[][] newArr = new int[arr.length/2][arr.length/2];
		
		for (int i = 0; i < newArr.length; i++) {
			for (int j = 0; j < newArr.length; j++) {
				newArr[i][j] = arr[startY+i][startX+j];
			}
		}
		return newArr;
	}
}
