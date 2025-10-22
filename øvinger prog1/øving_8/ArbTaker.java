package øving_8;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class ArbTaker {
private final Person personalia;
private final int arbtakernr;
private final int ansettelsesår;
private double månedslønn;
private double skatteprosent;

public ArbTaker(Person personalia, int arbtakernr, int ansettelsesår, double månedslønn, double skatteprosent){
	this.personalia = personalia;
	this.arbtakernr = arbtakernr;
	this.ansettelsesår = ansettelsesår;
	this.månedslønn = månedslønn;
	this.skatteprosent = skatteprosent;
}
  public Person getPersonalia() {
        return personalia;
    }

        public int getArbtakernr() {
        return arbtakernr;
    }

    public int getAnsettelsesår() {
        return ansettelsesår;
    }

    public double getMånedslønn() {
        return månedslønn;
    }

    public double getSkatteprosent() {
        return skatteprosent;
    }

    
    public void setMånedslønn(double månedslønn) {
        this.månedslønn = månedslønn;
    }

    public void setSkatteprosent(double skatteprosent) {
        this.skatteprosent = skatteprosent;
    }
     private int innevaerendeAar() {
GregorianCalendar kalender = new GregorianCalendar();
return kalender.get(Calendar.YEAR);
}


// 1) Hvor mange kroner trekk i skatt per måned
public double skattPerManed() {
return månedslønn * (skatteprosent / 100.0);
// Merk: I praksis kan skattetrekk per måned variere, men her er en enkel modell.
}


// 2) Bruttolønn per år
public double bruttoLonnPerAar() {
return månedslønn * 12.0;
}


// 3) Skattetrekk per år (juni skattefri, desember halv skatt)
public double skattPerAar() {
// 10,5 måneder med "fullt" trekk
return skattPerManed() * 10.5;
}


// 4) Navn: "etternavn, fornavn" (samarbeid med Person)
public String navnEtternavnFornavn() {
return personalia.getEtternavn() + ", " + personalia.getFornavn();
}


// 5) Alder (samarbeid med Person)
public int alder() {
int aar = innevaerendeAar();
return aar - personalia.getFødselsår();
}


// 6) Antall år ansatt
public int antallAarAnsatt() {
return innevaerendeAar() - ansettelsesår;
}


// 7) Har vært ansatt mer enn gitt antall år?
public boolean harVartAnsattMerEnn(int grenseAar) {
return antallAarAnsatt() > grenseAar;
}


@Override
public String toString() {
return String.format(
"%s (nr %d)\nAnsatt: %d\nMånedslønn: %.2f\nSkatteprosent: %.2f%%",
navnEtternavnFornavn(), arbtakernr, ansettelsesår, månedslønn, skatteprosent
);
}

}
