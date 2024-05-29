import java.util.Optional;

public class Letisko {
    private final int POCET_RADOV = 6;
    private Miesto[][] plocha;
    private int pocetRiadkov;


    public Letisko(int pocetRiadkov) {
        this.pocetRiadkov = pocetRiadkov;
        this.plocha = new Miesto[this.pocetRiadkov][this.POCET_RADOV];
        for (int i = 0; i < this.pocetRiadkov; i++) {
            for (int j = 0; j < POCET_RADOV; j++) {
                if (j == 1 || j == 3 || (j == 2 && i == 0)) {
                    this.plocha[i][j] = new LetiskovyObjekt("RRRRR");
                } else if (j == this.POCET_RADOV - 1) {
                    this.plocha[i][j] = new LetiskovyObjekt("HHHHH");
                } else if (j == this.POCET_RADOV - 2) {
                    this.plocha[i][j] = new ParkovacieMiesto(TypStroja.VRTULNIK);
                } else {
                    this.plocha[i][j] = new ParkovacieMiesto(TypStroja.LIETADLO);
                }
            }
        }
    }

    public boolean zaparkujStroj(LietajuciStroj lietac) {
        return this.najdiVolneMiesto(lietac.getTypStroja()).isPresent();
    }

    public void vypisLetisko() {
        System.out.println("Letisko FRI");
        for (int i = 0; i < this.pocetRiadkov; i++) {
            System.out.println();
            for (int j = 0; j < this.POCET_RADOV; j++) {
                System.out.print(this.plocha[i][j].getReprezentacia());
                System.out.print(" ");
            }
        }
        System.out.println("\nAktualne naklady na udrzbu : " + this.spocitajUdrzbu());
    }

    public Optional<ParkovacieMiesto> najdiVolneMiesto(TypStroja typStroja) {
        for (int i = 0; i < this.pocetRiadkov; i++) {
            for (int j = this.POCET_RADOV - 1; j >= 0; j--) {
                if (this.plocha[i][j] instanceof ParkovacieMiesto parkovacieMiesto) {
                    if (parkovacieMiesto.mozeZaparkovat(typStroja)) {
                        return Optional.of(parkovacieMiesto);
                    }
                }
            }
        }
        return Optional.empty();
    }

    public Optional<ParkovacieMiesto> najdiKdeParkuje(String volaciZnak) {
        for (int i = 0; i < this.pocetRiadkov; i++) {
            for (int j = 0; j < this.POCET_RADOV; j++) {
                if (this.plocha[i][j] instanceof ParkovacieMiesto parkovacieMiesto) {
                    if (parkovacieMiesto.uzTamParkuje(volaciZnak)) {
                        return Optional.of(parkovacieMiesto);
                    }
                }
            }
        }
        return Optional.empty();
    }

    public double spocitajUdrzbu() {
        int vzdialenost = 0;
        int celkovaSumaZaUdrzbu = 0;
        for (int i = 0; i < this.pocetRiadkov; i++) {
            for (int j = 0; j < this.POCET_RADOV; j++) {
                if (this.plocha[i][j] instanceof ParkovacieMiesto parkovacieMiesto) {
                    celkovaSumaZaUdrzbu += parkovacieMiesto.getNakladyNaUdrzbu(vzdialenost);
                } else if (this.plocha[i][j] instanceof LetiskovyObjekt letiskovyObjekt) {
                    int riadokMiesta = i;
                    for (int k = 0; k < this.pocetRiadkov; k++) {
                        for (int l = 0; l < this.POCET_RADOV; l++) {
                            if (this.plocha[k][l].getReprezentacia() == "HHHHH") {
                                int riadokHaly = l;
                                vzdialenost = Math.abs(riadokMiesta - riadokHaly);
                            }
                        }
                    }
                    celkovaSumaZaUdrzbu += letiskovyObjekt.getNakladyNaUdrzbu(vzdialenost);
                }
            }
        }
        return celkovaSumaZaUdrzbu;
    }
}
