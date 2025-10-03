package øving_2;
import java.util.Scanner;
public class oppgave_1 {
    
    static Scanner år = new Scanner(System.in);

    public static boolean sjekkSkuddår(int år){
        if (år%100==0){
            if (år%400==0){
                return true;
            }
            return false;
        }
        
        if (år%4==0){
            return true;
        
        }
        return false;

    }
        
    
        public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int år = in.nextInt();
        boolean skuddaar = sjekkSkuddår(år);
        System.out.println(skuddaar);
        


    }

    
}