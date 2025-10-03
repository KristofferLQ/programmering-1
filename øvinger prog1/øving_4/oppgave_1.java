import java.util.Scanner;
public class oppgave_1 {
    
    
    public static class Valuta{
        private final String valuta;
        private final double rate;
        
        public Valuta(String valuta, double rate){
            this.valuta=valuta;
            this.rate=rate;
        }
    }
    public static void main(String[] args){ 
        System.out.println("1. Dollar");
        System.out.println("2. Euro");
        System.out.println("3. Svenkse kroner");
        System.out.println("4. Avslutt");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        Valuta dollar = new Valuta("Dollar", 9.77);
        Valuta euro = new Valuta("Euro",11.59);
        Valuta Sek = new Valuta("SEK",1.06);
        if(i==1){
            System.out.println("hva vil du veksle?");
            System.out.println("1. Dollar til Nok");
            System.out.println("2. Nok til Dollar");
            Scanner scan= new Scanner(System.in);
            int valg = scan.nextInt(); 
            if (valg == 2){
                System.out.println("hvor mye vil du veksle");
                Scanner veksel = new Scanner(System.in);
                double exchange=veksel.nextInt();
                double dik=exchange/dollar.rate;
                System.out.println("Det blir "+dik+dollar.valuta);}
            else{
                System.out.println("hvor mye vil du veksle");
                Scanner veksel = new Scanner(System.in);
                double exchange=veksel.nextInt();
                double dik=exchange*dollar.rate;
                System.out.println("Det blir "+dik+" Kroner");}}
        
        else if(i==2){
            System.out.println("hva vil du veksle?");
            System.out.println("1. Nok til Euro");
            System.out.println("2. Euro til Nok");
            Scanner scan= new Scanner(System.in);
            int valg = scan.nextInt(); 
            if (valg == 1){
                System.out.println("hvor mye vil du veksle");
                Scanner veksel = new Scanner(System.in);
                double exchange=veksel.nextInt();
                double eik=exchange/euro.rate;
                System.out.println("Det blir "+eik+euro.valuta);}
            else{System.out.println("hvor mye vil du veksle");
                Scanner veksel = new Scanner(System.in);
                double exchange=veksel.nextInt();
                double eik=exchange*euro.rate;
                System.out.println("Det blir "+eik+" Nok");}

        }
        else if(i==3){
            System.out.println("hva vil du veksle?");
            System.out.println("1. Nok til Sek");
            System.out.println("2. Sek til Nok");
            Scanner scan= new Scanner(System.in);
            int valg = scan.nextInt();
            if(valg==1){
                System.out.println("hvor mye vil du veksle");
                Scanner veksel = new Scanner(System.in);
                double exchange=veksel.nextInt();
                double sek=exchange/Sek.rate;
                System.out.println("Det blir "+sek+Sek.valuta);}
            else{
                System.out.println("hvor mye vil du veksle");
                Scanner veksel = new Scanner(System.in);
                double exchange=veksel.nextInt();
                double sek=exchange*Sek.rate;
                System.out.println("Det blir "+sek+" Nok");
            }

        }
        else{
            System.out.println("Ferdig");
            return;
        }
    }
}