//Author: Goh Neng Fu

package Driver;

import View.InterfaceUtils;

import javax.swing.text.View;

import Controller.OrderController;
import View.OrderView;

public class OrderDriver {
    public static void orderMenu(OrderController orderController) {
        OrderView orderView = new OrderView();
        System.out.println(orderView.getClass());
        System.out.println(orderController.getClass());
        int choice = 0;     
        
        // order selection menu
        while (choice != 4) {
            InterfaceUtils.printHeader();
            System.out.println("Order");
            System.out.println("--------");
            System.out.println("1. Add Order");
            System.out.println("2. Remove Order");
            System.out.println("3. Order Report");
            System.out.println("4. Exit");
            System.out.print("Please enter your selection: ");
            choice = InterfaceUtils.getChoice(5);
            switch (choice) {
                case 1:
                    orderView.addOrder();
                    break;
                case 2:
                    orderView.removeOrder();
                    break;
                case 3:
                    // orderView.orderReport(Order order);
                    break;
                case 4:
                    System.out.println("Thank you for using Atlas Catering!");
                    break;
            }
        }
    }
}
