package øving_7;
    public class TestTekstbehandling {
    public static void main(String[] args) {
        String t = "Dette er en kort tekst. Finnes det noe mer? Ja: ære, øre og åre!";

        Tekstbehandling tb = new Tekstbehandling(t);

        System.out.println("Original tekst:");
        System.out.println(tb.hentTekst());
        System.out.println();

        System.out.println("Antall ord: " + tb.antallOrd());
        System.out.printf("Gj.snittlig ordlengde: %.2f%n", tb.gjennomsnittligOrdlengde());
        System.out.printf("Gj.snittlig antall ord per periode: %.2f%n", tb.gjennomsnittligAntallOrdPerPeriode());
        System.out.println();

        Tekstbehandling tb2 = tb.erstattOrd("Finnes", "Fins");
        System.out.println("Etter erstatning av 'Finnes' -> 'Fins':");
        System.out.println(tb2.hentTekst());
        System.out.println();

        System.out.println("Med STORE bokstaver:");
        System.out.println(tb.hentTekstMedStore());
    }
}


