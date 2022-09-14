/*
 * @Author: Wong Yan Zhi @ 21WMR03679
 */
package ADT;

import java.util.Iterator;

/**
 * SortedArrayList - Implements the ADT Sorted List using an array. - Note: Some
 * methods are not implemented yet and have been left as practical exercises
 */
public class SortedArrayList<T extends Comparable<T>> implements SortedListInterface<T> {

    private T[] array;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 5;

    public SortedArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public SortedArrayList(int initialCapacity) {
        numberOfEntries = 0;
        array = (T[]) new Comparable[initialCapacity];
    }

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

    public void clear() {
        numberOfEntries = 0;
    }

    public boolean contains(String targetEntry, String currentEntry) {
        boolean results = false;
        if (targetEntry.equals(currentEntry)) {
            results = true;
        } else {
            results = false;
        }

        return results;
    }

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

    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    public String toString() {
        String outputStr = "";
        for (int index = 0; index < numberOfEntries; ++index) {
            outputStr += array[index] + "\n";
        }

        return outputStr;
    }

    private boolean isArrayFull() {
        return numberOfEntries == array.length;
    }

    private void expandArray() {
        T[] oldList = array;
        int oldSize = oldList.length;

        array = (T[]) new Comparable[2 * oldSize];

        for (int index = 0; index < oldSize; index++) {
            array[index] = oldList[index];
        }
    }

    private void makeRoom(int newPosition) {
        int newIndex = newPosition - 1;
        int lastIndex = numberOfEntries - 1;

        for (int index = lastIndex; index >= newIndex; index--) {
            array[index + 1] = array[index];
        }
    }

    private void removeGap(int givenPosition) {
        int removedIndex = givenPosition - 1;
        int lastIndex = numberOfEntries - 1;

        for (int index = removedIndex; index < lastIndex; index++) {
            array[index] = array[index + 1];
        }
    }

    public int capacity() {
        return array.length;
    }

    public <T> T search(T list, T anEntry) {
        Iterator<?> givenIterator = ((SortedListInterface<T>) list).getIterator();
        while (givenIterator.hasNext()) {
            T entry = (T) givenIterator.next();

            if (entry.equals(anEntry)) {
                return (T) entry;
            }
        }

        return null;
    }

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
