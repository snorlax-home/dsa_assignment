package View;

import Controller.ProductController;
import Entity.Product;
import java.util.Scanner;
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

        controller.addProduct(tempProduct);
        InterfaceUtils.continuePrompt("1");

        sc.close();
    }

    public void viewProduct() {
        InterfaceUtils.printHeader();
        System.out.println("Product List");
        System.out.println("Product No\tProduct Name\tProduct Description\tProduct Price");
        
        Iterator<Product> iterator = controller.getProductList().getIterator();
        while (iterator.hasNext()) {
            Product tempProduct = iterator.next();
            System.out.println(tempProduct.getProductNo() + "\t" + tempProduct.getProductName() + "\t" + tempProduct.getProductDescription() + "\t" + tempProduct.getProductPrice());
        }
        InterfaceUtils.continuePrompt("1");
    }
}
