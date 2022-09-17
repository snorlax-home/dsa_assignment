/*
 * @Author: Wong Yan Zhi @ 21WMR03679
 */
package ADT;

import java.util.Iterator;

public interface SortedListInterface<T> {
    // Add an entry to the list
    public boolean add(T newEntry);

    // Remove an entry from the list
    public boolean remove(T anEntry);

    // Check if the list contains the value
    public boolean contains(String targetEntry, String currentEntry);

    // Replace & Modify the existing entry
    public boolean replace(T selectedEntry, T replacementEntry);

    // Clear all the element in the list
    public void clear();

    // Get the total number of elements in the list
    public int getNumberOfEntries();

    // Check if the list is empty or not
    public boolean isEmpty();

    // Get the size of the list
    public int capacity();

    // Search for the entry in the list
    public <T> T search(T list, T anEntry);

    // Trim the size of the array
    public void trimToSize();

    public Iterator<T> getIterator();
}
