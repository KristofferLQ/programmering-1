package øving_7;

public class TestNyString {
    public static void main(String[] args) {
        NyString s = new NyString("denne setningen kan forkortes");

        System.out.println("Original: " + s.getTekst());
        System.out.println("Forkortet: " + s.forkort());
        System.out.println("Uten 'e': " + s.fjernTegn('e'));
    }
}
