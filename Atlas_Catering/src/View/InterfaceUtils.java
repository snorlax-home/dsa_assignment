package View;

import java.util.Scanner;

/**
 * @author Tan Yi Hong
 */

public class InterfaceUtils {

  public static void printHeader() {
    System.out.println("--------ATLAS Catering--------");
  }

  public static void printDeliveryHeader() {
    System.out.println("--------Delivery Queue--------");
  }

  public static void printProductHeader() {
    System.out.println("-----------Products-----------");
  }

  public static void printOrderHeader() {
    System.out.println("-----------Orders-----------");
  }

  public static boolean continuePrompt() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Press Enter key to continue...");
    try {
      System.in.read();
      sc.nextLine();
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  public static boolean continuePrompt(String checkValue) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Press " + checkValue + " to continue...");
    if (sc.nextLine().equals(checkValue)) {
      return true;
    }
    return false;
  }

  public static boolean continuePrompt(String promptText, String checkValue) {
    Scanner sc = new Scanner(System.in);
    System.out.println(promptText);
    if (sc.nextLine().equals(checkValue)) {
      return true;
    }
    return false;
  }

  public static int getChoice(int choiceRange) {
    Scanner sc = new Scanner(System.in);
    int choice = sc.nextInt();
    while (choice < 1 || choice > choiceRange) {
      System.out.println("Invalid choice. Please enter again.");
      choice = sc.nextInt();
    }
    return choice;
  }
}
