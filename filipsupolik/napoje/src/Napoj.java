

/**
 *
 * @author vaclavko
 */
public class Napoj {
    private int id;
    private String nazov;
    private double cena;
    private String jednotka;

    public Napoj(int id, String nazov, double cena, String jednotka) {
        this.id = id;
        this.nazov = nazov;
        this.cena = cena;
        this.jednotka = jednotka;
    }

    public int getId() {
        return id;
    }

    public String getNazov() {
        return nazov;
    }

    public double getCena() {
        return cena;
    }

    @Override
    public String toString() {
        return String.format("Napoj id = %d nazov = %s cena =%5.2f E %s ", id, nazov, cena, jednotka);
    }
    
    
    
}
