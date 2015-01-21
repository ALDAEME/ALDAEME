/**
 * 
 * ALDA - inl�mning 1
 * 
 * @author Elise Edette (tero0337)
 * @author Mios ()
 * @author Emma ()
 * @version 1.0 Jan 2015
 */


/* Temporary note-board
 * --------------------
 * 
 * Elise(19jan): ska vi kanske ha en "sentinel" s� vi slipper edge cases?
 * Elise(19jan): TODO: throw exceptions, JUnit, check List interface docs so we have matching behavior. Document (javadoc) all the things!
 * 
 * 
 * 
 * 
 * 
 * 
 *---------------------*/


package alda.w1;

import java.util.Iterator;

import alda.linear.List.Node;

<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
//<<<<<<< Updated upstream
//=======

//>>>>>>> Stashed changes
public class LinkedList<T> implements ALDAList<T>{
	/** This is the node that represents an element in the list.
	 * It also contains the actual data.
	 */

	private static class Node<T> {
		T data;
		Node<T> next;
		
		public Node(T data) {
			this.data = data;
		}
	}
	
	private Node<T> head;
	private Node<T> tail;

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(T data) {
		if(head == null){
			head = new Node<T>(data);
			tail = head;
		}else{
			tail.next = new Node<T>(data);
			tail = tail.next;
		}
	}

	@Override
	public void add(int index, T data) {
		if (index < 0 || index > size())
			throw new IndexOutOfBoundsException();

		if(head == null){
			add(data);
			return;
		}

			Node<T> newNode = new Node<T>(data);
			Node<T> previous = head;
			
			if (index == size()) {
				tail.next = newNode;
				tail = newNode;
				System.out.println("last");
				return;
			}
			int counter = 0;
			for (Node<T> tmp = head; tmp != null; tmp = tmp.next) {

				if (counter == index) {

					if (tmp == head) {
						newNode.next = head;
						head = newNode;
						return;
					} else {
						newNode.next = tmp;
						previous.next = newNode;
						return;
					}
				}

				previous = tmp;
				counter++;
			}
		}

	@Override
	public T remove(int index) {
		if(index < 0 || index >= size()) throw new IndexOutOfBoundsException();
		
		int counter = 0;
		Node<T> previous = null;
		
		for(Node<T> tmp = head; tmp != null; tmp = tmp.next){
			if(counter == index){
				if(tmp == head){
					head = tmp.next;
					return tmp.data;
				}else if(tmp == tail){
					previous.next = null;
					tail = previous;
					return tmp.data;
				}else{
					previous.next = tmp.next;
					return tmp.data;
				}
			}
			previous = tmp;
		}
		
		return null;
	}

	@Override
	public boolean remove(T data) {
		Node<T> previous = null;
		
		for(Node<T> tmp = head; tmp != null; tmp = tmp.next){
			if(tmp.data == data || tmp.data.equals(data)){
				if(tmp == head){
					head = tmp.next;
					return true;
				}else if(tmp == tail){
					previous.next = null;
					tail = previous;
					return true;
				}else{
					previous.next = tmp.next;
					return true;
				}
			}
			previous = tmp;
		}
		
		return false;
	}

	@Override
	public T get(int index) {
		if(index < 0 || index >= size()) throw new IndexOutOfBoundsException();
		
		int counter = 0;
		
		for(Node<T> tmp = head; tmp != null; tmp = tmp.next){
			if(counter == index){
				return tmp.data;
			}
		}
		
		return null;
	}

	@Override
	public boolean contains(T data) {
		for(Node<T> tmp = head; tmp != null; tmp = tmp.next){
			if(tmp.data == data || tmp.data.equals(data)){
				return true;
			}
		}
		
		return false;
	}

	@Override
	public int indexOf(T data) {
		int index = 0;
		
		for(Node<T> tmp = head; tmp != null; tmp = tmp.next){
			if(tmp.data == data || tmp.data.equals(data)){
				return index;
			}
			index++;
		}
		
		return -1;
	}

	@Override
	public void clear() {
		head = null;
		tail = null;
	}

	@Override
	public int size() {
		int size = 0;
		
		for(Node<T> tmp = head; tmp != null; tmp = tmp.next){
			size++;
		}
		
		return size;
	}
	
	public String toString(){
		Node <T> tmp=head;
		String str="[";
			for(int i=0; i<this.size(); i++){
				str+= tmp.data.toString();
				if(tmp.next != null){
					str+=", ";
					tmp=tmp.next;
				}
			}

		return str+"]";
	}
	
	
}
