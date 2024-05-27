import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Optional;

public class Zapasnici implements Iterable<Zapasnik>{
    private ArrayList<Zapasnik> zapasnici;

    public Zapasnici() {
        this.zapasnici = new ArrayList<>();
    }

    public Optional<Zapasnik> dajCiel(Zapasnik utocnik) {
        Zapasnik najlepsiObranca = null;
        int najvyssiPocetZivotov = 0;

        for (Zapasnik obranca : this.zapasnici) {
            if (obranca != utocnik && obranca.jeZivy() && obranca.getZivot() > najvyssiPocetZivotov) {
                najlepsiObranca = obranca;
                najvyssiPocetZivotov = obranca.getZivot();
            }
        }

        return Optional.ofNullable(najlepsiObranca);
    }

    public void pridajZapasnika(Zapasnik zapasnik) {
        this.zapasnici.add(zapasnik);
    }

    public void odpracMrtvych() {
        ListIterator<Zapasnik> iterator = this.zapasnici.listIterator();
        while (iterator.hasNext()) {
            if (!iterator.next().jeZivy()) {
                iterator.remove();
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
