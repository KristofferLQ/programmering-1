

public class fortsetter {
    static int multiplikasjon(int x,int y){
        return (x*y);}
    static double multiplikasjon(double x,double y){
        return (x*y);
    }
    public static void main(String[] args) {
        for(int i=1;i<=5;i++){
             System.out.println(multiplikasjon(5,i));
        
        }
        for(double i=1;i<=3;i=i+0.5){
            System.out.println(multiplikasjon(5.43,i));
        }
    }
}
