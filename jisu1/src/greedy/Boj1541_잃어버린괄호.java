package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1541_잃어버린괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] sArr = s.split("-");
        int answer = 0;
        for (int i=0;i<sArr.length;i++) {
            int sum = 0;
            if (sArr[i].contains("+")){
                String[] plusArr = sArr[i].split("\\+");
                for (String p : plusArr) {
                    sum+=Integer.parseInt(p);
                }
            } else {
                sum = Integer.parseInt(sArr[i]);
            }

            if (i==0) {
                answer += sum;
            } else {
                answer -= sum;
            }
        }
        System.out.println(answer);
    }
}
