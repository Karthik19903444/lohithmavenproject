package com.crm.SDET25.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseClass;



public class ListnerTest extends BaseClass {
	@Test
	
	public void listner()              {
		System.out.println("---test start---");
		
		Assert.assertEquals(false, true);
		
		
		System.out.println("----test end----");
		
		
		
	}

}
