package Oving7;

// Spørsmål: floats i avragePerPeriod og håndtering av ø


public class TextProcessing {
    private String text;
    private String[] words;
    private String[] periods;

    public TextProcessing(String text){
        this.text = text;
        this.words = text.split(" ");
        this.periods = text.split("[.!:?]"); 
        
        
    }

    public int wordCount(){
        return words.length;
    }

    public float avrageLength(){
        float length = 0;

        for (String word : words){
            word.replaceAll("[\\W]", "");
            length += word.length();
        }
        return length / words.length;
    }

    public float avragePerPeriod(){
        float wordCount = words.length; // Spør om alternativ måte
        return  wordCount / periods.length;
    }

    public String replaceWord(String target, String newWord){
        String output = text.replace(target, newWord);
        
        return output;
    }

    public String getText(){
        return text;
    }

    public String getUppercaseText(){
        return text.toUpperCase();
    }
}
