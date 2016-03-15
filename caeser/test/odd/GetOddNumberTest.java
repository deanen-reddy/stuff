package odd;

import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GetOddNumberTest {
	
	static int [] largeArray = new int[Integer.MAX_VALUE - 8];
	//int [] largeArray = new int[10];
	
	@BeforeClass
	static public void setup(){
		System.out.println("Setting up " + largeArray.length + " elements.");
		//Random random = new Random(555);
		int c;
		for (c = 0; c < largeArray.length - 3; c++){
			if(c % 2 == 0)
				largeArray[c] = 1;
			else
				largeArray[c] = 2;
		}		
		largeArray[c] = 7;
		largeArray[c+1] = 7;
		largeArray[c+2] = 7;
		System.out.println("Done with setup.");
	}
	
	@Test
	public void testOddNumberSort(){
		GetOddNumber oddNumber = new GetOddNumber();
		Assert.assertEquals(new Integer(1), oddNumber.oddSort(new int[]{1,2,3,1,2,3,1}));
		Assert.assertEquals(new Integer(3), oddNumber.oddSort(new int[]{1,2,3,1,2,3,1,1,3}));	
		Assert.assertEquals(new Integer(2), oddNumber.oddSort(new int[]{1,2,2,2,2,3,1,2,3,1,1,3,3}));
		System.out.println(oddNumber.oddSort(largeArray));
	}

	@Test
	public void testOddNumberMap(){
		GetOddNumber oddNumber = new GetOddNumber();
		Assert.assertEquals(new Integer(1), oddNumber.oddMap(new int[]{1,2,3,1,2,3,1}));
		Assert.assertEquals(new Integer(3), oddNumber.oddMap(new int[]{1,2,3,1,2,3,1,1,3}));
		Assert.assertEquals(new Integer(2), oddNumber.oddMap(new int[]{1,2,2,2,2,3,1,2,3,1,1,3,3}));
		System.out.println(oddNumber.oddMap(largeArray));
	}
}
