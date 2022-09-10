// Author: Ong Tun Jiun

package ADT;

import java.util.Iterator;

public interface LinkedListInterface<T> {
  public void add(T newEntry);

  public boolean add(int newPosition, T newEntry);

  public T remove(int givenPosition);

  public void clear();

  public boolean replace(int givenPosition, T newEntry);

  public T getEntry(int givenPosition);

  public boolean contains(T anEntry);

  public int getNumberOfEntries();

  public boolean isEmpty();

  public Iterator<T> getIterator();
}