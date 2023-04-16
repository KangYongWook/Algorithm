package class2;
import java.util.*;
public class bj_2774_아름다운수 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t =sc.nextInt();
		HashSet<Integer> result = new HashSet<Integer>();
		
		for(int i = 0; i < t ; i++) {
			
			String x = sc.next();
			result.clear();
			for (int j = 0; j < x.length(); j++) {
				result.add((int)x.charAt(j));
			}
			System.out.println(result.size());
		}
		
	}
}
