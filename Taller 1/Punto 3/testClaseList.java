package Punto3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

import org.junit.Test;

public class testClaseList {
	
	@Test
	public void test100(){
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		LinkedList<Integer> linked = new LinkedList<Integer>();
		Vector<Integer> vector = new Vector<Integer>();
		
		ClaseList listas=new ClaseList();
		
		listas.insert(array, 100);
		listas.insert(linked, 100);
		listas.insert(vector, 100);
		
		listas.get(array, 100);
		listas.get(linked, 100);
		listas.get(vector, 100);
		
		listas.remove(array, 100);
		listas.remove(linked, 100);
		listas.remove(vector, 100);
	}
	
	@Test
	public void test1000(){
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		LinkedList<Integer> linked = new LinkedList<Integer>();
		Vector<Integer> vector = new Vector<Integer>();
		
		ClaseList listas=new ClaseList();
		
		listas.insert(array, 1000);
		listas.insert(linked, 1000);
		listas.insert(vector, 1000);
		
		listas.get(array, 1000);
		listas.get(linked, 1000);
		listas.get(vector, 1000);
		
		listas.remove(array, 1000);
		listas.remove(linked, 1000);
		listas.remove(vector, 1000);
	}
	
	@Test
	public void test100000(){
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		LinkedList<Integer> linked = new LinkedList<Integer>();
		Vector<Integer> vector = new Vector<Integer>();
		
		ClaseList listas=new ClaseList();
		
		listas.insert(array, 10000);
		listas.insert(linked, 10000);
		listas.insert(vector, 10000);
		
		listas.get(array, 10000);
		listas.get(linked, 10000);
		listas.get(vector, 10000);
		
		listas.remove(array, 10000);
		listas.remove(linked, 10000);
		listas.remove(vector, 10000);	
	}
}
