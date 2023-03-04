import java.io.*;
import java.util.Scanner;
/**
 * Represents a driver program for an sorted list
 * @author My Tran
 * @version 1.0
 */
public class Part1Test 
{
    
    public static void main(String args[]) throws FileNotFoundException
    {
        //commence testing
        sortedListTest();
    }   
    


    /**
     * Static method
     * Creates an SortedList object, and performs testing of the class methods on said object
     * @throws FileNotFoundException
     */
    public static void sortedListTest() throws FileNotFoundException
	{
        //Create an instance of the sorted list and save its reference
		SortedList<Integer> list1 = new SortedList<Integer>();

        //call addElements to test insert
		addElements(list1);

        //Print list to confirm
        System.out.println(list1.toString());

        //call subElements to test find and delete
        subElements(list1);

        //print list to confirm
        System.out.println(list1.toString());

        //call addElements
        addElements(list1);
        System.out.println("\nclear method test:");
        //call length method to test
        System.out.println("Length: " + list1.length());


        //call clear method to test
        list1.clear();

        //print list to confirm
        System.out.println(list1.toString());

        //call length method to confirm clear
        System.out.println("Length: " + list1.length());
        System.out.println("end clear method test.");


        //test for the equivalence with same lists
        SortedList<Integer> test1 = new SortedList<Integer>();
        addElements(test1);
        SortedList<Integer> test2 = new SortedList<Integer>();
        addElements(test2);
        if(test1.equals(test2))
        {
            System.out.println("lists are the same");
        }
        else
        {
            System.out.println("lists are the not same");
        }


        //test for equivalence with different lists
        addElements(test2);
        test2.delete(15);

        
        if(test1.equals(test2))
        {
            System.out.println("lists are the same");
        }
        else
        {
            System.out.println("lists are the not same");
        }


        //test for equivalence with an empty list
        test2 = new SortedList<Integer>();

        
        if(test1.equals(test2))
        {
            System.out.println("lists are the same");
        }
        else
        {
            System.out.println("lists are the not same");
        }


        //test for equivalence with both empty lists
        test1.clear();

        
        if(test1.equals(test2))
        {
            System.out.println("lists are the same");
        }
        else
        {
            System.out.println("lists are not the same");
        }


	}//end start



    /**
     * static method
     * Reads integers from an input file and inserts them into a sorted list to test insert method 
     * in SortedList class
     * @param list is a reference to a list
     * @throws FileNotFoundException
     */
	public static void addElements(SortedList<Integer> list)throws FileNotFoundException
	{

		//File object to store the file for ints
		File inFile = new File("test1.txt");

		//Scanner object to read from input file
		Scanner fin = new Scanner(inFile);
		System.out.println("SortedList insert test:");

        //insert entries into the list until the end of the file
		while(fin.hasNextLine())
		{
		
			list.insert(Integer.parseInt(fin.nextLine()));
		}

        System.out.println("end SortedList insert test.");
		
		fin.close();
	}//end addElements



    /**
     * static method
     * Reads integers from an input file, finds them in a sorted list, and deletes them from said list
     * to test delete and find method in SortedList class
     * @param list is a reference to a list
     * @throws FileNotFoundException
     */
	public static void subElements(SortedList<Integer> list)throws FileNotFoundException
	{
		//File object to store the file for ints
		File inFile = new File("test1.txt");

		//Scanner object to read from input file
		Scanner fin = new Scanner(inFile);
		System.out.println("SortedList delete test:");

        //temp int variable to contain number from file
        int temp;
		while(fin.hasNextLine())
		{
            temp = list.find(Integer.parseInt(fin.nextLine())).get();
            System.out.println(temp);
			list.delete(temp);
		}
		
		fin.close();
	}// end subElements
}
