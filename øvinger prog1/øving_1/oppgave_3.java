package øving_1;
public class oppgave_3 {
    public static void main(String[] args) {
        int sekunder=7003;
        int timer = sekunder/(60*60);
        int minutter = sekunder/60 % 60;
        int sekunder_2= sekunder - timer*60*60 - minutter *60;

        System.out.println(sekunder+" sekunder = "+timer+ " timer, "+minutter + " minutter "+"og "+ sekunder_2 + " sekunder");
        }
}
