package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2805_나무자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] tree = new int[n];
        long left = 0;
        long right = 0;
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, tree[i]);
        }

        long answer=  0;
        while(left<=right){
            long mid = (left+right)/2;
            long sum = 0;
            for (int t : tree) {
                sum += t<mid? 0 : t-mid;
            }

            if (sum<m) {
                right = mid-1;
            } else {
                answer = Math.max(mid,answer);
                left = mid+1;
            }
        }

        System.out.println(answer);

    }
}
