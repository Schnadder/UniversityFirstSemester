package Oving11;

import java.util.List;
import java.util.Scanner;

/**
 * The UserInterface class provides a console-based user interface for managing property information.
 */
public class UserInterface {
  // Constants representing the different menu choices
  private final static int ADD_PROPERTY = 1;
  private final static int LIST_ALL_PROPERTIES = 2;
  private final static int FIND_PROPERTY = 3;
  private final static int CALCULATE_AVERAGE_AREA = 4;
  private final static int EXIT = 9;
  
  
  /**
  * Starts the application. This is the main loop of the application,
  * presenting the menu, retrieving the selected menu choice from the user,
  * and executing the selected functionality.
  *
  * @param args Command line arguments (not used).
  */
  public static void main(String[] args) {
    PropertyRegister register = init();
    Scanner scanner = new Scanner(System.in);
    
    // The while-loop will run as long as the user has not selected
    // to quit the application
    while (true) {
      inputQuestion();

      if (scanner.hasNextInt()){
        int menuChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (menuChoice) {
          case ADD_PROPERTY:
            addProperty(register, scanner);
            break;
          case LIST_ALL_PROPERTIES:
            printPropertyList(register.getProperties());
            break;
          case FIND_PROPERTY:
            findProperty(register, scanner);
            break;
          case CALCULATE_AVERAGE_AREA:
            calculateAverageArea(register);
            break;
          case EXIT:
            System.out.println("Thank you for using the Properties app!\n");
            scanner.close();
            System.exit(0);

          default:
          System.out.println("Unrecognized menu selected..");
          break;
        }
      }
      else {
        scanner.nextLine();
        System.out.println("Please enter an integer");
      }
    }
  }

  /**
  * Prints the main menu question to the user.
  */
  private static void inputQuestion()
  {
    System.out.println("\n***** Property Register Application *****\n");
    System.out.println("1. Add property");
    System.out.println("2. List all properties");
    System.out.println("3. Search property");
    System.out.println("4. Calculate average area");
    //TODO: Add more menus
    System.out.println("9. Quit");
    System.out.println("\nPlease enter a number between 1 and 9.\n");
  }

  
  /**
   * Prints a list of properties.
   *
   * @param properties The list of properties to be printed.
   */
  public static void printPropertyList(List <Property> properties){
    for (Property property : properties){
      System.out.println(property.toString() + "\n");
    }

  }

  /**
   * Initializes the PropertyRegister with pre-defined properties.
   *
   * @return The initialized PropertyRegister.
   */
  private static PropertyRegister init(){
    PropertyRegister register = new PropertyRegister();
    Property eiendom1 = new Property(1445, "Gloppen", 77, 631, 1017.6, "Jens Olsen");
    Property eiendom2 = new Property(1445, "Gloppen", 77, 131, "Syningom", 661.3, "Nicolay Madsen");
    Property eiendom3 = new Property(1445, "Gloppen", 75, 19, "Fudletun", 650.6, "Evilyn Jensen");
    Property eiendom4 = new Property(1445, "Gloppen", 74, 188, 1457.2, "Karl Ove Bråten");
    Property eiendom5 = new Property(1445, "Gloppen", 69, 47, "Høiberg", 1339.4, "Elsa Indregård");
  
    register.addProperty(eiendom1);
    register.addProperty(eiendom2);
    register.addProperty(eiendom3);
    register.addProperty(eiendom4);
    register.addProperty(eiendom5);

    return register;
  }

  /**
   * Adds a new property to the PropertyRegister using user input from the console.
   *
   * @param register The PropertyRegister instance to which the property will be added.
   * @param scanner  The Scanner object for user input.
   */
  private static void addProperty(PropertyRegister register, Scanner scanner) {
    System.out.println("Adding a new property:");

    int municipalityNumber = 0, lotNumber = 0, sectionNumber = 0;
    double area = 0;
    String municipalityName = "", name = "", nameOfOwner = "";

    while (true) {
        System.out.print("Enter municipality number: ");
        if (scanner.hasNextInt()) {
          municipalityNumber = scanner.nextInt();
          scanner.nextLine(); // Consume newline
          if (municipalityNumber >= 101 && municipalityNumber <= 5045) {
            break;
          }
          else {
            System.out.println("Muncipality number has to be between 101 and 5054");
          }
        } 
        else {
          System.out.println("Invalid input for municipality number. Please enter a valid integer.");
          scanner.nextLine(); // Consume invalid input
        }
    }

    System.out.print("Enter municipality name: ");
    municipalityName = scanner.nextLine();

    while (true) {
        System.out.print("Enter lot number: ");
        if (scanner.hasNextInt()) {
            lotNumber = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            break;
        } else {
            System.out.println("Invalid input for lot number. Please enter a valid integer.");
            scanner.nextLine(); // Consume invalid input
        }
    }

    while (true) {
        System.out.print("Enter section number: ");
        if (scanner.hasNextInt()) {
            sectionNumber = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            break;
        } else {
            System.out.println("Invalid input for section number. Please enter a valid integer.");
            scanner.nextLine(); // Consume invalid input
        }
    }

    System.out.print("Enter property name (if any): ");
    name = scanner.nextLine();

    while (true) {
        System.out.print("Enter area: ");
        if (scanner.hasNextDouble()) {
            area = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            break;
        } else {
            System.out.println("Invalid input for area. Please enter a valid number.");
            scanner.nextLine(); // Consume invalid input
        }
    }

    System.out.print("Enter name of owner: ");
    nameOfOwner = scanner.nextLine();

    Property property;
    if (!name.isEmpty()) {
        property = new Property(municipalityNumber, municipalityName, lotNumber, sectionNumber, name, area, nameOfOwner);
    } else {
        property = new Property(municipalityNumber, municipalityName, lotNumber, sectionNumber, area, nameOfOwner);
    }

    register.addProperty(property);
    System.out.println("Property added successfully.");
  }

  /**
   * Finds and displays the property information based on the municipality number, lot number, and section number entered by the user.
   *
   * @param register The PropertyRegister to search for the property.
   * @param scanner  The Scanner object for user input.
   */
  private static void findProperty(PropertyRegister register, Scanner scanner) {
    int municipalityNumber = 0, lotNumber = 0, sectionNumber = 0;

    while (true) {
      System.out.print("Enter municipality number: ");
      if (scanner.hasNextInt()) {
        municipalityNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        break;
      } 
      else {
        System.out.println("Invalid input for municipality number. Please enter a valid integer.");
        scanner.nextLine(); // Consume invalid input
      }
    }

    while (true) {
      System.out.print("Enter lot number: ");
      if (scanner.hasNextInt()) {
        lotNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        break;
      } 
      else {
        System.out.println("Invalid input for lot number. Please enter a valid integer.");
        scanner.nextLine(); // Consume invalid input
      }
    }


    while (true) {
      System.out.print("Enter section number: ");
      if (scanner.hasNextInt()) {
        sectionNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        break;
      } 
      else {
        System.out.println("Invalid input for section number. Please enter a valid integer.");
        scanner.nextLine(); // Consume invalid input
      }
    }
    Property found = register.findProperty(municipalityNumber, lotNumber, sectionNumber);
    if (found == null){
      System.out.println("Property not found");
    }
    else {
      System.out.println(found.toString());
      
    }
  }

  /**
   * Calculates and prints the average area of all properties in the PropertyRegister.
   *
   * @param register The PropertyRegister instance used to calculate the average area.
   */
  private static void calculateAverageArea(PropertyRegister register) {
    System.out.println("Avrage area is: " + register.getArea());
  }

}
