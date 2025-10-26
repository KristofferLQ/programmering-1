

public class Oppgaveoversikt {
    
    private Student[] studenter; 
    private int antStud = 0;

    public Oppgaveoversikt(int maksAntallStudenter) {
        studenter = new Student[maksAntallStudenter];
    }

    public int finnAntStudenter() {
        return antStud;
    }

    public int finnAntOppgaver(String navn) {
        for (int i = 0; i < antStud; i++) {
            if (studenter[i].getNavn().equalsIgnoreCase(navn)) {
                return studenter[i].getAntOppg();
            }
        }
        return -1; // Ikke funnet
    }

    public boolean registrerNyStudent(String navn, int antOppg) {
        if (antStud >= studenter.length) return false; // full tabell
        if (finnStudent(navn) != null) return false;   // allerede registrert

        studenter[antStud] = new Student(navn, antOppg);
        antStud++;
        return true;
    }

    public boolean okAntOppg(String navn, int okning) {
        Student s = finnStudent(navn);
        if (s != null) {
            s.okAntOppg(okning);
            return true;
        }
        return false;
    }

    private Student finnStudent(String navn) {
        for (int i = 0; i < antStud; i++) {
            if (studenter[i].getNavn().equalsIgnoreCase(navn)) {
                return studenter[i];
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String tekst = "Antall studenter: " + antStud + "\n";
        for (int i = 0; i < antStud; i++) {
            tekst += studenter[i].toString() + "\n";
        }
        return tekst;
    }



    public static void main(String[] args) {
        Oppgaveoversikt oversikt = new Oppgaveoversikt(10);

        oversikt.registrerNyStudent("Ola", 3);
        oversikt.registrerNyStudent("Kari", 5);
        oversikt.registrerNyStudent("Per", 2);

        System.out.println("Før oppdatering:\n" + oversikt);

        oversikt.okAntOppg("Ola", 2);
        oversikt.okAntOppg("Per", 4);

        System.out.println("Etter oppdatering:\n" + oversikt);

        System.out.println("Kari har løst " + oversikt.finnAntOppgaver("Kari") + " oppgaver.");
    }
}

