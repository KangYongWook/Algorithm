package class2;

import java.util.Scanner;

public class bj_20413_mvp다이아몬드 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		int arr[] = new int[4];
		int temp = 0;
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		String grade = sc.next();
		
		char[] gradeArr = grade.toCharArray();
		
		for (int i = 0; i < gradeArr.length; i++) {
			
			if(gradeArr[i] == 'B' ) {
				result += arr[0]-1 - temp;  
				temp = arr[0]-1 - temp;
			}else if(gradeArr[i] == 'S' ) {
				result += arr[1]-1 - temp;
				temp = arr[1]-1 - temp;
				
			}
			else if(gradeArr[i] == 'G' ) {
				result += arr[2]-1 - temp;
				temp = arr[2]-1 - temp;
				
			}
			else if(gradeArr[i] == 'P' ) {
				result += arr[3]-1 - temp;
				temp = arr[3]-1 - temp;
			}
			else if(gradeArr[i] == 'D' ) {
				result += arr[3];
			}
		}
		
		System.out.println(result);
		
		
		
		
		
		
	}
}
