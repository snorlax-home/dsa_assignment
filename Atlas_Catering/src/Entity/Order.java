//Author: Goh Neng Fu

package Entity;

public class Order {
    // attributes
    Product[] products; 
    String orderNo;
    double orderPrice;

    // constructors
    public Order(){
        this("", 0.0);
    }

    public Order(String orderNo, double orderPrice){
        this.products = new Product[1];
        this.orderNo = orderNo;
        this.orderPrice = orderPrice;
    }

    // getters
    public Product[] getProducts() {
        return products;
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