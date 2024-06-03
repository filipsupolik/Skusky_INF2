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
                String nazovPrikazu = citac.next();
                if (nazovPrikazu.endsWith(":")) {
                    String celaInstrukcia = citac.nextLine();
                    if (!celaInstrukcia.equals(" ")) {
                        var citacCelychInstrukcii = new Scanner(celaInstrukcia);
                        while (citacCelychInstrukcii.hasNext()) {
                            String nazovInstrukcie = citacCelychInstrukcii.next();
                            switch (nazovInstrukcie) {
                                case "Load":
                                    char register = citacCelychInstrukcii.next().charAt(0);
                                    int hodnotaVRegistri = citacCelychInstrukcii.nextInt();
                                    this.pridajInstrukciu(new Load(register, hodnotaVRegistri));
                                    break;
                                case "Move":
                                    char registerZdroj = citacCelychInstrukcii.next().charAt(0);
                                    char registerCiel = citacCelychInstrukcii.next().charAt(0);
                                    this.pridajInstrukciu(new Move(registerZdroj, registerCiel));
                                    break;
                                case "JumpIfZero":
                                    String navestie = citacCelychInstrukcii.next();
                                    this.pridajInstrukciu(new JumpIfZero(navestie));
                                    break;
                                case "Substract":
                                    char registerCielSub = citacCelychInstrukcii.next().charAt(0);
                                    char registerOperand = citacCelychInstrukcii.next().charAt(0);
                                    this.pridajInstrukciu(new Substract(registerCielSub, registerOperand));
                                    break;
                                case "JumpIfNegative":
                                    String navestieNeg = citacCelychInstrukcii.next();
                                    this.pridajInstrukciu(new JumpIfNegative(navestieNeg));
                                    break;
                                case "Jump":
                                    String navestieJump = citacCelychInstrukcii.next();
                                    this.pridajInstrukciu(new Jump(navestieJump));
                                    break;
                            }
                        }
                    }
                } else {
                    switch (nazovPrikazu) {
                        case "Load":
                            char register = citac.next().charAt(0);
                            int hodnotaVRegistri = citac.nextInt();
                            this.pridajInstrukciu(new Load(register, hodnotaVRegistri));
                            break;
                        case "Move":
                            char registerZdroj = citac.next().charAt(0);
                            char registerCiel = citac.next().charAt(0);
                            this.pridajInstrukciu(new Move(registerZdroj, registerCiel));
                            break;
                        case "JumpIfZero":
                            String navestie = citac.next();
                            this.pridajInstrukciu(new JumpIfZero(navestie));
                            break;
                        case "Substract":
                            char registerCielSub = citac.next().charAt(0);
                            char registerOperand = citac.next().charAt(0);
                            this.pridajInstrukciu(new Substract(registerCielSub, registerOperand));
                            break;
                        case "JumpIfNegative":
                            String navestieNeg = citac.next();
                            this.pridajInstrukciu(new JumpIfNegative(navestieNeg));
                            break;
                        case "Jump":
                            String navestieJump = citac.next();
                            this.pridajInstrukciu(new Jump(navestieJump));
                            break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Subor sa nenasiel.");
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
