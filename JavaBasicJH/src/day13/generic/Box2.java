/*
 * 	E : Element
 * 	K : Key
 *	N : Number
 * 	T : Type
 * 	V : Value
 * 
 */
package day13.generic;

public class Box2<T> {
	private T data;
	public Box2() {}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
}
