public class Rytier extends Zapasnik {
    private final int UTOK = 5;
    private int brnenie;

    public Rytier(int zivot, int brnenie, String meno) {
        super(zivot, meno);
        this.brnenie = brnenie;
    }

    @Override
    protected int urciSiluUtoku() {
        return this.UTOK;
    }

    @Override
    protected int urciSiluObrany(int silaUtoku) {
        return this.brnenie - silaUtoku;
    }
}
