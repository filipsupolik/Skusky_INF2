public class Konstanta extends Vzorec {

    private int hodnota;

    public Konstanta(int hodnota) {
        this.hodnota = hodnota;
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
