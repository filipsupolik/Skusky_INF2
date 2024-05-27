public class Kuzelnik extends Zapasnik {
    private int ENERGIA = 20;

    public Kuzelnik(int zivot, String meno) {
        super(zivot, meno);
    }

    @Override
    protected int urciSiluUtoku() {
        int silaUtoku = 0;
        if (this.ENERGIA > 0) {
            silaUtoku = 8;
            this.ENERGIA -= silaUtoku;
        } else if (this.ENERGIA <= 0) {
            silaUtoku = 1;
        }
        return silaUtoku;
    }

    @Override
    protected int urciSiluObrany(int silaUtoku) {
        int silaObrany = 0;
        if (this.ENERGIA > 0) {
            silaObrany = silaUtoku;
            this.ENERGIA -= silaUtoku;
        } else if (this.ENERGIA <= 0) {
            silaObrany = 0;
        }
        return silaObrany;
    }

    public String getInfo() {
        return String.format("%s energia[%d]", super.getInfo(), this.ENERGIA);
    }
}
