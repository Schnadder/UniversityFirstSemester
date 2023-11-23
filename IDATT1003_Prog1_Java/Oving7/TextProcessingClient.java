package Oving7;

public class TextProcessingClient {
    public static void main(String[] args){    


    String text = "Sander Sandvik Nessa! Hei Hei prøver æå";
    String text2 = "æøå";
    TextProcessing client = new TextProcessing(text2);


    System.out.println(client.wordCount());
    System.out.println(client.avrageLength());
    System.out.println(client.avragePerPeriod());
    System.out.println(client.replaceWord("Hei", "Hallo"));
    System.out.println(client.getText());
    System.out.println(client.getUppercaseText());
    
    
    



    }
}
