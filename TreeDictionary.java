package eg.edu.alexu.csd.datastructure;

public class TreeDictionary <K extends Comparable<K>,V> implements  IDictionary<K,V> {

	
	private class Node
	{
		public K key;
		public V val;
		public Node left, right;
		public Node(K key, V val)
		{
			this.key = key;
			this.val = val;
		}
	}

	public Node root = null;
	private V temp =null;
	private V rem=null;
	
	@Override
	public V get(K key) {
		if(key== null)
			throw new RuntimeException();
		Node x =root;
		V value = null;
		while (x!= null) {
			int cmp = key.compareTo(x.key);
			if(cmp<0) {	
				x=x.left;
			}
			else if(cmp>0) {
				x=x.right;
			}
			else {
				return value=x.val;
			}
		}
		return null;
	}

	@Override
	public V set(K key, V value) {
		if(key == null || value == null)
			throw new RuntimeException();
		root=set(root , key, value);
		 return temp;
	}
	
	private Node set(Node x ,K key,V value) {
		
		if(x == null) {
			return new Node(key,value);
		}
		
		int cmp = key.compareTo(x.key);
		if(cmp<0) {	
			x.left=set(x.left,key,value);
		}
		else if(cmp>0) {
			
			x.right=set(x.right,key,value);
		}
		
		else {
			temp = x.val;
			x.val=value;
		}
		return x;
	}

	@Override
	public V remove(K key) {
		if(key== null)
			throw new RuntimeException();
		root=delete(root,key);
		return rem;
	}
	
	private Node deleteMin(Node root) {
		if(root.left==null)
			return root.right;
		root.left= deleteMin(root.left);
		return root;
	}
	private Node delete(Node root,K key) {
		if(root == null)
			return null;
		int cmp = key.compareTo(root.key);
		if(cmp<0) {	
			root.left=delete(root.left,key);
		}
		else if(cmp>0) {
			
			root.right=delete(root.right,key);
		}
		
		else {
			if(root.left ==null)
				return root.right;
			if(root.right ==null)
				return root.left;
			
			Node temp = root;
			rem=temp.val;
			root=temp.right.left;
			root.right=deleteMin(temp.right);
			root.left=temp.left;
		}
		return root;
	}

	@Override
	public boolean isEmpty() {
		if (root == null)
			return true;
		return false;
	}
	
