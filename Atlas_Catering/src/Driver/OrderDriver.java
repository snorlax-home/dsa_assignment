package Driver;

import View.InterfaceUtils;
import Controller.OrderController;
import View.OrderView;

public class OrderDriver {
    public static void main(String[] args) {
        OrderController controller = new OrderController();
        OrderView view = new OrderView(controller);
        int choice = 0;
        while (choice != 3) {
            InterfaceUtils.printHeader();
            System.out.println("Order");
            System.out.println("--------");
            System.out.println("1. Add Order");
            System.out.println("2. Remove Order");
            System.out.println("3. View Order");
            System.out.println("4. Clear Order");
            System.out.println("5. Exit");
            System.out.print("Please enter your selection: ");
            choice = InterfaceUtils.getChoice(2);
            switch (choice) {
                case 1:
                    view.addOrder();
                    break;
                case 2:
                    System.out.println("Thank you for using Atlas Catering!");
                    break;
            }
        }
    }
}
