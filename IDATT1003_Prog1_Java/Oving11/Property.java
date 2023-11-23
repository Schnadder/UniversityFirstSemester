package Oving11;

/**
 * The Property class represents a real estate property with various attributes.
 */
public class Property {
  private int muncipalityNumber;
  private String muncipalityName;
  private int lotNumber;
  private int sectionNumber;
  private String name;
  private double area;
  private String nameOfOwner;
  
  /**
   * Constructor for Property without a name.
   *
   * @param municipalityNumber The municipality number.
   * @param municipalityName The name of the municipality.
   * @param lotNumber The lot number.
   * @param sectionNumber The section number.
   * @param area The area of the property.
   * @param nameOfOwner The name of the owner.
   */
  public Property(int muncipalityNumber, String muncipalityName, int lotNumber, int sectionNumber, double area,
      String nameOfOwner) {
    this.muncipalityNumber = muncipalityNumber;
    this.muncipalityName = muncipalityName;
    this.lotNumber = lotNumber;
    this.sectionNumber = sectionNumber;
    this.area = area;
    this.nameOfOwner = nameOfOwner;
    this.name = "";
  }

  /**
   * Constructor for Property with a name.
   *
   * @param municipalityNumber The municipality number.
   * @param municipalityName The name of the municipality.
   * @param lotNumber The lot number.
   * @param sectionNumber The section number.
   * @param name The name of the property.
   * @param area The area of the property.
   * @param nameOfOwner The name of the owner.
   */
  public Property(int muncipalityNumber, String muncipalityName, int lotNumber, int sectionNumber, String name,
      double area, String nameOfOwner) {
    this.muncipalityNumber = muncipalityNumber;
    this.muncipalityName = muncipalityName;
    this.lotNumber = lotNumber;
    this.sectionNumber = sectionNumber;
    this.name = name;
    this.area = area;
    this.nameOfOwner = nameOfOwner;
  }

  /**
   * Getter for the municipality number.
   *
   * @return The municipality number.
   */
  public int getMuncipalityNumber() {
    return muncipalityNumber;
  }

  /**
   * Getter for the municipality name.
   *
   * @return The name of the municipality.
   */
  public String getMuncipalityName() {
    return muncipalityName;
  }

  /**
   * Getter for the lot number.
   *
   * @return The lot number.
   */
  public int getLotNumber() {
    return lotNumber;
  }

  /**
   * Getter for the section number.
   *
   * @return The section number.
   */
  public int getSectionNumber() {
    return sectionNumber;
  }

  /**
   * Getter for the property name.
   *
   * @return The name of the property.
   */
  public String getName() {
    return name;
  }

  /**
   * Getter for the area of the property.
   *
   * @return The area of the property.
   */
  public double getArea() {
    return area;
  }

  /**
   * Getter for the name of the owner.
   *
   * @return The name of the owner.
   */
  public String getNameOfOwner() {
    return nameOfOwner;
  }

  /**
   * Generates a string identifier for the property.
   *
   * @return A formatted string containing municipality number, lot number, and section number.
   */
  public String getStringID(){
    return String.format("%d-%d/%d",muncipalityNumber, lotNumber, sectionNumber);
  }

  /**
   * Overrides the toString() method to represent Property information as a string.
   *
   * @return A string representation of the Property object.
   */
  @Override
  public String toString() {
    return "muncipalityNumber: " + muncipalityNumber 
    + "\nmuncipalityName: " + muncipalityName 
    + "\nlotNumber: " + lotNumber 
    + "\nsectionNumber: " + sectionNumber 
    + "\nname: " + name 
    + "\narea: " + area
    + "\nnameOfOwner: " + nameOfOwner;
  }
}
