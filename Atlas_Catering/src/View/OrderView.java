//Author: Goh Neng Fu

package View;

import Controller.OrderController;
import Entity.Order;
import Entity.Product;

import java.util.Scanner;

import ADT.LinkedQueue;
import ADT.LinkedQueueInterface;

import java.util.Iterator;

public class OrderView {
    private OrderController orderController;

    public OrderView(OrderController orderController) {
        this.orderController = orderController;
    }

    public void addOrder() {
        // print header
        InterfaceUtils.printHeader();
        InterfaceUtils.printOrderHeader();

        Scanner sc = new Scanner(System.in);
        Order tempOrder = new Order();

        // Ask user to input order no
        System.out.println("Enter the order details:");
        System.out.print("Order No:");
        String orderNo = sc.nextLine();
        tempOrder.setOrderNo(orderNo);

        InterfaceUtils.continuePrompt("1");
    }

    public void removeOrder() {
        // print header
        InterfaceUtils.printHeader();
        InterfaceUtils.printOrderHeader();
        Scanner sc = new Scanner(System.in);

        // Ask user to input order no
        System.out.print("Please fill in the Order No:");
        String orderNo = sc.nextLine();

        Iterator<Order> orderQueueIterator = orderController.getOrderQueue().getIterator();
        int firstNode = -1;
        while (orderQueueIterator.hasNext()) {
            Order tempOrder = orderQueueIterator.next();
            if (tempOrder.getOrderNo().equals(orderNo)) {
                Order removedOrder = orderController.removedOrder(orderNo);
                if (removedOrder != null) {
                    System.out.println("Order " + removedOrder.getOrderNo() + " has been removed.");
                } else {
                    System.out.println("Order not found.");
                }
            }
        }
        // for user to prompt again
        InterfaceUtils.continuePrompt("1");
    }

    public void orderReport() {
        // print header
        InterfaceUtils.printHeader();
        InterfaceUtils.printOrderHeader();

        // print order list header
        System.out.println("Order Report");
        System.out.printf("%-15s %-25s %-50s\n", "Order No", "Product Name", "Order Price (RM)");
        System.out.printf("%-15s %-25s %-50s\n", "--------", "------------", "------------------");
        Iterator<Order> orderQueueIterator = orderController.getOrderQueue().getIterator();
        while (orderQueueIterator.hasNext()) {
            Order tempOrder = orderQueueIterator.next();
            System.out.printf("%-15s %-25s %-50s %18.2f\n", tempOrder.getOrderNo(), tempOrder.getProducts(),
                    tempOrder.getOrderPrice());
        }
        // for user to prompt again
        InterfaceUtils.continuePrompt("1");
    }
}
