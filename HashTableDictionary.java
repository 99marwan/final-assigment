package eg.edu.alexu.csd.datastructure;

public class HashTableDictionary <K,V> implements  IDictionary<K,V>  {
	
	private int size;
	private LinkedList[] array;
	public HashTableDictionary(int s){
		this.size=s;
		array=new LinkedList[size];
	}

	@Override
	public V get(K key) {
		if(key== null)
			throw new RuntimeException();
		int hash=Math.abs(key.hashCode())%size;
		for(int i=0;i<array[hash].size();i++) {
			if(Math.abs(key.hashCode())==Math.abs(array[hash].getKey(i).hashCode())) {
				V temp =(V)(array[hash].get(i));
				return temp;
			}
		}
		return null;
	}

	@Override
	public V set(K key, V value) {
		if(key == null || value == null)
			throw new RuntimeException();
		int hash=Math.abs(key.hashCode())%size;
		if(array[hash] == null) {
			array[hash]=new LinkedList();
			array[hash].add(value, key);
			return null;
		}
		else  {
			for(int i=0;i<array[hash].size();i++) {
				if(Math.abs(key.hashCode())==Math.abs(array[hash].getKey(i).hashCode())) {
					V temp =(V)(array[hash].get(i));
					array[hash].set(i, value, key);
					return temp;
				}
			}
			array[hash].add(value, key);
			return null;
		}
	}

	@Override
	public V remove(K key) {
		if(key== null)
			throw new RuntimeException();
		int hash=Math.abs(key.hashCode())%size;
		
		for(int i=0;i<array[hash].size();i++) {
			if(Math.abs(key.hashCode())==Math.abs(array[hash].getKey(i).hashCode())) {
				V temp =(V)(array[hash].get(i));
				array[hash].remove(i);
				return temp;
			}
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		boolean check = true;
		for(int i=0;i<array.length;i++) {
			if(!(array[i] == null)) {
				check = false;
			}
		}
		return check;
	}

}
