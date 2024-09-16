package class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj_4949_균형잡힌세상_용욱 {
	public static void main(String[] args) throws Exception{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<String> stack ; 
		String str = "";
		
		
		while(true) {
			str = br.readLine();
			stack = new Stack<String>();
			//종료조건
			//중괄호, 대괄호가 있는데 마지막에 들어온게 없으면 
			if(str.length() == 1 && str.equals(".")) {
				break;
			}
			
			String inputWord = "";
			//입력
			for (int i = 0; i < str.length(); i++) {
				inputWord = String.valueOf(str.charAt(i));
				if(inputWord.equals(")") || inputWord.equals("]") || inputWord.equals("(") || inputWord.equals("[")) {
					stack.push(inputWord);
				}
			}
			
			//조건 
			if(  stack.size() == 0) {
				System.out.println("yes");
				continue;
			}
			
			//조건2
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
