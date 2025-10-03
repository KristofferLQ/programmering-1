package øving_5;

public class Brok {
    private int teller;
    private int nevner;

    public Brok(int teller, int nevner) {
        if (nevner == 0) throw new IllegalArgumentException("Nevner kan ikke være 0");
        this.teller = teller;
        this.nevner = nevner;
        normalize();
        reduce(); 
    }

    public Brok(int teller) { this(teller, 1); }

    public int getTeller() { return teller; }
    public int getNevner() { return nevner; }

    public void add(Brok b) {
        this.teller = this.teller * b.nevner + b.teller * this.nevner;
        this.nevner = this.nevner * b.nevner;
        normalize(); reduce();
    }

    public void sub(Brok b) {
        this.teller = this.teller * b.nevner - b.teller * this.nevner;
        this.nevner = this.nevner * b.nevner;
        normalize(); reduce();
    }

    public void mul(Brok b) {
        this.teller *= b.teller;
        this.nevner *= b.nevner;
        if (this.nevner == 0) throw new ArithmeticException("Ugyldig multiplikasjon (nevner ble 0)");
        normalize(); reduce();
    }

    public void div(Brok b) {
        if (b.teller == 0) throw new ArithmeticException("Kan ikke dividere med 0");
        this.teller *= b.nevner;
        this.nevner *= b.teller;
        normalize(); reduce();
    }

    private void normalize() {
        if (nevner < 0) { teller = -teller; nevner = -nevner; }
        if (teller == 0) { nevner = 1; } 
    }

    private void reduce() {
        int g = gcd(Math.abs(teller), Math.abs(nevner));
        if (g > 1) { teller /= g; nevner /= g; }
    }

    private static int gcd(int a, int b) {
        
        if (a == 0) return b == 0 ? 1 : b;
        while (b != 0) {
            int t = a % b;
            a = b; b = t;
        }
        return a;
    }

    @Override
    public String toString() {
        return (nevner == 1) ? Integer.toString(teller) : (teller + "/" + nevner);
    }

    public static void main(String[] args) {
        Brok a = new Brok(1, 2);
        Brok b = new Brok(3, 4);

        Brok c = new Brok(a.getTeller(), a.getNevner());
        c.add(b); System.out.println("a + b = " + c); 

        c = new Brok(a.getTeller(), a.getNevner());
        c.sub(b); System.out.println("a - b = " + c); 

        c = new Brok(a.getTeller(), a.getNevner());
        c.mul(b); System.out.println("a * b = " + c);

        c = new Brok(a.getTeller(), a.getNevner());
        c.div(b); System.out.println("a / b = " + c); 

        System.out.println(new Brok(0, 5));  
        System.out.println(new Brok(-2, -4));
        System.out.println(new Brok(2, -4));  
    }
}