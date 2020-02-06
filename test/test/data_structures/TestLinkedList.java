package test.data_structures;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import model.data_structures.Comparendo;
import model.data_structures.LinkedList;

public class TestLinkedList <Item>
{	

	private LinkedList<Item> list;

	@Before
	public void setUp1() 
	{
		list = new LinkedList<Item>();
	}

	public void setUp2()
	{
		ArrayList<Double> array = new ArrayList<Double>();
		array.add(10.0067);
		array.add(-20.0034);
		Comparendo a = new Comparendo(1, "", "", "", "", "", "", "", array);
		Comparendo b = new Comparendo(2, "", "", "", "", "", "", "", array);
		Comparendo c = new Comparendo(3, "", "", "", "", "", "", "", array);
		Comparendo d = new Comparendo(4, "", "", "", "", "", "", "", array);
		list.append((Item) a);
		list.append((Item) b);
		list.append((Item) c);
		list.append((Item) d);
	}

	@Test
	public void testGetLength() 
	{
		setUp1();
		setUp2();
		assertEquals(4, list.getLength());
	}
	
	@Test
	public void testGetAt() 
	{
		setUp1();
		setUp2();
		try
		{
		assertEquals("Infracción #4:  en:  coords: 10.0067, -20.0034", list.getAt(3).toString());
		assertEquals("Infracción #1:  en:  coords: 10.0067, -20.0034", list.getAt(0).toString());
		}
		catch(Exception e)
		{
			
		}
	}
	
	@Test
	public void testDelete()
	{
		setUp1();
		setUp2();
		try
		{
		assertEquals("Infracción #2:  en:  coords: 10.0067, -20.0034", list.delete(1).toString());
		assertEquals(3, list.getLength());
		}
		catch(Exception e)
		{
			
		}
	}

	


}
