import java.util.Scanner;
public class App {


    public static void main(String[] args) {
        EiendomRegister register = new EiendomRegister();
        Scanner sc = new Scanner(System.in);
        int valg = 1;
        EiendomRegister reg = new EiendomRegister();
        
        while (valg!=0) {
            System.out.println("----Meny----");
            System.out.println("0: Avslutt");
            System.out.println("1: Registrere eiendom");
            System.out.println("2: Skrive ut alle eiendommer som er registrert");
            System.out.println("3: Søke etter eiendom (kommunenr/gnr/bnr)");
            System.out.println("4: Gjennomsnitt areal av eiendommene i registeret");
            valg = sc.nextInt();
            switch(valg){
                case 1:
                System.out.print("Kommunenummer: ");
                int kommunenummer = sc.nextInt();
                sc.nextLine();
                System.out.print("Kommunenavn: ");
                String kommunenavn = sc.nextLine();
                System.out.print("Gårdsnummer (gnr): ");
                int gnr = sc.nextInt();
                sc.nextLine();
                System.out.print("Bruksnummer (bnr): ");
                int bnr = sc.nextInt();
                sc.nextLine();
                System.out.print("Bruksnavn (kan være tom): ");
                String bruksnavn = sc.nextLine();
                System.out.print("Areal (m2): ");
                double areal = sc.nextDouble();
                sc.nextLine();
                System.out.print("Eier: ");
                String eier = sc.nextLine();
                sc.nextLine();
                Eiendom e;
                if (eier.length()==0){
                    e = new Eiendom(kommunenummer, kommunenavn, gnr, bnr, areal, eier);
                }else{e = new Eiendom(kommunenummer, kommunenavn, gnr, bnr, bruksnavn, areal, eier);}
                reg.leggTilEiendom(e);
                    break;
                case 2:
                    break;
                case 3:
                System.out.println("kommunenr?");
                int kommunenr = sc.nextInt();
                sc.nextLine();
                System.out.println("gnr?");
                int Gnr = sc.nextInt();
                sc.nextLine();
                    break;
                case 4:
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        }
    }
}
