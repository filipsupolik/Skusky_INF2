import java.util.Iterator;
import java.util.Optional;

public class Arena {
    private int pocetKol;
    private Zapasnici zapasnici;

    public Arena() {
        this.zapasnici = new Zapasnici();
        this.pocetKol = 0;
    }

    public void vhodZapasnika(Zapasnik zapasnik) {
        this.zapasnici.pridajZapasnika(zapasnik);
    }

    public void spustiZapas() {
        while (zapasnici.pocetZapasnikov() > 1) {
            pocetKol++;
            System.out.printf("%d. kolo:%n", this.pocetKol);

            Iterator<Zapasnik> iterator = zapasnici.iterator();
            while (iterator.hasNext()) {
                Zapasnik utocnik = iterator.next();
                if (utocnik.jeZivy()) {
                    var ciel = zapasnici.dajCiel(utocnik);
                    if (ciel.isPresent() && ciel.get().jeZivy()) {
                        System.out.printf("%s utoci na %s = ", utocnik.getInfo(), ciel.get().getInfo());
                        utocnik.zautoci(ciel.get());
                        ciel.get().prijmiUtok(utocnik.urciSiluUtoku());
                        System.out.printf("%s%n", ciel.get().getInfo());
                    }
                }
            }

            zapasnici.odpracMrtvych();
            System.out.println("Počet živých zápasníkov: " + zapasnici.pocetZapasnikov());
        }

        if (zapasnici.pocetZapasnikov() == 1) {
            System.out.println("Víťaz: " + zapasnici.iterator().next().getInfo());
        } else {
            System.out.println("Nikto nezostal živý.");
        }
    }
}
