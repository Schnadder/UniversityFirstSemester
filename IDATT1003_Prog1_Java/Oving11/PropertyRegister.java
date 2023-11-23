package Oving11;

import java.util.ArrayList;
import java.util.List;

/**
 * The PropertyRegister class represents a register of properties.
 */
public class PropertyRegister {
  /**
   * Using an ArrayList because of its Dynamic size as the register can add and
   * remove Properties throughout
   * Aswell as its good performance at adding to end of list
   * And because it implements the List interface it comes with usefull prebuilt
   * methods
   */
  private List<Property> properties;

  /**
   * Default constructor for PropertyRegister.
   */
  public PropertyRegister() {
    properties = new ArrayList<>();
  }

  /**
   * Constructor for PropertyRegister with initial list of properties.
   *
   * @param properties The initial list of properties.
   */
  public PropertyRegister(List<Property> properties) {
    this.properties = properties;
  }

  /**
   * Adds a property to the register.
   *
   * @param property The property to be added.
   */
  public void addProperty(Property property) {
    properties.add(property);
  }

  /**
   * Removes a property from the register.
   *
   * @param property The property to be removed.
   */
  public void removeProperty(Property property) {
    properties.remove(property);
  }

  /**
   * Gets the number of properties in the register.
   *
   * @return The number of properties in the register.
   */
  public int getSize() {
    return properties.size();
  }

  /**
   * Finds a property based on municipality number, lot number, and section
   * number.
   *
   * @param municipalityNumber The municipality number of the property.
   * @param lotNumber          The lot number of the property.
   * @param sectionNumber      The section number of the property.
   * @return The found property or null if not found.
   */
  public Property findProperty(int muncipalityNumber, int lotNumber, int sectionNumber) {
    if (properties == null || properties.isEmpty()) {
      // Handle empty properties collection case
      return null;
    }
    
    // Is stream or for each better in this case?
    return properties.stream()
        .filter(property -> 
            property.getMuncipalityNumber() == muncipalityNumber &&
            property.getLotNumber() == lotNumber &&
            property.getSectionNumber() == sectionNumber)
        .findFirst()
        .orElse(null);
  }

  /**
   * Calculates the average area of all properties in the register.
   *
   * @return The average area of properties.
   */
  public double getArea() {
    double area = 0;
    for (Property property : properties) {
      area += property.getArea();
    }

    return area / properties.size();
  }

  /**
   * Finds properties based on municipality number.
   *
   * @param municipalityNumber The municipality number of properties to find.
   * @return A list of properties within the specified municipality.
   */
  public List<Property> findProperties(int muncipalityNumber) {
    List<Property> output = new ArrayList<>();
    for (Property property : properties) {
      if (property.getMuncipalityNumber() == muncipalityNumber) {
        output.add(property);
      }
    }
    return output;
  }

  /**
   * Gets the list of properties in the register.
   *
   * @return The list of properties in the register.
   */
  public List<Property> getProperties() {
    return properties;
  }
}
