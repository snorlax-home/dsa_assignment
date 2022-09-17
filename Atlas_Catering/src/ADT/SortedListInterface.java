/*
 * @Author: Wong Yan Zhi @ 21WMR03679
 */
package ADT;

import java.util.Iterator;

/**
 * SortedListInterface - An interface for the ADT sorted list.
 *
 * @param <T>
 */
public interface SortedListInterface<T> {

    /**
     * Task: Adds a new entry to the sorted list in its proper order.
     *
     * @param newEntry the object to be added as a new entry
     * @return true if the addition is successful
     */
    public boolean add(T newEntry);

    /**
     * Task: Removes a specified entry from the sorted list.
     *
     * @param anEntry the object to be removed
     * @return true if anEntry was located and removed
     */
    public boolean remove(T anEntry);

    public boolean contains(String targetEntry, String currentEntry);

    public boolean replace(T selectedEntry, T replacementEntry);

    public void clear();

    public int getNumberOfEntries();

    public boolean isEmpty();

    public int capacity();

    public <T> T search(T list, T anEntry);

    public Iterator<T> getIterator();
}
