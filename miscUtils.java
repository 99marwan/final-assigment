package eg.edu.alexu.csd.datastructure;

import java.util.EmptyStackException;


public class miscUtils implements IMiscUtils {
	
	
	private class Stack {
		private class Node {
			private Object element;
			private Node next;
			public Node() {
				this(null,null);
			}
			public Node(Object obj,Node n) {
				element=obj;
				next=n;
			}
			public Object getElement() {
				return element; 
			}
			public Node getNext() {
				return next; 
			}
			public void setElement(Object newElem) {
				element = newElem;
			}
			public void setNext(Node newNext) { 
				next = newNext;
			}
		}
		private Node top;
		private int size;
		public Stack() {
			top=null;
			size=0;
		}
		public Object pop() {
			if(isEmpty()) {
				throw new EmptyStackException();
			}
			
			Object temp=top.getElement();
			
			top=top.getNext();
			size--;
			return temp;
		}
		public Object peek() {
			if(isEmpty()) {
				throw new EmptyStackException();
			}
			return top.getElement();
		}
		public void push(Object element) {
			Node v=new Node(element,top);
			top=v;
			size++;
		}
		public boolean isEmpty() {
			if(top==null)
				return true;
			return false;
		}
		public int size() {
			return this.size;
		}
	}


	@Override
	public BinaryTreeNode insert(BinaryTreeNode root, int element) {
		
		if(root == null) {
			return new BinaryTreeNode(element);
		}
		int cmp= Integer.compare(element, Integer.parseInt(root.element.toString()));
		
		
		if(cmp<0) {
			root.left=insert(root.left,element);
		}
		
		else if(cmp>0) {
			root.right=insert(root.right,element);
		}
		
		else {
			root.element=element;
		}
		return root;
		
	}

	@Override
	public int sumRange(BinaryTreeNode root, int low, int high) {
		int sum =0;
		
		if(root == null) {
			return 0;
		}
		
		
	    if (Integer.parseInt(root.element.toString()) < high && Integer.parseInt(root.element.toString()) > low) {
			sum += Integer.parseInt(root.element.toString());
		}
		
	    
		sum += sumRange (root.left,low,high);
		sum += sumRange (root.right,low,high);
	
		return sum;
	}

	@Override
	public boolean isValidBST(BinaryTreeNode root) {
		if(root == null ) {
			return true;
		}
		
		else if(root.left == null && root.right == null) {
			return true;
		}
		
		else if(root.left == null && 
				(Integer.parseInt(root.right.element.toString()) > Integer.parseInt(root.element.toString()))) {
			return (isValidBST(root.right));
		}
		
		else if(root.right == null && 
				(Integer.parseInt(root.left.element.toString()) < Integer.parseInt(root.element.toString()))) {
			return (isValidBST(root.left));
		}
		
		else if((Integer.parseInt(root.left.element.toString()) < Integer.parseInt(root.element.toString()))
				&& (Integer.parseInt(root.right.element.toString()) > Integer.parseInt(root.element.toString()))) {
			return (isValidBST(root.right) && isValidBST(root.left));	
		}
		
		else {
			return false;
		}
	}

	@Override
	public int[] nextSmallerNumber(int[] array) {
		Stack stack=new Stack();
		int [] result = new int [array.length];
		
		for (int i=0;i<array.length;i++) {
			
			if(stack.isEmpty()) {
				stack.push(i);
			}
			
			else {
				
				while (!stack.isEmpty() && (array[Integer.parseInt(stack.peek().toString())] >array[i])) {
					result[Integer.parseInt(stack.peek().toString())]=i;
					stack.pop();
				}
				
				stack.push(i);
			}
		}
		
		while(!stack.isEmpty()) {
			result[Integer.parseInt(stack.peek().toString())]=-1;
			stack.pop();
		}
		
		return result;
	}

}
