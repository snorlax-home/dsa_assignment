/**
 * @author Ong Tun Jiun
 */

package View;

import Controller.ProductController;
import Entity.Product;
import java.util.Scanner;

import java.util.Iterator;

public class ProductView {
    // declare variables
    private ProductController productController;

    public ProductView(ProductController controller) {
        this.productController = controller;
    }

    // Method to add new product
    public void addProduct() {
        // print Header
        InterfaceUtils.printHeader();
        InterfaceUtils.printProductHeader();

        Scanner sc = new Scanner(System.in);
        Product tempProduct = new Product();

        // Ask user to input product details
        System.out.println("Please fill in product details as following.");
        System.out.print("Product No: ");
        String productNo = sc.nextLine();
        tempProduct.setProductNo(productNo);

        System.out.print("Product Name: ");
        String productName = sc.nextLine();
        tempProduct.setProductName(productName);

        System.out.print("Product Description: ");
        String productDescription = sc.nextLine();
        tempProduct.setProductDescription(productDescription);

        System.out.print("Product Price: ");
        double productPrice = sc.nextDouble();
        tempProduct.setProductPrice(productPrice);

        // add product to product list
        productController.addProduct(tempProduct);
        // prompt user to continue
        InterfaceUtils.continuePrompt("1");

    }

    public void editProduct() {
        // print Header
        InterfaceUtils.printHeader();
        InterfaceUtils.printProductHeader();

        Scanner sc = new Scanner(System.in);
        Product tempProduct = new Product();

        // Ask user to input product details
        System.out.println("Please fill in product details as following.");
        System.out.print("Product No: ");
        String productNo = sc.nextLine();
        tempProduct.setProductNo(productNo);

        System.out.print("Product Name: ");
        String productName = sc.nextLine();
        tempProduct.setProductName(productName);

        System.out.print("Product Description: ");
        String productDescription = sc.nextLine();
        tempProduct.setProductDescription(productDescription);

        System.out.print("Product Price: ");
        double productPrice = sc.nextDouble();
        tempProduct.setProductPrice(productPrice);

        // Get product position and replace the product
        int productPosition = -1;
        Iterator<Product> productListIterator = productController.getProductList().getIterator();
        while (productListIterator.hasNext()) {
            productPosition++;
            Product tempProduct2 = productListIterator.next();
            if (tempProduct2.getProductNo().equals(tempProduct.getProductNo())) {
                boolean result = productController.replaceProduct(productPosition, tempProduct);
                if (result) {
                    System.out.println("Product edited successfully.");
                } else {
                    System.out.println("Product edited failed.");
                }
            }
        }
        // prompt user to continue
        InterfaceUtils.continuePrompt("1");
    }

    public void removeProduct() {
        // print Header
        InterfaceUtils.printHeader();
        InterfaceUtils.printProductHeader();

        Scanner sc = new Scanner(System.in);

        // Ask user to input product No
        System.out.println("Please input the product No.");
        System.out.print("Product No: ");
        String productNo = sc.nextLine();

        // Get product position and replace the product
        int productPosition = -1;
        Iterator<Product> productListIterator = productController.getProductList().getIterator();
        while (productListIterator.hasNext()) {
            productPosition++;
            Product tempProduct = productListIterator.next();
            if (tempProduct.getProductNo().equals(productNo)) {
                Product removedProduct = productController.removeProduct(productPosition);
                if (removedProduct != null) {
                    System.out.println("Product " + removedProduct.getProductNo() + " has been removed.");
                } else {
                    System.out.println("Product not found.");
                }

            }
        }
        // prompt user to continue
        InterfaceUtils.continuePrompt("1");
    }

    public void productReport() {
        // print Header
        InterfaceUtils.printHeader();
        InterfaceUtils.printProductHeader();

        // List amount of products
        System.out.println("Total Products: " + productController.getNumberOfProducts());

        // Product List Header
        System.out.println("Product List");
        System.out.printf("%-15s %-25s %-50s %18s\n", "Product No", "Product Name", "Product Description",
                "Product Price (RM)");
        System.out.printf("%-15s %-25s %-50s %18s\n", "----------", "------------", "-------------------",
                "------------------");

        // List all products
        Iterator<Product> productListIterator = productController.getProductList().getIterator();
        while (productListIterator.hasNext()) {

            Product tempProduct = productListIterator.next();
            System.out.printf("%-15s %-25s %-50s %18.2f\n", tempProduct.getProductNo(), tempProduct.getProductName(),
                    tempProduct.getProductDescription(), tempProduct.getProductPrice());
        }

        // prompt user to continue
        InterfaceUtils.continuePrompt("1");
    }
}
