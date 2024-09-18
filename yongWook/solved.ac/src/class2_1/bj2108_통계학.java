package class2_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj2108_통계학 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		int plusMaxCntArr[] = new int[4001];
		int minusMaxCntArr[] = new int[4001];
		
		int arr[] = new int[t];
		int total = 0;
		
		for (int i = 0; i < t; i++) {
			total += arr[i] = Integer.parseInt(br.readLine());
			if(arr[i] >= 0) {
				plusMaxCntArr[arr[i]]++;
			}else {
				minusMaxCntArr[Math.abs(arr[i])	]++;
			}
			
		}
		
		Arrays.sort(arr);
		
		int maxCnt = 0;
		int maxIdx = 0;
		int cnt = 0;
		for (int i = 0; i < plusMaxCntArr.length; i++) {
			if(maxCnt < plusMaxCntArr[i]) {
				maxCnt = plusMaxCntArr[i];
			}
			
			if(maxCnt < minusMaxCntArr[i]) {
				maxCnt = minusMaxCntArr[i];
			}
		}
		
		//2번째 작은값 찾기
		for (int i = minusMaxCntArr.length -1 ; i >= 0 ; i--) {
			if(minusMaxCntArr[i] == maxCnt) {
				maxIdx = -i;
				cnt++;
				if(cnt == 2) {
					break;
				}
			}
		}
		for (int i = 0; i < plusMaxCntArr.length; i++) {
			if(cnt == 2) {
				break;
			}
			
			if(plusMaxCntArr[i] == maxCnt) {
				maxIdx = i;
				cnt++;
			}
		}
		
		
		System.out.println( Math.round((float)total / t));
		System.out.println( arr[t/2]);
		System.out.println(maxIdx);
		System.out.println(arr[t-1] -arr[0]);
		
		
	}
}

