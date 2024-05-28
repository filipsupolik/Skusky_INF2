import java.util.ArrayList;

public class PokrocilyCarodej extends Carodej {
    public PokrocilyCarodej(int riadok, int stlpec) {
        super(riadok, stlpec, 'X', 3);
    }

    @Override
    protected ArrayList<Carodej> dajZasiahnutych(Mapa mapa) {
//        int deltaX = this.getRiadok()
        ArrayList<Carodej> zasiahnutyCarodeji = new ArrayList<>();
        if (mapa.ktoJeTam(this.getRiadok() + 1, this.getStlpec()).isPresent()) {
            zasiahnutyCarodeji.add(mapa.ktoJeTam(this.getRiadok() + 1, this.getStlpec()).get());
        } else if (mapa.ktoJeTam(this.getRiadok() - 1, this.getStlpec()).isPresent()) {
            zasiahnutyCarodeji.add(mapa.ktoJeTam(this.getRiadok() - 1, this.getStlpec()).get());
        } else if (mapa.ktoJeTam(this.getRiadok(), this.getStlpec() + 1).isPresent()) {
            zasiahnutyCarodeji.add(mapa.ktoJeTam(this.getRiadok(), this.getStlpec() + 1).get());
        } else if (mapa.ktoJeTam(this.getRiadok(), this.getStlpec() - 1).isPresent()) {
            zasiahnutyCarodeji.add(mapa.ktoJeTam(this.getRiadok(), this.getStlpec() - 1).get());
        }
        return zasiahnutyCarodeji;
    }
}
