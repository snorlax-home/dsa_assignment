package Controller;

import ADT.SortedArrayList;
import ADT.SortedListInterface;
import Entity.Payment;
import java.util.Iterator;

public class PaymentController {
    // Attributes for Payment Sorted Array List
    private SortedListInterface<Payment> paymentSortedArrayList;

    // Constructor for Payment Controller
    public PaymentController() {
        paymentSortedArrayList = new SortedArrayList<>();
    }

    // Getter
    public SortedListInterface<Payment> getPaymentSortedArrayList() {
        return paymentSortedArrayList;
    }

    // Methods to add a payment to the payment sorted array list
    public void addPayment(Payment payment) {
        paymentSortedArrayList.add(payment);
    }

    public void addPayment(String paymentID, String paymentMethod, double orderFees, double deliveryFees) {
        paymentSortedArrayList.add(new Payment(paymentID, paymentMethod, orderFees, deliveryFees));
    }

    // Method to remove a payment from the payment sorted array list
    public boolean removePayment(Payment payment) {
        return paymentSortedArrayList.remove(payment);
    }

    public boolean containsPayment(String targetPaymentID, String currentPaymentID) {
        return paymentSortedArrayList.contains(targetPaymentID, currentPaymentID);
    }

    public boolean replacePayment(Payment targetedPayment, Payment replacePayment) {
        return paymentSortedArrayList.replace(targetedPayment, replacePayment);
    }

    // Method to clear the payment sorted array list
    public void clearPaymentList() {
        paymentSortedArrayList.clear();
    }

    // Method to get the number of payments in the payment sorted array list
    public int getNumberOfPayments() {
        return paymentSortedArrayList.getNumberOfEntries();
    }

    public void sortDescendingOrder() {
        paymentSortedArrayList.sortDescending();
    }

    // Method to check if the payment sorted array list is empty
    public boolean isEmpty() {
        return paymentSortedArrayList.isEmpty();
    }

    public int arrayListCapacity() {
        return paymentSortedArrayList.capacity();
    }

    public Iterator<Payment> getIterator() {
        return paymentSortedArrayList.getIterator();
    }
}
