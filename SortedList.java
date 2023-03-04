/**
 * An implementation of ADTSortedList representing a generic sorted doubly linked 
 * list.
 * @author My Tran
 * @version 1.0
 */
public class SortedList<E extends Comparable<E>> implements ADTSortedList<E>
{
	/*Class data members*/


	/**
	 * Member
	 * Reference to the head node in the sorted list.
	 */
	private Node<E> head;	
	
	/**
	 * Member
	 * represents the number of nodes in the list.
	 */
	private int count;
	


	/*Class Methods */
	


	/**
	 * Default Constructor
	 */
	public SortedList()
	{
		count = 0;
		head = null;
	}//end default constructor

	
	/**
	 * Method
	 * Inserts element into list in the proper location for the list to remain sorted
	 * @param element is the element to be inserted into the list
	 */
	public void insert(E element)
	{

		//create a new node with the given element
		Node<E> temp = new Node<E>(element);


		//if the list is empty
		if(isEmpty())
		{
			//make head the new node
			head = temp;
			temp.next = null;
			temp.previous = null;
			count++;
		}
		else
		{
			//if the element being inserted is lesser than the head of the list
			if(head.get().compareTo(element) >= 0)
			{
				//add the new node to the list before the head and make the new node the head
				temp.next = head;
				head.previous = temp;

				head = temp;
				
				//increment the list entry count
				count++;
			}
			else
			{
				//refer temporary node to the head
				Node<E> tempNode = head;

				//move reference to the next node until element in the node is greater than
				//that of the one being inserted
				while(tempNode.next != null && tempNode.get().compareTo(element) < 0)
				{
					tempNode = tempNode.next;
				}

				//element being inserted is at the end of the list
				if(tempNode.next == null && tempNode.get().compareTo(element) <= 0)
				{
					//last node in the list refers the new node and new node refers to it
					tempNode.next = temp;
					temp.previous = tempNode;

					//initiallize the next reference to null
					temp.next = null;
				}
				//element is to be in the middle of the list
				else
				{
					//make a reference to the previous node that will be the previous of the new node
					Node<E> prevNode = tempNode.previous;

					//make previous reference of new node the previous of the original node at that
					//position and the next reference to the original node
					temp.previous = prevNode;
					temp.next = tempNode;

					//refer the original nodes before and after to the new node
					prevNode.next = temp;
					tempNode.previous = temp;
				}

				//increment count
				count++;
			}
		}

	}//end insert
	



	/**
	 * Method
	 * Gets a reference to the first node in the list
	 * @return reference to head of the list
	 */
	protected Node<E> getFirstNode()
	{
		return head;
	}


	/**
	 * Method
	 * Deletes an element from the list
	 * @param target is the element to be deleted from the list
	 */
	public void delete(E target)
	{
		//Output message if the list is empty
		if(isEmpty())
		{
			System.out.println("List is empty.\n");
		}
		else
		{
			//if the head contains the target element
			if(head.get().equals(target))
			{
				//make a reference to the original head and make the head node the next
				Node<E> temp = head;
				head = head.next;

				//clear the old head
				temp.next = null;
				temp.previous = null;
				temp.set(null);
				temp = null;


				//decrement the count
				count--;
			}
			else
			{
				//make a reference to the head
				Node<E> tempNode = head;

				//Move temporary reference along the list until the element is found or the end is reached
				while(!tempNode.get().equals(target) && tempNode.next != null)
				{
					tempNode = tempNode.next;
				}
				
				//if the target element is found at the end of the list
				if(tempNode.next == null && tempNode.get().equals(target))
				{
					//make the end of the list the previous node to the original last node
					Node<E> prevNode = tempNode.previous;

					//unreference the last node from the previous
					tempNode.previous = null;

					//set all values of the original node to null and make the new end node reference null
					tempNode.set(null);
					prevNode.next = null;
					tempNode.next = null;
					tempNode = null;
				}
				//if the end of the list is reached and the last element is not the target, target is not in list
				//print message
				else if(tempNode.next == null && !(tempNode.get().equals(target)))
				{
					System.out.println("Element not found.\n");
				}
				//target is found in the middle of the list
				else
				{
					//make the nodes before and after the target refer to each other
					Node<E> prevNode = tempNode.previous;
					Node<E> nextNode = tempNode.next;

					prevNode.next = nextNode;
					nextNode.previous = prevNode;

					//clear the target node
					tempNode.previous = null;
					tempNode.next = null;
					tempNode.set(null);
				}
				//decrement the count
				count--;
			}
		}
	}//end delete
	



	/**
	 * Method
	 * Finds and returns a reference to a Node with a given element at the position in the
	 * list where the element was found.
	 * @param target is the target element the list is trying to search for.
	 * @return element begin searched for in the list or null if empty
	 */
	public Node<E> find(E target)
	{
		//if the list is empty, return null
		if(isEmpty())
		{
			return null;
		}
		else
		{
			//traverse along the list until the target is found or reference is null
			Node<E> temp = head;
			while(!temp.get().equals(target) && temp.next != null)
			{
				temp = temp.next;
			}

			if(temp.get().equals(target))
			{
				//return element
				return temp;
			}
			else
			{
				//return null
				return null;
			}
		}
	}//end find




	/**
	 * Method
	 * Determines if the list is empty and returns if the list is empty or not to caller.
	 * @return true if the list is empty, false .
	 */
	public boolean isEmpty()
	{
		//list is empty if head of the list is undefined
		return (count == 0);
	}//end isEmpty
	


	/**
	 * Method
	 * Clears all objects in the list
	 */
	public void clear()
	{
		//delete head node until no head node exists
		while(head != null)
		{
			delete(head.get());
		}
	}//end clear
	



	/**
	 * Method
	 * Determines and returns the number of elements contained in the list
	 * @return number of elements contained in the list
	 */
	public int length()
	{
		return count;
	}//end length
	
	

	/**
	 * Method
	 * Returns a string representation of this object consisting of the object's 
	 * current type and every entry in the list, one line per element.
	 * @returns a string representation of this list
	 */
	@Override
	public String toString()
	{
		//String to contain the string representation of the list
		String result = getClass().toString() + "\n";

		//if the list is not empty
		if(!isEmpty())
		{
			//append first item in the list followed by a new line
			Node<E> temp = head;
			do
			{
				//append next element to result
				result += (temp.get().toString() + "\n");

				//traverse to next node
				temp = temp.next;
			}while (temp != null);	//ends when temp is not the end
		}

		//return the string representation accumulated if any
		return result;
	}//end overridden toString


	/**
     * Method
	 * Determines if this list and another list are equivalent
	 * @param other is the object being compared to this list
	 * @return true if the lists are equivalent, false otherwise
     */
    @Override
    public boolean equals(Object other)
    {
		//if they are the same object, they are equivalent
        if(this == other)
		{
			return true;
		}
		//if other is type SortedList
		else if(other instanceof SortedList)
		{
			//make a reference to a list with other
			SortedList<E> tempList = (SortedList<E>) other;

			//get references to the first node of both lists
			Node<E> currentList = head;
			Node<E> otherList = tempList.head;

			//if the lists are both empty, they are equivalent
			if(tempList.isEmpty() && isEmpty())
			{
				return true;
			}
			//if one list is empty and the other is not, they are not equivalent
			else if ((isEmpty() && !tempList.isEmpty()) || (!isEmpty() && tempList.isEmpty()))
			{
				return false;
			}
			
			//traverse both lists
			while(currentList.get().equals(otherList.get()) && (currentList.next != null && otherList.next != null))
			{
				currentList = currentList.next;
				otherList = otherList.next;
			}

			//if all the elements in the list are equivalent, and both references are at the end of their lists
			if(currentList.get().equals(otherList.get()) && (currentList.next == null && otherList.next == null))
			{
				return true;
			}
			//if the full traversal on both lists are not complete, the lists are not equivalent
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

}//end SortedList class definition
