

public class countdown {
    static void countdown(int n){
        if(n>0){
            System.out.println(n+" sekunder");
            countdown(n-1);
        
        }    
    }
public static void main(String[] args) {
    countdown(5);
}
}
