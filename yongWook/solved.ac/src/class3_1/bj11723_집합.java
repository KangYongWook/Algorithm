package class3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11723_С§Че {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st ;
		
		int checkMap[] = new int[21];
		int orderNumbr = 0 ;
		String order;
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			order = st.nextToken();
			if( !(order.equals("all") || order.equals("empty"))) {
				orderNumbr = Integer.parseInt(st.nextToken());
			}
			
			if("add".equals(order)) {
				checkMap[orderNumbr]++;
			}
			else if("remove".equals(order)) {
				
				if(checkMap[orderNumbr] != 0) {
					checkMap[orderNumbr]--;
				}
			}
			else if("check".equals(order)) {
				
				if(checkMap[orderNumbr] > 0 ) {
					sb.append("1\n");
				}else {
					sb.append("0\n");
				}
			}
			else if("toggle".equals(order)) {
				
				if(checkMap[orderNumbr] > 0 ) {
					checkMap[orderNumbr]--;
				}else {
					checkMap[orderNumbr]++;
				}			
			}
			else if("all".equals(order)) {
				
				for (int j = 1; j < 21; j++) {
					checkMap[j] = 1;
				}
			}
			else if("empty".equals(order)) {
				checkMap = new int[21];
			}
		}
		
		System.out.println(sb);
	}
}
