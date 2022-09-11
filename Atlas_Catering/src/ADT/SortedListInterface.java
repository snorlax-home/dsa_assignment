package ADT;

public interface SortedListInterface<T> {

  public boolean add(T newEntry);
  public boolean remove(T anEntry);
  public boolean contains(T anEntry);

  public void clear();
  public int getNumberOfEntries();
  public boolean isEmpty();
  public boolean isFull();

}
