package Controller;

import ADT.Queue;
import ADT.QueueInterface;
import Entity.Delivery;

import java.lang.reflect.Array;
import java.time.LocalDateTime;

/**
 * @author Tan Yi Hong
 */

public class DeliveryController {

    private final Queue<Delivery> deliveryQueue;

    public DeliveryController() {
        deliveryQueue = new Queue<>();
    }

    public void addDelivery(Delivery delivery) {
        deliveryQueue.enqueue(delivery);
    }

    public void addDelivery(
            String addressLine1,
            String addressLine2,
            String city,
            String state,
            String zip
    ) {
        double deliveryFee = generateDeliveryFee();
        LocalDateTime estimatedDeliveryTime = generateDeliveryTime();

        Delivery delivery = new Delivery(
                addressLine1,
                addressLine2,
                city,
                state,
                zip,
                deliveryFee,
                estimatedDeliveryTime
        );
        deliveryQueue.enqueue(delivery);
    }

    public void addDelivery(
            String addressLine1,
            String addressLine2,
            String city,
            String state,
            String zip,
            double deliveryFee,
            LocalDateTime estimatedDeliveryTime
    ) {
        Delivery delivery = new Delivery(
                addressLine1,
                addressLine2,
                city,
                state,
                zip,
                deliveryFee,
                estimatedDeliveryTime
        );
        deliveryQueue.enqueue(delivery);
    }

    public static LocalDateTime generateDeliveryTime() {
        int deliveryTime = 30;
        LocalDateTime orderTime = LocalDateTime.now();
        return orderTime.plusMinutes(deliveryTime);
    }

    public static double generateDeliveryFee() {
        return 2.0;
    }

    public Queue<Delivery> getDeliveryQueue() {
        return deliveryQueue;
    }

    public Delivery getNextDelivery() {
        return deliveryQueue.dequeue();
    }

    public Delivery getFrontDelivery() {
        return deliveryQueue.getFront();
    }

    public boolean isEmpty() {
        return deliveryQueue.isEmpty();
    }

    public boolean isFull() {
        return deliveryQueue.isFull();
    }

    public int getSize() {
        return deliveryQueue.getSize();
    }

    public void clear() {
        deliveryQueue.clear();
    }

    public Delivery[] getArray() {
        Delivery[] deliveryArray = (Delivery[]) Array.newInstance(Delivery.class, getSize());
        QueueInterface<Delivery> tempQueue = deliveryQueue.clone();
        for (int i = 0; i < getSize(); i++) {
            deliveryArray[i] = tempQueue.dequeue();
        }

        return deliveryArray;
    }
}
