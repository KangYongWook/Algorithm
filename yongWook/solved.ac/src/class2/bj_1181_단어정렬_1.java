package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
/**
 * 
 * ���� : �ܾ�����  �ܾ ª���ź��� ����
 * �ۼ��� : �����
 * ���� : 
 */
public class bj_1181_�ܾ�����_1 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		String strArr[] = new String[N];
		
		for (int i = 0; i < strArr.length; i++) {
			strArr[i] = br.readLine(); 
		}
		
		Arrays.sort(strArr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length()-o2.length();
			}
		});
		
		for (int i = 0; i < strArr.length; i++) {
			sb.append(strArr[i]+"\n");
		}
		System.out.println(sb);
		
		
		
	}
}
