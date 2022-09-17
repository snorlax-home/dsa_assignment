//Author: Goh Neng Fu

package Controller;

import java.util.Iterator;
import java.util.Scanner;

import ADT.LinkedQueue;
import ADT.LinkedQueueInterface;
import Entity.Order;
import Entity.Product;
import View.InterfaceUtils;
import View.OrderView;

public class OrderController {
    private OrderView view;
    private LinkedQueue<Order> orderQueue;

    // constructor
    public OrderController(){
        orderQueue = new LinkedQueue<Order>();
        this.view = new OrderView();
    }

    // getters
    public LinkedQueueInterface<Order> getOrderQueue() {
        return orderQueue;
    }

    // add method
    public void addOrder() {
        view.addOrder();
        Scanner sc = new Scanner(System.in);
        
        // Ask user to input order no
        System.out.println("Enter the order details:");
        System.out.print("Order No:");
        String orderNo = sc.nextLine();
        
        System.out.print("Order Price:");
        Double orderPrice = sc.nextDouble();

        Order tempOrder = new Order(orderNo, orderPrice, new Product());
        
        // for user to prompt again
        InterfaceUtils.continuePrompt("1");
        orderQueue.enqueue(tempOrder);
    }

    // remove method
    public void removeOrder() {
        view.removeOrder();

        Scanner sc = new Scanner(System.in);
        // Ask user to input order no
        System.out.print("Please fill in the Order No:");
        String orderNo = sc.nextLine();

        Iterator<Order> orderQueueIterator = getOrderQueue().getIterator();

        while (orderQueueIterator.hasNext()) {
            Order tempOrder = orderQueueIterator.next();
            if (tempOrder.getOrderNo().equals(orderNo)) {
                // Order removedOrder = orderController.removedOrder(orderNo);
                Order removeOrder = orderQueue.dequeue();
                if (removeOrder != null) {
                    System.out.println("Order " + removeOrder.getOrderNo() + " has been removed.");
                } else {
                    System.out.println("Order not found.");
                }
            }
        }
        // for user to prompt again
        InterfaceUtils.continuePrompt("1");
    }

    public void showOrderReport(){
        view.orderReport(orderQueue.getIterator().next());
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
