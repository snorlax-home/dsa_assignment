/*
 * @Author: Wong Yan Zhi @ 21WMR03679
 */
package Entity;

public class Payment implements Comparable<Payment> {

    // Attributes for Payment class, all are set to private
    private String paymentID;
    private String paymentMethod;
    private double orderFees;
    private static final double SST = 0.1; // SST is set to 10%
    private double deliveryFees;
    private double totalPayment;

    // Constructors
    public Payment() {
        this("", "", 0.00, 0.00);
    }

    public Payment(String paymentID, String paymentMethod, double orderFees, double deliveryFees) {
        this.paymentID = paymentID;
        this.paymentMethod = paymentMethod;
        this.orderFees = orderFees;
        this.deliveryFees = deliveryFees;
    }

    // Getters
    public String getPaymentID() {
        return this.paymentID;
    }

    public String getPaymentMethod() {
        return this.paymentMethod;
    }

    public double getOrderFees() {
        return this.orderFees;
    }

    public static double getSST() {
        return SST * 100;
    }

    public double getDeliveryFees() {
        return this.deliveryFees;
    }

    public double getTotalPayment() {
        return calculateTotalPayment();
    }

    // Setters
    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setOrderFees(double orderFees) {
        this.orderFees = orderFees;
    }

    public void setDeliveryFees(double deliveryFees) {
        this.deliveryFees = deliveryFees;
    }

    // Calculate total payment
    private double calculateTotalPayment() {
        this.totalPayment = orderFees + (orderFees * SST) + deliveryFees;
        return this.totalPayment;
    }

    // Override toString method
    @Override
    public String toString() {
        return "Payment{" + "paymentID=" + paymentID + ", orderFees=" + orderFees + ", deliveryFees=" + deliveryFees + ", totalPayment=" + totalPayment + '}';
    }

    // Override compareTo method
    @Override
    public int compareTo(Payment payment) {
        return this.paymentID.compareTo(payment.paymentID);
    }
}
