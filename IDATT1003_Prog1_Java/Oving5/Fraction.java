public class Fraction {
    private int teller;
    private int nevner;

    public Fraction(int teller, int nevner){
        if (nevner == 0){
            throw new IllegalArgumentException("Test");
        }
        this.nevner = nevner;
        this.teller = teller;
    }

    public Fraction(int teller){
        this.teller = teller;
        this.nevner = 1;
    }

    public int getTeller(){
        shorten();
        return teller;
    }
    
    public int getNevner(){
        shorten();
        return nevner;
    }

    public String getFraction(){
        shorten();
        return String.format("%s / %s", teller, nevner);
    }

    public void summere(Fraction inputFraction){
        this.teller = this.teller * inputFraction.nevner + inputFraction.teller*this.nevner;
        this.nevner = this.nevner * inputFraction.nevner;
    }
    public void subtrahere(Fraction inputFraction){
        this.teller = this.teller * inputFraction.nevner - inputFraction.teller*this.nevner;
        this.nevner = this.nevner * inputFraction.nevner;
    }
    public void multiplisere(Fraction inputFraction){
        this.teller = this.teller * inputFraction.teller;
        this.nevner = this.nevner * inputFraction.nevner;
    }
    public void dividere(Fraction inputFraction){
        this.teller = this.teller * inputFraction.nevner;
        this.nevner = this.nevner * inputFraction.teller;

    }

    private int gcd(int a, int b){ //GCD Euclidean Algortihm
        if (a == 0){
            return b;
        }
        return gcd(b % a, a);
    }

    private void shorten(){
        int num = gcd(this.teller, this.nevner);
        this.teller = this.teller / num;
        this.nevner = this.nevner / num;
    }

    public static void main(String[] args){ // Testing
        Fraction testFraction = new Fraction(3, 4);
        int testTeller = 2;
        int testNevner = 3;
        Fraction inputFraction = new Fraction(testTeller, testNevner);
        

        System.out.println(testFraction.getFraction());
        testFraction.summere(inputFraction);
        System.out.println(testFraction.getFraction());
        testFraction.subtrahere(inputFraction);
        System.out.println(testFraction.getFraction());
        testFraction.multiplisere(inputFraction);
        System.out.println(testFraction.getFraction());
        testFraction.dividere(inputFraction);
        System.out.println(testFraction.getFraction());


    }
}
