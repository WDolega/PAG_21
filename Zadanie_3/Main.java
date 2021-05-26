/*
    authors: Wojciech Dołęga, Adam Ziętek
 */

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;

public class Main {

    //Przechowujemy dane o wartosciach nazw, cen, nazwisk oraz koszykow w osobnych tablicach,
    //aby skrocic zapis tworzenia obiektow klas Produkt i Klient.
    //Ponizej z tych wartosci tworzone sa obiekty.
    static public String[] nazwyProduktow(){
        return new String[]{
            "Telewizor", "Lodowka", "Okap", "Lampa", "Pralka",
            "Suszarka", "Piekarnik", "Zmywarka", "Mikrofalowka", "Radio",
            "Odkurzacz", "Kosiarka", "Prostownica", "Laptop",
            "Filtry do odkurzacza", "Kostki do zmywarki", "Płyta CD"
        };
    }

    static public double[] cenyProduktow(){
        return new double[]{
            3000.99, 2400.99, 999.98, 178.99, 1997.98,
            79.99, 2200.99, 1950.49, 399.99, 110.99,
            395.99, 970.99, 300.99, 4499.99,
            3.49, 15.99, 45.99
        };
    }

    static public String[] nazwiskaKlientow(){
        return new String[]{
            "Kowalski", "Janiak", "Sobczak",
            "Lange", "Zarecki", "Olasik",
            "Mazurek", "Zawierucha", "Disney",
            "Tesla", "Gates", "Nowak"
        };
    }

    static public Koszyk[] koszyki(int ileKlientow){
        Koszyk[] koszyki = new Koszyk[ileKlientow];
        for (int i = 0; i < ileKlientow; ++i) {
            Koszyk koszyk = new Koszyk();
            koszyki[i] = koszyk;
        }
        return koszyki;
    }

    //Funkcja bedzie uzyta, aby skrocic zapis dodawania produktow do koszyka.
    static public int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public static void main(String[] args) {
        //Tworzenie list obiektow z wartosci wypisanych w tablicach powyzej.
        List<Produkt> listaProduktow = new ArrayList<>(nazwyProduktow().length);
        for (int i = 0; i < nazwyProduktow().length; ++i) {
            listaProduktow.add(new Produkt(nazwyProduktow()[i], cenyProduktow()[i]));
        }
        List<Klient> listaKlientow = new ArrayList<>(nazwiskaKlientow().length);
        for (int i = 0; i < nazwiskaKlientow().length; ++i){
            listaKlientow.add(new Klient(nazwiskaKlientow()[i], koszyki(nazwiskaKlientow().length)[i]));
        }

        ProduktWKoszyku[] pwks = new ProduktWKoszyku[listaProduktow.size()];
        for (int i = 0; i < listaProduktow.size(); ++i) {
            int n = getRandomNumberUsingNextInt(0,10);
            ProduktWKoszyku pwk = new ProduktWKoszyku(listaProduktow.get(i).getNazwa(), listaProduktow.get(i).getCena(), n);
            pwks[i] = pwk;
        }

        for (Klient klient : listaKlientow) {
            klient.getKoszyk().dodajProdukt(pwks[getRandomNumberUsingNextInt(0, pwks.length - 1)]);
            klient.getKoszyk().dodajProdukt(pwks[getRandomNumberUsingNextInt(0, pwks.length - 1)]);
            klient.getKoszyk().dodajProdukt(pwks[getRandomNumberUsingNextInt(0, pwks.length - 1)]);
        }

        //prezentacja dzialania funkcji wyjmijProdukt
        ProduktWKoszyku Segway = new ProduktWKoszyku("Segway", 15000.99, 1);
        listaKlientow.get(0).getKoszyk().dodajProdukt(Segway);
        listaKlientow.get(0).getKoszyk().wyjmijProdukt("Segway");

        Queue<Klient> q = new LinkedList<>(listaKlientow);

        System.out.print(q);
    }
}
