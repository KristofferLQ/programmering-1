package øving_3;
import java.util.Scanner;
public class oppgave_1{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int x = sc.nextInt();
        Scanner stopp= new Scanner(System.in);
        int y = stopp.nextInt()+1;

        for (int i=x; i<y;i++){
            System.out.println();
            System.out.println(i+" gangen:");
        
            for (int j=1; j < 11; j++)
            System.out.println(i+" x "+j+ " = "+j*i);
        }
      

    }
}