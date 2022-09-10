package Controller;

import ADT.LinkedQueue;
import ADT.LinkedQueueInterface;
import Entity.Order;
import java.util.Iterator;

public class OrderController {
    private LinkedQueueInterface<Order> orderQueue;

    public OrderController(){
        orderQueue = new LinkedQueue<>();
    }

    public LinkedQueueInterface<Order> getOrderQueue() {
        return orderQueue;
    }

    public void addOrder(Order order) {
        orderQueue.enqueue(order);
    }

    public void addOrder(String orderNo, double orderPrice) {
        Order order = new Order(orderNo,orderPrice);
        orderQueue.enqueue(order);
    }

    public void removeOrder() {
        orderQueue.dequeue();
    }

    public void viewNextOrder() {
        orderQueue.getFront();
    }

    public void clearOrder() {
        orderQueue.clear();
    }
}
