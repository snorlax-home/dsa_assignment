/*
 * @Author: Wong Yan Zhi @ 21WMR03679
 */
package ADT;

import java.util.Iterator;

// Sorted Array List = An array of sorted list
public class SortedArrayList<T extends Comparable<T>> implements SortedListInterface<T> {

    private T[] array;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 5;

    // Constructors
    public SortedArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public SortedArrayList(int initialCapacity) {
        numberOfEntries = 0;
        array = (T[]) new Comparable[initialCapacity]; // Initialization of the array
    }

    /*
     * Before adding the new entry, we need to check if the array list is full or not. If
     * the list is full, we need to double the size of the list. 
     */
    public boolean add(T newEntry) {
        if (isArrayFull()) {
            expandArray();
        }

        int i = 0;
        while (i < numberOfEntries && newEntry.compareTo(array[i]) > 0) {
            i++;
        }
        makeRoom(i + 1);
        array[i] = newEntry;
        numberOfEntries++;

        return true;
    }

    /*
     * Before removing the entry, we need check if the array list is empty or not. If the
     * list is empty, there is no need to remove the entry.
     */
    public boolean remove(T anEntry) {
        if (numberOfEntries == 0) {
            return false;
        } else {
            int index = 0;
            while (index < numberOfEntries && array[index].compareTo(anEntry) < 0) {
                index++;
            }
            if (array[index].equals(anEntry)) {
                removeGap(index + 1);
                numberOfEntries--;
                return true;
            }
        }
        return false;
    }

    // Check if two values are identical
    public boolean contains(String targetEntry, String currentEntry) {
        boolean results = false;
        if (targetEntry.equals(currentEntry)) {
            results = true;
        } else {
            results = false;
        }

        return results;
    }

    // Replace the entry if they are the same
    public boolean replace(T targetedEntry, T replacementEntry) {
        if (numberOfEntries == 0) {
            return false;
        } else {
            int index = 0;
            while (index < numberOfEntries && array[index].compareTo(targetedEntry) < 0) {
                index++;
            }
            if (array[index].equals(targetedEntry)) {
                array[index] = replacementEntry;
                return true;
            }
        }
        return false;
    }

    // Clean up the array list
    public void clear() {
        numberOfEntries = 0;
    }

    // Get the total number of elements in the array list
    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    // Check if the array list is empty or not
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    // Get the size of the array list
    public int capacity() {
        return array.length;
    }

    /*
     * Search for the entry in the array list. If the entry is found, return the entry.
     * If the entry is not found, return null.
     */
    public <T> T search(T list, T anEntry) {
        // Creating Iterator
        Iterator<?> givenIterator = ((SortedListInterface<T>) list).getIterator();
        // While there are still element exists
        while (givenIterator.hasNext()) {
            T entry = (T) givenIterator.next();

            // If the entry is found, return the entry
            if (entry.equals(anEntry)) {
                return (T) entry;
            }
        }

        return null;
    }

    // Simple toString method to print out the elements in the array list
    public String toString() {
        String outputStr = "";
        for (int index = 0; index < numberOfEntries; ++index) {
            outputStr += array[index] + "\n";
        }

        return outputStr;
    }

    // Check if the array list is full or not
    private boolean isArrayFull() {
        return numberOfEntries == capacity();
    }

    /*
     * Creating a new array where its size is twice the size of the original array list.
     * Copy the elements from the original array list to the new array list.
     */
    private void expandArray() {
        T[] oldList = array;
        int oldSize = oldList.length;

        array = (T[]) new Comparable[2 * oldSize];

        for (int index = 0; index < oldSize; index++) {
            array[index] = oldList[index];
        }
    }

    /*
     * Make room for the new entry by shifting the elements to the right. 
     * The new entry will be placed at the index of the array list.
     */
    private void makeRoom(int newPosition) {
        int newIndex = newPosition - 1;
        int lastIndex = numberOfEntries - 1;

        for (int index = lastIndex; index >= newIndex; index--) {
            array[index + 1] = array[index];
        }
    }

    /*
     * Remove the gap by shifting the elements to the left. 
     * The entry will be removed at the index of the array list.
     */
    private void removeGap(int givenPosition) {
        int removedIndex = givenPosition - 1;
        int lastIndex = numberOfEntries - 1;

        for (int index = removedIndex; index < lastIndex; index++) {
            array[index] = array[index + 1];
        }
    }

    /*
     * Create a new array that the capacity fits exactly the number of elements
     * inside the list, then copy all the elements of the list into that new array.
     */
    public void trimToSize() {
        T[] oldList = array;

        array = (T[]) new Comparable[numberOfEntries];

        for (int index = 0; index < numberOfEntries; index++) {
            array[index] = oldList[index];
        }
    }

    // Get the iterator of the array list
    public Iterator<T> getIterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        // private Node currentNode = firstNode;

        int index;

        public boolean hasNext() {
            return index < numberOfEntries;
        }

        public T next() {
            T temp = null;
            if (hasNext()) {
                temp = array[index];
                index++;
            }
            return temp;
        }
    }
}
