package øving_10;
import java.util.Objects;

public class Rett {
    private final String navn;       // entydig
    private final String type;       // f.eks. forrett, hovedrett, dessert
    private final double pris;       // i kroner
    private final String oppskrift;  // enkel tekst

    public Rett(String navn, String type, double pris, String oppskrift) {
        if (navn == null || navn.isBlank()) throw new IllegalArgumentException("Navn kan ikke være tomt");
        if (type == null || type.isBlank()) throw new IllegalArgumentException("Type kan ikke være tom");
        if (pris < 0) throw new IllegalArgumentException("Pris kan ikke være negativ");
        this.navn = navn.trim();
        this.type = type.trim();
        this.pris = pris;
        this.oppskrift = oppskrift == null ? "" : oppskrift.trim();
    }

    public String getNavn() { return navn; }
    public String getType() { return type; }
    public double getPris() { return pris; }
    public String getOppskrift() { return oppskrift; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rett)) return false;
        Rett rett = (Rett) o;
        return navn.equalsIgnoreCase(rett.navn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(navn.toLowerCase());
    }

    @Override
    public String toString() {
        return String.format("%s (%s) – %.2f kr", navn, type, pris);
    }
}
