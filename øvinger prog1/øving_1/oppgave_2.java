package øving_1;

public class oppgave_2 {
    public static void main(String[] args) {
        double timer = 2;
        double minutter = 45;
        double sekunder = 36;
        double total_tid = timer*60*60 + minutter*60 + sekunder;
        System.out.println(timer + " timer, "+ minutter+" minutter og "+ sekunder + " sekunder = "+ total_tid);
        }
}