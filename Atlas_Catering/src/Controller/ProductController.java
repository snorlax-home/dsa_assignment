// Author: Ong Tun Jiun

package Controller;

import ADT.LinkedList;
import ADT.LinkedListInterface;
import Entity.Product;
import java.util.Iterator;

public class ProductController {
    private LinkedListInterface<Product> productList;

    public ProductController() {
        productList = new LinkedList<>();
    }

    public LinkedListInterface<Product> getProductList() {
        return productList;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void addProduct(String productNo, String productName, String productDescription, double productPrice) {
        Product product = new Product(productNo, productName, productDescription, productPrice);
        productList.add(product);
    }

    public void addProduct(int position, Product product) {
        productList.add(position, product);
    }

    public void addProduct(int position, String productNo, String productName, String productDescription, double productPrice) {
        Product product = new Product(productNo, productName, productDescription, productPrice);
        productList.add(position, product);
    }

    public Product removeProduct(int position) {
        return (Product)productList.remove(position);
    }

    public void clearProductList() {
        productList.clear();
    }

    public boolean replaceProduct(int position, Product product) {
        return productList.replace(position, product);
    }

    public boolean replaceProduct(int position, String productNo, String productName, String productDescription, double productPrice) {
        Product product = new Product(productNo, productName, productDescription, productPrice);
        return productList.replace(position, product);
    }

    public Product getProduct(int position) {
        return productList.getEntry(position);
    }

    public boolean containsProduct(Product product) {
        return productList.contains(product);
    }

    public boolean containsProduct(String productNo, String productName, String productDescription, double productPrice) {
        Product product = new Product(productNo, productName, productDescription, productPrice);
        return productList.contains(product);
    }

    public int getNumberOfProducts() {
        return productList.getNumberOfEntries();
    }

    public boolean isEmpty() {
        return productList.isEmpty();
    }

    public Iterator<Product> getIterator() {
        return productList.getIterator();
    }

    public String toString() {
        String output = "";

        Iterator<Product> productListIterator = productList.getIterator();
        while (productListIterator.hasNext()) {
            output += productListIterator.next().toString() + "\n";
        }
        return output;
    }

    public String toString(int position) {
        return productList.getEntry(position).toString();
    }


}
