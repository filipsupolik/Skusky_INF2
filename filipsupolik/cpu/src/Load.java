public class Load implements Instrukcia {
    private char register;
    private int hodnota;

    public Load(char register, int hodnota) {
        this.register = register;
        this.hodnota = hodnota;
    }

    @Override
    public void vykonaj(Procesor procesor) {
        procesor.getRegistre().nastav(this.register, this.hodnota);
    }
}
