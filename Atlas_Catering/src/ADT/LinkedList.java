// Author: Ong Tun Jiun

package ADT;

import java.util.Iterator;

public class LinkedList<T> implements LinkedListInterface<T> {
    private Node firstNode;
    private int numberOfEntries;

    public LinkedList() {
        clear();
    }

    private class Node {
        private T data;
        private Node next;

        private Node(T dataPortion) {
            this(dataPortion, null);
        }

        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }

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
    }

    public void add(T newEntry) {
        Node newNode = new Node(newEntry);
        if (isEmpty()) {
            firstNode = newNode;
        } else {
            Node lastNode = getNodeAt(numberOfEntries);
            lastNode.setNextNode(newNode);
        }
        numberOfEntries++;
    }

    public void add(int newPosition, T newEntry) {
        if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
            Node newNode = new Node(newEntry);
            if (newPosition == 1) {
                newNode.setNextNode(firstNode);
                firstNode = newNode;
            } else {
                Node nodeBefore = getNodeAt(newPosition - 1);
                Node nodeAfter = nodeBefore.getNextNode();
                newNode.setNextNode(nodeAfter);
                nodeBefore.setNextNode(newNode);
            }
            numberOfEntries++;
        } else {
            throw new IndexOutOfBoundsException("Illegal position given to add operation.");
        }
    }

    public T remove(int givenPosition) {
        T result = null;
        if (!isEmpty() && (givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            if (givenPosition == 1) {
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
            return result;
        } else {
            throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
        }
    }

    public void clear() {
        firstNode = null;
        numberOfEntries = 0;
    }

    public boolean replace(int givenPosition, T newEntry) {
        boolean isSuccessful = false;
        if (!isEmpty() && (givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            Node desiredNode = getNodeAt(givenPosition);
            desiredNode.setData(newEntry);
            isSuccessful = true;
        } else {
            // TODO: Do we need to throw an exception?
            throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
        }
        return isSuccessful;
    }

    public T getEntry(int givenPosition) {
        if (!isEmpty() && (givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            return getNodeAt(givenPosition).getData();
        } else {
            // TODO: Do we need to throw an exception?
            throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
        }
    }

    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;
        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.getData())) {
                found = true;
            } else {
                currentNode = currentNode.getNextNode();
            }
        }
        return found;
    }

    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    private Node getNodeAt(int givenPosition) {
        if (!isEmpty() && (givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            Node currentNode = firstNode;
            for (int counter = 1; counter < givenPosition; counter++) {
                currentNode = currentNode.getNextNode();
            }
            if (currentNode != null) {
                return currentNode;
            } else {
                // TODO: Do we need to throw an exception?
                throw new IndexOutOfBoundsException("Illegal position given to getNodeAt operation.");
            }
        } else {
            // TODO: Do we need to throw an exception?
            throw new IndexOutOfBoundsException("Illegal position given to getNodeAt operation.");
        }
    }

    public Iterator<T> getIterator() {
        return new IteratorForLinkedList();
    }

    private class IteratorForLinkedList implements Iterator<T> {
        private Node nextNode;

        private IteratorForLinkedList() {
            nextNode = firstNode;
        }

        public boolean hasNext() {
            return nextNode != null;
        }

        public T next() {
            T result;
            if (hasNext()) {
                result = nextNode.getData();
                nextNode = nextNode.getNextNode();
            } else {
                // TODO: Do we need to throw an exception?
                throw new IndexOutOfBoundsException("Illegal position given to next operation.");
            }
            return result;
        }
    }
}