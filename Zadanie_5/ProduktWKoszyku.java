public class ProduktWKoszyku extends Produkt{
    private final int liczbaSztukProduktu;

    public ProduktWKoszyku(String nazwa, double cena, int liczbaSztukProduktu){
        super(nazwa, cena);
        this.liczbaSztukProduktu = liczbaSztukProduktu;
    }

    int getLiczbaSztukProduktu() { return liczbaSztukProduktu; }
}