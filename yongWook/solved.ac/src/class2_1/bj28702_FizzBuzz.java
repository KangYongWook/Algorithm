package class2_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj28702_FizzBuzz {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int resultNumber = 0;
		String a = br.readLine();
		String b = br.readLine();
		String c = br.readLine();
		if(_isNumber(a)) resultNumber = Integer.parseInt(a) + 3;
		if(_isNumber(b)) resultNumber = Integer.parseInt(b) + 2;
		if(_isNumber(c)) resultNumber = Integer.parseInt(c) + 1;
		
		
		_isFizzBuzz(resultNumber);
		
	}
	

	public static boolean _isNumber(String str) {
		
		try {
			Integer.parseInt(str);
			
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public static void _isFizzBuzz(int number) {
		
		if(number%3 == 0 && number%5 == 0 ) {
			System.out.println("FizzBuzz");
		}
		else if(number%3 == 0 && number%5 != 0 ) {
			System.out.println("Fizz");
		}
		else if(number%3 != 0 && number%5 == 0 ) {
			System.out.println("Buzz");
		}
		else {
			System.out.println(number);
		}
	}
}
