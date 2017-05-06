import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

public class DequeTests {

	@Test
	public void createDeque(){
		Deque<String> d = new Deque<>();
		d.addFirst("first");
		assertEquals(1, d.size());
	}
	
	@Test
	public void removeFirst(){
		String s = "first";
		Deque<String> d = new Deque<String>();
		d.addFirst("first");
		String x = d.removeFirst();
		assertEquals(s, x);
	}
	
	@Test
	public void addLastRemoveFirst(){
		String s = "first";
		Deque<String> d = new Deque<String>();
		d.addLast("first");
		String x = d.removeFirst();
		assertEquals(s, x);
	}
	
	@Test
	public void addFirstRemoveLast(){
		String s = "first";
		Deque<String> d = new Deque<String>();
		d.addFirst("first");
		String x = d.removeLast();
		assertEquals(s, x);
	}
	
	@Test
	public void testIterator(){
		String[] strings = {
			"first", "second", "third", "fourth", "fifth"	
		};
		Deque<String> d = new Deque<>();
		for(String s : strings){
			d.addLast(s);
		}
		Iterator<String> it = d.iterator();
		boolean passed = true;
		int i = 0;
		while(it.hasNext()){
			if(!strings[i].equals(it.next())){
				passed = false;
			}
			i++;
		}
		assertTrue(passed);
	}
}
