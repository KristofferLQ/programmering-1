import java.util.Scanner;

public class Klientprogram {
    public static void main(String[] args) {
        Oppgaveoversikt oversikt = new Oppgaveoversikt(10);
        Scanner in = new Scanner(System.in);

        oversikt.registrerNyStudent("Ola", 3);
        oversikt.registrerNyStudent("Kari", 5);

        System.out.println(oversikt);

        System.out.print("Skriv inn navnet på studenten du vil øke antall oppgaver for: ");
        String navn = in.nextLine();
        System.out.print("Hvor mange oppgaver skal legges til? ");
        int okning = in.nextInt();

        oversikt.okAntOppg(navn, okning);

        System.out.println("\nEtter oppdatering:");
        System.out.println(oversikt);
    }
}
