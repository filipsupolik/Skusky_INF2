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
        while (this.zapasnici.iterator().hasNext()) {
            System.out.println(this.zapasnici.iterator().next().getInfo());
        }
    }
}
