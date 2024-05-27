public class Odkaz extends Vzorec {
    private String adresa;

    public Odkaz(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public int vypocitaj(Harok harok) {
        return 0;
    }

    @Override
    public String formatuj() {
        return null;
    }
}
