import java.io.Serializable;

public class PolozkaObjednavky implements Serializable {
    private Napoj objednavanyNapoj;
    private int pocet;

    public PolozkaObjednavky(Napoj objednavanyNapoj, int pocet) {
        this.objednavanyNapoj = objednavanyNapoj;
        this.pocet = pocet;
    }

    public double dajCenu() {
        return this.objednavanyNapoj.getCena() * this.pocet;
    }

    @Override
    public String toString() {
        return String.format("%s, mnozstvo = %d", this.objednavanyNapoj, this.pocet);
    }
}
