package class2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class bj_2108_≈Î∞Ë«– {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int arr[] = new int[N];
		int amniotic[] = new int[4001];
		int negative[] = new int[4001];
		ArrayList<Integer> indexArr = new ArrayList<Integer>();
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();

			if (arr[i] < 0) {
				negative[Math.abs(arr[i])] += 1;
			} else {
				amniotic[arr[i]]++;
			}
			sum += arr[i];
		}

		Arrays.sort(arr);
		
		System.out.println(Math.round((float)sum / N));

		if (N == 1) {
			System.out.println(arr[0]);
		} else {
			System.out.println(arr[N / 2]);
		}
		int result = 0;
		int max1 = 0;
		int max2 = 0;
		for (int i = 0; i < negative.length; i++) {
			if ( max1 < amniotic[i] ) {
				max1 = amniotic[i];
			}
			if ( max2 < negative[i] ) {
				max2 = negative[i];
			}
		}
		if(max1> max2) {
			result = max1;
		}else {
			result = max2;
		}

		
		for (int i = 0; i < negative.length; i++) {
			if (amniotic[i] == result) {
				indexArr.add(i);
			}
			if (negative[i] == result) {
				indexArr.add(-i);
			}
		}

		Collections.sort(indexArr);
		
		if(indexArr.size() > 1)
			System.out.println(indexArr.get(1));
		else
			System.out.println(indexArr.get(0));
		System.out.println(arr[N - 1] - arr[0]);
	}

}
