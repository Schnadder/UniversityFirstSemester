package Oving7;

public final class NyString {
    private String text;
    public NyString(String text){
        this.text = text;
    }


    public String shorten(){
        String[] ordList = this.text.split(" ");
        String output = "";

        for (String ord : ordList){
            output += ord.charAt(0);
        }
        return output;
    }

    public String remove(String letter){
            String output = this.text.replaceAll(letter, "");
        return output;
    }

    public static void main(String[] args){

        String text = "Sander Sandvik Nessa";

        NyString nyString = new NyString(text);

        System.out.println(nyString.shorten());
        System.out.println(nyString.remove("e"));


    }
}
