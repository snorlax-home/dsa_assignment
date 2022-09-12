package Driver;

import Controller.PaymentController;
import View.PaymentView;
import View.InterfaceUtils;

public class PaymentDriver {
    public static void initialize(PaymentController paymentController) {
        System.out.println("Initializing Payment Sorted Array List...");
        paymentController.addPayment("P0005", "Cash", 10.00, 5.00);
        paymentController.addPayment("P0002", "TnG", 15.00, 10.00);
        paymentController.addPayment("P0001", "Card", 5.00, 2.00);
        paymentController.addPayment("P0007", "Card", 25.00, 3.00);
        paymentController.addPayment("P0009", "Cash", 20.00, 7.00);
        paymentController.addPayment("P0010", "TnG", 30.00, 4.00);
        paymentController.addPayment("P0008", "Grab", 40.00, 8.00);
        paymentController.addPayment("P0003", "Grab", 50.00, 6.00);
        paymentController.addPayment("P0006", "Cash", 35.00, 1.00);
        paymentController.addPayment("P0004", "TnG", 45.00, 9.00);
        System.out.println("Payment Sorted Array List initialize completed!\n");
    }

    public static void main(String[] args) {
        PaymentController paymentController = new PaymentController();
        PaymentView paymentView = new PaymentView(paymentController);
        
        int choice = 0;
        while (choice != 5) {
            InterfaceUtils.printHeader();
            InterfaceUtils.printPaymentHeader();
            System.out.println("Please select an option below:-");
            System.out.println("1. Add Payment");
            System.out.println("2. Show Report");
            System.out.println("4. Initialize");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            choice = InterfaceUtils.getChoice(5);

            switch (choice) {
                case 1:
                    paymentView.addPayment();
                    break;
                
                case 2:
                    paymentView.paymentReport();
                    break;

                case 3:
                    // paymentView.updatePayment();
                    break;
                
                case 4:
                    initialize(paymentController);
                    break;

                case 5:
                    System.out.println("\nThank you for using Atlas Catering!");
                    break;
            }
        }
    }
}
