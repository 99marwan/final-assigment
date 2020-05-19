package eg.edu.alexu.csd.datastructure;

public class LinkedList {
	private class Node{
		// we assume elements are character strings
				private Object element;
				private Object key;
				private Node next;
			
			/** Returns the element of this node. */
			public Object getElement() {
				return element; 
			}
			/** Returns the next node of this node. */
			public Node getNext() {
				return next; 
			}
			// Modifier methods:
			/** Sets the element of this node. */
			public void setElement(Object newElem) {
				element = newElem;
			}
			/** Sets the next node of this node. */
			public void setNext(Node newNext) { 
				next = newNext;
			}
			public Object getKey() {
				return key;
			}
			public void setKey(Object key) {
				this.key = key;
			}

	}
	private Node head; // head node of the list
	private int size; // number of nodes in the list
	/** Default constructor that creates an empty list */
	public LinkedList(){
	head = null;
	size = 0;
	            }
	
	public void add(int index, Object element,Object key) {
		Node node = new Node();
		node.setElement(element);
		node.setKey(key);
		node.setNext(null);
			if(index==0) {
				node.setNext(head);
				head=node;
				size++;
			}
			else {
				    if(index>size || index <0) {
				    	NullPointerException nullPointer = new NullPointerException();
	                    throw nullPointer;
				    }
				    else {
				    Node n =head;
					for(int i=0;i<index-1;i++) {
						n=n.getNext();
					}
					node.setNext(n.getNext());
					n.setNext(node);
					size++;
				    }
			}	
	}
	
	public void add(Object element,Object key) {
		add(this.size,element,key);
		
	}
	
	public Object get(int index) {
		if(index>size || index <0) {
	    	NullPointerException nullPointer = new NullPointerException();
            throw nullPointer;
	    }
		else {
		Node n =head;
		for(int i=0;i<index;i++) {
			n=n.getNext();
		}
		if(n.getElement()==null)
			return 1;
		return n.getElement();
		}
	}
	
	public Object getKey(int index) {
		if(index>size || index <0) {
	    	NullPointerException nullPointer = new NullPointerException();
            throw nullPointer;
	    }
		else {
		Node n =head;
		for(int i=0;i<index;i++) {
			n=n.getNext();
		}
		if(n.getKey()==null)
			return 1;
		return n.getKey();
		}
	}
	
	public void set(int index, Object element,Object key) {
		if(index>size || index <0) {
	    	NullPointerException nullPointer = new NullPointerException();
            throw nullPointer;
	    }
		else {
		Node node =head;
		for(int i=0;i<index;i++) {
			node=node.getNext();
		}
		node.setElement(element);
		node.setKey(key);
		}
	}
	public void clear() {
		
		while(head.getNext()!=null){
			head=head.getNext();
			size--;
		}
		head=head.getNext();
		
		size--;
		
	}
	
	public boolean isEmpty() {
		boolean test=false;
			//if(head==null) we can use this also
			if(size==0) {
				test = true;
			}
		return test;
	}
	
	public void remove(int index) {
		if(index==0) {
			head=head.getNext();
			size--;
		}
		else {
			if(index>size || index <0) {
		    	NullPointerException nullPointer = new NullPointerException();
                throw nullPointer;
		    }
			else {
				Node n =head;
				Node m;
				for(int i=0;i<index-1;i++) {
					n=n.getNext();
				}
				m=n.getNext();
				n.setNext(m.getNext());
				size--;
			}
			
		}
		
	}
	
	public int size() {
		return this.size;
	}


	public boolean contains(Object o) {
		boolean test =false;
		Node node =head;
		if(node.getElement()==o) {
			test =true;
		}
		else {
			for(int i=1;i<this.size;i++) {
				node=node.getNext();
				if(node.getElement()==o) {
					test =true;
				}
			}
		}
		
		return test;
	}
	public void show() {
		Node n = head;
		while(n.getNext()!=null) {
			System.out.println(n.getElement());
			n=n.getNext();
		}
		System.out.println(n.getElement());
		
	}

}
