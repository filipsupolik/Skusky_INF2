import java.io.FileNotFoundException;

public class CarodejiMain {
    public static void main(String[] args) {
        Hra hra = null;
        try {
            hra = new Hra(4, 6, "C:\\Users\\FILIP\\Documents\\Informatika\\inf2\\Skusky_INF2\\filipsupolik\\carodeji\\src\\assets\\subor-mapa.txt");
            hra.hraj("C:\\Users\\FILIP\\Documents\\Informatika\\inf2\\Skusky_INF2\\filipsupolik\\carodeji\\src\\assets\\subor-carovanie.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
