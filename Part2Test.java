import java.io.*;
import java.util.Scanner;

/**
 * Represents a driver program for an address book
 * @author My Tran
 * @version 1.0
 */
public class Part2Test 
{
    public static void main(String args[]) throws FileNotFoundException
    {
        //commence test
        addressBookTest();
    }   
    

    /**
     * Static method
     * Perform testing on AddressBook class
     * @throws FileNotFoundException
     */
    public static void addressBookTest() throws FileNotFoundException
    {
        //Create an instance of the address book and save its reference
        AddressBook book1 = new AddressBook();

        //call addContacts to test insert
        addContacts(book1);

        //Print contacts to confirm
        System.out.println(book1.toString());

        //call subContracts to test search and delete
        subContacts(book1);

        //Print contacts to confirm
        System.out.println("Length: " + book1.length());

        //add contacts to test further methods
        addContacts(book1);

        //test length
        System.out.println("Length: " + book1.length());

        //test clear
        book1.clear();

        //confirm clear using length
        System.out.println("Length: " + book1.length());

        //test clear with an empty list
        book1.clear();

        //add contacts to test further methods
        addContacts(book1);


        //Testing for getSameLastName and getSameAreaCode

        //Test for duplicate existing last names
        System.out.println("\ngetSameName test:\n" + book1.getSameNames("Tran").toString() + "\nend getSameName test.\n");
        //Test for one entry of the target last name
        System.out.println("\ngetSameName test:\n" + book1.getSameNames("Royster").toString() + "\nend getSameName test.\n");
        //Test for no entries of the target last name
        System.out.println("\ngetSameName test:\n" + book1.getSameNames("Johnson").toString() + "\nend getSameName test.\n");

        //Test for duplicate existing area codes
        System.out.println("\ngetAreaCode test:\n" + book1.getSameAreaCode("212").toString() + "\nend getSameAreaCode test.\n");
        //Test for one entry of the target area code
        System.out.println("\ngetAreaCode test:\n" + book1.getSameAreaCode("810").toString() + "\nend getSameAreaCode test.\n");
        //Test for no entries of the target area code
        System.out.println("\ngetAreaCode test:\n" + book1.getSameAreaCode("777").toString() + "\nend getSameAreaCode test.\n");

        //test equals method

        //test for the equivalence with same books
        AddressBook test1 = new AddressBook();
        addContacts(test1);


        AddressBook test2 = new AddressBook();
        addContacts(test2);

        if(test1.equals(test2))
        {
            System.out.println("lists are the same");
        }
        else
        {
            System.out.println("lists are the not same");
        }


        //test for equivalence with different books
        test2.delete(book1.getBook().getFirstNode().get());

        
        if(test1.equals(test2))
        {
            System.out.println("lists are the same");
        }
        else
        {
            System.out.println("lists are the not same");
        }


        //test for equivalence with an empty book
        test2 = new AddressBook();

        
        if(test1.equals(test2))
        {
            System.out.println("lists are the same");
        }
        else
        {
            System.out.println("lists are the not same");
        }


        //test for equivalence with both empty books
        test1.clear();

        
        if(test1.equals(test2))
        {
            System.out.println("lists are the same");
        }
        else
        {
            System.out.println("lists are not the same");
        }

    }


    
    /**
     * Static method
     * Inserts contacts into an address book from a file to test class
     * @param book1 is a reference to an address book for testing
     * @throws FileNotFoundException
     */
    public static void addContacts(AddressBook book1) throws FileNotFoundException
    {
        Contact contact1;

        //File object to store the file for ints
		File inFile = new File("contacts.txt");

		//Scanner object to read from input file
		Scanner fin = new Scanner(inFile);
		System.out.println("AddressBook insert test:");

        //read from file until end of file
        while(fin.hasNextLine())
        {
            //get a line of input and split up input to insert into contact
            String input[] = fin.nextLine().split(" ");
            contact1 = new Contact(input[0], input[1], input[2]);

            //insert contact into list
            book1.insert(contact1);
        }

        System.out.println("\nend AddressBook insert test.\n");

        //close file
        fin.close();

    }
    



    /**
     * Static method
     * Searches for contacts in the list using input from a file and deletes contacts from a list
     * @param book1 is a reference to an address book for testing
     * @throws FileNotFoundException
     */
    public static void subContacts(AddressBook book1) throws FileNotFoundException
    {
        //temp variable to hold contacts from a file
        Contact contact1;

        //File object to store the file for ints
		File inFile = new File("contacts.txt");

		//Scanner object to read from input file
		Scanner fin = new Scanner(inFile);
		System.out.println("AddressBook delete test:");

        //read from list
        while(fin.hasNextLine())
        {
            //get a line of input and split up input to insert into contact
            String input[] = fin.nextLine().split(" ");
            contact1 = new Contact(input[0], input[1], input[2]);

            //Search for and return contact in book
            System.out.println(book1.search(contact1).get());
            //delete said contact
            book1.delete(contact1);
        }

        System.out.println("end AddressBook delete test.\n");

        //close file
        fin.close();
    }
    

}
