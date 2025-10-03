package øving_5;
import java.util.Random;
public class oppgave_2 {
    


    private final Random rng;

    public oppgave_2() {
        this.rng = new Random();
    }
    public oppgave_2(long seed) {
        this.rng = new Random(seed);
    }

   
     
    public int nesteHeltall(int nedre, int ovre) {
        if (nedre > ovre) {
            throw new IllegalArgumentException("nedre må være <= ovre");
        }
        
        return nedre + rng.nextInt(ovre - nedre + 1);
        
    }

   
    public double nesteDesimaltall(double nedre, double ovre) {
        if (ovre <= nedre) {
            throw new IllegalArgumentException("ovre må være > nedre");
        }
        
        return nedre + rng.nextDouble() * (ovre - nedre);
    }


    public static void main(String[] args) {
        oppgave_2 mr = new oppgave_2(42L); 

        
        int min = 3, max = 7;
        for (int i = 0; i < 10; i++) {
            int v = mr.nesteHeltall(min, max);
            System.out.println("heltall: " + v);
            assert v >= min && v <= max : "utenfor [min,max]";
        }

        double a = -2.5, b = 1.5;
        for (int i = 0; i < 10; i++) {
            double x = mr.nesteDesimaltall(a, b);
            System.out.println("desimaltall: " + x);
            assert x >= a && x < b : "utenfor [a,b)";
        }

        System.out.println("OK  alle innenfor intervallene.");
    }

}