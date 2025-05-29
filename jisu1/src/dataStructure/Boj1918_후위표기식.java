package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj1918_후위표기식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringBuilder answer = new StringBuilder();
        Stack<Character> operation = new Stack<>();

        for (char ch : line.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                answer.append(ch);
            } else if (ch == '+' || ch == '-') {
                // 46% 틀림
                while (!operation.isEmpty() && (operation.peek() == '*' || operation.peek() == '/')) {
                    answer.append(operation.pop());
                }

                // 반레 : A+B+C 정답 : AB+C+ 결과: ABC++
                if (!operation.isEmpty() && (operation.peek() == '+' || operation.peek() == '-')) {
                    answer.append(operation.pop());
                }
                operation.push(ch);

            } else if (ch == '*' || ch == '/') {
                if (!operation.isEmpty() && (operation.peek() == '*' || operation.peek() == '/')) {
                    answer.append(operation.pop());
                }
                operation.push(ch);

            } else if (ch == ')') {
                while (!operation.isEmpty()) {
                    if (operation.peek() == '(') {
                        operation.pop();
                        // 3% 틀림 반례 : K/((A+B)*C)
                        break;
                    } else {
                        answer.append(operation.pop());
                    }
                }
            } else {
                operation.push(ch);
            }
        }

        while (!operation.isEmpty()) {
            answer.append(operation.pop());
        }

        System.out.println(answer);
    }
}
/*
반례
A+B*C/(D*E-F)+G
답: ABC*DE*F-/+G+
 */