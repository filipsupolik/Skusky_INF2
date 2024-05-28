import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

public class Mapa implements Iterable<Carodej> {
    private String[][] mapa;
    private int riadky;
    private int stlpce;
    private ArrayList<Carodej> carodeji;

    public Mapa(int riadky, int stlpce) {
        this.riadky = riadky;
        this.stlpce = stlpce;
        this.mapa = new String[this.riadky][this.stlpce];
        this.carodeji = new ArrayList();
    }

    public void pridajCarodeja(Carodej carodej) {
        if (this.jeNaMape(carodej.getRiadok(), carodej.getStlpec())) {
            this.carodeji.add(carodej);
        } else {
            System.out.println("Nie je mozne pridat carodeja.");
        }
    }

    public boolean jeNaMape(int riadok, int stlpec) {
        boolean existuje = true;
        if (!(riadok <= this.riadky && stlpec <= this.stlpce)) {
            existuje = false;
        }
        return existuje;
    }

    public Optional<Carodej> ktoJeTam(int riadok, int stlpec) {
        Optional<Carodej> carodej = Optional.empty();
        for (Carodej kuzelnik : this.carodeji) {
            if (kuzelnik.getRiadok() == riadok && kuzelnik.getStlpec() == stlpec) {
                carodej = Optional.of(kuzelnik);
            }
        }

        return carodej;
    }

    public void vypisMapu() {
        for (int i = 0; i < 18; i++) {
            System.out.print("*");
        }
        System.out.println();
        for (int i = 0; i < this.riadky; i++) {
            for (int j = 0; j < this.stlpce; j++) {
                if (this.ktoJeTam(i, j).isPresent()) {
                    var carodej = this.ktoJeTam(i, j).get();
                    this.mapa[i][j] = carodej.getZnak();
                    System.out.print(this.mapa[i][j] + " ");
                } else {
                    this.mapa[i][j] = "..";
                    System.out.print(this.mapa[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    @Override
    public Iterator<Carodej> iterator() {
        return this.carodeji.iterator();
    }
}
