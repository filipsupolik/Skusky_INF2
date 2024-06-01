public class JumpIfNegative implements Instrukcia {
    private String navestie;

    public JumpIfNegative(String navestie) {
        this.navestie = navestie;
    }

    @Override
    public void vykonaj(Procesor procesor) {
        int hodnotaVRegistri = procesor.getRegistre().citaj('A');
        if (hodnotaVRegistri >= 0) {
            procesor.skoc(this.navestie);
        }
    }
}
