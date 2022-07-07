package Catena_circolare;

public class Nodo<T> {
	
	private T info;
	private int key;
	
	private Nodo<?> next;
	private Nodo<?> previous;
	
	public Nodo (T info, int key) {
		this.info = info;
		if(key >= 1 && key <= 100000) {
			this.key = key;
		}else {
			throw new IllegalArgumentException("Numero di chiave non valido, inserisci valore fra 1 e 1 000 000.");
		}
	}
	
	public void setNext(Nodo<?> head) {
		this.next = head;
	}
	
	public void setPrevious(Nodo<?> previous) {
		this.previous = previous;
	}
	
	public T getInfo() {
		return info;
	}
	
	public int getKey() {
		return key;
	}
	
	public Nodo<?> getNext() {
		return next;
	}
	
	public Nodo<?> getPrevious() {
		return previous;
	}

	
}
