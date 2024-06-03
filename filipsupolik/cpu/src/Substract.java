public class Substract implements Instrukcia {
    private char ciel;
    private char operand;

    public Substract(char ciel, char operand) {
        this.ciel = ciel;
        this.operand = operand;
    }

    @Override
    public void vykonaj(Procesor procesor) {
        int hodnotaCiel = procesor.getRegistre().citaj(this.ciel);
        int hodnotaOperand = procesor.getRegistre().citaj(this.operand);
        procesor.getRegistre().nastav(this.ciel, hodnotaCiel - hodnotaOperand);
    }
}
