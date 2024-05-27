import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

public class Zapasnici implements Iterable<Zapasnik>{
    private ArrayList<Zapasnik> zapasnici;

    public Zapasnici() {
        this.zapasnici = new ArrayList<>();
    }

    public Optional<Zapasnik> dajCiel(Zapasnik utocnik) {
        Optional<Zapasnik> obranca = null;
        int pocetZivotovUtocnika = utocnik.getZivot();
        int pocetZivotovObrancu = 0;
        while (this.iterator().hasNext()) {
            pocetZivotovObrancu = this.iterator().next().getZivot();
            if (pocetZivotovUtocnika < pocetZivotovObrancu) {
                obranca = Optional.of(this.iterator().next());
            }
        }
        return obranca;
    }

    public void pridajZapasnika(Zapasnik zapasnik) {
        this.zapasnici.add(zapasnik);
    }

    public void odpracMrtvych() {
        while (this.iterator().hasNext()) {
            if (!this.iterator().next().jeZivy()) {
                this.iterator().remove();
            }
        }
    }

    public int pocetZapasnikov() {
        return this.zapasnici.size();
    }


    @Override
    public Iterator<Zapasnik> iterator() {
        return this.zapasnici.iterator();
    }
}
