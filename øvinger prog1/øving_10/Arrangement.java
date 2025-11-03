package øving_10;

import java.util.Locale;

public class Arrangement {
    private final int id;           // entydig nummer
    private final String navn;
    private final String sted;
    private final String arrangor;
    private final String type;      // f.eks. konsert, barneteater, foredrag
    private final long tidspunkt;   // lagres som YYYYMMDDHHmm

    public Arrangement(int id, String navn, String sted, String arrangor, String type, long tidspunkt) {
        this.id = id;
        this.navn = navn;
        this.sted = sted;
        this.arrangor = arrangor;
        this.type = type;
        this.tidspunkt = tidspunkt;
    }

    public int getId() { return id; }
    public String getNavn() { return navn; }
    public String getSted() { return sted; }
    public String getArrangor() { return arrangor; }
    public String getType() { return type; }
    public long getTidspunkt() { return tidspunkt; }

    public int getDatoYYYYMMDD() {
        // Eks: 202511031230 -> 20251103
        return (int)(tidspunkt / 10000L);
    }

    @Override
    public String toString() {
        return String.format(
            Locale.ROOT,
            "ID: %d | \"%s\" | Sted: %s | Arrangør: %s | Type: %s | Tid: %s (%d)",
            id, navn, sted, arrangor, type, formatTimestamp(tidspunkt), tidspunkt
        );
    }

    private static String formatTimestamp(long ts) {
        String s = String.format(Locale.ROOT, "%012d", ts);
        String yyyy = s.substring(0, 4);
        String MM   = s.substring(4, 6);
        String dd   = s.substring(6, 8);
        String HH   = s.substring(8, 10);
        String mm   = s.substring(10, 12);
        return yyyy + "-" + MM + "-" + dd + " " + HH + ":" + mm;
    }
}

