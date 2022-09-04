package Entity;

public class Product {
    String productNo;
    String productName;
    String productDescription;
    double productPrice;

    public Product() {
        this("", "", "", 0.0);
    }

    public Product(String productNo, String productName, String productDescription, double productPrice) {
        this.productNo = productNo;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
    }

    public String getProductNo() {
        return productNo;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productNo='" + productNo + '\'' +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }

}
