import java.util.HashMap;
import java.util.Map;

public class Registre {
    private HashMap<Character, Integer> sadaRegistrov;

    public Registre() {
        this.sadaRegistrov= new HashMap<>();
        this.sadaRegistrov.put('A', 0);
        this.sadaRegistrov.put('B', 0);
        this.sadaRegistrov.put('C', 0);
        this.sadaRegistrov.put('D', 0);
        this.sadaRegistrov.put('E', 0);
    }

    public int citaj(char register) {
        return this.sadaRegistrov.get(register);
    }

    public void nastav(char register, int hodnota) {
        this.sadaRegistrov.put(register, hodnota);
    }

    public void vypis() {
        for (Map.Entry<Character, Integer> entry : this.sadaRegistrov.entrySet()) {
            System.out.printf("%s = %d%n", entry.getKey(), entry.getValue());
        }
    }
}

