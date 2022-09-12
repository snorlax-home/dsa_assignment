
/**
 * @author Ong Tun Jiun
 */

import Controller.OrderController;
import Controller.ProductController;
import Driver.OrderDriver;
import Driver.ProductDriver;
import View.InterfaceUtils;

public class Main {
    public static void main(String[] args) {
        OrderController orderController = new OrderController();
        ProductController productController = new ProductController();

        productController.addProduct("P001", "Chicken Chop", "Chicken Chop with  fries", 8.00);
        productController.addProduct("P002", "Nasi Lemak", "Traditional Malay Nasi Lemak", 6.00);
        productController.addProduct("P003", "Chicken Rice", "Rice with Chicken", 6.00);
        productController.addProduct("P004", "Nasi Goreng", "Traditional Malay Fried Rice", 6.00);
        productController.addProduct("P005", "Spaghetti", "Traditional Italian Spaghetti", 8.00);
        productController.addProduct("P006", "Chinese Fried Rice", "Traditional Chinese Fried Rice", 6.00);
        productController.addProduct("P007", "Char Kway Teow", "Char Kway Teow with Fried Egg and Prawn", 6.00);
        productController.addProduct("P008", "Mee Goreng", "Traditional Malay Fried Noodles", 6.00);
        productController.addProduct("P009", "Wan Tan Mee", "Traditional Chinese Wan Tan Mee", 6.00);
        productController.addProduct("P010", "Popcorn Chicken Rice", "Rice with Popcorn Chicken and salad", 8.00);

        int choice = 0;

        // Display main menu
        while (choice != 5) {
            InterfaceUtils.printHeader();
            System.out.println("Main Menu");
            System.out.println("---------");
            System.out.println("1. Order");
            System.out.println("2. Products");
            System.out.println("3. Payment");
            System.out.println("4. User");
            System.out.println("5. Exit");
            System.out.print("Please enter your choice: ");
            choice = InterfaceUtils.getChoice(5);
            switch (choice) {
                case 1:
                    OrderDriver.orderMenu(orderController);
                    break;
                case 2:
                    ProductDriver.productMenu(productController);
                    break;
                case 3:
                    //PaymentDriver.paymentMenu();
                    break;
                case 4:
                    //UserDriver.userMenu();
                    break;
                case 5:
                    System.out.println("Thank you for using Atlas Catering!");
                    break;
            }
        }
    }
}
