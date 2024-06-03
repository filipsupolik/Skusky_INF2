public class Move implements Instrukcia {
    private char zdroj;
    private char ciel;

    public Move(char zdroj, char ciel) {
        this.zdroj = zdroj;
        this.ciel = ciel;
    }

    @Override
    public void vykonaj(Procesor procesor) {
        int hodnotaVZdroji = procesor.getRegistre().citaj(this.zdroj);
        procesor.getRegistre().nastav(this.ciel, hodnotaVZdroji);
    }
}
