class KlasseTekstAnalyse {
    private int[]= new int[30];
    private String tekst;
    public KlasseTekstAnalyse(String tekst){
        this.tekst=tekst;
    }
    public void analyserTekst(){
        for(int i=0;i<tekst.length();i++){
            char c = tekst.charAt(i);
        
            if(c>='a' && c<='z'){
                int index = c - 'a';
                antall[index]++;
            } else if(c>='A' && c<='Z'){
                int index = c - 'A';
                antall[index]++;
            }
        }
    }
    public void skrivUtAntall(){
        for(int i=0;i<26;i++){
            char bokstav = (char)('a' + i);}
        } 
   

    public static void main(String[] args) {
        String tekst = "Dette er en eksempeltekst for å analysere bokstaver!";
        KlasseTekstAnalyse analyse = new KlasseTekstAnalyse(tekst);
        analyse.analyserTekst();
        analyse.skrivUtAntall();
        System.out.println("Bokstaven " + bokstav + " forekommer " + antall[i] + " ganger");
    }
}
  
