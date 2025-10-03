package øving_3;
import java.util.Scanner;
public class oppgave_2 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int x =sc.nextInt();
    Boolean primtall = true;
    if(x<2){
        primtall = false;
    }
    else if (x==2){
        primtall = true;
    }
    else {
        for (int i=2; i<Math.sqrt(x)+1; i++){
         if (x%i==0){ 
           primtall = false;
           
        }
    }}
    if (primtall){
        System.out.println(x+" er et primtall");
    }
    else{
        System.out.println(x+" er ikke et primtall");
    }
    }
    }

