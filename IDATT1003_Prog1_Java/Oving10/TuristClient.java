package Oving10;
import java.util.Scanner;

public class TuristClient {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        ArrangementRegister register = new ArrangementRegister();
        
        Arrangement arrangement1 = new Arrangement(1, "Konsert i parken", "Parken", "Live Events AS", "Konsert", 202210301600L);
        Arrangement arrangement2 = new Arrangement(2, "Teaterforestilling", "Teaterhuset", "Dramatikkteateret", "Teater", 202310101600L);
        Arrangement arrangement3 = new Arrangement(3, "Idrettskonkurranse", "Idrettsarenaen", "Sportsforeningen", "Idrett", 202310281600L);
        Arrangement arrangement4 = new Arrangement(4, "Ballettopptreden", "Teaterhuset", "Ballettforeningen", "Dans", 202310241900L);
        Arrangement arrangement5 = new Arrangement(5, "Rockekonsert", "Rock Arena", "Live Events AS", "Konsert", 202310301600L);
        Arrangement arrangement6 = new Arrangement(6, "Jazzfestival", "Jazzklubben", "Musikkforeningen", "Musikkfestival", 202310101600L);

        register.registrerArangement(arrangement1);
        register.registrerArangement(arrangement2);
        register.registrerArangement(arrangement3);
        register.registrerArangement(arrangement4);
        register.registrerArangement(arrangement5);
        register.registrerArangement(arrangement6);

        while(true){
            inputQuestion();

            int valg = scanner.nextInt();
            scanner.nextLine();


            switch(valg){
                case 1:
                    leggTilArrangement(register, scanner);
                    break;
                case 2:
                    finnArrangementerPåSted(register, scanner);
                    break;
                case 3:
                    finnArrangementerPåDato(register, scanner);
                    break;
                case 4:
                    finnArrangementerMellomDatoer(register, scanner);
                    break;
                case 5:
                    register = register.sorterPåTid();
                    System.out.println("Arrangementer sortert på tid:");
                    System.out.println(register);
                    break;
                case 6:
                    register = register.sorterPåSted();
                    System.out.println("Arrangementer sortert på sted:");
                    System.out.println(register);
                    break;
                case 7:
                    register = register.sorterPåType();
                    System.out.println("Arrangementer sortert på type:");
                    System.out.println(register);
                    break;
                case 8:
                    System.out.println("Avslutter programmet.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Ugyldig valg. Prøv igjen.");
                    break;
            }
        }
    }

    private static void inputQuestion(){
        System.out.println("Velg en handling:");
        System.out.println("1. Legg til et arrangement");
        System.out.println("2. Finn arrangementer på sted");
        System.out.println("3. Finn arrangementer på dato");
        System.out.println("4. Finn arrangementer mellom datoer");
        System.out.println("5. Sorter arrangementer på tid");
        System.out.println("6. Sorter arrangementer på sted");
        System.out.println("7. Sorter arrangementer på type");
        System.out.println("8. Avslutt");
    }

    private static void leggTilArrangement(ArrangementRegister register, Scanner scanner) {
        System.out.println("Legg til et arrangement:");
        int nummer;

        while (true) {
            System.out.print("Nummer: ");
            if (scanner.hasNextInt()) {
                nummer = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                if (!register.doesNumberExist(nummer)) {
                    break; 
                } 
                else {
                    System.out.println("Nummeret eksisterer allerede. Prøv igjen.");
                }
            } 
            else {
                System.out.println("Ugyldig nummer. Vennligst oppgi et unikt tall.");
                scanner.nextLine();
            }
        }

        System.out.print("Navn: ");
        String navn = scanner.nextLine();
        System.out.print("Sted: ");
        String sted = scanner.nextLine();
        System.out.print("Arrangør: ");
        String arrangør = scanner.nextLine();
        System.out.print("Type: ");
        String type = scanner.nextLine();

        long tidspunkt;

        while (true) {
            System.out.print("Tidspunkt (yyyymmddhhmm): ");
            if (scanner.hasNextLong()) {
                tidspunkt = scanner.nextLong();
                scanner.nextLine();
                if(Long.toString(tidspunkt).length() != 12){
                    System.out.println("Ugyldig tidspunkt må være på formen (yyyymmddhhmm):");
                    scanner.nextLine();
                }
                else{
                    break;
                }
            } 
            else {
                System.out.println("Ugyldig tidspunkt. Vennligst oppgi en gyldig dato og tid.");
                scanner.nextLine();
            }
        }

        Arrangement arrangement = new Arrangement(nummer, navn, sted, arrangør, type, tidspunkt);
        register.registrerArangement(arrangement);
        System.out.println("Arrangement lagt til.");
    }

    private static void finnArrangementerPåSted(ArrangementRegister register, Scanner scanner) {
        while (true) {
            System.out.print("Skriv inn sted: ");
            String sted = scanner.nextLine();
    
            if (sted.length() > 0) {
                ArrangementRegister result = register.finnArrangementerPåSted(sted);
                System.out.println("Arrangementer på sted " + sted + ":");
                System.out.println(result);
                break;
            } 
            else {
                System.out.println("Ugyldig inndata. Prøv igjen.");
            }
        }
    }

    private static void finnArrangementerPåDato(ArrangementRegister register, Scanner scanner) {
        while (true) {
            System.out.print("Skriv inn dato (yyyymmdd): ");
            String dato = scanner.nextLine();
    
            if (dato.matches("^\\d{8}$")) { // Clean way to check if dato is exactly 8 digits
                ArrangementRegister result = register.finnArrangementerPåDato(dato);
                System.out.println("Arrangementer på dato " + dato + ":");
                System.out.println(result);
                break;
            } 
            else {
                System.out.println("Ugyldig datoformat. Prøv igjen.");
            }
        }
    }

    private static void finnArrangementerMellomDatoer(ArrangementRegister register, Scanner scanner) {
        long startDato;
        long sluttDato;
    
        while (true) {
            System.out.print("Skriv inn startdato (yyyymmdd): ");
            String start = scanner.nextLine();
    
            if (start.matches("^\\d{8}$")) {
                startDato = Long.parseLong(start);
    
                System.out.print("Skriv inn sluttdato (yyyymmdd): ");
                String slutt = scanner.nextLine();
    
                if (slutt.matches("^\\d{8}$")) {
                    sluttDato = Long.parseLong(slutt);
    
                    if (startDato <= sluttDato) {
                        ArrangementRegister result = register.finnArrangementerMellomDatoer(startDato, sluttDato);
                        System.out.println("Arrangementer mellom " + startDato + " og " + sluttDato + ":");
                        System.out.println(result);
                        break;
                    } 
                    else {
                        System.out.println("Startdato må være før eller lik sluttdato. Prøv igjen.");
                    }
                } 
                else {
                    System.out.println("Ugyldig sluttdatoformat. Prøv igjen.");
                }
            } 
            else {
                System.out.println("Ugyldig startdatoformat. Prøv igjen.");
            }
        }
    }
}
