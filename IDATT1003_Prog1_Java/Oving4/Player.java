package Oving4;

import java.util.Random;

public class Player {
    int sumPoeng = 0;
    Random terning = new Random();
    
    public void getSumPoeng(int kast){ 
        if (kast == 1){
            sumPoeng = 0;
        }
        if (sumPoeng > 100){
            sumPoeng -= kast;
        }
        else{
            sumPoeng += kast;
        }   
    }

    public int kastTerningen(){   
        return terning.nextInt(6) + 1;
    }

    public boolean erFerdig(){
        if (sumPoeng == 100){
            return true;
        }
        return false;
    }
}
