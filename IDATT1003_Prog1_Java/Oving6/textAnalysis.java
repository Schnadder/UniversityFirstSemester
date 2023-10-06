package Oving6;

public class textAnalysis { // Only works for a-z and A-Z, æøå counts as special chars
    private int counter[] = new int[30];
    private int A = 65; // ASCI Value of A
    private int length;

    public textAnalysis(String text){
        
        text = text.toUpperCase();
        this.length = text.length();
        for (int i = 0; i < text.length(); i++){

            int s = (int) text.charAt(i) - A;
            

            if (s <= 28 && s >= 0){
                this.counter[s]++;
            }
            else{
                this.counter[29]++;
            }
        }
    }
    
    public int different(){
        int nums = 0; //Counter for amount of different letters
        
        for (int i = 0; i < this.counter.length - 1; i++){
            if (this.counter[i] != 0){
                nums++;
            }
        }
        return nums;
    }

    public int amount(){
        return this.length - this.counter[29];
    }

    public double notLetter(){      
        return (double) this.counter[29] / this.length * 100; // Returns as a percentage
    }

    public int count(char letter){
        if (letter >= 65 && letter <= 90){ // Upper case
            return this.counter[letter - 65];
        }
        if (letter >= 97 && letter <= 122){ // Lower case
            return this.counter[letter - 97];
        }
        else{
            throw new IllegalArgumentException("Must be a letter a-z, or A-Z");
        }
    }

    public String mostCommon(){
        String output = "";
        int largest = -1;

        for (int i = 0; i < 29; i++){
            if (this.counter[i] > largest){
                largest = this.counter[i];
                output = String.valueOf((char) (i + 65));

            }
            else if (this.counter[i] == largest){
                output += String.valueOf((char) (i + 65));
            }
        }
        return output;
    }

    public int[] testing(){

        return this.counter;
    }
}
