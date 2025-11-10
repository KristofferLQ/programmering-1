public class Eiendom {
    private final int kommunenummer;
    private final String kommunenavn;
    private final int gnr;
    private final int bnr;
    private final String bruksnavn;
    private final double areal;
    private final String eier;

    public Eiendom(int kommunenummer, String kommunenavn, int gnr, int bnr, String bruksnavn, double areal, String eier){
        this.kommunenummer = kommunenummer;
        this.kommunenavn = kommunenavn;
        this.gnr = gnr;
        this.bnr = bnr;
        this.bruksnavn = bruksnavn;
        this.areal = areal;
        this.eier = eier;
    
    }
    public Eiendom(int kommunenummer, String kommunenavn, int gnr, int bnr, double areal, String eier){
    this(kommunenummer,kommunenavn,gnr,bnr,"Ikke noe bruksnavn.",areal,eier);
}
public int getKommunenummer(){
    return kommunenummer;
}
public int getBnr(){
    return bnr;
}
public int getGnr(){
    return gnr;
}
public double getAreal(){
    return areal;
}
}
