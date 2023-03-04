
/**
 * Is an abstract representation for a generic address book that uses a sorted doubly 
 * linked list to store contacts. It outlines the methods required for implementation.
 * @author My Tran
 * @version 1.0
 */
public interface ADTAddressBook 
{
    /**
     * Search a contact in this address book.
     * @param target is the contact being searched for in the list
     * @return a reference to the position where the contact was found in the list.
     */
    public Node<Contact> search(Contact target);


    /**
     * Insert a contact into this address book.
     * @param newContact is the contact to be inserted into the list.
     */
    public void insert(Contact newContact);

    /**
     * Delete a contact from this address book.
     * @param target
     */
    public void delete(Contact target);

    /**
     * Delete all the contacts from this address book. Makes this address 
     * book empty
     */
    public void clear();

    /**
     * Determine if this address book is empty.
     * @return true if the list is empty. False otherwise.
     */
    public boolean isEmpty();

    /**
     *  Determine the number of contacts contained in this address book.
     * @return the number of contacts contained by the doubly linked list.
     */
    public int length();

    /**
     * Return a sorted doubly linked list by including all contacts whose last 
     * names are the same. 
     * @param name is the last name the new sorted doubly linked list is based off of.
     * @return a sorted doubly linked list with contacts that have the same last name.
     */
    public SortedList<Contact> getSameNames(String name);



    /**
     * Return a sorted doubly linked list by including all contacts whose phone 
     * numbers have the same area code. 
     * @param areaCode is the area code the new sorted doubly linked list is based
     * off of.
     * @return a sorted doubly linked list with contacts that have the same phone area
     * code.
     */
    public SortedList<Contact> getSameAreaCode(String areaCode);

    /**
     * Compare this address book with some other object for equivalency (overridden equals).
     * @param other is the object the current book is being compared to.
     * @return true if the books are equivalent
     */
    @Override
    public boolean equals(Object other);


    /**
     *  Return a string representation of this address book (overridden toString).
     * @return a string representation of this address book
     */
    @Override
    public String toString();

    
}
