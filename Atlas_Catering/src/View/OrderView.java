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

    public void addOrder() {
        // print header
        InterfaceUtils.printHeader();
        InterfaceUtils.printOrderHeader();
        System.out.println("ADD ORDER ");
    }

    public void removeOrder() {
        // print header
        InterfaceUtils.printHeader();
        InterfaceUtils.printOrderHeader();
    }

    public void orderReport(Order order) {
        // print header
        InterfaceUtils.printHeader();
        InterfaceUtils.printOrderHeader();

        // print order list header
        System.out.println("Order Report");
        System.out.printf("%-15s %-25s %-50s\n", "Order No", "Product Name", "Order Price (RM)");
        System.out.printf("%-15s %-25s %-50s\n", "--------", "------------", "------------------");
       
        System.out.printf("%-15s %-25s %-50s %18.2f\n", order.getOrderNo(), order.getProducts(),
        // for user to prompt again
        InterfaceUtils.continuePrompt("1");
    }
}
