package Oving4;

// Can be improved by implementing exception handeling, feks. checking for valid inputs

public class CurrencyClient {
    public static void main(String[] args){
        double USDValue = 10.66;
        double EURValue = 11.49;
        double SEKValue = 0.97;
        
        Currency USD = new Currency(USDValue);
        Currency EUR = new Currency(EURValue);
        Currency SEK = new Currency(SEKValue);
        Currency[] listCurrency = {USD, EUR, SEK};

        int inputCurrency;
        boolean toNok;
        double amount;
        double outputAmount;
        boolean repeat = true;
        String outputStringCurrency = "\n\nVelg valuta: \n1: dollar \n2: euro \n3: svenske kroner  \n4: avslutt\n";
        String outputStringNok = "\nTil eller fra Norske kroner: \n1: Til Norske Kroner \n2: Fra norske kroner\n";
        String outputStringAmount = "Hvor mye vil du konvertere: ";

        do{
            // Ask user for wich currency or quit
            inputCurrency = Integer.parseInt(System.console().readLine(outputStringCurrency));
            if (inputCurrency == 4){
                repeat = false;
                break;
            }

            // Ask user if to or from NOK
            int inputToNok = Integer.parseInt(System.console().readLine(outputStringNok));
            if (inputToNok == 1){
                toNok = true;
            }
            else if (inputToNok == 2){
                toNok = false;
            }
            else{
                repeat = false;
                break;
            }
            
            // Ask user for amount
            amount = Double.parseDouble(System.console().readLine(outputStringAmount));
            

            if (toNok){
                outputAmount = listCurrency[inputCurrency - 1].toNok(amount);
            }
            else{
                outputAmount = listCurrency[inputCurrency - 1].fromNok(amount);
            }
            System.out.printf("%s", outputAmount);

        }
        // Repeat
        while (repeat);


    }
}