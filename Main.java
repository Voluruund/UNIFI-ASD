package Catena_circolare;
/*
 * MAJID ALESSIO 7073646
 */
public class Main {

	public static void main(String[] args) {
		
		Catena<String> chain = new Catena<String>("Alessio", 1);
		chain.inserisciNodo("Gianluca", 5);
		chain.inserisciNodo("Claudio", 2);
		chain.inserisciNodo("Vasco", 5);
		chain.inserisciNodo("Elisa", 6);
		chain.inserisciNodo("Lorenzo", 5);
		chain.inserisciNodo("Matteo", 2);
		
		System.out.println(chain.getNumeroNodi() + "\n");
		System.out.println(chain.toString() + "\n");
		System.out.println("Ultimo nodo: " + chain.getTail() + "\n");
		System.out.println("Dodicesimo elemento: " + chain.ricercaNodoPosizione(12) + "\n");
		System.out.println( chain.ricercaNodoChiave(5) + "\n");
		System.out.println(  chain.ricercaNodoChiave(10) + "\n");
		
		chain.rimuoviNodo(1);
		chain.rimuoviNodo(5);
		
		System.out.println(chain.toString() + "\n");
		System.out.println("Catena ordinata tramite bubbleSort con flag: \n" + chain.ordinamentoCatena());
	}

}
