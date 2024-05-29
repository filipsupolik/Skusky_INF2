public class LetiskovyObjekt implements Miesto {
    private String reprezentacia;

    public LetiskovyObjekt(String reprezentacia) {
        this.reprezentacia = reprezentacia;
    }

    @Override
    public String getReprezentacia() {
        return this.reprezentacia;
    }

    @Override
    public double getNakladyNaUdrzbu(int vzdialenost) {
        int pevnaCast = 50;
        int premenlivaCast = vzdialenost * 10;
        return pevnaCast + premenlivaCast;
    }
}
