
import org.junit.Test;

public class TestByCode {
	@Test
	public void testbycode(){
		Sorter Organiza = new Sorter();
		Organiza.Order(new OrderByCode());
		
		System.out.println("Ordenados por c�digo");
		for(int i = 0; i < 12; i++) {   
			System.out.println(Organiza.get(i).getCode());
		}
	}
}