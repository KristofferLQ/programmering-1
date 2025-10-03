package øving_2;


public class oppgave_21 {
   
    
    public static void main(String[] args) {
    double Kjøttdeig_a= 450;
    double Kjøttdeig_b= 500;
    double gram_prisa= 35.90/Kjøttdeig_a;
    double gram_prisb= 39.50/Kjøttdeig_b;
        
        if (gram_prisa>gram_prisb){
            System.out.println(gram_prisa+"Kjøttdeig A er dyrere enn kjøttdeig B "+ gram_prisb);
        } 
        else if(gram_prisa==gram_prisb){
            System.out.println("kjøttdeig A "+ gram_prisa+" og"+gram_prisb+ "B er like dyre");
        }
        else{
            System.out.println("Kjøttdeig B "+gram_prisb+"g/kr er dyrere en kjøttdeig A "+ gram_prisa+"g/kr");
        }

    }
}

