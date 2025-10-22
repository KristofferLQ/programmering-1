
import java.util.Scanner;

public class Tekstanalyse {
int[] antallTegn = new int[30];
String tekst;
   // Konstruktøren teller for hele teksten 
 public Tekstanalyse(String tekst) {
        if (tekst == null) tekst = "";
        for (int i = 0; i < tekst.length(); i++) {
            antallTegn[idx(tekst.charAt(i))]++;
        }
    }
static int idx(char ch) {
        ch = Character.toLowerCase(ch);
        if (ch >= 'a' && ch <= 'z') return ch - 'a';
        if (ch == 'æ') return 26;
        if (ch == 'ø') return 27;
        if (ch == 'å') return 28;
        return 29;
    }
int antallForskjelligeBokstaver() {
    int antall = 0;
    for (int i = 0; i <= 28; i++) {
        if (antallTegn[i] > 0) antall++;
    }
    return antall;
}
void AntallProsent(){
    double sumBoks = 0;
    for(int i =0;i<30;i++){
        sumBoks+= antallTegn[i];
        
    }
    double sumTegn = antallTegn[29];
    double prosent = (sumTegn/sumBoks)*100;
    System.out.println("Hvor mange prosent av teksten er ikke bokstaver: "+prosent+"%" );

}
int antallForekomstavBokstav(char bokstav){
    int i = idx(bokstav);
    if(i==29) return 0;
    return antallTegn[i];
}
int maksfrekvens(){
    int max=0;
    for(int i=0;i<=28;i++){
        if (antallTegn[i]>max){
            max=antallTegn[i];
        }
    
    }return max;
}
    static char tegnFraIdx(int i) {
        if (i >= 0 && i <= 25) return (char) ('a' + i);
        if (i == 26) return 'æ';
        if (i == 27) return 'ø';
        if (i == 28) return 'å';
        return '?';
    }
        

String bokstaverMedMaksFrekvens() {
    int max = maksfrekvens();

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i <= 28; i++) {
        if (antallTegn[i] == max) {
            if (sb.length() > 0) sb.append(", ");
            sb.append(tegnFraIdx(i));
        }
    }
    return sb.toString();
}
   
   
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
        System.out.println("Press 1 for å avbryte:");
        System.out.print("Skriv en tekst: ");
        String tekst = sc.nextLine();
        if (tekst.equals("1")) {
            break;
        }

        Tekstanalyse app = new Tekstanalyse(tekst);

        int sumBokstaver = 0;
        for (int i = 0; i < 29; i++) sumBokstaver += app.antallTegn[i];
   
        System.out.println("Tekstanalyse:");
        System.out.println("Totalt bokstaver: " + sumBokstaver);
        System.out.println("antallt ulike bokstaer: "+app.antallForskjelligeBokstaver());
        app.AntallProsent();

        System.out.print("Hvilken bokstav vil du telle? ");
            String inn = sc.nextLine();
            char b = inn.charAt(0);
            int ant = app.antallForekomstavBokstav(b);
            System.out.println("Forekomster av '" + b + "':" + ant);
        System.out.println("Bokstaven "+app.bokstaverMedMaksFrekvens()+"forkekommer oftest");
    
}
}
} 

