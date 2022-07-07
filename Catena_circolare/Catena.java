package Catena_circolare;

public class Catena<T> {
	
	public static Nodo<?> HEAD;
	public static int numeroNodi;
	
	public Catena() {
		HEAD = null;
		HEAD.setNext(null);
		HEAD.setPrevious(null);
		numeroNodi = 0;
	}
	
	public void addNodo(Nodo<?> nodo) {
		if(numeroNodi == 0) {
			HEAD = nodo;
			HEAD.setNext(HEAD);
			HEAD.setPrevious(HEAD);
			numeroNodi++;
		}else if(numeroNodi == 1 && !ricercaNodo(nodo.getInfo(), nodo.getKey())) { //todo
			HEAD.setNext(nodo);
			HEAD.setPrevious(nodo);
			nodo.setNext(HEAD);
			nodo.setPrevious(HEAD);
			numeroNodi++;
		}else{
			Nodo<?> temp = HEAD.getNext();
			nodo.setPrevious(HEAD);
			nodo.setNext(temp);
			HEAD.setNext(nodo);
			numeroNodi++;
		}
	}
	
	
	public void ritornaNodo(T info, int key) {
		ritornaNodo(HEAD, info, key, 0);
	}
	
	public Nodo<?> ritornaNodo(Nodo next, T info, int key, int i) {
		while(i < numeroNodi){
			if(next.getKey() == key && next.getInfo()== info) return next;
			else {
				ritornaNodo(next.getNext(), info, key, i++);
			}
		}
		return null;
	}
	
	public boolean ricercaNodo(T info, int key) {
		return ricercaNodo(HEAD, info, key, 0);
	}
	
	public boolean ricercaNodo(Nodo<?> next, T info, int key, int i) { 
		while(i < numeroNodi){
			if(next.getKey() == key && next.getInfo()== info) return true;
			else {
				ritornaNodo(next.getNext(), info, key, i++);
			}
		}
		return false;
	}

	public static int getNumeroNodi() {
		return numeroNodi;
	}
	
	public static void getHEAD() {
		System.out.println("il nodo HEAD è composto dalla chiave "+HEAD.getKey()+" e dal dato "+HEAD.getInfo()+".");
	}
	
    
}
