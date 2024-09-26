package codingtest.ibk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class task1 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> shuffles = new ArrayList<>(); // 최대 10개
        List<Integer> cards = new ArrayList<>(); // 최대 100개. 짝수만


        /*
            shuffles
                cut,shuffle,shuffle,cut,shuffle

            cards
                1,2,3,4,5,6

1.
cut,shuffle,shuffle,cut,shuffle
1,2,3,4,5,6

2.
cut,cut,cut
1,2,3,4,5,6,7,8

3.
cut,shuffle,cut
1,2,3,4,5,6,7,8

5,6,7,8,1,2,3,4

1,5,2,6,3,7,4,8

3,7,4,8,1,5,2,6

         */

        try {

            StringTokenizer st = new StringTokenizer(br.readLine(), ",");
            while(st.hasMoreTokens()) {
                shuffles.add(st.nextToken());
            }

            st = new StringTokenizer(br.readLine(), ",");
            while(st.hasMoreTokens()) {
                cards.add(Integer.parseInt(st.nextToken()));
            }

            for(String shuffle : shuffles) {
                if(shuffle.equals("cut")) { // cut
                    List<Integer> cards1 = cards.subList(0, cards.size() / 2);
                    List<Integer> cards2 = cards.subList(cards.size() / 2, cards.size());

                    cards2.addAll(cards1);
                    cards = cards2;
                }
                else { // shuffle
                    List<Integer> cards1 = cards.subList(0, cards.size() / 2);
                    List<Integer> cards2 = cards.subList(cards.size() / 2, cards.size());

                    cards = new ArrayList<>();

                    for(int i=0; i<cards1.size(); i++) {
                        cards.add(cards2.get(i));
                        cards.add(cards1.get(i));
                    }
                }
            }

            System.out.println(cards);

        } catch (IOException e) {}
    }
}
