import java.util.LinkedList;
import java.lang.Math;

public class Koszyk {
    private LinkedList<Produkt> produkty = new LinkedList<>();

    public Koszyk(){}
    public Koszyk(LinkedList<Produkt> produkty){
        this.produkty = produkty;
    }

    LinkedList<Produkt> getProdukty(){
        return produkty;
    }

    void dodajProdukt(ProduktWKoszyku pwk) {
        for (int i = 0; i < pwk.getLiczbaSztukProduktu(); ++i) {
            produkty.add(new Produkt(pwk.getNazwa(), pwk.getCena()));
        }
    }

    void wyjmijProdukt(String nazwa) {
        int id = 0;
        while(id < produkty.size() && !produkty.get(id).getNazwa().equals(nazwa)) { id++; }
        if (produkty.get(id).getNazwa().equals(nazwa)) { produkty.remove(id); }
    }

    //funkcja potrzebna do zaokraglenia wartosci cen
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    //funkcja, ktora umozliwia odczytanie produktow, ich cen i ilosci oraz sumy cen tych produktow
    public String toString() {
        StringBuilder r = new StringBuilder();
        String nazwa = produkty.get(0).getNazwa();
        double sumaProdukt = produkty.get(0).getCena();
        double sumaCalosc = 0;
        int sztuk = 1;
        r.append(" - Koszyk: ");
        if (!produkty.isEmpty()){
            for (Produkt p : produkty){
                if (p.getNazwa().equals(nazwa)){
                    sumaProdukt += p.getCena();
                    sztuk++;
                }
                else {
                    sumaProdukt = round(sumaProdukt, 2);
                    sumaCalosc += sumaProdukt;
                    sumaCalosc = round(sumaCalosc, 2);
                    r.append(nazwa).append(" x ").append(sztuk).append(" cena: ").append(sumaProdukt).append("zl, ");
                    nazwa = p.getNazwa();
                    sumaProdukt = p.getCena();
                    sztuk = 1;
                }
            }
            sumaProdukt = round(sumaProdukt, 2);
            sumaCalosc += sumaProdukt;
            sumaCalosc = round(sumaCalosc, 2);
            r.append(produkty.getLast().getNazwa()).append(" x ").append(sztuk).append(" cena: ").append(sumaProdukt).append("zl").append("; Suma całości: ").append(sumaCalosc).append("zl");
        }
        else {
            r.append(" Pusty!");
        }
        return r.toString();
    }
}