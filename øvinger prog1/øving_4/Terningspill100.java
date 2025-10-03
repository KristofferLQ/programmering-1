import java.util.Random;

public class Terningspill100 {

    public static void main(String[] args) {
        Spiller A = new Spiller();
        Spiller B = new Spiller();

        int runde = 1;
        while (true) {
            // Spiller A sin tur
            int kastA = A.kastTerningen();
            System.out.printf("Runde %d  A kaster %d. Sum A = %d%n",
                    runde, kastA, A.getSumPoeng());
            if (A.erFerdig()) {
                System.out.println("A vant spillet!");
                break;
            }

            // Spiller B sin tur
            int kastB = B.kastTerningen();
            System.out.printf("Runde %d  B kaster %d. Sum B = %d%n",
                    runde, kastB, B.getSumPoeng());
            if (B.erFerdig()) {
                System.out.println("B vant spillet!");
                break;
            }

            runde++;
        }
    }
}

/** Simulerer en spiller i spillet 100. */
class Spiller {
    private int sumPoeng = 0;
    private final Random terning = new Random();

    public int getSumPoeng() {
        return sumPoeng;
    }

    /** Kaster terningen én gang og oppdaterer poengsummen. */
    public int kastTerningen() {
        int terningkast = terning.nextInt(6) + 1; // 1..6
        if (terningkast == 1) {
            sumPoeng = 0; // mister alt
        } else {
            sumPoeng += terningkast;
        }
        return terningkast;
    }

    /** Vinner når man passerer 100 poeng. Bruk >= 100 hvis "nå 100" skal gjelde. */
    public boolean erFerdig() {
        return sumPoeng > 100;
    }
}