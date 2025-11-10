package øving_10;
import java.util.*;
public class TestMeny {
    


    public static void main(String[] args) {
        MenyRegister reg = new MenyRegister();

        // Registrer retter
        reg.registrerRett(new Rett("Tomatsuppe", "forrett", 79, "Kok tomater, løk, kraft..."));
        reg.registrerRett(new Rett("Cæsarsalat", "forrett", 109, "Salat, kylling, krutonger..."));
        reg.registrerRett(new Rett("Biff", "hovedrett", 259, "Stek biff, lag saus..."));
        reg.registrerRett(new Rett("Pasta Carbonara", "hovedrett", 189, "Pasta, egg, pancetta..."));
        reg.registrerRett(new Rett("Sjokoladefondant", "dessert", 119, "Smør, sjokolade, egg..."));
        reg.registrerRett(new Rett("Creme Brulee", "dessert", 115, "Fløte, vanilje, egg..."));

        
        System.out.println("\nFinn rett: 'Biff'");
        reg.finnRett("Biff").ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Fant ikke retten.")
        );

        System.out.println("\nRetter av type 'dessert':");
        for (Rett r : reg.finnRetterAvType("dessert")) {
            System.out.println("  - " + r);
        }

     
        Set<Rett> meny1Retter = new LinkedHashSet<>();
        reg.finnRett("Tomatsuppe").ifPresent(meny1Retter::add);
        reg.finnRett("Biff").ifPresent(meny1Retter::add);
        reg.finnRett("Sjokoladefondant").ifPresent(meny1Retter::add);
        reg.registrerMeny("Klassisk 3-retter", meny1Retter);

        Set<Rett> meny2Retter = new LinkedHashSet<>();
        reg.finnRett("Cæsarsalat").ifPresent(meny2Retter::add);
        reg.finnRett("Pasta Carbonara").ifPresent(meny2Retter::add);
        reg.finnRett("Creme Brulee").ifPresent(meny2Retter::add);
        reg.registrerMeny("Italiensk aften", meny2Retter);

        
        System.out.println("\nAlle menyer:");
        for (Meny m : reg.getAlleMenyer()) {
            System.out.println(m);
        }

        
        System.out.println("\nMenyer med totalpris mellom 400 og 520 kr:");
        for (Meny m : reg.finnMenyerInnenforPris(400, 520)) {
            System.out.printf("  * %s – totalt: %.2f kr%n", m.getNavn(), m.totalPris());
        }
    }
}


