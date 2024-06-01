public class JumpIfZero implements Instrukcia {
    private String navestie;

    public JumpIfZero(String navestie) {
        this.navestie = navestie;
    }

    @Override
    public void vykonaj(Procesor procesor) {
        int hodnotaVNavesti = procesor.getRegistre().citaj('A');
        if (hodnotaVNavesti == 0) {
            procesor.skoc(this.navestie);
        }
    }
}
