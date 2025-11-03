package øving_10;

import java.util.*;
import java.util.stream.Collectors;

public class ArrangementRegister {
    private final List<Arrangement> arrangementer = new ArrayList<>();

    public void leggTil(Arrangement a) {
        arrangementer.add(a);
    }

    public boolean eksistererId(int id) {
        return arrangementer.stream().anyMatch(a -> a.getId() == id);
    }

    public List<Arrangement> finnPåSted(String sted) {
        String needle = sted.trim().toLowerCase(Locale.ROOT);
        return arrangementer.stream()
                .filter(a -> a.getSted().toLowerCase(Locale.ROOT).equals(needle))
                .collect(Collectors.toList());
    }

    public List<Arrangement> finnPåDato(int datoYYYYMMDD) {
        return arrangementer.stream()
                .filter(a -> a.getDatoYYYYMMDD() == datoYYYYMMDD)
                .sorted(Comparator.comparingLong(Arrangement::getTidspunkt))
                .collect(Collectors.toList());
    }

    public List<Arrangement> finnIIntervall(long fraTid, long tilTid) {
        long lo = Math.min(fraTid, tilTid);
        long hi = Math.max(fraTid, tilTid);
        return arrangementer.stream()
                .filter(a -> a.getTidspunkt() >= lo && a.getTidspunkt() <= hi)
                .sorted(Comparator.comparingLong(Arrangement::getTidspunkt))
                .collect(Collectors.toList());
    }

    public List<Arrangement> listSortertEtterSted() {
        return arrangementer.stream()
                .sorted(Comparator.comparing(Arrangement::getSted, String.CASE_INSENSITIVE_ORDER)
                        .thenComparingLong(Arrangement::getTidspunkt))
                .collect(Collectors.toList());
    }

    public List<Arrangement> listSortertEtterType() {
        return arrangementer.stream()
                .sorted(Comparator.comparing(Arrangement::getType, String.CASE_INSENSITIVE_ORDER)
                        .thenComparingLong(Arrangement::getTidspunkt))
                .collect(Collectors.toList());
    }

    public List<Arrangement> listSortertEtterTid() {
        return arrangementer.stream()
                .sorted(Comparator.comparingLong(Arrangement::getTidspunkt))
                .collect(Collectors.toList());
    }

    public boolean tom() {
        return arrangementer.isEmpty();
    }
}

