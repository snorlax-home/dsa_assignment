package Driver;

import Controller.DeliveryController;
import View.DeliveryView;
import View.InterfaceUtils;

public class DeliveryDriver {

  public static void main(String[] args) {
    DeliveryController controller = new DeliveryController();
    DeliveryView view = new DeliveryView(controller);
    int choice = 0;
    while (choice != 4) {
      InterfaceUtils.printHeader();
      System.out.println("Delivery");
      System.out.println("--------");
      System.out.println("1. New Delivery");
      System.out.println("2. Delivery Fee");
      System.out.println("3. Dequeue top");
      System.out.println("4. Exit");
      System.out.print("Please enter your choice: ");
      choice = InterfaceUtils.getChoice(4);
      switch (choice) {
        case 1:
          view.newDelivery();
          break;
        case 2:
          view.deliveryFee();
          break;
        case 3:
          controller.getNextDelivery();
          break;
        case 4:
          System.out.println("Thank you for using Atlas Catering!");
          break;
      }
    }
  }
}
