public class ParkovacieMiesto implements Miesto {
    private LietajuciStroj stroj;
    private TypStroja typStroja;

    public ParkovacieMiesto(TypStroja typStroja) {
        this.typStroja = typStroja;
        this.stroj = null;
    }

    @Override
    public String getReprezentacia() {
        if (this.stroj == null) {
            return ".....";
        }
        return this.stroj.getVolaciZnak();
    }

    @Override
    public double getNakladyNaUdrzbu(int vzdialenost) {
        double celkoveNakladyZaUdrzbuMiesta = 0;
        if (this.stroj == null) {
            celkoveNakladyZaUdrzbuMiesta = 100;
        } else if (this.stroj.getTypStroja().equals(TypStroja.LIETADLO)) {
            celkoveNakladyZaUdrzbuMiesta = 500;
        } else {
            celkoveNakladyZaUdrzbuMiesta = 200;
        }
        return celkoveNakladyZaUdrzbuMiesta;
    }

    public void uvolniMIesto() {
        this.stroj = null;
    }

    public boolean mozeZaparkovat(TypStroja typStroja) {
        return this.stroj != null && this.typStroja.equals(typStroja);
    }

    public void zaparkuj(LietajuciStroj lietac) {
        this.stroj = lietac;
    }

    public boolean uzTamParkuje(String volaciZnak) {
        return this.stroj != null && this.stroj.getVolaciZnak().equals(volaciZnak);
    }
}
