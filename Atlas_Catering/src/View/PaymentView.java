/*
 * @Author: Wong Yan Zhi @ 21WMR03679
 */
package View;

import Controller.PaymentController;
import java.util.Iterator;
import java.util.Scanner;
import Entity.Payment;

public class PaymentView {

    private PaymentController paymentController;
    private Scanner input = new Scanner(System.in);

    public PaymentView(PaymentController controller) {
        this.paymentController = controller;
    }

    public void addPayment() {
        InterfaceUtils.printHeader();
        InterfaceUtils.printPaymentHeader();

        Payment tempPayment = new Payment();

        System.out.println("Please enter the payment details to add:-");
        System.out.print("Payment ID: ");
        String paymentID = input.nextLine();
        tempPayment.setPaymentID(paymentID);

        System.out.print("Payment Method: ");
        String paymentMethod = input.nextLine();
        tempPayment.setPaymentMethod(paymentMethod);

        System.out.print("Order Fees: ");
        double orderFees = input.nextDouble();
        input.nextLine();
        tempPayment.setOrderFees(orderFees);

        System.out.print("Delivery Fees: ");
        double deliveryFees = input.nextDouble();
        input.nextLine();
        tempPayment.setDeliveryFees(deliveryFees);

        paymentController.addPayment(tempPayment);
        InterfaceUtils.printFooter();
        System.out.println("Payment added successfully!");
        InterfaceUtils.printFooter();
        InterfaceUtils.continuePrompt("0");
    }

    public void removePayment() {
        InterfaceUtils.printHeader();
        InterfaceUtils.printPaymentHeader();

        System.out.println("Please enter the Payment ID you wish to remove:-");
        System.out.print("Payment ID: ");
        String paymentID = input.nextLine();

        Iterator<Payment> paymentIterator = paymentController.getPaymentSortedArrayList().getIterator();
        boolean identifyResult = false;
        while (paymentIterator.hasNext()) {
            Payment tempPayment = paymentIterator.next();
            identifyResult = tempPayment.getPaymentID().equals(paymentID);
            if (identifyResult) {
                if (paymentController.removePayment(tempPayment)) {
                    System.out.println("Payment removed successfully.");
                } else {
                    System.out.println("Payment removal failed.");
                }
                break;
            }
        }

        if (!identifyResult) {
            System.out.println("Payment ID not found.");
        }

        InterfaceUtils.printFooter();
        InterfaceUtils.continuePrompt("0");
    }

    public void modifyPayment() {
        InterfaceUtils.printHeader();
        InterfaceUtils.printPaymentHeader();

        Payment tempPayment = new Payment();

        System.out.println("Please enter the payment details to modify:-");
        System.out.print("Payment ID: ");
        String paymentID = input.nextLine();
        tempPayment.setPaymentID(paymentID);

        System.out.print("Payment Method: ");
        String paymentMethod = input.nextLine();
        tempPayment.setPaymentMethod(paymentMethod);

        System.out.print("Order Fees: ");
        double orderFees = input.nextDouble();
        input.nextLine();
        tempPayment.setOrderFees(orderFees);

        System.out.print("Delivery Fees: ");
        double deliveryFees = input.nextDouble();
        input.nextLine();
        tempPayment.setDeliveryFees(deliveryFees);

        InterfaceUtils.printFooter();

        Iterator<Payment> paymentIterator = paymentController.getPaymentSortedArrayList().getIterator();
        boolean successModify = false;
        while (paymentIterator.hasNext()) {
            Payment selectedModifyPayment = paymentIterator.next();
            boolean identifyResult = paymentController.getPaymentSortedArrayList().contains(selectedModifyPayment.getPaymentID(), tempPayment.getPaymentID());
            if (identifyResult) {
                successModify = paymentController.replacePayment(selectedModifyPayment, tempPayment);
                System.out.println("Payment modified successfully.");
                break;
            }
        }

        if (!successModify) {
            System.out.println("Payment ID not found.");
            System.out.println("Payment modification failed.");
        }

        InterfaceUtils.printFooter();
        InterfaceUtils.continuePrompt("0");
    }

    public void searchPayment() {
        InterfaceUtils.printHeader();
        InterfaceUtils.printPaymentHeader();

        System.out.println("Please enter the Payment ID you wish to search:-");
        System.out.print("Payment ID: ");
        String paymentID = input.nextLine();

        InterfaceUtils.printFooter();

        boolean searchingFlags = false;
        Iterator<Payment> paymentIterator = paymentController.getPaymentSortedArrayList().getIterator();
        while (paymentIterator.hasNext()) {
            Payment tempPayment = paymentIterator.next();
            if (paymentController.getPaymentSortedArrayList().contains(paymentID, tempPayment.getPaymentID())) {

                if (paymentController.getPaymentSortedArrayList().search(paymentController.getPaymentSortedArrayList(), tempPayment) != null) {
                    searchingFlags = true;
                    System.out.printf("%-15s %-20s %-25s %-10s %-20s %-15s\n", "Payment ID", "Payment Method", "Order Fees (RM)", "SST (%)", "Delivery Fees (RM)", "Total Payment (RN)");
                    System.out.printf("%-15s %-20s %-25s %-10s %-20s %-15s\n", "----------", "--------------", "---------------", "--------", "------------------", "------------------");
                    System.out.printf("%-15s %-20s %-25.2f %-10.2f %-20.2f %-15.2f\n", tempPayment.getPaymentID(), tempPayment.getPaymentMethod(), tempPayment.getOrderFees(), Payment.getSST(), tempPayment.getDeliveryFees(), tempPayment.getTotalPayment());
                }
            }
        }

        if (!searchingFlags) {
            System.out.println("Payment ID not found.");
            System.out.println("Payment search failed.");
        }
        InterfaceUtils.printFooter();
        InterfaceUtils.continuePrompt("0");
    }

    public void showArrayListCapacity() {
        InterfaceUtils.printHeader();
        InterfaceUtils.printPaymentHeader();

        System.out.println("\nCurrent ArrayList Maximum Capacity: " + paymentController.arrayListCapacity() + "\n");

        InterfaceUtils.printFooter();
        InterfaceUtils.continuePrompt("0");
    }

    public void paymentReport() {
        InterfaceUtils.printHeader();
        InterfaceUtils.printPaymentHeader();

        System.out.println("Total Payments in the system: " + paymentController.getNumberOfPayments());

        System.out.println("Payments Array List:");
        System.out.printf("%-15s %-20s %-25s %-10s %-20s %-15s\n", "Payment ID", "Payment Method", "Order Fees (RM)", "SST (%)", "Delivery Fees (RM)", "Total Payment (RN)");
        System.out.printf("%-15s %-20s %-25s %-10s %-20s %-15s\n", "----------", "--------------", "---------------", "--------", "------------------", "------------------");

        Iterator<Payment> paymentSortedArrayListIterator = paymentController.getPaymentSortedArrayList().getIterator();
        while (paymentSortedArrayListIterator.hasNext()) {
            Payment tempPayment = paymentSortedArrayListIterator.next();
            System.out.printf("%-15s %-20s %-25.2f %-10.2f %-20.2f %-15.2f\n", tempPayment.getPaymentID(), tempPayment.getPaymentMethod(), tempPayment.getOrderFees(), Payment.getSST(), tempPayment.getDeliveryFees(), tempPayment.getTotalPayment());
        }
        InterfaceUtils.printFooter();
        InterfaceUtils.continuePrompt("0");
    }
}
