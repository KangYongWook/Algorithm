public class Main {
    public static void main(String[] args) {
/*
        for (int i = 0; i < 6; i++) {
            double ran = Math.random()*27;
            int a = (int)ran;
            System.out.println(ran);
            System.out.println(a);
        }
*/

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int c = 'a'+(int)(Math.random()*26);
            sb.append((char)c);
        }

        System.out.println(sb);
        System.out.println((int)'a');
        System.out.println((int)'z');
        System.out.println((int)'{');
    }
}