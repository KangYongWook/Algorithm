package codingtest.ibk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class test2 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            String answer = st.nextToken();

            st = new StringTokenizer(br.readLine());
            String[] answerSheet = st.nextToken().split(",");
            TreeSet<Integer> answerSet = new TreeSet<>();

/*
12345345

12343211
23452354,23452354,12345345,12345345,12345345
 */

            for(int i=0; i<answerSheet.length; i++) {
                String answer1 = answerSheet[i];

                for(int j=i+1; j<answerSheet.length; j++) {
                    String answer2 = answerSheet[i+1];

                    int score = 0;
                    int count = 0;

                    // ´ä¾ÈÁö1
                    for(int a=0; a<answer1.length(); a++) {
                        if(answer1.charAt(a) == answer2.charAt(a) && answer.charAt(a) != answer1.charAt(a)) {
                            score++;
                            count++;
                        }
                        else {
                            if(count > 1) score += count;
                            count = 0;
                        }
                    }

                    answerSet.add(score);
                }
            }

            System.out.println(answerSet.last().intValue());

        } catch(Exception e) {}

    }
}
