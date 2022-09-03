package Controller;

import ADT.DeliveryQueue;
import ADT.QueueInterface;
import Entity.Delivery;
import java.time.LocalDateTime;

public class DeliveryController {

  private QueueInterface<Delivery> deliveryQueue;

  public DeliveryController() {
    deliveryQueue = new DeliveryQueue<>();
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
    Delivery delivery = new Delivery(
      addressLine1,
      addressLine2,
      city,
      state,
      zip,
      generateDeliveryFee(),
      generateDeliveryTime(null)
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

  public static LocalDateTime generateDeliveryTime(LocalDateTime orderTime) {
    int deliveryTime = 30;
    orderTime = orderTime != null ? orderTime : LocalDateTime.now();
    return orderTime.plusMinutes(deliveryTime);
  }

  public static double generateDeliveryFee() {
    return 2.0;
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
}
