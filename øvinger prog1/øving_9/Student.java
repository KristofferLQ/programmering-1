public class Student {
    private String navn;   // entydig navn
    private int antOppg;   // antall godkjente oppgaver

    public Student(String navn, int antOppg) {
        this.navn = navn;
        this.antOppg = antOppg;
    }

    public String getNavn() {
        return navn;
    }

    public int getAntOppg() {
        return antOppg;
    }

    public void okAntOppg(int okning) {
        if (okning > 0) {
            antOppg += okning;
        }
    }

    @Override
    public String toString() {
        return navn + " har " + antOppg + " godkjente oppgaver.";
    }
}