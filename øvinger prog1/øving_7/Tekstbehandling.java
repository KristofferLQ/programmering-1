package øving_7;


import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Tekstbehandling {
    private final String tekst;

    // Konstruktør
    public Tekstbehandling(String tekst) {
        this.tekst = tekst == null ? "" : tekst;
    }

    // --- Grunnleggende henting ---
    public String hentTekst() {
        return tekst;
    }

    public String hentTekstMedStore() {
        // Norsk locale for riktig håndtering av æøå
        return tekst.toUpperCase(new Locale("nb", "NO"));
    }

    // --- Ordstatistikk ---
    // Teller ord som sekvenser av bokstaver (unicode), slik at æøå teller som bokstaver
    public int antallOrd() {
        int count = 0;
        Matcher m = WORD_PATTERN.matcher(tekst);
        while (m.find()) count++;
        return count;
    }

    public double gjennomsnittligOrdlengde() {
        int ord = 0;
        int sumLengder = 0;
        Matcher m = WORD_PATTERN.matcher(tekst);
        while (m.find()) {
            ord++;
            sumLengder += m.group().length();
        }
        return ord == 0 ? 0.0 : (double) sumLengder / ord;
    }

    // --- Perioder ---
    // Perioder skilles av . ! : ?
    public double gjennomsnittligAntallOrdPerPeriode() {
        String[] perioder = tekst.split("[.!:?]");
        int antPer = 0;
        int ordTot = 0;

        for (String p : perioder) {
            String trimmed = p.trim();
            if (trimmed.isEmpty()) continue;
            antPer++;
            ordTot += tellOrdI(trimmed);
        }

        return antPer == 0 ? 0.0 : (double) ordTot / antPer;
    }

    // --- Erstatning av ord ---
    // Skifter ut *hele ord* (ikke inni andre ord). Bruker unicode-bokstavgrenser.
    // Eksempel: "finnes" -> "fins" vil ikke erstatte "befinnes" inni et lengre ord.
    public Tekstbehandling erstattOrd(String gammeltOrd, String nyttOrd) {
        if (gammeltOrd == null || gammeltOrd.isEmpty()) return this;
        if (nyttOrd == null) nyttOrd = "";

        // Hele ord: ikke bokstav før og ikke bokstav etter
        // (?<!\p{L})  ...  (?!\p{L})
        String regex = "(?<!\\p{L})" + Pattern.quote(gammeltOrd) + "(?!\\p{L})";
        String ny = tekst.replaceAll(regex, Matcher.quoteReplacement(nyttOrd));
        return new Tekstbehandling(ny);
    }

    // --- Hjelpere ---
    private static final Pattern WORD_PATTERN = Pattern.compile("\\p{L}+"); // én eller flere bokstaver

    private static int tellOrdI(String s) {
        int c = 0;
        Matcher m = WORD_PATTERN.matcher(s);
        while (m.find()) c++;
        return c;
    }
}

