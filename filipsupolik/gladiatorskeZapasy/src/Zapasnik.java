public abstract class Zapasnik {
    private int zivot;
    private String meno;

    public Zapasnik(int zivot, String meno) {
        this.zivot = zivot;
        this.meno = meno;
    }

    public boolean jeZivy() {
        boolean zivy = true;
        if (this.zivot <= 0) {
            zivy = false;
        }
        return zivy;
    }

    protected abstract int urciSiluUtoku();
    protected abstract int urciSiluObrany(int silaUtoku);

    public String getInfo() {
        return String.format("%s[%d]", this.meno, this.zivot);
    }

    public void zautoci(Zapasnik cielUtoku) {
        cielUtoku.urciSiluObrany(this.urciSiluUtoku());
    }

    protected void prijmiUtok(int silaUtoku) {
        int silaObrany = this.urciSiluObrany(silaUtoku);
        int rozdielUtoku = silaUtoku - silaObrany;
        if (rozdielUtoku > 0) {
            this.zivot -= rozdielUtoku;
        }
    }

    public int getZivot() {
        return zivot;
    }
}
