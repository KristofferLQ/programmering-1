public class Oppgaveoversikt {
    private Student[] studenter;
    private int antStud;

    public Oppgaveoversikt(int maksAntall) {
        studenter = new Student[maksAntall];
        antStud = 0;
    }

    // Finn antall studenter registrert
    public int getAntStud() {
        return antStud;
    }

    // Finn antall oppgaver som en bestemt student har løst
    public int finnAntOppg(String navn) {
        for (int i = 0; i < antStud; i++) {
            if (studenter[i].getNavn().equalsIgnoreCase(navn)) {
                return studenter[i].getAntOppg();
            }
        }
        return -1; // returnerer -1 hvis studenten ikke finnes
    }

    // Registrer en ny student
    public void registrerNyStudent(String navn, int antOppg) {
        if (antStud < studenter.length) {
            studenter[antStud] = new Student(navn, antOppg);
            antStud++;
        } else {
            System.out.println("Ingen plass til flere studenter!");
        }
    }

    // Øk antall oppgaver for en bestemt student
    public void okAntOppg(String navn, int okning) {
        for (int i = 0; i < antStud; i++) {
            if (studenter[i].getNavn().equalsIgnoreCase(navn)) {
                studenter[i].okAntOppg(okning);
                return;
            }
        }
        System.out.println("Fant ikke studenten: " + navn);
    }

    @Override
    public String toString() {
        String resultat = "Registrerte studenter:\n";
        for (int i = 0; i < antStud; i++) {
            resultat += (i + 1) + ". " + studenter[i].toString() + "\n";
        }
        return resultat;
    }
}


