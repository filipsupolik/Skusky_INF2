import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Hra {
    private Mapa mapa;
    private int riadky;
    private int stlpce;
    private String nazovSuboru;

    public Hra(int riadky, int stlpce, String nazovSuboru) throws FileNotFoundException {
        this.riadky = riadky;
        this.stlpce = stlpce;
        this.nazovSuboru = nazovSuboru;
        this.mapa = new Mapa(riadky, stlpce);
        File file = new File(this.nazovSuboru);
        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            int riadokCarodeja = sc.nextInt();
            int stlpecCarodeja = sc.nextInt();
            String znakCarodeja = sc.next();
            char convertZnakCarodejaToChar = znakCarodeja.charAt(0);
            if (convertZnakCarodejaToChar == 'X') {
                mapa.pridajCarodeja(new PokrocilyCarodej(riadokCarodeja, stlpecCarodeja));
            } else if (convertZnakCarodejaToChar == '*') {
                mapa.pridajCarodeja(new JednosmernyCarodej(riadokCarodeja, stlpecCarodeja));
            }
        }
        mapa.vypisMapu();
    }

    public void hraj(String nazovSuboru) throws FileNotFoundException {
        File file = new File(nazovSuboru);
        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            int riadokCarodeja = sc.nextInt();
            int stlpecCarodeja = sc.nextInt();
            try {
                this.mapa.ktoJeTam(riadokCarodeja, stlpecCarodeja).get().caruj(this.mapa);
            } catch (MrtvyCarodejException e) {
                System.out.println();
            }
        }
    }
}
