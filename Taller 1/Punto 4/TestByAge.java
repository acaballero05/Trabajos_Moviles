import org.junit.Test;

public class TestByAge {
	@Test
	public void testbyage(){
		Sorter Organiza = new Sorter();
		Organiza.Order(new OrderByAge());
		System.out.println("Ordenados por Edad");
		for(int i = 0; i < 12; i++) {   
			System.out.println(Organiza.get(i).getAge());
		}
	}
}
