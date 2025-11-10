package øving_10;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Meny {
    private final String navn;            // identifikator for meny
    private final Set<Rett> retter;       // ingen duplikater

    public Meny(String navn) {
        if (navn == null || navn.isBlank()) throw new IllegalArgumentException("Meny-navn kan ikke være tomt");
        this.navn = navn.trim();
        this.retter = new LinkedHashSet<>();
    }

    public String getNavn() { return navn; }

    public Set<Rett> getRetter() {
        return Collections.unmodifiableSet(retter);
    }

    public boolean leggTil(Rett r) {
        Objects.requireNonNull(r, "Rett kan ikke være null");
        return retter.add(r);
    }

    public boolean fjern(Rett r) {
        Objects.requireNonNull(r, "Rett kan ikke være null");
        return retter.remove(r);
    }

    public double totalPris() {
        return retter.stream().mapToDouble(Rett::getPris).sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Meny: ").append(navn)
                .append(" (").append(String.format("%.2f kr", totalPris())).append(")\n");
        for (Rett r : retter) {
            sb.append("  - ").append(r.toString()).append("\n");
        }
        return sb.toString();
    }
}

