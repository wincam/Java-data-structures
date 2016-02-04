package datastructures;

public interface Container<T> {
	
	/**
	 * Getter for stored value
	 * 
	 * @return	Stored value
	 */
	T getValue();
	
	/**
	 * Setter for stored value
	 * 
	 * @param value	The new stored value
	 */
	void setValue(T value);
}
