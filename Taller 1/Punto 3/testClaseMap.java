package Punto3;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.junit.Test;

public class testClaseMap {

	@Test
	public void test100(){
		
		HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
		LinkedHashMap<Integer,Integer> lhmap = new LinkedHashMap<Integer,Integer>();
		
		ClseMap listas=new ClseMap();
		
		listas.put(hmap, 100);
		listas.put(lhmap, 100);

		
		listas.get(hmap, 100);
		listas.get(lhmap, 100);
		
		listas.remove(hmap, 100);
		listas.remove(lhmap, 100);
	}
	
	@Test
	public void test1000(){
		
		HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
		LinkedHashMap<Integer,Integer> lhmap = new LinkedHashMap<Integer,Integer>();
		
		ClseMap listas=new ClseMap();
		
		listas.put(hmap, 1000);
		listas.put(lhmap, 1000);
		
		listas.get(hmap, 1000);
		listas.get(lhmap, 1000);
		
		listas.remove(hmap, 1000);
		listas.remove(lhmap, 1000);
	}
	
	@Test
	public void test100000(){
		
		HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
		LinkedHashMap<Integer,Integer> lhmap = new LinkedHashMap<Integer,Integer>();
		
		ClseMap listas=new ClseMap();
		
		listas.put(hmap, 10000);
		listas.put(lhmap, 10000);
		
		listas.get(hmap, 10000);
		listas.get(lhmap, 10000);
		
		listas.remove(hmap, 10000);
		listas.remove(lhmap, 10000);	
	}

}
