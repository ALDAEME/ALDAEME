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
		if(index < 0 || index >= size()) throw new IndexOutOfBoundsException();
		
		
		if(head == null){
			
		}else{
			int counter = 0;
			
			for(Node<T> tmp = head; tmp != null; tmp = tmp.next){
				if(counter == index - 1){
					Node<T> newNode = new Node<T>(data);
					newNode.next = (tmp.next).next;
					tmp.next = newNode;
				}
				index++;
			}
		}
	}

	@Override
	public T remove(int index) {
		if(index < 0 || index >= size()) throw new IndexOutOfBoundsException();
		
		int counter = 0;
		
		for(Node<T> tmp = head; tmp != null; tmp = tmp.next){
			if(counter == index - 1){
				tmp.next = (tmp.next).next;
				
				return (tmp.next).data;
			}
		}
		
		return null;
	}

	@Override
	public boolean remove(T data) {
		Node<T> previous;
		
		for(Node<T> tmp = head; tmp != null; tmp = tmp.next){
			if(tmp.data == data || tmp.data.equals(data)){
				if(tmp == head){
					
				}else{
					
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
