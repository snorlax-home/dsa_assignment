// Author: Ong Tun Jiun

package ADT;

import java.util.Iterator;

public interface LinkedListInterface<T> {
  public Iterator<T> getIterator();

  public void add(T newEntry);

  public void add(int newPosition, T newEntry);

  public T remove(int givenPosition);

  public void clear();

  public T replace(int givenPosition, T newEntry);

  public T getEntry(int givenPosition);

  public boolean contains(T anEntry);

  public int getLength();

  public boolean isEmpty();

  public boolean isFull();
}