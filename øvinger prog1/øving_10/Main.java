package øving_10;

import java.util.*;

public class Main {
    private static final Scanner in = new Scanner(System.in);
    private static final ArrangementRegister register = new ArrangementRegister();

    public static void main(String[] args) {
        seedEksempler();

        boolean fortsett = true;
        while (fortsett) {
            skrivMeny();
            String valg = in.nextLine().trim();

            switch (valg) {
                case "1":
                    registrerArrangement();
                    break;
                case "2":
                    finnPåSted();
                    break;
                case "3":
                    finnPåDato();
                    break;
                case "4":
                    finnIIntervall();
                    break;
                case "5":
                    skrivListe(register.listSortertEtterSted(), "Alle – sortert etter sted");
                    break;
                case "6":
                    skrivListe(register.listSortertEtterType(), "Alle – sortert etter type");
                    break;
                case "7":
                    skrivListe(register.listSortertEtterTid(),  "Alle – sortert etter tid");
                    break;
                case "0":
                    System.out.println("Avslutter. Ha en fin dag!");
                    fortsett = false;
                    break;
                default:
                    System.out.println("Ugyldig valg!");
                    break;
            }
        }
    }

    private static void skrivMeny() {
        System.out.println("\n=== Arrangementregister ===");
        System.out.println("1) Registrer nytt arrangement");
        System.out.println("2) Finn alle arrangementer på et gitt sted");
        System.out.println("3) Finn alle arrangementer på en gitt dato (YYYYMMDD)");
        System.out.println("4) Finn alle arrangementer i et tidsintervall (YYYYMMDDHHmm)");
        System.out.println("5) List alle – sortert etter sted");
        System.out.println("6) List alle – sortert etter type");
        System.out.println("7) List alle – sortert etter tidspunkt");
        System.out.println("0) Avslutt");
        System.out.print("Velg: ");
    }

    private static void registrerArrangement() {
        System.out.println("\n--- Registrer nytt arrangement ---");
        int id = lesUnikId();
        System.out.print("Navn: ");
        String navn = in.nextLine().trim();
        System.out.print("Sted: ");
        String sted = in.nextLine().trim();
        System.out.print("Arrangør: ");
        String arrangor = in.nextLine().trim();
        System.out.print("Type (konsert, foredrag, osv.): ");
        String type = in.nextLine().trim();
        long tidspunkt = lesTimestamp("Tidspunkt (YYYYMMDDHHmm): ");

        Arrangement a = new Arrangement(id, navn, sted, arrangor, type, tidspunkt);
        register.leggTil(a);
        System.out.println("Lagt til: " + a);
    }

    private static void finnPåSted() {
        System.out.print("Skriv inn sted: ");
        String sted = in.nextLine().trim();
        skrivListe(register.finnPåSted(sted), "Arrangementer på " + sted);
    }

    private static void finnPåDato() {
        int dato = lesDato("Skriv dato (YYYYMMDD): ");
        skrivListe(register.finnPåDato(dato), "Arrangementer på dato " + dato);
    }

    private static void finnIIntervall() {
        long fra = lesTimestamp("Fra (YYYYMMDDHHmm): ");
        long til = lesTimestamp("Til  (YYYYMMDDHHmm): ");
        skrivListe(register.finnIIntervall(fra, til), "Arrangementer mellom " + fra + " og " + til);
    }

    private static void skrivListe(List<Arrangement> liste, String tittel) {
        System.out.println("\n" + tittel);
        if (liste.isEmpty()) {
            System.out.println("(ingen treff)");
            return;
        }
        for (Arrangement a : liste) {
            System.out.println(a);
        }
    }

    private static int lesUnikId() {
        while (true) {
            System.out.print("ID (heltall, unikt): ");
            try {
                int id = Integer.parseInt(in.nextLine().trim());
                if (register.eksistererId(id)) {
                    System.out.println("ID finnes allerede, prøv igjen.");
                } else return id;
            } catch (NumberFormatException e) {
                System.out.println("Ugyldig tall!");
            }
        }
    }

    private static int lesDato(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = in.nextLine().trim();
            if (s.matches("\\d{8}")) return Integer.parseInt(s);
            System.out.println("Feil format! Bruk YYYYMMDD.");
        }
    }

    private static long lesTimestamp(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = in.nextLine().trim();
            if (s.matches("\\d{12}")) return Long.parseLong(s);
            System.out.println("Feil format! Bruk YYYYMMDDHHmm.");
        }
    }

    private static void seedEksempler() {
        register.leggTil(new Arrangement(1, "Høstkonsert", "Oslo", "Kulturhuset", "konsert", 202510152000L));
        register.leggTil(new Arrangement(2, "Barneteater", "Bergen", "Teaterlaget", "barneteater", 202509071100L));
        register.leggTil(new Arrangement(3, "Foredrag", "Oslo", "Arkitektfor.", "foredrag", 202511031800L));
        register.leggTil(new Arrangement(4, "Jazzkveld", "Trondheim", "Jazzklubben", "konsert", 202511052100L));
        register.leggTil(new Arrangement(5, "Byvandring", "Oslo", "Turistkontoret", "omvisning", 202511031000L));
    }
}

