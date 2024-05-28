import java.util.ArrayList;

public abstract class Carodej {
    private int riadok;
    private int stlpec;
    private char znak;
    private int zivoty;

    public Carodej(int riadok, int stlpec, char znak, int zivoty) {
        this.riadok = riadok;
        this.stlpec = stlpec;
        this.znak = znak;
        this.zivoty = zivoty;
    }

    public int getRiadok() {
        return this.riadok;
    }

    public int getStlpec() {
        return this.stlpec;
    }

    public String getZnak() {
        return this.znak + "" + this.zivoty;
    }

    protected abstract ArrayList<Carodej> dajZasiahnutych(Mapa mapa);

    public void caruj(Mapa mapa) throws MrtvyCarodejException {
        if (this.zivoty == 0) {
            throw new MrtvyCarodejException();
        } else {
            ArrayList<Carodej> carodejiNaZasiahnutie = this.dajZasiahnutych(mapa);
            for (Carodej c: carodejiNaZasiahnutie) {
                c.uberZivot();
            }
        }
    }

    public void uberZivot() {
        if (this.zivoty > 0) {
            this.zivoty--;
        }
    }

}
