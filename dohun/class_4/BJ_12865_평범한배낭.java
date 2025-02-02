package class_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BJ_12865_평범한배낭 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            Item[] items = new Item[n];
            TreeMap<Integer, Integer> itemMap = new TreeMap<>();

            for (int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());

                int weight = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());

                items[i] = new Item(weight, value);
                itemMap.put(weight, value);
            }

            //


        } catch (Exception ignored) {}
    }



    static class Item {
        int weight;
        int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}
