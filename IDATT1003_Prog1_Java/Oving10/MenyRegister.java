package Oving10;
import java.util.ArrayList;
import java.util.List;

public class MenyRegister {
    List<Rett> retter = new ArrayList<>();
    List<Meny> menyer = new ArrayList<>();

    
    public MenyRegister() {
    }

    public MenyRegister(List<Rett> retter, List<Meny> menyer) {
        this.retter = retter;
        this.menyer = menyer;
    }

    public void nyRett(String navn, String type, double pris, String oppskrift){
        retter.add(new Rett(navn, type, pris, oppskrift));
    }

    public void nyRett(Rett nyrett){
        retter.add(nyrett);
    }

    public Rett finnRett(String navn){
        for (Rett rett : retter){
            if(rett.getNavn().equals(navn)){
                return rett;
            }
        }
        return null;
    }

    public List<Rett> finnRetterType(String type){
        List<Rett> output = new ArrayList<>();
        for (Rett rett: retter){
            if(rett.getType().equals(type)){
                output.add(rett);
            }
        }
        return output;
    }

    public void nyMeny(List<Rett> listeRetter){
        menyer.add(new Meny(listeRetter));
    }

    public void nyMeny(Meny nyMeny){
        menyer.add(nyMeny);
    }

    public List<Meny> finnMenyerPrisMellom(double minPris, double maxPris){
        List<Meny> output = new ArrayList<>();

        for (Meny meny : menyer){
            double pris = meny.totalPris();
            if (pris >= minPris && pris <= maxPris){
                output.add(meny);
            }
        }
        return output;
    }

}
