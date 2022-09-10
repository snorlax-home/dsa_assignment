// Author: Ong Tun Jiun

package View;

import Controller.ProductController;
import Entity.Product;
import java.util.Scanner;

import ADT.Queue;
import ADT.QueueInterface;

import java.util.Iterator;

public class ProductView {
    private ProductController productController;

    public ProductView(ProductController controller) {
        this.productController = controller;
    }

    public void addProduct() {
        InterfaceUtils.printHeader();
        InterfaceUtils.printProductHeader();

        Scanner sc = new Scanner(System.in);
        Product tempProduct = new Product();

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

        productController.addProduct(tempProduct);
        InterfaceUtils.continuePrompt("1");

    }

    public void editProduct() {
        InterfaceUtils.printHeader();
        Scanner sc = new Scanner(System.in);
        Product tempProduct = new Product();

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
        InterfaceUtils.continuePrompt("1");
    }

    public void removeProduct() {
        InterfaceUtils.printHeader();
        InterfaceUtils.printProductHeader();
        Scanner sc = new Scanner(System.in);

        System.out.println("Please fill in product details as following.");
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
        InterfaceUtils.continuePrompt("1");
    }

    public void productReport() {
        InterfaceUtils.printHeader();
        InterfaceUtils.printProductHeader();

        // List amount of products
        System.out.println("Total Products: " + productController.getNumberOfProducts());

        System.out.println("Product List");
        System.out.printf("%-15s %-25s %-50s %18s\n", "Product No", "Product Name", "Product Description",
                "Product Price (RM)");
        System.out.printf("%-15s %-25s %-50s %18s\n", "----------", "------------", "-------------------",
                "------------------");

        Iterator<Product> productListIterator = productController.getProductList().getIterator();
        while (productListIterator.hasNext()) {

            Product tempProduct = productListIterator.next();
            System.out.printf("%-15s %-25s %-50s %18.2f\n", tempProduct.getProductNo(), tempProduct.getProductName(),
                    tempProduct.getProductDescription(), tempProduct.getProductPrice());
        }

        InterfaceUtils.continuePrompt("1");
    }

    public void addProductToOrder() {
        QueueInterface<Product> productQueue = new Queue<>();

        Scanner input = new Scanner(System.in);

        InterfaceUtils.printHeader();
        InterfaceUtils.printProductHeader();

        System.out.println("Product List");
        System.out.printf("%-15s %-25s %-50s %18s\n", "Product No", "Product Name", "Product Description",
                "Product Price (RM)");
        System.out.printf("%-15s %-25s %-50s %18s\n", "----------", "------------", "-------------------",
                "------------------");

        Iterator<Product> productListIterator = productController.getProductList().getIterator();
        while (productListIterator.hasNext()) {

            Product tempProduct = productListIterator.next();
            System.out.printf("%-15s %-25s %-50s %18.2f\n", tempProduct.getProductNo(), tempProduct.getProductName(),
                    tempProduct.getProductDescription(), tempProduct.getProductPrice());
        }

        do {
            System.out.print("\nSelect Product by Entering Product No.:");
            String productNo = input.nextLine();

            while (productListIterator.hasNext()) {
                Product tempProduct = productListIterator.next();
                if (tempProduct.getProductNo().equals(productNo)) {
                    productQueue.enqueue(tempProduct);
                }
            }

        } while (InterfaceUtils.continuePrompt("Enter 1 to select more products: ", "1"));
        // Passed Queue to Order
    }
}
