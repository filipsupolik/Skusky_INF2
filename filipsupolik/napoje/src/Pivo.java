public class Pivo extends Napoj {
    private int stupne;

    public Pivo(int id, String nazov, double cena, String jednotka, int stupne) {
        super(id, nazov, cena, jednotka);
        this.stupne = stupne;
    }

    @Override
    public String toString() {
        return  String.format("%s Pivo %d stupnov", this,this.stupne);
    }
}
