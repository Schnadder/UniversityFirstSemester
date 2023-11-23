package Oving10;

import java.util.ArrayList;
import java.util.List;

public class Meny {
    private List<Rett> retter;

    public Meny() {
      retter = new ArrayList<>();
    }

    public Meny(List<Rett> retter) {
        this.retter = retter;
    }

    public List<Rett> getRetter() {
        return retter;
    }

    public double totalPris(){
        double sum = 0;

        for(Rett rett : retter){
            sum += rett.getPris();
        }
        return sum;
    }

    @Override
    public String toString() {
        String output = "Meny:\n";

        for (Rett rett : retter){
            output += rett.toString();
        }
        return output;
    }
}
