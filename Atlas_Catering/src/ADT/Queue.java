package ADT;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

public class Queue<T> implements QueueInterface<T> {

    private T[] array;
    private static final int frontIndex = 0;
    private int backIndex;
    private static final int DEFAULT_CAPACITY = 10;

    public Queue() {
        this(DEFAULT_CAPACITY);
    }

    public Queue(int initialCapacity) {
        array = (T[]) new Object[initialCapacity];
        backIndex = -1;
    }

    public int getBackIndex() {
        return backIndex;
    }

    public void setBackIndex(int backIndex) {
        this.backIndex = backIndex;
    }

    @Override
    public void enqueue(T newEntry) {
        // Enqueue
        if (isFull()) {
            // Increase the size of array
            array = Arrays.copyOf(array, array.length + 1);
        }
        backIndex++;
        array[backIndex] = newEntry;
    }

    @Override
    public T dequeue() {
        // Dequeue
        T front = null;
        if (!isEmpty()) {
            front = array[frontIndex];
            T[] temp = (T[]) new Object[array.length - 1];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = array[i + 1];
            }
//            for (int i = frontIndex; i < backIndex; ++i) {
//                array[i] = array[i + 1];
//            }
            this.array = temp;
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
        return array.length;
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

    @Override
    public QueueInterface<T> clone() {
        final Queue<T> clone = new Queue<T>(this.getSize());
        for (T element : this.array) {
            clone.enqueue(element);
        }
        clone.setBackIndex(this.getBackIndex());

        return clone;
    }


    @Override
    public boolean equals(QueueInterface<T> o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Queue<T> queue = (Queue<T>) o;
        return backIndex == queue.backIndex && Arrays.equals(array, queue.array);
    }

    @Override
    public String toString() {
        return "Queue{" +
                "array=" + Arrays.toString(array) +
                ", backIndex=" + backIndex +
                '}';
    }

    @Override
    public boolean contains(T element) {
        boolean found = false;
        for (int i = 0; i < this.getSize(); i++) {
            if (this.array[i] == element) {
                found = true;
            }
        }
        return found;
    }

    @Override
    public boolean containsAll(T[] elements) {
        for (T e : elements) {
            boolean found = contains(e);
            if (!found) {
                return false;
            }
        }
        return true;

    }

}
