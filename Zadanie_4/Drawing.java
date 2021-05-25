import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Drawing {
    public static void main(String[] args) {
        System.out.println("Wprowadź maksymalną liczbę ograniczającą zakres losowania: ");
        Scanner scan = new Scanner(System.in);
        int max = scan.nextInt();
        System.out.println("Wprowadź liczbę po wylosowaniu, której zatrzyma się losowanie: ");
        int s = scan.nextInt();
        while (s >= max) {
            System.out.println("Wprowadzona liczba nie należy do zakresu, wprowadź poprawną liczbę: ");
            s = scan.nextInt();
        }
        System.out.println("Wprowadź liczbę wypisawanych, wylosowanych liczb");
        int n = scan.nextInt();
        List<Integer> list_1 = new ArrayList<>();
        Set<Integer> list_2 = new TreeSet<>();
        List<Integer> list_3 = new ArrayList<>();
        List<Integer> list_4 = new ArrayList<>();
        Random random = new Random();
        Integer number;

        do {
            number = random.nextInt(max);
            list_1.add(number);
            list_2.add(number);
        }
        while (!number.equals(s));

        if (n > list_1.size()) {
            System.out.println("Zbiór wylosowanych liczb jest mniejszy niż " + n);
            n = list_1.size();
        }

        for (int i = 0; i < n; i++) {
            list_3.add(list_1.get(i));
        }

        for (int i = n; i > 0; i--) {
            list_4.add(list_1.get(list_1.size() - i));
        }

        String text_1 = " pierwszych wylosowanych liczb: ";
        String text_2 = " ostatnich wylosowanych liczb: ";
        if (n == 1) {
            text_1 = " wylosowana liczba: ";
            text_2 = " ostatnia wylosowana liczba: ";
        }
        else if (n == 2 || n == 3 || n == 4) {
            text_1 = " pierwsze wylosowane liczby: ";
            text_2 = " ostatnie wylosowane liczby: ";
        }

        System.out.println(n + text_1 + list_3);
        System.out.println(n + text_2 + list_4);
        System.out.println("Wylosowane liczby posortowane rosnąco, bez duplikatów: " + list_2);
    }
}