package Oving10;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class ArrangementRegister {
    private List<Arrangement> arrangementer = new ArrayList<>();

    public void registrerArangement(Arrangement newAr){
        if(doesNumberExist(newAr.getNummer())){
            throw new IllegalArgumentException("Number has to be uniqe however the given number already exists in Register");
        }
        arrangementer.add(newAr);
    }

    public ArrangementRegister finnArrangementerPåSted(String sted){
        ArrangementRegister result = new ArrangementRegister();

        for (Arrangement arrangement : arrangementer){
            if(arrangement.getSted().equals(sted)){
                result.registrerArangement(arrangement);
            }
        }
        return result;
    }


    public ArrangementRegister finnArrangementerPåDato(String dato){
        ArrangementRegister result = new ArrangementRegister();
        for (Arrangement arrangement : arrangementer){
            String tidspunktStr = arrangement.strTidspunkt();
            String test = tidspunktStr.substring(0, 10);

            if(test.equals(dato)){
                result.registrerArangement(arrangement);
            }
        }
        return result;
    }

    
    public ArrangementRegister finnArrangementerMellomDatoer(long start, long slutt){
        ArrangementRegister result = new ArrangementRegister();
        for (Arrangement arrangement : arrangementer){
            long dato = arrangement.getTidspunkt() / 10000;

            if(dato >= start && dato <= slutt){
                result.registrerArangement(arrangement);
            }
        }


        return result.sorterPåTid();
    }
    


    public ArrangementRegister sorterPåTid(){
        ArrangementRegister sortertRegister = new ArrangementRegister();
        List<Arrangement> sortertArrangementer = new ArrayList<>(arrangementer);


        Collections.sort(sortertArrangementer, new Comparator<Arrangement>() {
            @Override
            public int compare(Arrangement a1, Arrangement a2){
                return Long.compare(a1.getTidspunkt(), a2.getTidspunkt());
            }
        });

        sortertRegister.arrangementer = sortertArrangementer;
        return sortertRegister;
    }

    public ArrangementRegister sorterPåSted(){
        ArrangementRegister sortertRegister = new ArrangementRegister();
        List<Arrangement> sortertArrangementer = new ArrayList<>(arrangementer);


        Collections.sort(sortertArrangementer, new Comparator<Arrangement>() {
            @Override
            public int compare(Arrangement a1, Arrangement a2){
                return a1.getSted().compareTo(a2.getSted());
            }
        });

        sortertRegister.arrangementer = sortertArrangementer;
        return sortertRegister;
    }

    public ArrangementRegister sorterPåType(){
        ArrangementRegister sortertRegister = new ArrangementRegister();
        List<Arrangement> sortertArrangementer = new ArrayList<>(arrangementer);
        
        Collections.sort(sortertArrangementer, new Comparator<Arrangement>() {
            @Override
            public int compare(Arrangement a1, Arrangement a2){
                return a1.getType().compareTo(a2.getType());
            }
        });

        sortertRegister.arrangementer = sortertArrangementer;
        return sortertRegister;
    }

    public boolean doesNumberExist(int number){
        for (Arrangement arrangement : arrangementer){
            if (arrangement.getNummer() == number){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String output = "Arrangementer: \n";
        for (Arrangement arrangement : arrangementer){
            output += arrangement.toString() + "\n";
        }
        return output;
    }

}
