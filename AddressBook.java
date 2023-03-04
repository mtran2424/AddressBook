/**
 * An implementation of a ADTAddressBook representing a generic address book
 * @author My Tran
 * @version 1.0
 */
public class AddressBook implements ADTAddressBook
{
    /*Class data members*/
    /** 
     * Member
     * Represents an address book to contain contacts in the form of a sorted list
    */
    private SortedList<Contact> book;


    /**
     * Default Constructor
     * Creates an instance of an empty address book object
     */
    public AddressBook()
    {
        book = new SortedList<Contact>();
    }//end default constructor



    /**
     * Method
     * Searches for a Contact in the list and returns a reference to that contact. Returns 
     * null otherwise.
     * @param target is a contact to be searched for in the list
     * @return a reference to the contact in the list if found, null otherwise
     */
    public Node<Contact> search(Contact target)
    {
        //if the list is empty, the target is not in the list because nothing is in the list
        if(book.isEmpty())
        {
            System.out.println("Searching error: List is currently empty.");
            return null;
        }
        else
        {
            //create a reference to a contact and find it in the sorted list
            Node<Contact> temp = book.find(target);

            //if null is returned from find, the contact was not found
            if(temp == null)
            {
                System.out.println("Searching error: Contact does not exist.");
                return null;
            }
            //if something was returned the list was found
            else
            {
                System.out.println("Search successful! Contact was found");
                return temp;
            }
        }
    }//end search



    /**
     * Method
     * Inserts a contact into a list given a new contact
     * @param newContact is a contact to be inserted in the list
     */
    public void insert(Contact newContact)
    {
        book.insert(newContact);
    }//end insert



    /**
     * Method
     * Searches for and deletes a contact in the address book
     * @param target contact to be deleted in the list. If contact does not exist, message is output
     */
    public void delete(Contact target)
    {
        book.delete(target);
    }//end delete

    

    /**
     * Method
     * Deletes all contacts in the address book if any. Leaves the address book alone if address book is empty.
     */
    public void clear()
    {
        if(book.isEmpty())
        {
            System.out.println("Clearing error: List is already empty.");
        }
        else
        {
            System.out.println("Clearing successful! List has been cleared.");
            book.clear();
        }
    }//end clear


    /**
     * Method
     * Determines if the address book is empty
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty()
    {
        //if list is empty, then address book is empty
        return book.isEmpty();
    }//end isEmpty


    /**
     * Method
     * Determines the number of contacts in the addess book.
     * @return length of the sorted list
     */
    public int length()
    {
        //return number of list entries to caller
        return book.length();
    }//end length


    


    /** 
     * Method
     * Creates and returns a sorted doubly linked list containing all contacts with the same last name
     * @param name is a string representing a last name that the new list is to be made with
     * @return a list containing all the same last names or an empty list if the name does not exist
    */
    public SortedList<Contact> getSameNames(String name)
    {
        //Create a new address book
        AddressBook newList = new AddressBook();

        //Return empty book if the list is empty
        if(book.isEmpty())
        {
            return newList.getBook();
        }
        else
        {
            //Create a reference to the first Node in this list
            Node<Contact> temp = book.getFirstNode();

            //traverse along the list
            while(temp.next != null)
            {
                //if the node currently being referenced has an equivalent last name, insert the contact
                //from that node to the new book
                if(temp.get().getLastName().equals(name))
                {
                    newList.insert(temp.get());
                }

                temp = temp.next;
            }


            //return the filled list
            return newList.getBook();
        }
    }//end getSameName


    /**
     * Method
     * Creates and returns a list containing contacts with all the same area code in there phone number
     * @param areaCode is a string containing an area code given by the caller
     * @return a list containing contacts with all the same area code
     */
    public SortedList<Contact> getSameAreaCode(String areaCode)
    {
        //Create a new address book
        AddressBook newList = new AddressBook();

        //if the book is empty, return the empty address book
        if(book.isEmpty())
        {
            return newList.getBook();
        }
        else
        {
            //Create a reference to the first Node in this list
            Node<Contact> temp = book.getFirstNode();

            //traverse along the list
            while(temp.next != null)
            {

                //if the node currently being referenced has an equivalent area code, insert the contact
                //from that node to the new book
                if(temp.get().getPhoneNumber().substring(0, 3).equals(areaCode))
                {
                    newList.insert(temp.get());
                }

                temp = temp.next;
            }


            //return the filled list
            return newList.getBook();
        }
    }//end getSameAreaCode




    /**
     * Method 
     * Returns the current list.
     * @return this books list member.
     */
    public SortedList<Contact> getBook()
    {
        //return list
        return book;
    }//end getBook



    /**
     * Method
     * Returns a string representation of the address book consisting of the current
     * object type and all the entries contained in the list if any.
     * @return a string containing the string representation of the address book
     */
    @Override
    public String toString()
    {
        return (getClass().toString()
         + "\n\n" + book.toString());
    }//end toString



    /**
     * Method
     * Determines if the current and the given address book are equivalent.
     * @return true if the other book is equivalent to the current. False otherwise.
     */
    @Override
    public boolean equals(Object other)
    {
        //if they are the same object, they are equivalent
        if(this == other)
        {
            return true;
        }
        //if other is the same type as this book
        else if(other instanceof AddressBook)
        {
            //create a reference to the book contained by other
            SortedList<Contact> otherBook = ((AddressBook) other).getBook();

            //return if this book is equivalent to the other book
            if(book.equals(otherBook))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }//end overridden equals

}//end AddressBook class definition