public enum TypStroja {
    LIETADLO(500),
    VRTULNIK(200);

    private int cenaUdrzby;

    TypStroja(int cenaUdrzby) {
        this.cenaUdrzby = cenaUdrzby;
    }

    public double getUdrzba() {
        return this.cenaUdrzby;
    }
}
