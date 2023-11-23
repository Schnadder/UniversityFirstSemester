package Oving10;

import java.util.List;

public class ResturantClient {
    public static void main(String args[]){
        Rett rett1 = new Rett("Spaghetti Bolognese", "hovedrett", 12.99, "Kok spaghetti og lag en saus med kjøttdeig, tomatsaus, løk og krydder.");
        Rett rett2 = new Rett("Caesar Salat", "forrett", 8.99, "En klassisk Caesar-salat med romainesalat, krutonger, parmesan og Caesar-dressing.");
        Rett rett3 = new Rett("Biff Stroganoff", "hovedrett", 19.99, "Strimle biff, stek med løk, sopp og fløte, krydre etter smak.");
        Rett rett4 = new Rett("Kylling Tikka Masala", "hovedrett", 16.99, "Mariner kylling i yoghurt og krydder, stek og server med en kremet tomatbasert saus.");
        Rett rett5 = new Rett("Sushi Ruller", "forrett", 24.99, "Lag sushi-ruller med fersk fisk, ris, tang og grønnsaker, servert med soyasaus og ingefær.");
        Rett rett6 = new Rett("Gulrotsuppe", "forrett", 6.99, "Kok gulrøtter til møre, purér dem og tilsett krydder og fløte for en deilig suppe.");
        
        Meny meny1 = new Meny(List.of(rett1, rett2, rett3));
        Meny meny2 = new Meny(List.of(rett4, rett5, rett6));
        Meny meny3 = new Meny(List.of(rett2, rett4, rett6));
        Meny meny4 = new Meny(List.of(rett1, rett3, rett5));

        MenyRegister register = new MenyRegister();
        register.nyRett(rett1);
        register.nyRett(rett2);
        register.nyRett(rett3);
        register.nyRett(rett4);
        register.nyRett(rett5);
        register.nyRett(rett6);

        register.nyMeny(meny1);
        register.nyMeny(meny2);
        register.nyMeny(meny3);
        register.nyMeny(meny4);

        Rett Gulrotsuppe = register.finnRett("Gulrotsuppe");
        Rett finnesIkke = register.finnRett("test");
        System.out.print(Gulrotsuppe);
        System.out.println(finnesIkke);
        System.out.println();

        printRetter(register.finnRetterType("hovedrett"));

        printMenyer(register.finnMenyerPrisMellom(0, 40));

    }

    private static void printRetter(List<Rett> retter){
        String output = "Retter:\n";

        for (Rett rett : retter){
            output += rett.toString();
            output += "\n";
        }
        System.out.print(output);
    }

    private static void printMenyer(List<Meny> menyer){
        String output = "Menyer:\n";

        for (Meny meny : menyer){
            output += meny.toString();
            output += "\n";
        }
        System.out.print(output);
    }
}
