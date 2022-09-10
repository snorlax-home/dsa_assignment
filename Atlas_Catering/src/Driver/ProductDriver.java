// Author: Ong Tun Jiun

package Driver;

import Controller.ProductController;
import View.ProductView;
import View.InterfaceUtils;

// TODO: what is the purpose of this class?
public class ProductDriver {
    public static void main(String[] args) {
        ProductController controller = new ProductController();
        ProductView view = new ProductView(controller);
        int choice = 0;

        controller.addProduct("P001", "Chicken Chop", "Chicken Chop with fries", 8.00);
        controller.addProduct("P002", "Nasi Lemak", "Traditional Malay Nasi Lemak", 6.00);
        controller.addProduct("P003", "Chicken Rice", "Rice with Chicken", 6.00);
        controller.addProduct("P004", "Nasi Goreng", "Traditional Malay Fried Rice", 6.00);
        controller.addProduct("P005", "Spaghetti", "Traditional Italian Spaghetti", 8.00);
        controller.addProduct("P006", "Chinese Fried Rice", "Traditional Chinese Fried Rice", 6.00);  
        controller.addProduct("P007", "Char Kway Teow", "Char Kway Teow with Fried Egg and Prawn", 6.00);
        controller.addProduct("P008", "Mee Goreng", "Traditional Malay Fried Noodles", 6.00);
        controller.addProduct("P009", "Wan Tan Mee", "Traditional Chinese Wan Tan Mee", 6.00);
        controller.addProduct("P010", "Popcorn Chicken Rice", "Rice with Popcorn Chicken and salad", 8.00);


        while (choice != 4) {
            InterfaceUtils.printHeader();
            System.out.println("Product");
            System.out.println("--------");
            System.out.println("1. New Product");
            System.out.println("2. View Product");
            System.out.println("3. View and Choose Product");
            System.out.println("4. Exit");
            System.out.print("Please enter your choice: ");
            choice = InterfaceUtils.getChoice(4);
            switch (choice) {
                case 1:
                    view.newProduct();
                    break;
                case 2:
                    view.viewProduct();
                    break;
                case 3:
                    view.viewAndChooseProduct();
                    break;
                case 4:
                    System.out.println("Thank you for using Atlas Catering!");
                    break;
            }
        }
    }
}
