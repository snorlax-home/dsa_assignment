package ADT;

import java.util.Iterator;

public class DeliveryQueue<T> implements QueueInterface<T> {

  private T[] array;
  private static final int frontIndex = 0;
  private int backIndex;
  private static final int DEFAULT_CAPACITY = 10;

  public DeliveryQueue() {
    this(DEFAULT_CAPACITY);
  }

  public DeliveryQueue(int initialCapacity) {
    array = (T[]) new Object[initialCapacity];
    backIndex = -1;
  }

  @Override
  public void enqueue(T newEntry) {
    // Enqueue
    if (!isFull()) {
      backIndex++;
      array[backIndex] = newEntry;
    }
  }

  @Override
  public T dequeue() {
    // Dequeue
    T front = null;
    if (!isEmpty()) {
      front = array[frontIndex];
      for (int i = frontIndex; i < backIndex; ++i) {
        array[i] = array[i + 1];
      }
      backIndex--;
    }
    return front;
  }

  @Override
  public T getFront() {
    // Get front
    T front = null;
    if (!isEmpty()) {
      front = array[frontIndex];
    }
    return front;
  }

  @Override
  public boolean isEmpty() {
    // Is empty
    return frontIndex > backIndex;
  }

  @Override
  public boolean isFull() {
    // Is full
    return backIndex == array.length - 1;
  }

  @Override
  public void clear() {
    // Clear
    if (!isEmpty()) {
      for (int index = frontIndex; index <= backIndex; index++) {
        array[index] = null;
      }
      backIndex = -1;
    }
  }

  @Override
  public int getSize() {
    // Get size
    return backIndex - frontIndex + 1;
  }

  @Override
  public Iterator<T> getIterator() {
    return new DeliveryQueueIterator();
  }

  private class DeliveryQueueIterator implements Iterator<T> {

    private int nextIndex;

    private DeliveryQueueIterator() {
      nextIndex = 0;
    }

    @Override
    public boolean hasNext() {
      return nextIndex <= backIndex;
    }

    @Override
    public T next() {
      T next = null;
      if (hasNext()) {
        next = array[nextIndex];
        nextIndex++;
      }
      return next;
    }
  }
}
