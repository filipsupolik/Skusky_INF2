import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;
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
        this.mapa.vypisMapu();

        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                int riadokCarodeja = sc.nextInt();
                if (sc.hasNextInt()) {
                    int stlpecCarodeja = sc.nextInt();

                    Optional<Carodej> optionalCarodej = this.mapa.ktoJeTam(riadokCarodeja, stlpecCarodeja);
                    if (optionalCarodej.isPresent()) {
                        try {
                            Carodej carodej = optionalCarodej.get();
                            carodej.caruj(this.mapa);

                            // Vykreslenie mapy po úspešnom carovaní
                            this.mapa.vypisMapu();
                        } catch (MrtvyCarodejException e) {
                            System.out.println("Carodej na pozicii (" + riadokCarodeja + ", " + stlpecCarodeja + ") uz nema zivot, tak nemoze carovat.");
                        }
                    } else {
                        System.out.println("Na suradniciach (" + riadokCarodeja + ", " + stlpecCarodeja + ") sa carodej nenasiel.");
                    }
                } else {
                    System.out.println("Ocakavany stlpec po riadku, ale ziskana neplatna hodnota.");
                    sc.next(); // Preskočíme neplatný token
                }
            } else {
                System.out.println("Ocakavany riadok, ale ziskana neplatna hodnota.");
                sc.next(); // Preskočíme neplatný token
            }
        }

        sc.close();
    }
}
