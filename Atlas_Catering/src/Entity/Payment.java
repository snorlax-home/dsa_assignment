package Entity;

public class Payment {
    private String paymentID;
    private double orderFees;
    private static final double taxSST = 0.06;
    private double deliveryFees;
    private double totalPayment;
    
    public Payment() {
        this("", 0.00, 0.00);
    }

    public Payment(String paymentID, double orderFees, double deliveryFees) {
        this.paymentID = paymentID;
        this.orderFees = orderFees;
        this.deliveryFees = deliveryFees;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public double getOrderFees() {
        return orderFees;
    }

    public double getDeliveryFees() {
        return deliveryFees;
    }

    public double getTotalPayment() {
        return calculateTotalPayment();
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public void setOrderFees(double orderFees) {
        this.orderFees = orderFees;
    }

    public void setDeliveryFees(double deliveryFees) {
        this.deliveryFees = deliveryFees;
    }

    private double calculateTotalPayment() {
        return totalPayment = orderFees + (orderFees * taxSST) + deliveryFees;
    }

}