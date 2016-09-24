package paq1;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class SingletonTests {

	@Test
	public void referenciaTest() {
		
		Stock s1 = Stock.getInstance();
		Stock s2 = Stock.getInstance();
		
		Assert.assertSame(s1, s2);
	}

}
