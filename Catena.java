package Catena_circolare;
/*
 * MAJID ALESSIO 7073646
 */
public class Catena<T> {
	
	private Nodo<T> HEAD;
	private int numeroNodi;
	
	public Catena(T info, int key) {
		this.HEAD = new Nodo<T>(info, key, null, null);
		this.HEAD.setNext(HEAD);
		this.HEAD.setPrevious(HEAD);
		numeroNodi = 1;
	}
	
	public Nodo<T> getHEAD() {
		return HEAD;
	}
	
	public String getNumeroNodi() {
		return "Numero di nodi presenti nella catena: " + numeroNodi;
	}
	
	public Nodo<T> getTail(){
		return HEAD.getPrevious();
	}
	
	//ricerca che ritorna il valore booleano true se il nodo è già presente nella catena
	public boolean ricercaNodo(T info, int key) {
		Nodo<T> appo = HEAD; //nodo di partenza
		for(int i = 0; i < numeroNodi; i++) {
			if(appo.getKey() == key && appo.getInfo().equals(info)) return true;
			appo = appo.getNext();
		}
		return false;
	}
	
	//ricerca che ritorna il nodo data una posizione, viene gestito tramite la funzione modulo
	public Nodo<T> ricercaNodoPosizione(int pos) {
		Nodo<T> appo = HEAD; //nodo di partenza
		for(int i = 0; i < (pos % numeroNodi); i++) {
			appo = appo.getNext();
		}
		return appo;
	}
	
	//ricerca che ritorna un nodo data la sua chiave, qualora 2 nodi avessero la stessa chiave alla stessa distanza
	//da HEAD ritorna entrambi.
	public String ricercaNodoChiave(int key) {
		Nodo<T> front = HEAD.getNext();
		Nodo<T> back = HEAD.getPrevious();
		if(HEAD.getKey() == key) return HEAD.toString();
		for(int i = 0; i < numeroNodi / 2; i++) {
			//l'ordine dei controlli è importante
			if(front.getKey() == key && back.getKey() == key) {
				return "Nodo con chiave: " + key + " " + front.toString() + ", " + back.toString();
			}else if(front.getKey() == key) {
				return "Nodo con chiave: " + key + " " + front.toString();
			}else if(back.getKey() == key) {
				return "Nodo con chiave: " + key + " " + back.toString();
			}
			//in cui nessuno dei due nodi è uguale
			front = front.getNext();
			back = back.getPrevious();
		}
		return "Nodo con chiave: " + key + " non presente nella catena.";
	}
	
	public void inserisciNodo(T info, int key) {
		if(ricercaNodo(info, key)) {
			System.out.println("Nodo " + info + " " + key + " gia' presente nella catena, inserimento non avvenuto.");
			return;
		}
		// swap dei puntatori dei nodi head, del nuovo e dell'attuale successivo di head
		Nodo<T> nuovo = new Nodo<T>(info, key, HEAD, HEAD.getNext());
		HEAD.getNext().setPrevious(nuovo);
		HEAD.setNext(nuovo);
		numeroNodi++; //incremento il numero di nodi
	}
	
	public void rimuoviNodo(int key) {
		//controllo che il nodo da rimuovere sia HEAD
		if(HEAD.getKey() == key) {
			HEAD.getNext().setPrevious(HEAD.getPrevious()); // nodo successivo a HEAD ha come precedente il precedente di HEAD
			HEAD.getPrevious().setNext(HEAD.getNext()); // nodo precedente a HEAD ha come successivo il successivo di HEAD
			HEAD = HEAD.getNext();
			numeroNodi--;
			System.out.println("Nodo HEAD, rimosso. il nuovo nodo HEAD è il seguente: " + HEAD.toString() + "\n");
			return;
		}	
		Nodo<T> front = HEAD.getNext();
		Nodo<T> back = HEAD.getPrevious();
		for(int i = 0; i < numeroNodi / 2; i++) {	
			//l'ordine dei controlli è importante
			if(front.getKey() == key && back.getKey() == key) {
				front.getNext().setPrevious(front.getPrevious());
				front.getPrevious().setNext(front.getNext());
				back.getPrevious().setNext(back.getNext());
				back.getNext().setPrevious(back.getPrevious());
				numeroNodi -= 2;
				System.out.println("Rimossi i seguenti nodi: " + front.toString() + ", " + back.toString() + "\n");
				return;
			}else if(front.getKey() == key) {
				front.getNext().setPrevious(front.getPrevious());
				front.getPrevious().setNext(front.getNext());
				numeroNodi--;
				System.out.println("Rimosso il seguente nodo: " + front.toString() + "\n");
				return;
			}else if(back.getKey() == key) {
				back.getPrevious().setNext(back.getNext());
				back.getNext().setPrevious(back.getPrevious());
				numeroNodi--;
				System.out.println("Rimosso il seguente nodo: " + back.toString() + "\n");
				return;
			}
			//nel caso in cui nessuno dei due nodi è uguale incremento "l'indice"
			front = front.getNext();
			back = back.getPrevious();
		}
		//caso in cui la cancellazione non avviene
		System.out.println("Nessun nodo rimosso. La chiave " + key + " non e' presente in alcun nodo della catena.");
	}
	
	public String ordinamentoCatena() {
		@SuppressWarnings("unchecked")
		Nodo<T>[] arr = new Nodo[numeroNodi];
		Nodo<T> appo = HEAD;
		for(int i = 0; i < numeroNodi; i++) {
			arr[i] = appo;
			appo = appo.getNext();
		}
		BubbleSortFlag.bubbleSort(arr, numeroNodi);
		String listOfNodes = "";
		for(int i = 0; i < numeroNodi; i++) {
			listOfNodes += arr[i].toString() + ", ";
		}
		return listOfNodes;
	}
	
	@Override
	public String toString() {
		String listOfNodes = HEAD.toString() + ",";
		Nodo<T> appo = HEAD; //nodo di partenza
		while(appo.getNext() != HEAD) {
			appo = appo.getNext();
			listOfNodes += appo.toString() + ",";
		}
		return listOfNodes;
	}
    
}
