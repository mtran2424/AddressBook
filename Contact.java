
/**
 * Representing a contact entry in an address book, consisting of a unique name
 * and phone number
 * @author My Tran
 * @version 1.0
 */
public class Contact implements Comparable<Contact>
{
    
    //Members of the Contact class

    /**
     * Member
     * Represents the first name of this contact.
     */
    protected String firstName;

    /**
     * Member
     * Represents the last name of this contact
     */
    protected String lastName;

    /**
     * Member
     * Representts the phone number of this contact
     */
    protected String phoneNumber;


    
    /**
     * Default Constructor
     * Creates an instance of a contact object with members set to initial values.
     */
    public Contact()
    {
        firstName = "";
        lastName = "";
        phoneNumber = "";
    }//end default constructor




    /**
     * Non-defualt Constructor
     * Creates an instance of a contact object with members set values of the given parameters.
     * @param first a string representing the first name of the contact
     * @param last a string representing the last name of the contact
     * @param phone a string representing the phone number of contact
     */
    public Contact(String first, String last, String phone)
    {
        firstName =  first;
        lastName = last;
        phoneNumber = phone;
    }//end non-default constructor




    /**
     * Method
     * Sets the members firstName, lastName, and phoneNumber to the given parameters
     * @param first a string representing a contact's first name
     * @param last a string representing a contact's last name
     * @param phone a string representing a contact's phone number
     */
    public void set(String first, String last, String phone)
    {
        firstName =  first;
        lastName = last;
        phoneNumber = phone;
    }//end set


    /**
     * Method
     * Gets the last name in this contact
     * @return the last name of current contact object
     */
    public String getLastName()
    {
        return lastName;
    }//end getLastName



    /**
     * Method
     * Gets the first name in this contact
     * @return the first name of current contact object
     */
    public String getFirstName()
    {
        return firstName;
    }//end getFirstName



    /**
     * Method
     * Gets the phone number in this contact
     * @return the phone number of current contact object
     */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }//end set




    /**
     * Method
     * Returns a string representation of the contact
     * @return a string representation of this current object
     */
    @Override
    public String toString()
    {
        return ("Name: " + lastName + ", " + firstName 
                + "\nPhone number: " + phoneNumber + "\n");
    }//end overridden toString

    


    /**
     * Method
     * Determines whether the given Contact is greater, less than, or equal to another object.
     * Comparisons are made using between last names.
     * @param other represents the object to be compared to the current object
     * @return 0 if the last names are the same, >0 if the last name is less than this,
     *         and <0 if the last name is greater in the dictionary sense
     */
    @Override
    public int compareTo(Contact other) 
    {
        return lastName.compareTo(other.lastName); 
    }//end overridden compareTo





    /**
     * Method
     * Overrides equals to determine the equivalence of instances of Contact objects. Objects are
     * equivalent if members are all the same and both type contact.
     * @param other is the object being compared to the current
     */
    @Override
	public boolean equals(Object other)
	{
        //if other refers to the same object as the current object
		if(other == this)
		{
            //objects are the same
			return true;
		}
        //other is an instance of a contact object
		else if((other instanceof Contact))
		{
            //type cast other to a contact object
			Contact currentContact = (Contact) other;


            //check for members all be equivalent. False if any members are not the same.
			if(!currentContact.firstName.equals(firstName))
            {
                return false;
            }
            else
            {
                if(!currentContact.lastName.equals(lastName))
                {
                    return false;
                }
                else
                {
                    if(!currentContact.phoneNumber.equals(phoneNumber))
                    {
                        return false;
                    }
                    else
                    {
                        return true;
                    }
                }
            }
		}
		else
		{
			return false;
		}

	}//end overridden equals

}//end Contact class definition
