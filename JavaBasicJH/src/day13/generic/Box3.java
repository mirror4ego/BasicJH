package day13.generic;

public class Box3<K, V> {
	private K key;
	private V value;
	
	public Box3() {}
	
	public Box3(K key, V value){
		this.key = key;
		this.value = value;
		
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}
	
}
