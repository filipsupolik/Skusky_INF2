import java.util.ArrayList;

public class JednosmernyCarodej extends Carodej {
    private String smer;

    public JednosmernyCarodej(int riadok, int stlpec) {
        super(riadok, stlpec, '*', 1);
        this.smer = "vertikalne";
    }

    @Override
    protected ArrayList<Carodej> dajZasiahnutych(Mapa mapa) {
        ArrayList<Carodej> zasiahnutyCarodeji = new ArrayList<>();
        switch (this.smer) {
            case "vertikalne":
                for (int i = 0; i < this.getRiadok(); i++) {
                    if (mapa.ktoJeTam(i, this.getStlpec()).isPresent() && i != this.getRiadok()) {
                        zasiahnutyCarodeji.add(mapa.ktoJeTam(i, this.getStlpec()).get());
                    }
                }
                this.smer = "horizontalne";
                break;
            case "horizontalne":
                for (int i = 0; i < this.getStlpec(); i++) {
                    if (mapa.ktoJeTam(this.getRiadok(), i).isPresent() && i != this.getStlpec()) {
                        zasiahnutyCarodeji.add(mapa.ktoJeTam(this.getRiadok(), i).get());
                    }
                }
                this.smer = "vertikalne";
                break;
        }
        return zasiahnutyCarodeji;
    }
}
