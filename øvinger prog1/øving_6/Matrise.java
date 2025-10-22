import java.util.Arrays;

public final class Matrise {
    private final int rader;
    private final int kolonner;
    private final double[][] data;

    public Matrise(double[][] data) {
        if (data == null || data.length == 0 || data[0].length == 0) {
            throw new IllegalArgumentException("Tom eller null-tabell er ikke tillatt.");
        }
        this.rader = data.length;
        this.kolonner = data[0].length;
        
        for (double[] rad : data) {
            if (rad.length != this.kolonner) {
                throw new IllegalArgumentException("Alle rader må ha samme lengde.");
            }
        }
       
        this.data = new double[rader][kolonner];
        for (int i = 0; i < rader; i++) {
            System.arraycopy(data[i], 0, this.data[i], 0, kolonner);
        }
    }

    public int rader()    { return rader; }
    public int kolonner() { return kolonner; }

   
    public double hent(int rad, int kol) {
        if (rad < 0 || rad >= rader || kol < 0 || kol >= kolonner) {
            throw new IndexOutOfBoundsException("Ugyldig indeks.");
        }
        return data[rad][kol];
    }

    
    public Matrise add(Matrise annen) {
        if (annen == null || annen.rader != this.rader || annen.kolonner != this.kolonner) {
            return null;
        }
        double[][] resultat = new double[rader][kolonner];
        for (int i = 0; i < rader; i++) {
            for (int j = 0; j < kolonner; j++) {
                resultat[i][j] = this.data[i][j] + annen.data[i][j];
            }
        }
        return new Matrise(resultat);
    }

    
    public Matrise mult(Matrise annen) {
        if (annen == null || this.kolonner != annen.rader) {
            return null;
        }
        double[][] resultat = new double[this.rader][annen.kolonner];
        for (int i = 0; i < this.rader; i++) {
            for (int j = 0; j < annen.kolonner; j++) {
                double sum = 0.0;
                for (int k = 0; k < this.kolonner; k++) {
                    sum += this.data[i][k] * annen.data[k][j];
                }
                resultat[i][j] = sum;
            }
        }
        return new Matrise(resultat);
    }

    
    public Matrise transponer() {
        double[][] resultat = new double[kolonner][rader];
        for (int i = 0; i < rader; i++) {
            for (int j = 0; j < kolonner; j++) {
                resultat[j][i] = data[i][j];
            }
        }
        return new Matrise(resultat);
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (double[] rad : data) {
            sb.append("[ ");
            for (int j = 0; j < rad.length; j++) {
                sb.append(String.format("%8.3f", rad[j]));
                if (j < rad.length - 1) sb.append(" ");
            }
            sb.append(" ]\n");
        }
        return sb.toString();
    }

    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Matrise)) return false;
        Matrise m = (Matrise) o;
        if (rader != m.rader || kolonner != m.kolonner) return false;
        for (int i = 0; i < rader; i++) {
            if (!Arrays.equals(this.data[i], m.data[i])) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int h = 1;
        h = 31 * h + rader;
        h = 31 * h + kolonner;
        for (double[] rad : data) {
            h = 31 * h + Arrays.hashCode(rad);
        }
        return h;
    }
}
