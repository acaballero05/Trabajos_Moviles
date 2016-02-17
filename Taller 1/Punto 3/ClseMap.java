package Punto3;

import java.util.Map;

public class ClseMap {

	public void put(Map<Integer,Integer> m, int tam) {
		for (int i = 0; i < tam; i++) {
			m.put(i, 0);
		}
	}
	public void remove(Map<Integer,Integer> m, int tam) {
		for (int i = 0; i < tam; i++) {
			m.remove(i);
		}
	}
	public void get(Map<Integer,Integer> m, int tam) {
		for (int i = 0; i < tam; i++) {
			m.get(i);
		}
	}
}
