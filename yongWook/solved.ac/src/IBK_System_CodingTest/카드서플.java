package IBK_System_CodingTest;

import java.util.ArrayList;

public class ī�弭�� {
	
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
				
				//ī�弭��
				for (int j = 0; j < cards.length; j++) {
					if(j  < cards.length / 2 ) {
						resultCard.add(cards[j + cards.length / 2]  );
					}
					else {
						resultCard.add(cards[j - cards.length / 2] );
					}
				}
				
				//��ī�忡 �ٽ� ����
				for (int j = 0; j < cards.length; j++) {
					cards[j] = resultCard.get(j);
				}
			}
			else {
				
				//ī�弭��
				for (int j = cards.length-1; j >= cards.length/2; j--) {
					resultCard.add(cards[j - cards.length/2 ]   ); //��ī�� �ǹ�
					resultCard.add(cards[j] ); //��ī�� �ǹ�
				}
				//������ ���� �־����.
				
				
				//��ī�忡 �ٽ� ����
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
