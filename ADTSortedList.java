/**
 * Is an abstract representation for a generic sorted doubly linked list that outlines
 * the methods required for implementation.
 * @author My Tran
 * @version 1.0
 */
public interface ADTSortedList <E> 
{
    
    /**
     * Insert an element into this list. When inserting a new element, a proper location 
     * must be determined so that the updated list remains sorted. 
     * @param element is the element to be inserted
     */
    public void insert(E element);


    /**
     * Delete an element from this list
     * @param target is the desired element to be deleted from the list
     */
    public void delete(E target);

    /**
     * Find and return a reference to the element at a specific position of this list.
     * @param target represents the element to be deleted from the list
     * @return a reference to the position of the target in the list
     */
    public Node<E> find(E target);

    /**
     * Determine if this list is empty.
     * @return true if the list is empty.False otherwise
     */
    public boolean isEmpty();

    /**
     *  Delete all the elements from this list
     */
    public void clear();


    /**
     * Determine the number of elements contained in this list
     * @return the number of elements in the list
     */
    public int length();


    /**
     *  Compare this list with some other object for equivalency (overridden equals).
     * @param other is the object being compared to this list
     * @return true if the lists are equal. False otherwise.
     */
    @Override
    public boolean equals(Object other);

    /**
     * Return a string representation of this list (overridden toString).
     * @return a string representation of the list
     */
    @Override
    public String toString();



}
