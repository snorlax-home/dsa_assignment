package ADT;

import java.util.Iterator;

/**
 * @author Tan Yi Hong
 */
public interface QueueInterface<T> {
    Iterator<T> getIterator();

    void enqueue(T newEntry);

    T dequeue();

    T getFront();

    boolean isEmpty();

    boolean isFull();

    void clear();

    int getSize();

    QueueInterface<T> clone();

    boolean equals(QueueInterface<T> o);

    boolean contains(T element);

    boolean containsAll(T[] elements);

}
