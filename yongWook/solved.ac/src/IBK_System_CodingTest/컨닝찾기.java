package IBK_System_CodingTest;

public class ����ã�� {
	
	public static void main(String[] args) {
		
		
		String answerSheet[] = {"12343211"};
		String submitSheet[] = {"23452354", "23452354", "12345345", "12345345", "12345345"};
		
		int cnt1 = 0; //���װ���
		int cnt2 = 0; //���ӵ� ���� ���� ����
		int cnt3 = 0; //���ӵ� ���׼� ����
		
		int result = 0;
		//������ ��Ž
		for (int i = 0; i < submitSheet.length; i++) {
			for (int j = i+1; j < submitSheet.length; j++) {
				
				cnt1 = 0;
				cnt2 = 0; 
				cnt3 = 0;
				//�������� ���̷� ����
				for (int k = 0; k < answerSheet[0].length(); k++) {
					
					//������ ��
					if(submitSheet[i].charAt(k) == submitSheet[j].charAt(k)  ) {
						
						//������ ��
						if(submitSheet[i].charAt(k) != answerSheet[0].charAt(k) ) {
							cnt1++;
							cnt2++;
						}
						else{
							cnt3 = Math.max(cnt3, cnt2); //���ӵ� ���װ� ���� 
							cnt2 = 0; //���Ӱ� �ʱ�ȭ
						}
					}
				}
				result = Math.max(result, cnt1 + cnt3);
			}
		}
		
		
		System.out.println(result);
		
		
		
		
		
	}
}
