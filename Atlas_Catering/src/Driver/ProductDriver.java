// Author: Ong Tun Jiun

package Driver;

import Controller.ProductController;
import View.ProductView;
import View.InterfaceUtils;

public class ProductDriver {
    public static void productMenu(ProductController productController) {
        ProductView productView = new ProductView(productController);
        int choice = 0;

        // Display menu
        while (choice != 5) {
            InterfaceUtils.printHeader();
            System.out.println("Product");
            System.out.println("--------");
            System.out.println("1. Add Product");
            System.out.println("2. Edit Product");
            System.out.println("3. Remove Product");
            System.out.println("4. Product Report");
            System.out.println("5. Exit");
            System.out.print("Please enter your choice: ");
            choice = InterfaceUtils.getChoice(6);
            switch (choice) {
                case 1:
                    productView.addProduct();
                    break;
                case 2:
                    productView.editProduct();
                    break;
                case 3:
                    productView.removeProduct();
                    break;
                case 4:
                    productView.productReport();
                    break;
                case 5:
                    System.out.println("Exiting Product Menu...");
                    break;
            }
        }
    }
}
