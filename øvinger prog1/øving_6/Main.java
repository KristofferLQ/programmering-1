public class Main {
    public static void main(String[] args) {
     double[][] aData = {
                {1, 2, 3},
                {4, 5, 6}
        };
        double[][] bData = {
                {7,  8,  9},
                {10, 11, 12}
        };
        double[][] cData = {
                {1, 4},
                {2, 5},
                {3, 6}
        };

        Matrise A = new Matrise(aData); // 2x3
        Matrise B = new Matrise(bData); // 2x3
        Matrise C = new Matrise(cData); // 3x2

        System.out.println("A:\n" + A);
        System.out.println("B:\n" + B);
        System.out.println("C:\n" + C);

        Matrise AplussB = A.add(B);
        System.out.println("A + B:\n" + (AplussB != null ? AplussB : "null (uforenlige dimensjoner)"));

        Matrise AxC = A.mult(C);
        System.out.println("A * C:\n" + (AxC != null ? AxC : "null (uforenlige dimensjoner)"));

        Matrise AT = A.transponer();
        System.out.println("A^T (transponert):\n" + AT);

       
        Matrise ugyldig = A.mult(B); 
        System.out.println("A * B:\n" + (ugyldig != null ? ugyldig : "null (uforenlige dimensjoner)"));
    }
}
