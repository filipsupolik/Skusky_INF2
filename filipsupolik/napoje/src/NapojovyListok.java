import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;
import java.util.Scanner;

public class NapojovyListok implements Iterable<Napoj> {
    private ArrayList<Napoj> napojovyListok;

    public NapojovyListok() {
        this.napojovyListok = new ArrayList<>();
    }

    public void addNapoj(Napoj napoj) {
        this.napojovyListok.add(napoj);
    }

    public Optional<Napoj> getNapoj(int idNapoja) {
        Iterator<Napoj> iterator = this.iterator();
        while (iterator().hasNext()) {
            if (iterator.next().getId() == idNapoja) {
                Optional.of(this);
            }
        }
        return Optional.empty();
    }


    @Override
    public Iterator<Napoj> iterator() {
        return this.napojovyListok.iterator();
    }

    @Override
    public String toString() {
        String vypis = null;
        Iterator<Napoj> iterator = this.iterator();
        while (iterator.hasNext()) {
            vypis = String.format("Napojovy listok obsahuje napojde:%n" +
                    "%s", iterator.next());
        }
        return vypis;
    }

    public void vytvorNapojovyListok(String nazovSuboru) throws FileNotFoundException {
        Iterator<Napoj> iterator = this.iterator();
        String uvod = "Ponukame nasledovne napoje:";
        String uvod1 = "***************************";
        var file = new File(nazovSuboru);
        var writer = new PrintWriter(file);
        while (iterator.hasNext()) {
            writer.println(this.getNapoj(iterator.next().getId()));
        }
        writer.close();
    }
}
