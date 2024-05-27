public class Plus extends Vzorec {
    private Vzorec operand1;
    private Vzorec operand2;

    public Plus(Vzorec operand1, Vzorec operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    @Override
    public int vypocitaj(Harok harok) {
        return 0;
    }

    @Override
    public String formatuj() {
        return null;
    }
}
