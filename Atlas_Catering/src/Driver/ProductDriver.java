package Driver;

import Controller.ProductController;
import View.ProductView;
import View.InterfaceUtils;

public class ProductDriver {
    public static void main(String[] args) {
        ProductController controller = new ProductController();
        ProductView view = new ProductView(controller);
        int choice = 0;
        while (choice != 3) {
            InterfaceUtils.printHeader();
            System.out.println("Product");
            System.out.println("--------");
            System.out.println("1. New Product");
            System.out.println("2. View Product");
            System.out.println("3. Exit");
            System.out.print("Please enter your choice: ");
            choice = InterfaceUtils.getChoice(3);
            switch (choice) {
                case 1:
                    view.newProduct();
                    break;
                case 2:
                    view.viewProduct();
                    break;
                case 3:
                    System.out.println("Thank you for using Atlas Catering!");
                    break;
            }
        }
    }
}
