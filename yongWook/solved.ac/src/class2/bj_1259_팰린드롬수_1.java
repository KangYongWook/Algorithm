package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 
 * ���� : �յڰ� �Ȱ��� ��ȣ
 * �ۼ��� : �����
 * ���� : 
 */
public class bj_1259_�Ӹ���Ҽ�_1 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		while (true) {
			input = br.readLine();
			if (input.equals("0"))
				return;
			String compareArr[] = new String[input.length()];
			String compareArr1[] = new String[input.length()];
			boolean result = true;

			for (int i = 0; i < compareArr1.length; i++) {
				compareArr[i] = input.substring(i, i + 1);
				compareArr1[i] = input.substring(compareArr1.length - i - 1, compareArr1.length - i);
			}
			for (int i = 0; i < compareArr1.length; i++) {
				if (compareArr[i].equals(compareArr1[i]))
					continue;
				else {
					result = false;
					break;
				}
			}
			System.out.println(result== true ? "yes"  : "no" );
		}

	}
}
