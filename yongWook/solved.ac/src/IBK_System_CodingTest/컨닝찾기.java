package IBK_System_CodingTest;

public class 컨닝찾기 {
	
	public static void main(String[] args) {
		
		
		String answerSheet[] = {"12343211"};
		String submitSheet[] = {"23452354", "23452354", "12345345", "12345345", "12345345"};
		
		int cnt1 = 0; //컨닝개수
		int cnt2 = 0; //연속된 컨닝 상태 개수
		int cnt3 = 0; //연속된 컨닝수 적립
		
		int result = 0;
		//제출지 완탐
		for (int i = 0; i < submitSheet.length; i++) {
			for (int j = i+1; j < submitSheet.length; j++) {
				
				cnt1 = 0;
				cnt2 = 0; 
				cnt3 = 0;
				//정답지의 길이로 돌림
				for (int k = 0; k < answerSheet[0].length(); k++) {
					
					//제출자 비교
					if(submitSheet[i].charAt(k) == submitSheet[j].charAt(k)  ) {
						
						//정답지 비교
						if(submitSheet[i].charAt(k) != answerSheet[0].charAt(k) ) {
							cnt1++;
							cnt2++;
						}
						else{
							cnt3 = Math.max(cnt3, cnt2); //연속된 컨닝값 적립 
							cnt2 = 0; //연속값 초기화
						}
					}
				}
				result = Math.max(result, cnt1 + cnt3);
			}
		}
		
		
		System.out.println(result);
		
		
		
		
		
	}
}
