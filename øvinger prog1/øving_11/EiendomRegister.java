import java.util.ArrayList;
import java.util.List;
public class EiendomRegister{
    private ArrayList<Eiendom> eiendommer;

    public EiendomRegister(){
        eiendommer = new ArrayList<>();
    }

    public boolean leggTilEiendom(Eiendom e){
        eiendommer.add(e);
        return true;
    }
    public Eiendom søkEtterEiendom(int Kommunenummer,int gnr, int bnr){
        for(Eiendom e : eiendommer){
            if (e.getKommunenummer()==Kommunenummer && e.getGnr()==gnr && e.getBnr()==bnr){
                return e;
            }
            
        }
        return null;
    }
    public void skriveutEiendom(){
        for(Eiendom e : eiendommer){
            System.out.println(e);
        }
    }
    public double finneAreal(){
        double sum = 0;
        if(eiendommer.isEmpty()){
               return 0.0;}
        else{
            for(Eiendom e : eiendommer){
            sum +=e.getAreal();}  
        }    
        double areal = sum/eiendommer.size();
        return areal;}
    
    }


