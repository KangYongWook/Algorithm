package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj_9012_°ýÈ£ {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			char[] strChr = str.toCharArray();
			Stack<Character> stack = new Stack<Character>();

			int result = 0;
			for (int j = 0; j < strChr.length; j++) {

				if (strChr[j] == '(') {
					stack.push(strChr[j]);
				} else {
					if (stack.isEmpty()) {
						result = 1;
						System.out.println("NO");
						break;
					}
					stack.pop();
				}
			}
			if (result != 1) {
				if (stack.isEmpty())
					System.out.println("YES");
				else
					System.out.println("NO");
			}

		}

	}
}
