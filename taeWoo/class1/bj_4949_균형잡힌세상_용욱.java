package class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj_4949_������������_��� {
	public static void main(String[] args) throws Exception{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<String> stack ; 
		String str = "";
		
		
		while(true) {
			str = br.readLine();
			stack = new Stack<String>();
			//��������
			//�߰�ȣ, ���ȣ�� �ִµ� �������� ���°� ������ 
			if(str.length() == 1 && str.equals(".")) {
				break;
			}
			
			String inputWord = "";
			//�Է�
			for (int i = 0; i < str.length(); i++) {
				inputWord = String.valueOf(str.charAt(i));
				if(inputWord.equals(")") || inputWord.equals("]") || inputWord.equals("(") || inputWord.equals("[")) {
					stack.push(inputWord);
				}
			}
			
			//���� 
			if(  stack.size() == 0) {
				System.out.println("yes");
				continue;
			}
			
			//����2
			String currentWord = "";
			//String firstWord = "";
			//String lastWord = "";
			//int condition1 = 0; // )
			//int condition2 = 0; // ]
			
			while(stack.size() > 0){
				currentWord = stack.pop();
				if() {
					
				}
				
				if(currentWord.equals("]")) {
					if(stack.peek().equals("[")) {
						stack.pop();
					}
					if(stack.peek().equals(")")) {
						continue;
					}
					else {
						System.out.println("no");
						break;
					}
				}
				else if(currentWord.equals(")")) {
					if(stack.peek().equals("(")) {
						stack.pop();
					}
					if(stack.peek().equals("]")) {
						continue;
					}
					else {
						System.out.println("no");
						break;
					}
				}
			}
		}
		
		
	}
}
