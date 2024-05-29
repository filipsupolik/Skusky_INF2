import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LetiskoMain {
    public static void main(String[] args) {
        var letisko = new Letisko(5);

        // Vytvorenie letiska a výpis pociatocneho stavu
        System.out.println("Letisko FRI:");
        letisko.vypisLetisko();

        // Spracovanie udajov zo suboru
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\FILIP\\Documents\\Informatika\\inf2\\Skusky_INF2\\filipsupolik\\letisko\\assets\\subor-letisko.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Spracovanie riadku zo suboru
                String[] parts = line.split(" ");
                String volaciZnak = parts[1];
                String typStrojaString = parts[0];
                TypStroja typStroja = TypStroja.valueOf(typStrojaString);

                // Vytvorenie lietajuceho stroja
                LietajuciStroj stroj = new LietajuciStroj(volaciZnak, typStroja);

                // Overenie, či je možné pristáť alebo odletieť
                if (typStroja == TypStroja.LIETADLO) {
                    // Ak žiada o pristátie
                    if (letisko.zaparkujStroj(stroj)) {
                        System.out.println("Stroj " + volaciZnak + " uspesne pristal.");
                    } else {
                        System.out.println("Stroj " + volaciZnak + " nemá voľné parkovacie miesto a nepristane.");
                    }
                } else {
                    // Ak žiada o odlet
                    // Tu môžeš pridať ďalšiu funkcionalitu v prípade potreby
                    System.out.println("Stroj " + volaciZnak + " uspesne odletel.");
                }

                // Výpis aktuálneho stavu letiska po spracovaní každého stroja
                System.out.println("Aktuálny stav letiska:");
                letisko.vypisLetisko();
            }
        } catch (IOException e) {
            System.err.println("Chyba pri čítaní zo súboru: " + e.getMessage());
        }

    }
}
