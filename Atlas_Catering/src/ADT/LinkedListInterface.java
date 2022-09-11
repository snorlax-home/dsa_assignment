/**
 * @author Ong Tun Jiun
 */


package ADT;

import java.util.Iterator;

public interface LinkedListInterface<T> {
  // Adds a new entry to the end of this list.
  public void add(T newEntry);

  // Adds a new entry at a specified position within this list.
  public boolean add(int newPosition, T newEntry);

  // Removes the entry at a given position from this list.
  public T remove(int givenPosition);

  // Removes all entries from this list.
  public void clear();

  // Replaces the entry at a given position in this list.
  public boolean replace(int givenPosition, T newEntry);

  // Retrieves the entry at a given position in this list.
  public T getEntry(int givenPosition);

  // Retrieves all entries that are in this list in the order in which they occur in the list.
  public boolean contains(T anEntry);

  // Get the length/number of entries in this list.
  public int getNumberOfEntries();

  // Checks whether this list is empty.
  public boolean isEmpty();

  // Returns an iterator of the linkedList
  public Iterator<T> getIterator();
}