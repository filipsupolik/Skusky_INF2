public class LietajuciStroj {
    private String volaciZnak;
    private TypStroja typStroja;

    public LietajuciStroj(String volaciZnak, TypStroja typStroja) {
        this.volaciZnak = volaciZnak;
        this.typStroja = typStroja;
    }

    public String getVolaciZnak() {
        return this.volaciZnak;
    }

    public TypStroja getTypStroja() {
        return this.typStroja;
    }
}
