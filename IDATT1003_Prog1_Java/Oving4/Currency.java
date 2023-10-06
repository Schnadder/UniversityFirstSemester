package Oving4;

public class Currency {
    private double conversion; // Amount per nok


    public Currency(double conversion){
        this.conversion = conversion;
    }

    public double toNok(double amount){
        return amount * conversion;
    }

    public double fromNok(double amount){
        return amount / conversion;
    }
}
