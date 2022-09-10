// Author: Ong Tun Jiun

package View;

import Controller.ProductController;
import Entity.Product;
import java.util.Scanner;

import ADT.DeliveryQueue;
import ADT.QueueInterface;

import java.util.Iterator;

public class ProductView {
    private ProductController controller;

    public ProductView(ProductController controller) {
        this.controller = controller;
    }

    public void newProduct() {
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

        sc.close();

        controller.addProduct(tempProduct);
        InterfaceUtils.continuePrompt("1");

    }

    public void viewProduct() {
        InterfaceUtils.printHeader();
        System.out.println("Product List");
        System.out.printf("%-15s %-25s %-50s %18s\n", "Product No", "Product Name", "Product Description",
                "Product Price (RM)");
        System.out.printf("%-15s %-25s %-50s %18s\n", "----------", "------------", "-------------------",
                "------------------");

        Iterator<Product> productListIterator = controller.getProductList().getIterator();
        while (productListIterator.hasNext()) {
            Product tempProduct = productListIterator.next();
            System.out.printf("%-15s %-25s %-50s %18.2f\n", tempProduct.getProductNo(), tempProduct.getProductName(),
                    tempProduct.getProductDescription(), tempProduct.getProductPrice());
        }
    }

    public void viewAndChooseProduct() {
        QueueInterface<Product> productQueue = new DeliveryQueue<>();

        // TODO: Pass this from main instead
        Scanner input = new Scanner(System.in);
        viewProduct();

        do {
            System.out.print("\nSelect Product by Entering Product No.:");
            String productNo = input.nextLine();

            Iterator<Product> productListIterator = controller.getProductList().getIterator();
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
