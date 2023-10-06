

class Currency{
    // convert varaibles in form: from "usd" to "nok"
    double usdNok = 10.656900; 
    double usdSek = 11.005800; 
    double nokUsd = 1 / usdNok;
    double sekUsd = 1 / usdSek; 
    double nokSek = nokUsd * usdSek; 
    double sekNok = sekUsd * usdNok;

}

class Nok extends Currency{
    public double nokToUsd(double amount){
        double value = amount * super.nokUsd;

        return value;
    }
    public double nokToSek(double amount){
        double value = amount * super.nokSek;
        return value;
    }
}

class Sek extends Currency{
    public double sekToUsd(double amount){
        double value = amount * super.sekUsd;

        return value;
    }
    public double sekToNok(double amount){
        double value = amount * super.sekNok;
        return value;
    }
}

class Usd extends Currency{
    public double usdToNok(double amount){
        double value = amount * super.usdNok;

        return value;
    }
    public double usdToSek(double amount){
        double value = amount * super.usdSek;
        return value;
    }
}
    


public class CurrencyConverterOutdated {
 
    public static void main(String[] args){
        Nok nokConverter = new Nok();
        double output = nokConverter.nokToSek(10);
        System.out.println(output);
        
    }

    

}