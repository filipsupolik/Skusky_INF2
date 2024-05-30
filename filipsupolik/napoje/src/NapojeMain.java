import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author vaclavko
 */
public class NapojeMain {

    public static void main (String[] args) {

//         vytvorenie nealkoholickeho napoja
        Nealko kofola = new Nealko(100, "kofola", 0.5, "3 dcl", "klasik");

//        vytvorenie piva - 2 druhy
        Pivo pivo1 = new Pivo(200, "Gambrinus", 1, "0.5 litra", 12);
        Pivo pivo2 = new Pivo(300, "Zlaty bazant", 0.8, "0.5 litra", 10);

//        vytvorenie napojoveho listka
        NapojovyListok nl = new NapojovyListok();

//        pridanie troch napojov
        nl.addNapoj(kofola);
        nl.addNapoj(pivo1);
        nl.addNapoj(pivo2);

//        vypis napojoveho listka
        System.out.println(nl);

//        zapis listka do suboru
// * tu osetrite vynimku

        try {
            nl.vytvorNapojovyListok("napojovyListok.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Doslo k chybe, nepodarilo sa zapisat do suboru.");
        }


        //vytvorenie objednavky
        Objednavka obj = new Objednavka();

        //vytvorenie polozky objednavky
        PolozkaObjednavky pol1 = new PolozkaObjednavky(kofola,3);

        //pridanie polozky objednavky do objednavky
        obj.addPolozkaObjednavky(pol1);

        //pridanie do objednavky prvej polozky ,
        //ktora bude pridana zo suboru
// ** tu osetrite vynimku
        try {
            obj.addPolozkaObjednavky("polozka1.bin", nl);
        } catch (IOException e) {
            System.out.println("Doslo k chybe pri vytvoreni napoja zo suboru polozka1.dat(System nemoze najst zadany subor");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IllegalArgumentException e) {
            System.out.println("Doslo k chybe Napoj nenajdeny");
        }


        //pridanie do objednavky druhej polozky ,
        //ktora bude pridana zo suboru
// *** tu osetrite vynimku
        try {
            obj.addPolozkaObjednavky("polozka2.bin", nl);
        } catch (IOException e) {
            System.out.println("Doslo k chybe pri vytvoreni napoja zo suboru polozka1.dat(System nemoze najst zadany subor");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IllegalArgumentException e) {
            System.out.println("Doslo k chybe Napoj nenajdeny");
        }



        //vypis objednavky
        System.out.println(obj);

        //zapis objednavky do suboru
// **** tu osetrite vynimku
        try {
            obj.zapisObjednavku("objednavka.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Doslo k chybe, nepodarilo sa zapisat do suboru");
        }

    }


}
