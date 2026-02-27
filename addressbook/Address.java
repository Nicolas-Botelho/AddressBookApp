package addressbook;

import java.util.GregorianCalendar;

public class Address {
  private String name;
  private GregorianCalendar birthDate;
  private String gender;

  public Address(String name, GregorianCalendar birthDate, String gender) {
    this.name = name;
    this.birthDate = birthDate;
    this.gender = gender;
  }

  public Address(String[] line) {
    this.name = line[0];
    String[] dateStrings = line[2].split("/");
    this.birthDate = new GregorianCalendar(Integer.parseInt(dateStrings[2]), Integer.parseInt(dateStrings[1])-1, Integer.parseInt(dateStrings[0]));

    if (line[1].charAt(0) == "M".charAt(0) || line[1].charAt(0) == "F".charAt(0)) {
      this.gender = String.valueOf(line[1].charAt(0));
    }
    else {
      this.gender = "O";
    }
  }

  public String getName() {
    return name;
  }
  public GregorianCalendar getBirthDate() {
    return birthDate;
  }
  public String getGender() {
    return gender;
  }

  @Override
  public String toString() {
    return this.name;
  }
}
