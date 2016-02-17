package Punto3;

import java.util.List;

public class ClaseList {
	

	public void insert(List<Integer> lista, int tam) {
		for (int i = 0; i < tam; i++) {
			lista.add(i,1);
		}
	}

	public void remove(List<Integer> lista, int tam) {
		for (int i = 0; i < tam; i++) {
			lista.remove(0);
		}
	} 

	public void get(List<Integer> lista, int tam) {
		for (int i = 0; i < tam; i++) {
			lista.get(i);
		}
	}
}
