package mars.test;

import static org.junit.Assert.*;

import org.junit.Test;



public class MarsTest {
	
	private MarsMain mars = new MarsMain();

	@Test
	public void testNested(){
		assertEquals("NESTED", mars.parseInterval(new String[]{"8", "0", "12", "0", "9", "0", "10","0"}));
	}
	
	@Test
	public void testNestedCompletly(){
		assertEquals("NESTED", mars.parseInterval(new String[]{"8", "0", "12", "0", "8", "0", "12","0"}));
	}
	
	@Test
	public void testOverlapAtTheEndOfFirstInterval(){
		assertEquals("OVERLAP", mars.parseInterval(new String[]{"8", "0", "12", "0", "9", "0", "13","0"}));
	}
	
	@Test
	public void testOverlapAtTheBeginningOfFirstInterval(){
		assertEquals("OVERLAP", mars.parseInterval(new String[]{"8", "0", "12", "0", "5", "0", "9","0"}));
	}

	@Test
	public void testTouch(){
		assertEquals("TOUCH", mars.parseInterval(new String[]{"8", "0", "12", "0", "5", "0", "8","0"}));
	}
	
	@Test
	public void testDisjoint(){
		assertEquals("DISJOINT", mars.parseInterval(new String[]{"8", "0", "12", "0", "5", "0", "7","0"}));
	}
	
	@Test
	public void testRejectInvertedInterval(){
		assertEquals("REJECTED", mars.parseInterval(new String[]{"8", "0", "12", "0", "12", "0", "7","0"}));
	}

	@Test
	public void testRejectNegativNumber(){
		assertEquals("REJECTED", mars.parseInterval(new String[]{"-8", "0", "12", "0", "3", "0", "7","0"}));
	}
	
	@Test
	public void testRejectToHighMinutes(){
		assertEquals("REJECTED", mars.parseInterval(new String[]{"8", "999", "12", "0", "3", "0", "7","0"}));
	}
	
	@Test
	public void testRejectToHighHours(){
		assertEquals("REJECTED", mars.parseInterval(new String[]{"88", "0", "12", "0", "3", "0", "7","0"}));
	}
}
