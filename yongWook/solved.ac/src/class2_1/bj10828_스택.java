package class2_1;

import java.util.Scanner;
import java.util.Stack;

public class bj10828_Ω∫≈√ {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		Stack<Integer> stack = new Stack<Integer>();
		
		String input ;
		for (int i = 0; i < t; i++) {
			
			input = sc.next();
			if( input.equals("push")) {
				stack.add(sc.nextInt());
			}
			else if("top".equals(input)){
				if(stack.isEmpty()) {
					System.out.println("-1");
				}else {
					System.out.println(stack.peek());
				}
			}
			else if("size".equals(input)){
				System.out.println(stack.size());
			}
			else if("empty".equals(input)){
				if(stack.isEmpty()) {
					System.out.println("1");
				}else {
					System.out.println("0");
				}
				
			}
			else if("pop".equals(input)){
				if(stack.isEmpty()) {
					System.out.println("-1");
				}else {
					System.out.println(stack.pop());
				}
				
			}
		}
	}
}
