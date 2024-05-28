import java.io.FileNotFoundException;

public class CarodejiMain {
    public static void main(String[] args) {
        Hra hra = null;
        try {
            hra = new Hra(4, 6, "subor-mapa.txt");
            hra.hraj("subor-carovanie.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
