package øving_6;
import java.util.Scanner;

public class Tekstanalyse {
    int[] antallTegn = new int[30];

    static int idx(char ch) {
        ch = Character.toLowerCase(ch);
        if (ch >= 'a' && ch <= 'z') return ch - 'a';
        if (ch == 'æ') return 26;
        if (ch == 'ø') return 27;
        if (ch == 'å') return 28;
        return 29;
    }

    // Konstruktøren teller for hele teksten
    Tekstanalyse(String tekst) {
        if (tekst == null) tekst = "";
        for (int i = 0; i < tekst.length(); i++) {
            antallTegn[idx(tekst.charAt(i))]++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Skriv en tekst: ");
        String tekst = sc.nextLine();

        Tekstanalyse app = new Tekstanalyse(tekst);

        int sumBokstaver = 0;
        for (int i = 0; i < 29; i++) sumBokstaver += app.antallTegn[i];
        int ikkeBokstaver = app.antallTegn[29];

        System.out.println("Totalt bokstaver: " + sumBokstaver);
        System.out.println("Ikke-bokstaver:   " + ikkeBokstaver);
    }
}

