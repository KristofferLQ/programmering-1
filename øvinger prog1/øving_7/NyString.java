package øving_7;

public class NyString {
    // Objektvariabel (privat og endelig, for å gjøre klassen immutabel)
    private final String tekst;

    // Konstruktør
    public NyString(String tekst) {
        this.tekst = tekst;
    }

    // Metode 1: Forkorting
    // Henter første bokstav fra hvert ord og setter dem sammen
    public String forkort() {
        String[] ord = tekst.split(" "); // Deler opp teksten ved mellomrom
        StringBuilder forkortet = new StringBuilder();

        for (String o : ord) {
            if (o.length() > 0) {
                forkortet.append(o.charAt(0)); // Legger til første bokstav i hvert ord
            }
        }

        return forkortet.toString();
    }

    // Metode 2: Fjerning av et tegn
    // Returnerer en ny streng uten det gitte tegnet
    public String fjernTegn(char tegn) {
        String nyTekst = tekst;
        int pos = nyTekst.indexOf(tegn);

        // Så lenge tegnet finnes i teksten
        while (pos != -1) {
            nyTekst = nyTekst.substring(0, pos) + nyTekst.substring(pos + 1);
            pos = nyTekst.indexOf(tegn); // Finn neste forekomst
        }

        return nyTekst;
    }

    // Hjelpemetode for å hente original tekst (valgfritt)
    public String getTekst() {
        return tekst;
    }
}
