//Author: Goh Neng Fu

package Entity;

public class Order {
    // attributes
    Product product; 
    String orderNo;
    double orderPrice;

    // constructors
    public Order(){
        this("", 0.0, new Product());
    }

    public Order(String orderNo, double orderPrice, Product product){
        this.product = product;
        this.orderNo = orderNo;
        this.orderPrice = orderPrice;
    }

    // getters
    public Product getProducts() {
        return product;
    }

    public String getOrderNo() {
        return orderNo;
    }
    
    public double getOrderPrice() {
        return orderPrice;
    }

    // setters
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }
    
    @Override
    public String toString() {
        return "Order" + '\n' +
                "| orderNo:" + orderNo + '\n' +
                "| orderPrice:" + orderPrice + '\n';
    }
}