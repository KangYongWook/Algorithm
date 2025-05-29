package divideNconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Boj11444_피보나치수열6 {

    static long mod = 1000000007;
    static Map<Long, Long> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long answer = fibo(n);

        System.out.println(answer);

    }

    public static long fibo(long n) {
        if (map.get(n) != null) {
            return map.get(n);
        }

        if (n == 1) return 1L;
        else if (n == 2) return 1L;

        long result;
        if (n % 2 == 0) { // 짝수일경우
            result = (fibo(n / 2) * (fibo(n / 2 + 1) + fibo(n / 2 - 1))) % mod;
        } else { // 홀수일경우
            long k1 = fibo(n / 2 + 1);
            long k = fibo(n / 2);
            result = (((k1 * k1) % mod) + ((k * k) % mod)) % mod;
        }

        map.put(n, result);
        return result;

    }
}

