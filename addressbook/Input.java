package addressbook;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.naming.NameNotFoundException;

import addressbook.Address;

public class Input {
  public ArrayList<Address> addressBook;

  public Input(){
    ArrayList<String[]> aux = readFile();
    this.addressBook = new ArrayList<>();

    for (String[] elem : aux){
      this.addressBook.add(new Address(elem));
    }
  }

  // = = = = = = = = =
  // = = = UTILS = = =
  // = = = = = = = = =
  public ArrayList<String[]> readFile(){
    try {
      File file = new File("addressbook/AddressBook.txt");
      Scanner s = new Scanner(file);
      ArrayList<String[]> out = new ArrayList<>();

      while (s.hasNextLine()) {
        String line = s.nextLine();
        String[] lineContent = line.strip().split(", ");
        out.add(lineContent);
      }

      return out;

    } catch (Exception e) {
      System.out.println(e.getMessage());
      ArrayList<String[]> blank = new ArrayList<>();
      return blank;
    }
  }

  private Address nameFinder(String name) throws NameNotFoundException{
    for (Address item : this.addressBook){
      if (name.strip().equals(item.getName())){
        return item;
      }
    }
    throw new NameNotFoundException("Name not found in the Address Book");
  }

  // = = = = = = = = =
  // = = = MENUS = = =
  // = = = = = = = = =

  public void menu(){
    try {
      Scanner s = new Scanner(System.in);

      String text =
      "\n\n----------------\n" +
      "- ADDRESS BOOK -\n" +
      "---MAIN--MENU---\n" +
      "----------------\n" +
      "Select a option below:\n" +
      "1 - Males in the Address Book\n" +
      "2 - Oldest in the Address Book\n" +
      "3 - Age Difference between 2 People\n" +
      "0 - Exit\n";

      int op = 4;

      while (op != 0) {
        System.out.println(text);
        try {
          op = s.nextInt();
        }
        catch(Exception e) {
          op = 4;
        }

        switch (op) {
          case 1:
            malesMenu();
            break;
          case 2:
            oldestMenu();
            break;
          case 3:
            ageMenu();
            break;
          default:
            break;
        }
      }

      System.out.println("\n\nGoodbye! :)");

    } catch (Exception e) {
      System.out.println("\n\nERROR: " + e.getMessage());
    }
  }

  private void malesMenu(){
    Integer amount = 0;

    for (Address item : this.addressBook){
      if (item.getGender().equals("M")){
        amount = amount + 1;
      }
    }

    System.out.println("\n\nThere are " + amount.toString() + " males in the Address Book");
  }

  private void oldestMenu(){
    Address oldest = this.addressBook.get(0);

    for (Address item : this.addressBook){
      if (item.getBirthDate().compareTo(oldest.getBirthDate()) < 0){
        oldest = item;
      }
    }

    System.out.println("\n\nThe oldest person in the Address Book is " + oldest.getName());
  }

  private void ageMenu(){
    try {
      Scanner s = new Scanner(System.in);

      System.out.println("\nSelect one of the addresses below (Type the full name the same way it is shown):");
      for (Address item : this.addressBook){
        System.out.println(item.toString());
      }
      System.out.println("\n-------\n");
      Address p1 = nameFinder(s.nextLine().strip());

      System.out.println("\nSelect one more address (Type the full name the same way it is shown):");
      System.out.println("\n-------\n");
      Address p2 = nameFinder(s.nextLine().strip());

      // int agediff = p1.getBirthDate().compareTo(p2.getBirthDate());
      long agediff = (p1.getBirthDate().getTimeInMillis() - p2.getBirthDate().getTimeInMillis()) / (1000 * 3600 * 24);
      if (agediff > 0) {
        System.out.println("\n" + p2.getName() + " is older than " + p1.getName() + " by " + agediff + " days");
      }
      else {
        agediff = agediff * -1;
        System.out.println("\n" + p1.getName() + " is older than " + p2.getName() + " by " + agediff + " days");
      }
      
    } catch (Exception e) {
      System.out.println("\n\nERROR: " + e.getMessage());
    }
  }
}