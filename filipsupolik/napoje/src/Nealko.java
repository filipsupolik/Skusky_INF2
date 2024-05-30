public class Nealko extends Napoj {
    private String prichut;

    public Nealko(int id, String nazov, double cena, String jednotka, String prichut) {
        super(id, nazov, cena, jednotka);
        this.prichut = prichut;
    }

    @Override
    public String toString() {
        return String.format("%s Nealko s prichutou %s", this, this.prichut);
    }
}
