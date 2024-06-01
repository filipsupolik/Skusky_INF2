public class Jump implements Instrukcia {
    private String navestie;

    public Jump(String navestie) {
        this.navestie = navestie;
    }

    @Override
    public void vykonaj(Procesor procesor) {
        procesor.skoc(this.navestie);
    }
}
