package øving_6;
import java.util.Random;
public class tilfeldigetall {
    public static void main(String[] args) {
        Random random = new Random();
        int[] antall = new int[10];
        int N=5000;
        for(int i =0;i<N;i++){
            int t = random.nextInt(10);
            antall[t]++;
            //System.out.println(antall[t]);
        }
        for(int i = 0; i < antall.length; i++){
            System.out.println("Tallet " + i + " ble trukket " + antall[i] + " ganger");
        }
    }
}
 