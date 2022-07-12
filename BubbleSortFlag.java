package Catena_circolare;
/*
 * MAJID ALESSIO 7073646
 */
public class BubbleSortFlag {
	
	public  static <T> void bubbleSort(Nodo<T>[] arr, int numeroNodi){
		int i = numeroNodi - 1;
		boolean sorted = false;
		while( i >= 1 && !sorted) {
			sorted = true;
			for(int j = 1; j <= i; j++) {
				if(arr[j-1].getKey() > arr[j].getKey()) {
					Nodo<T> temp = arr[j - 1];
					arr[j-1] = arr[j];
					arr[j] = temp;
					sorted = false;
				}
			}
			i--;
		}
	}
}
