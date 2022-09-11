/**
 * @author Ong Tun Jiun
 */


package ADT;

import java.util.Iterator;

public class LinkedList<T> implements LinkedListInterface<T> {
    // Attributes
    private Node firstNode;
    private int numberOfEntries;

    // Constructor
    public LinkedList() {
        clear();
    }

    private class Node {
        // Attributes of Node class
        private T data;
        private Node next;

        // Constructors of Node class
        private Node(T dataPortion) {
            this(dataPortion, null);
        }

        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }

        // Getters and Setters of Node class
        private T getData() {
            return data;
        }

        private void setData(T newData) {
            data = newData;
        }

        private Node getNextNode() {
            return next;
        }

        private void setNextNode(Node nextNode) {
            next = nextNode;
        }

        // Methods of Node class
        public String toString() {
            return data.toString();
        }

    }

    // Methods of LinkedList class
    // Adds a new node with the new entry to the end of the linked list.
    public void add(T newEntry) {
        Node newNode = new Node(newEntry);

        // If the linked list is empty, the new node will be the first node.
        if (isEmpty())
            firstNode = newNode;
        // If the linked list is not empty, the new node will be the last node.
        else {
            Node lastNode = getNodeAt(numberOfEntries - 1);
            lastNode.setNextNode(newNode);
        }

        numberOfEntries++;
    }

    // Adds a new node with the new entry to the linked list at a specified
    // position.
    public boolean add(int newPosition, T newEntry) {
        boolean isSuccessful = false;

        // Check if the new position is between zero and the number of entries of the
        // linked list.
        if ((newPosition >= 0) && (newPosition <= numberOfEntries)) {
            Node newNode = new Node(newEntry);

            // If the linked list is empty, the new node will be the first node.
            if (newPosition == 0) {
                newNode.setNextNode(firstNode);
                firstNode = newNode;
            }
            /*
             * If the new position is equal to the number of entries of the linked list,
             * then the current last node will point to the node of the new entry.
             */
            else if (newPosition == numberOfEntries) {
                Node lastNode = getNodeAt(numberOfEntries - 1);
                lastNode.setNextNode(newNode);
            }
            /*
             * Otherwise,
             * the node of the new entry will point to the node after it,
             * and the node before it will point to the new node.
             */
            else {
                Node nodeBefore = getNodeAt(newPosition - 1);
                Node nodeAfter = nodeBefore.getNextNode();
                newNode.setNextNode(nodeAfter);
                nodeBefore.setNextNode(newNode);
            }
            numberOfEntries++;
            isSuccessful = true;
        }

        return isSuccessful;

    }

    // Removes the node at a given position from the linked list.
    public T remove(int givenPosition) {
        T result = null;

        /*
         * Check if he linked list is not empty, and the given position is between zero
         * and the number of entries of the linked list minus by one.
         */
        if (!isEmpty() && (givenPosition >= 0) && (givenPosition <= numberOfEntries - 1)) {

            /*
             * If the given position is zero, the node after the first node will become the
             * new first node and the linked list's number of entries is decreased by 1.
             * 
             * Otherwise, the node before the removed node will point to the node after the
             * removed node and the linked list's number of entries is decreased by 1.
             * 
             */
            if (givenPosition == 0) {
                result = firstNode.getData();
                firstNode = firstNode.getNextNode();
            } else {
                Node nodeBefore = getNodeAt(givenPosition - 1);
                Node nodeToRemove = nodeBefore.getNextNode();
                Node nodeAfter = nodeToRemove.getNextNode();
                nodeBefore.setNextNode(nodeAfter);
                result = nodeToRemove.getData();
            }
            numberOfEntries--;
        }

        return result;
    }

    // Removes all nodes from the linked list.
    public void clear() {
        firstNode = null;
        numberOfEntries = 0;
    }

    // Replaces the data of the node at a given position in the linked list.
    public boolean replace(int givenPosition, T newEntry) {
        boolean isSuccessful = false;
        /*
         * Check if the linked list is not empty, 
         * and the given position is between zero and 
         * the number of entries of the linked list minus by one.
         */
        if (!isEmpty() && (givenPosition >= 0) && (givenPosition <= numberOfEntries - 1)) {
            // The data of the node at the given position is replaced with the new entry.
            Node desiredNode = getNodeAt(givenPosition);
            desiredNode.setData(newEntry);
            isSuccessful = true;
        }

        return isSuccessful;
    }

    // Retrieves the data of the node at a given position in the linked list.
    public T getEntry(int givenPosition) {
        T result = null;
        /*
         * Check if ehe linked list is not empty, 
         * and the given position is between zero 
         * and the number of entries of the linked list minus by one.
         */
        if (!isEmpty() && (givenPosition >= 0) && (givenPosition <= numberOfEntries - 1)) {
            // The data of the node at the given position is retrieved.
            result = getNodeAt(givenPosition).getData();
        }

        return result;
    }

    // Sees whether the linked list has a node that contains a given entry.
    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;

        // Loop through the linked list until the end of the linked list is reached.
        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.getData())) {
                found = true;
            } else {
                currentNode = currentNode.getNextNode();
            }
        }
        return found;
    }

    // Retrieves the number of nodes in the linked list.
    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    // Sees whether the linked list is empty.
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    // Retrieves the node at a given position in the linked list.
    private Node getNodeAt(int givenPosition) {
        /*
         * Check if ehe linked list is not empty, 
         * and the given position is between zero 
         * and the number of entries of the linked list minus by one.
         */
        if (!isEmpty() && (givenPosition >= 0) && (givenPosition <= numberOfEntries - 1)) {
            Node currentNode = firstNode;
            // Loop through the linked list until the given position is reached.
            for (int counter = 0; counter < givenPosition; counter++) {
                currentNode = currentNode.getNextNode();
            }
            // Check to see if the current node is not null.
            if (currentNode != null) {
                return currentNode;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    // Get the iterator for the linked list.
    public Iterator<T> getIterator() {
        return new IteratorForLinkedList();
    }

    // Iterator class for the linked list.
    private class IteratorForLinkedList implements Iterator<T> {
        // Attributes of the IteratorForLinkedList
        private Node nextNode;

        // Constructor of the IteratorForLinkedList
        private IteratorForLinkedList() {
            nextNode = firstNode;
        }

        // Methods of the IteratorForLinkedList
        // Sees whether the linked list has a next node.
        public boolean hasNext() {
            return nextNode != null;
        }

        public T next() {
            T result = null;
            // Sees whether the linked list has a next node.
            if (hasNext()) {
                // The data of the next node is retrieved.
                result = nextNode.getData();
                // The next node is set to the node after the current node.
                nextNode = nextNode.getNextNode();
            }
            return result;
        }
    }

    public String toString() {
        String outputStr = "";
        Node currentNode = firstNode;
        // Loop through the linked list until the end of the linked list is reached.
        while (currentNode != null) {
            // The data of the current node's toString return value is added to the output string.
            outputStr += currentNode.getData().toString() + "\n";
            // The current node is set to the node after the current node.
            currentNode = currentNode.getNextNode();
        }
        return outputStr;
    }
}