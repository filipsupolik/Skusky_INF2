import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Objednavka implements Iterable<PolozkaObjednavky> {
    private ArrayList<PolozkaObjednavky> zoznamPoloziek;
    private double celkovaCena;
    public Objednavka() {
        this.zoznamPoloziek = new ArrayList<>();
        this.celkovaCena = 0;
    }

    public void addPolozkaObjednavky(PolozkaObjednavky polozkaObjednavky) {
        this.zoznamPoloziek.add(polozkaObjednavky);
        this.celkovaCena += polozkaObjednavky.dajCenu();
    }

    public void addPolozkaObjednavky(String nazovSuboru, NapojovyListok listok) throws IOException, ClassNotFoundException {
        var file = new File(nazovSuboru);
        var stream = new FileInputStream(file);
        var citac = new ObjectInputStream(stream);
        this.zoznamPoloziek = (ArrayList<PolozkaObjednavky>) citac.readObject();
    }

    public void zapisObjednavku(String nazovSuboru) throws FileNotFoundException {
        Iterator<PolozkaObjednavky> iterator = this.iterator();
        var file = new File(nazovSuboru);
        var writer = new PrintWriter(file);
        String uvod = "Objednavka:";
        String uvod1 = "***************************";
        writer.println(uvod);
        writer.println(uvod1);
        writer.println(" ");
        while (iterator.hasNext()) {
            writer.println(iterator.next());
        }
        writer.println(uvod1);
        writer.println(String.format("Cena celkom : %5.f Euro", this.celkovaCena));
    }

    @Override
    public Iterator<PolozkaObjednavky> iterator() {
        return this.zoznamPoloziek.iterator();
    }

    @Override
    public String toString() {
        String vypis = null;
        Iterator<PolozkaObjednavky> iterator = this.iterator();
        while (iterator.hasNext()) {
            vypis = String.format("%s%n", iterator.next().toString());
        }
        return vypis;
    }
}
