/**
 * @author Ong Tun Jiun
 */
package Controller;

import ADT.LinkedList;
import ADT.LinkedListInterface;
import Entity.Product;
import java.util.Iterator;

public class ProductController {
    // Attributes
    private LinkedListInterface<Product> productList;

    // Constructor
    public ProductController() {
        productList = new LinkedList<>();
    }

    // Getters
    public LinkedListInterface<Product> getProductList() {
        return productList;
    }

    // Methods
    // add Product Methods
    public void addProduct(Product product) {
        productList.add(product);
    }

    public void addProduct(String productNo, String productName, String productDescription, double productPrice) {
        Product product = new Product(productNo, productName, productDescription, productPrice);
        productList.add(product);
    }

    public boolean addProduct(int position, Product product) {
        return productList.add(position, product);
    }

    public boolean addProduct(int position, String productNo, String productName, String productDescription,
            double productPrice) {
        Product product = new Product(productNo, productName, productDescription, productPrice);
        return productList.add(position, product);
    }

    // remove Product Method
    public Product removeProduct(int position) {
        return (Product) productList.remove(position);
    }

    // clear Product List Method
    public void clearProductList() {
        productList.clear();
    }

    // replace Product Methods
    public boolean replaceProduct(int position, Product product) {
        return productList.replace(position, product);
    }

    public boolean replaceProduct(int position, String productNo, String productName, String productDescription,
            double productPrice) {
        Product product = new Product(productNo, productName, productDescription, productPrice);
        return productList.replace(position, product);
    }

    // get Product Method
    public Product getProduct(int position) {
        return productList.getEntry(position);
    }

    // contains Product Method
    public boolean containsProduct(Product product) {
        return productList.contains(product);
    }

    public boolean containsProduct(String productNo, String productName, String productDescription,
            double productPrice) {
        Product product = new Product(productNo, productName, productDescription, productPrice);
        return productList.contains(product);
    }

    // get number of Product Method
    public int getNumberOfProducts() {
        return productList.getNumberOfEntries();
    }

    // isEmpty Method
    public boolean isEmpty() {
        return productList.isEmpty();
    }

    // get Iterator Method
    public Iterator<Product> getIterator() {
        return productList.getIterator();
    }

}
