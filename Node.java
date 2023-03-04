/**
 * Representing a generic node for a doubly linked list that stores a generic element type,
 * and has references to the node before and after it
 * @author My Tran
 * @version 1.0
 */
public class Node <T> 
{
	/*Class Data Members*/

	/**
	 * Member
	 * Represents a generic element contained by Node object
	 */
	private T element;
	
	/**
	 * Member
	 * Represents references to other nodes that the current node points to
	 */
	protected Node<T> previous, next;


	/*Class Methods*/

	/**
	 * Default Constructor
	 */
	public Node()
	{
		element = null;
		previous = null;
		next = null;
	}//end default constructor




	/**
	 * Non-default constructor
	 * @param input
	 */
	public Node(T input)
	{
		element = input;
		previous = null;
		next = null;
	}//end non-default constructor




	/**
	 * Method
	 * Setter method sets the element of the current Node to a given value.
	 * @param value is the desired value for element.
	 */
	public void set(T value)
	{
		element = value;
	}//end set




	/**
	 * Method
	 * Getter returns the element value of the current Node object
	 * @return
	 */
	public T get()
	{
		
		return element;
	}//end get

}//end Node class definition
