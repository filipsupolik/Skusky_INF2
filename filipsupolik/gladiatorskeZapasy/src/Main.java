public class Main {
    public static void main(String[] args) {
        var arena = new Arena();
        arena.vhodZapasnika(new Rytier(15, 5, "Sparstrakus"));
        arena.vhodZapasnika(new Elf(8, 2, "Duracikolas"));
        arena.vhodZapasnika(new Kuzelnik(10, "Janechius"));
        arena.spustiZapas();
    }
}