package Entity;

import java.time.LocalDate;

public class Order {
    String orderNo;
    double orderPrice;
    LocalDate orderDate;

    public Order(){
        this("", 0.0);
    }

    public Order(String orderNo, double orderPrice){
        this.orderNo = orderNo;
        this.orderPrice = orderPrice;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
    
    public double getOrderPrice() {
        return orderPrice;
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