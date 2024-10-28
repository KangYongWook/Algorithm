import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeMap<Integer,Integer> set = new TreeMap<>();
        set.put(-100,100);
        System.out.println(set.get(-100));
    }
}