package class3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj5525_IOIOI_50�� {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder sb = new StringBuilder();
		//sb.append("IOI");
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
//		//OI����
//		for (int i = 1; i < N; i++) {
//			sb.append("OI");
//		}
		
		int result = 0;
		String input = br.readLine();
		
		//�Է¹����� �Ǵ�
		for (int i = 0; i < M; i++) {
			
			//���� Ž�� ���̺��� �񱳱��̰� ��ũ�� ����
			if( M-i < 3 + 2*(N-1)) {
				break; 
			}
			//�ٷ� ��������
			if(input.charAt(i) != 'I') {
				continue;
			}
			
			boolean isTrue = true; //��ġ���� 
			for (int j = 0; j < 3 + 2*(N-1) ; j++) {
				if( j % 2 == 0) { //¦��
					//���������� �ٷ� ����
					if(input.charAt(i+j) != 'I') {
						isTrue = false;
						i = i+j-1; //�������� ��ġ
						break;
					}
				}else { //Ȧ��
					//���������� �ٷ� ����
					if(input.charAt(i+j) != 'O') {
						isTrue = false;
						i = i+j-1; //�������� ��ġ
						break;
					}
				}
			}
			if(isTrue) {
				result++;
			}
		}
		
		System.out.println(result);
	}
}
