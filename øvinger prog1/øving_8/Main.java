package øving_8;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US); // valgfritt: forutsigbar desimal (.)
        
        Person p = new Person("Kristoffer", "Qvenild", 2005);
        ArbTaker a = new ArbTaker(p, 1001, 2015, 50000.0, 25.0);

        System.out.println("=== Initielle verdier ===");
        skrivAlt(a);

        try (Scanner sc = new Scanner(System.in)) {
            boolean fortsett = true;
            while (fortsett) {
                System.out.println(" MENY ");
                System.out.println("1) Endre månedslønn");
                System.out.println("2) Endre skatteprosent");
                System.out.println("3) Vis alle beregninger");
                System.out.println("0) Avslutt");
                System.out.print("Valg: ");

                String valg = sc.nextLine().trim();
                switch (valg) {
                    case "1":
                        System.out.print("Ny månedslønn: ");
                        double nyLonn = Double.parseDouble(sc.nextLine());
                        a.setMånedslønn(nyLonn); // ASCII-navn
                        System.out.println("Oppdatert!\n");
                        skrivAlt(a);
                        break;
                    case "2":
                        System.out.print("Ny skatteprosent: ");
                        double nySkatt = Double.parseDouble(sc.nextLine());
                        a.setSkatteprosent(nySkatt);
                        System.out.println("Oppdatert!\n");
                        skrivAlt(a);
                        break;
                    case "3":
                        skrivAlt(a);
                        break;
                    case "0":
                        fortsett = false;
                        break;
                    default:
                        System.out.println("Ugyldig valg. Prøv igjen.");
                }
            }
        }

        System.out.println("Avslutter.");
    }

    private static void skrivAlt(ArbTaker a) {
        System.out.println(a.toString());
        System.out.printf("Navn (etternavn, fornavn): %s%n", a.navnEtternavnFornavn());
        System.out.printf("Alder: %d%n", a.alder());
        System.out.printf("Antall år ansatt: %d%n", a.antallAarAnsatt());
        System.out.printf("Har vært ansatt > 5 år? %s%n", a.harVartAnsattMerEnn(5));
        System.out.printf("Skatt per måned: %.2f%n", a.skattPerManed());
        System.out.printf("Bruttolønn per år: %.2f%n", a.bruttoLonnPerAar());
        System.out.printf("Skattetrekk per år (juni 0, des 1/2): %.2f%n", a.skattPerAar());
    }
}