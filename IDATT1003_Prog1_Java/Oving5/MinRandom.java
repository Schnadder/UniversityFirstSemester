import java.util.Random;

public class MinRandom {
    private Random generator = new Random();

    public int nesteHeltall(int nedre, int ovre){ // Inclusive, exclusive
        if (ovre <= nedre){
            throw new IllegalArgumentException("Ovre må være storre enn nedre");
        }
        int dif = ovre - nedre;
        int output = generator.nextInt(dif) + nedre;

        // int output = generator.nextInt(nedre, ovre);
        return output;
    }

    // Don't think it matters as the probability of hitting the bound is about 2^54
    public double nesteDesimaltall(double nedre, double ovre){ // Inlcusive, exclusive
        if (ovre <= nedre){
            throw new IllegalArgumentException("Ovre må være storre enn nedre");
        }
        double dif = ovre - nedre;
        double output = generator.nextDouble(dif) + nedre;
        return output;
    }

    public static void main(String args[]){ // Testing
        MinRandom driver = new MinRandom();

        int a = driver.nesteHeltall(2, 4);
        double b = driver.nesteDesimaltall(2, 4);
        System.out.println(a);
        System.out.println(b);
    }
}
