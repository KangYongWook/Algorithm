package class2_1;

import java.util.ArrayList;
import java.util.Scanner;

public class bj30802_À£ÄÄÅ°Æ® {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		ArrayList<Integer> sizeArr = new ArrayList<Integer>();
		for (int i = 0; i < 6; i++) {
			sizeArr.add(sc.nextInt());
		}
		int bundleT = sc.nextInt();
		int bundleP = sc.nextInt();
		
		int resultT = 0;
		int resultBundleP = 0;
		int resultP = 0;
		
		for (int i = 0; i < sizeArr.size(); i++) {
			resultT += sizeArr.get(i) / bundleT ;
			if( sizeArr.get(i) % bundleT > 0) {
				resultT++;
			}
		}
		resultBundleP = t / bundleP ; 
		resultP = t % bundleP ;
		
		System.out.println(resultT);
		System.out.println(resultBundleP+" "+resultP);
		
		
		
	}
}
