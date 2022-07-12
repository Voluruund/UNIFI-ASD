package Catena_circolare;
/*
 * MAJID ALESSIO 7073646
 */
public class Nodo<T> {
	
	protected T info;
	private int key;
	private Nodo<T> next;
	private Nodo<T> previous;
	
	public Nodo (T info, int key, Nodo<T> prev, Nodo<T> next) {
		if(key >= 1 && key <= Math.pow(10, 6)) {
			this.key = key;
		}else {
			throw new IllegalArgumentException("Numero di chiave non valido, inserisci valore fra 1 e 1 000 000.");
		}
		this.info = info;
		this.previous = prev;
		this.next = next;
	}
	
	public T getInfo() {
		return info;
	}
	
	public void setInfo(T info) {
		this.info = info;
	}
	
	public int getKey() {
		return key;
	}
	
	public void setKey(int key) {
		if(key < Math.pow(10, 6) && key >= 1)
			this.key = key;
	}
	
	public Nodo<T> getNext() {
		return next;
	}
	
	public void setNext(Nodo<T> head) {
		this.next = head;
	}
	
	public Nodo<T> getPrevious() {
		return previous;
	}
	
	public void setPrevious(Nodo<T> prev) {
		this.previous = prev;
	}
	
	@Override
	public String toString() {
		return "[Informazione: " + info + ", Chiave: "+ key +"]";
	}
}
