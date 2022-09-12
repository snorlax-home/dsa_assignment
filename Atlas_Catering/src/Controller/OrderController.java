//Author: Goh Neng Fu

package Controller;

import java.util.Iterator;

import ADT.LinkedQueue;
import ADT.LinkedQueueInterface;
import Entity.Order;
import Entity.Product;

public class OrderController {
    private LinkedQueueInterface<Order> orderQueue;

    // constructor
    public OrderController(){
        orderQueue = new LinkedQueue<>();
    }

    // getters
    public LinkedQueueInterface<Order> getOrderQueue() {
        return orderQueue;
    }

    // add method
    public void addOrder(Order order) {
        orderQueue.enqueue(order);
    }

    public void addOrder(String orderNo, double orderPrice, Product product) {
        Order order = new Order(orderNo,orderPrice);
        orderQueue.enqueue(order);
    }

    // remove method
    public void removeOrder() {
        orderQueue.dequeue();
    }

    // show next queue
    public void viewNextOrder() {
        orderQueue.getFront();
    }

    // clear the queue
    public void clearOrder() {
        orderQueue.clear();
    }

    // check whether queue is empty
    public boolean orderIsEmpty() {
        return orderQueue.isEmpty();
    }

    // get iterator method
    public Iterator<Order> getIterator() {
        return orderQueue.getIterator();
    }
}
