import org.junit.Test;

public class TestByName {
	@Test
	public void testbyname(){
		Sorter Organiza = new Sorter();
		Organiza.Order(new OrderByName());
		System.out.println("Ordenados por Nombre");
		for(int i = 0; i < 12; i++) {   
			System.out.println(Organiza.get(i).getName());
		}
	}
}