package ADT;

import java.util.Iterator;

public interface LinkedQueueInterface<T> {
  public Iterator<T> getIterator();

  public void enqueue(T newEntry);

  public T dequeue();

  public T getFront();

  public boolean isEmpty();

  public void clear();
}
