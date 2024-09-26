package IBK_System_CodingTest;

import java.util.ArrayList;

public class 카드서플 {
	
	public static void main(String[] args) throws Exception{
		
		
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int cards[] = {1,2,3,4,5,6,7,8};
		String suffle[] = {"cut","suffle", "cut"};
		//String suffle[] = {"suffle"};
		
		ArrayList<Integer> resultCard = new ArrayList<Integer>();
		//String resultCards[] ;
		
		for (int i = 0; i < suffle.length; i++) {
			resultCard.clear();
			if("cut".equals(suffle[i])) {
				
				//카드서플
				for (int j = 0; j < cards.length; j++) {
					if(j  < cards.length / 2 ) {
						resultCard.add(cards[j + cards.length / 2]  );
					}
					else {
						resultCard.add(cards[j - cards.length / 2] );
					}
				}
				
				//원카드에 다시 기입
				for (int j = 0; j < cards.length; j++) {
					cards[j] = resultCard.get(j);
				}
			}
			else {
				
				//카드서플
				for (int j = cards.length-1; j >= cards.length/2; j--) {
					resultCard.add(cards[j - cards.length/2 ]   ); //앞카드 맨밑
					resultCard.add(cards[j] ); //뒷카드 맨밑
				}
				//뒤집는 로직 넣어야함.
				
				
				//원카드에 다시 기입
				for (int j = 0; j < cards.length; j++) {
					cards[j] = resultCard.get(j);
				}
			}
		}
		
		
		for (int i = 0; i < resultCard.size(); i++) {
			System.out.print(resultCard.get(i) + " ");
		}
		
		
		
		
		
		
		
	}

}
