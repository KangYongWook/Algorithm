package class3_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class bj5430_AC {
	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//R는 순서뒤집
		//D는 첫번째수 버림 배열 비였는데 하면 오류
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			String condition = br.readLine();
			int nbrCnt = Integer.parseInt(br.readLine());
			String inputStr[] = br.readLine().replaceAll("[^0-9,]", "").split(",");
			Deque<String> dq = new LinkedList<String>();
			for (int j = 0; j < nbrCnt; j++) {
				dq.add(inputStr[j]);
			}
			boolean error = false;
			boolean reverseStatus = false; //리버스 상태면 true 
			for (int j = 0; j < condition.length(); j++) {
				if(condition.charAt(j) == 'R') {
					reverseStatus = reverseStatus ? false : true;
				}else if(condition.charAt(j) == 'D'){
					try {
						if(reverseStatus) {
							dq.removeLast();
						}
						else {
							dq.removeFirst();
						}
					} catch (Exception e) {
						error = true;
						break;
					}
				}
			}
			
			if(error) {
				System.out.println("error");
			}else {
				StringBuilder sb = new StringBuilder();
				sb.append("[");
				int size = dq.size();
				for (int j = 0; j < size; j++) {
					if(reverseStatus) {
						sb.append(dq.removeLast()).append(",");
					}else {
						sb.append(dq.removeFirst()).append(",");	
					}
				}
				if(sb.length() >= 2) {
					sb.delete( sb.length()-1, sb.length());
				}
				sb.append("]");
				System.out.println(sb.toString());
			}
			
			
			
		}
		
	}
	
}
