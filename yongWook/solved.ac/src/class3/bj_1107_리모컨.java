package class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1107_������ {
	static char validation[] ;
	
	
	static int temp1 =0;
	static int temp2 =0;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String N = br.readLine();//�̵�ä��
		int M = Integer.parseInt(br.readLine());//���峭 ��ư
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		char moveChanel[] = N.toCharArray(); 
		validation = new char[M];//���峭��ư�迭
		int result = 0; //���
		
		for (int i = 0; i < validation.length; i++) {
			validation[i] = st.nextToken().charAt(0);
		}
		
		int check = 0;
		for (int i = 0; i < moveChanel.length; i++) {
			for (int j = 0; j < validation.length; j++) {
				if(validation[j] == moveChanel[i]) {
					check = 1;
				}
			}
			
			if(check == 1) {
				int leftCount = left( (int)moveChanel[i] );
				int rightCount = right( (int)moveChanel[i] );
				if(leftCount < rightCount) {
					result+= leftCount; 
					System.out.println("����Ʈ ++" + leftCount);
				}else {
					result+= rightCount;
					System.out.println("����Ʈ ++" + rightCount);
				}
				
				temp1 = 0;
				temp2 = 0;
						
			}else {
				result++;
				System.out.println("�׳� ++");
			}
			check = 0;
		}
		
		System.out.println(result);
		
	}
	
	private static int left(int N) {
		
		
		for (int j = 0; j < validation.length; j++) {
			if(validation[j] == N && N-1>0) {
				temp1++;
				left(N-1);
			}
		}
		return temp1;
	}
	private static int right(int N) {
		
		for (int j = 0; j < validation.length; j++) {
			if(validation[j] == N ) {
				temp2++;
				right(N+1);
			}
		}
		return temp2;
	}
}
