package ADT;

import java.util.Iterator;

public interface QueueInterface<T> {
  public Iterator<T> getIterator();

  public void enqueue(T newEntry);

  public T dequeue();

  public T getFront();

  public boolean isEmpty();

  public boolean isFull();

  public void clear();

  public int getSize();
}
