import java.util.Scanner;

public class Boj1629_곱셈 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();


        long oper = divide(a,b,c);

        System.out.println(oper);
    }

    static long divide(int a, int b, int c) {
        // 2로 나누다가 중간에 2로 나눠도 홀수로 나올 수 있는 부분을 체크를 안함
        // 예시) 36 -> 18 -> "9"
        long oper = a % c;

        // 1% 에서 실패
        if (b==1) {
            return oper;

        } else {
            oper = divide(a,b/2,c);
            // () 로 우선순위 필요
            oper = (oper * oper) % c;
            if (b % 2 == 1) {
                // 홀수인 경우
                return (oper * a) % c;
            }
            return oper;
        }
    }
}

/*
입력
1234567 1234567 12344321

출력
5011891

정답
5205370
 */