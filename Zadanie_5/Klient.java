public class Klient {
    final private String nazwisko;
    public Koszyk koszyk;

    public Klient(String nazwisko, Koszyk koszyk){
        this.nazwisko = nazwisko;
        this.koszyk = koszyk;
    }

    String getNazwisko() { return nazwisko; }
    Koszyk getKoszyk() { return koszyk; }

    public String toString() {
        return '\n' + "Klient: " + nazwisko + koszyk;
    }
}