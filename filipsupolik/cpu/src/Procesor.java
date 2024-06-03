public class Procesor {
    private Registre registre;
    private Program program;

    public Procesor(Program program) {
        this.program = program;
        this.registre = new Registre();
        this.aktualnaInstrukcia = this.program.
    }

    public void spusti() {

    }

    public Registre getRegistre() {
        return this.registre;
    }

    public void skoc(String navestie) {

    }
}
