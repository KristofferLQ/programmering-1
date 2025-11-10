package øving_10;

import java.util.*;
import java.util.stream.Collectors;

public class MenyRegister {
    private final Map<String, Rett> retter = new HashMap<>(); // key: navn (case-insensitivt lagres som lower)
    private final Map<String, Meny> menyer = new HashMap<>(); // key: meny-navn (lower)

    // --- Hjelper for case-insensitiv nøkkel ---
    private static String key(String s) { return s.toLowerCase(Locale.ROOT).trim(); }

    // • Registrer ny rett
    public boolean registrerRett(Rett r) {
        Objects.requireNonNull(r);
        String k = key(r.getNavn());
        if (retter.containsKey(k)) return false;   // finnes allerede
        retter.put(k, r);
        return true;
    }

    // • Finn en rett ved navn
    public Optional<Rett> finnRett(String navn) {
        if (navn == null) return Optional.empty();
        return Optional.ofNullable(retter.get(key(navn)));
    }

    // • Finn alle retter av gitt type (case-insensitiv)
    public List<Rett> finnRetterAvType(String type) {
        if (type == null) return List.of();
        String t = type.toLowerCase(Locale.ROOT).trim();
        return retter.values().stream()
                .filter(r -> r.getType().toLowerCase(Locale.ROOT).equals(t))
                .sorted(Comparator.comparing(Rett::getNavn, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
    }

    // • Registrer ny meny som består av et sett med retter
    public boolean registrerMeny(String menyNavn, Set<Rett> retterIMeny) {
        Objects.requireNonNull(menyNavn, "Meny-navn må angis");
        if (menyNavn.isBlank()) throw new IllegalArgumentException("Meny-navn kan ikke være tomt");
        String k = key(menyNavn);
        if (menyer.containsKey(k)) return false;

        Meny m = new Meny(menyNavn);
        if (retterIMeny != null) {
            for (Rett r : retterIMeny) m.leggTil(r);
        }
        menyer.put(k, m);
        return true;
    }

    // • Finn alle menyer med totalpris innenfor [fra, til]
    public List<Meny> finnMenyerInnenforPris(double fra, double til) {
        double lo = Math.min(fra, til);
        double hi = Math.max(fra, til);
        return menyer.values().stream()
                .filter(m -> {
                    double p = m.totalPris();
                    return p >= lo && p <= hi;
                })
                .sorted(Comparator.comparingDouble(Meny::totalPris)
                        .thenComparing(Meny::getNavn, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
    }

    // Nyttige ekstrahentere til test/visning
    public List<Rett> getAlleRetter() {
        return retter.values().stream()
                .sorted(Comparator.comparing(Rett::getNavn, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
    }

    public List<Meny> getAlleMenyer() {
        return menyer.values().stream()
                .sorted(Comparator.comparing(Meny::getNavn, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
    }
}


