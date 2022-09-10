package Driver;

import ADT.Queue;
import Controller.DeliveryController;
import Entity.Delivery;
import View.DeliveryView;
import View.InterfaceUtils;

public class DeliveryDriver {

    private static void init(DeliveryController controller) {
        System.out.println("Initializing delivery queue...");
        controller.addDelivery("Lot 12, Jalan ABC", "Taman XYZ", "Kuala Lumpur", "Wilayah Persekutuan", "12345");
        controller.addDelivery("Lot 42, Jalan JIK", "Taman QWE", "Kuala Lumpur", "Wilayah Persekutuan", "12345");
        controller.addDelivery("Lot 32, Jalan RST", "Taman UIV", "Kuala Lumpur", "Wilayah Persekutuan", "12345");
        controller.addDelivery("Lot 22, Jalan YUI", "Taman HJK", "Kuala Lumpur", "Wilayah Persekutuan", "12345");
        controller.addDelivery("Lot 12, Jalan MNB", "Taman VBN", "Kuala Lumpur", "Wilayah Persekutuan", "12345");
        controller.addDelivery("Lot 12, Jalan ABC", "Taman XYZ", "Kuala Lumpur", "Wilayah Persekutuan", "12345");
        controller.addDelivery("Lot 42, Jalan JIK", "Taman QWE", "Kuala Lumpur", "Wilayah Persekutuan", "12345");
        controller.addDelivery("Lot 32, Jalan RST", "Taman UIV", "Kuala Lumpur", "Wilayah Persekutuan", "12345");
        controller.addDelivery("Lot 22, Jalan YUI", "Taman HJK", "Kuala Lumpur", "Wilayah Persekutuan", "12345");
        System.out.println("Delivery queue initialized.");
    }

    private static void test(DeliveryController controller) {
        System.out.println("Test Start");
        Queue<Delivery> currentDelivery = (Queue<Delivery>) controller.getDeliveryQueue().clone();
        System.out.println("Test 1 : Queue - clone()");
        System.out.println("1.1 : Check whether clone is equal to original queue. Expected : Passed");
        System.out.print(currentDelivery.equals(controller.getDeliveryQueue()) ? " - Passed \n" : " - Failed\n");

        System.out.println("1.2 : Check whether clone is equal to original queue after dequeue. Expected : Failed");
        Delivery nextDelivery = controller.getNextDelivery();
        System.out.println(currentDelivery.equals(controller.getDeliveryQueue()) ? " - Passed \n" : " - Failed\n");

        System.out.println("Test 2 : Queue - contains()");
        System.out.println("2.1 Check whether original queue contains the next delivery. Expected : Failed");
        System.out.println(controller.getDeliveryQueue().contains(nextDelivery) ? " - Passed \n" : " - Failed\n");

        System.out.println("2.2 Check whether cloned queue contains the next delivery. Expected : Passed");
        System.out.println(currentDelivery.contains(nextDelivery) ? " - Passed \n" : " - Failed\n");

        System.out.println("Test 3 : Queue - containsAll()");
        Delivery[] deliveries = new Delivery[2];
        deliveries[0] = nextDelivery;
        deliveries[1] = controller.getNextDelivery();
        System.out.println("3.1 Check whether original queue contains all the next 2 deliveries. Expected : Failed");
        System.out.println(controller.getDeliveryQueue().containsAll(deliveries) ? " - Passed \n" : " - Failed\n");
        System.out.println("3.2 Check whether cloned queue contains all the next 2 deliveries. Expected : Passed");
        System.out.println(currentDelivery.containsAll(deliveries) ? " - Passed \n" : " - Failed\n");
        System.out.println("Test ended");

    }

    public static void main(String[] args) {
        DeliveryController controller = new DeliveryController();
        DeliveryView view = new DeliveryView(controller);
        int choice = 0;
        while (choice != 7) {
            InterfaceUtils.printHeader();
            System.out.println("Delivery");
            System.out.println("--------");
            System.out.println("1. New Delivery");
            System.out.println("2. Delivery Fee");
            System.out.println("3. Dequeue top");
            System.out.println("4. Report");
            System.out.println("5. Initialize");
            System.out.println("6. Test");
            System.out.println("7. Exit");
            System.out.print("Please enter your choice: ");
            choice = InterfaceUtils.getChoice(7);
            switch (choice) {
                case 1 -> view.newDelivery();
                case 2 -> view.deliveryFee();
                case 3 -> controller.getNextDelivery();
                case 4 -> view.deliveryReport();
                case 5 -> init(controller);
                case 6 -> test(controller);
                case 7 -> System.out.println("Thank you for using Atlas Catering!");
            }
        }
    }
}
