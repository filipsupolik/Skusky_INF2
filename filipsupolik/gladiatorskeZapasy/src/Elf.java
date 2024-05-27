public class Elf extends Zapasnik {
    public final int UTOK = 4;
    private int pocetUtokov;
    private int sikovnost;

    public Elf(int zivot, int sikovnost, String meno) {
        super(zivot, meno);
        this.sikovnost = sikovnost;
        this.pocetUtokov = 0;
    }

    @Override
    protected int urciSiluUtoku() {
        return this.UTOK;
    }

    @Override
    protected int urciSiluObrany(int silaUtoku) {
        int silaObrany = silaUtoku;
        this.pocetUtokov++;
        if (pocetUtokov == this.sikovnost) {
            silaObrany = 0;
            this.pocetUtokov = 0;
        }
        return silaObrany;
    }
}
