public class Produkt {
    private final String nazwa;
    private final double cena;

    public Produkt(String nazwa, double cena) {
        this.nazwa = nazwa;
        this.cena = cena;
    }

    String getNazwa() { return nazwa; }
    double getCena() { return cena; }

    public String toString() {
        return "Nazwa: " + nazwa + ", cena: " + cena;
    }
}