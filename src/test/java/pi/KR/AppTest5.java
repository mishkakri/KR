package pi.KR;

import junit.framework.TestCase;

/**
 * Unit test for DepositApp.
 */
public class AppTest5 
    extends TestCase {
	
	public void test_kapitalOnSum()
	{
		String result = Calculation.kapitalOnSum(20000.0, 4.2, 2);
		// assert
		assertEquals("1749,39", result);	
	}
}
