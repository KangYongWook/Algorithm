package week0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<String> suffleArr = new ArrayList<>();
        while (st.hasMoreTokens()) {
            suffleArr.add(st.nextToken());
        }

        Queue<Integer> cardQueue = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            cardQueue.add(Integer.parseInt(st.nextToken()));
        }

        int cardSize = cardQueue.size();

        for (String command : suffleArr) {
            if ("cut".equals(command)){
                for (int i = 0; i < cardSize/2; i++) {
                    cardQueue.add(cardQueue.poll());
                }

            } else if ("suffle".equals(command)) {
                Stack<Integer> frontStack = new Stack<>();
                for (int i = 0; i < cardSize/2; i++) {
                    frontStack.add(cardQueue.poll());
                }
                Stack<Integer> backStack = new Stack<>();
                while (!cardQueue.isEmpty()) {
                    backStack.add(cardQueue.poll());
                }

                Stack<Integer> tmpStack = new Stack<>();
                for (int i = 0; i < cardSize/2; i++) {
                    tmpStack.add(frontStack.pop());
                    tmpStack.add(backStack.pop());
                }

                while(!tmpStack.isEmpty()){
                    cardQueue.add(tmpStack.pop());
                }
            }
        }

        StringBuffer answer = new StringBuffer();
        while (!cardQueue.isEmpty()){
            answer.append(cardQueue.poll()).append(" ");
        }

        System.out.println(answer);

    }
}
