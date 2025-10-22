class main{
String name;
int age;

public main(String name, int age){
    this.name = name;   
    this.age = age;
}

void introduksjon(){
    System.out.println("Dette er "+name+" og er "+age+ " år gammel.");
}
int getage(){return age;}
}
class penger{
double startkapital;
double rente;
int age;
public penger(double startkapital, double rente, int age){
    this.startkapital=startkapital;
    this.rente=rente;
    this.age=age;
}
double spenn(){
    return startkapital*Math.pow(rente,age);
 
}
}
public class test {
public static void main(String[] args) {
    main p = new main("kristoffer", 19);
    p.introduksjon();
    penger q = new penger(1000,1.05,p.getage());
    System.out.println(q.spenn());


}
}


