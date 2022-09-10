package View;

import Controller.DeliveryController;
import Entity.Delivery;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DeliveryView {

    private final DeliveryController controller;

    public DeliveryView(DeliveryController controller) {
        this.controller = controller;
    }

    public void newDelivery() {
        InterfaceUtils.printHeader();
        Scanner sc = new Scanner(System.in);
        Delivery tempDelivery = new Delivery();
        System.out.println("Please fill in delivery address as following.");
        System.out.print("Address Line 1: ");
        String addressLine1 = sc.nextLine();
        tempDelivery.setAddressLine1(addressLine1);
        System.out.print("Address Line 2: ");
        String addressLine2 = sc.nextLine();
        tempDelivery.setAddressLine2(addressLine2);
        System.out.print("City: ");
        String city = sc.nextLine();
        tempDelivery.setCity(city);
        System.out.print("State: ");
        String state = sc.nextLine();
        tempDelivery.setState(state);
        System.out.print("Zip: ");
        String zip = sc.nextLine();
        tempDelivery.setZip(zip);

        tempDelivery.setDeliveryFee(DeliveryController.generateDeliveryFee());
        tempDelivery.setEstimatedDeliveryTime(
                DeliveryController.generateDeliveryTime()
        );

        controller.addDelivery(tempDelivery);
        InterfaceUtils.continuePrompt("1");
    }

    public void deliveryFee() {
        Delivery currentDelivery = controller.getFrontDelivery();
        if (currentDelivery == null) {
            System.out.println("There is no delivery in queue");
            return;
        }
        InterfaceUtils.printHeader();
        System.out.println("Below are the summary of delivery.");
        System.out.println("--------");
        // Address
        System.out.println("Your address");
        System.out.println("Address Line 1: " + currentDelivery.getAddressLine1());
        System.out.println("Address Line 2: " + currentDelivery.getAddressLine2());
        System.out.println("City: " + currentDelivery.getCity());
        System.out.println("State: " + currentDelivery.getState());
        System.out.println("Zip: " + currentDelivery.getZip());
        System.out.println("--------");
        // Delivery Fee
        System.out.printf("Delivery Fee: RM%.2f%n", currentDelivery.getDeliveryFee());
        // Estimated Delivery Time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                "yyyy-MM-dd HH:mm:ss"
        );
        System.out.println(
                "Estimated Delivery Time: " +
                        currentDelivery.getEstimatedDeliveryTime().format(formatter)
        );
        InterfaceUtils.continuePrompt("1");
    }

    public void deliveryReport() {
        Delivery[] deliveries = controller.getArray();
        InterfaceUtils.printHeader();
        int count = 0;
        for (Delivery d : deliveries) {
            if (d == null) {
                break;
            }
            count++;
            System.out.println("--------");
            // Address
            System.out.println("Your address");
            System.out.println("Address Line 1: " + d.getAddressLine1());
            System.out.println("Address Line 2: " + d.getAddressLine2());
            System.out.println("City: " + d.getCity());
            System.out.println("State: " + d.getState());
            System.out.println("Zip: " + d.getZip());
            System.out.println("--------");
            // Delivery Fee
            System.out.printf("Delivery Fee: RM%.2f%n", d.getDeliveryFee());
            // Estimated Delivery Time
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                    "yyyy-MM-dd HH:mm:ss"
            );
            System.out.println(
                    "Delivery Time: " +
                            d.getEstimatedDeliveryTime().format(formatter)
            );
        }
        System.out.println("--------");
        System.out.println("Total delivery: " + count);
        InterfaceUtils.continuePrompt("1");

    }
}
