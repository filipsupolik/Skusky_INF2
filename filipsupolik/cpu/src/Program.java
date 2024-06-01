import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    private ArrayList<Instrukcia> zoznamInstrukcii;
    private String nazovSuboru;

    public Program() {
        this.zoznamInstrukcii = new ArrayList<>();
    }

    public Program(String nazovSuboru) {
        this.nazovSuboru = nazovSuboru;
        this.zoznamInstrukcii = new ArrayList<>();
        File file = new File(this.nazovSuboru);
        try {
            var citac = new Scanner(file);
            while (citac.hasNextLine()) {
                String nazovInstrukcie = citac.next();
                if (nazovInstrukcie.endsWith(":")) {
                    if (citac.hasNextLine()) {
                        String nasledujucaInstrukcia = citac.nextLine();
                        var citacRiadku = new Scanner(nasledujucaInstrukcia);
                        String nazovNasledujucejInstrukcie = citacRiadku.next();
                    }
                } else {
                    switch (nazovInstrukcie) {
                        case "Load" -> {
                            char register = citac.next().charAt(0);
                            this.pridajInstrukciu(new Load(register, citac.nextInt()));
                        }
                        case "Move" -> {
                            char zdrojRegister = citac.next().charAt(0);
                            char cielReg = citac.next().charAt(0);
                            this.pridajInstrukciu(new Move(zdrojRegister, cielReg));
                        }
                        case "Jump" -> {
                            String navestie = citac.next();
                            this.pridajInstrukciu(new Jump(navestie));
                        }
                        case "JumpIfNegative" -> {
                            String navestie = citac.next();
                            this.pridajInstrukciu(new JumpIfNegative(navestie));
                        }
                        case "JumpIfZero" -> {
                            String navestie = citac.next();
                            this.pridajInstrukciu(new JumpIfZero(navestie));
                        }
                        case "Substract" -> {
                            char ciel = citac.next().charAt(0);
                            char operand = citac.next().charAt(0);
                            this.pridajInstrukciu(new Substract(ciel, operand));
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void pridajInstrukciu(Instrukcia instrukcia) {
        this.zoznamInstrukcii.add(instrukcia);
    }

    public void pridajNavestie(String nazov) {

    }

    public Instrukcia getInstrukcia(int adresa) {

    }

    public int getAdresaNavestie(String nazov) {

    }

    public boolean jePlatnaAdresa(int adresa) {

    }
}
