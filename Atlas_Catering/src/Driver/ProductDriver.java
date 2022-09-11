// Author: Ong Tun Jiun

package Driver;

import Controller.ProductController;
import View.ProductView;
import View.InterfaceUtils;

public class ProductDriver {
    public static void main(String[] args) {
        ProductController productController = new ProductController();
        ProductView productView = new ProductView(productController);
        int choice = 0;

        // Add sample product data
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
                    System.out.println("Thank you for using Atlas Catering!");
                    break;
            }
        }
    }
}
