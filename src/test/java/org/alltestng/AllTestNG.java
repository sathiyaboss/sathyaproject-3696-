package org.alltestng;

import org.supportpack.HelperPojo;
import org.supportpack.UtilClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AllTestNG extends UtilClass{
	@Test()
	private void tc1() {
		browserLaunch("edge");
		launchURL("https://www.facebook.com/");
		String tittle = driver.getTitle();
		System.out.println(tittle);
		Assert.assertTrue(tittle.contains("Facebook"), "to check tittle");
		HelperPojo q = new HelperPojo();
		valuePass(q.getTxtemail(),"raja");
	}
	
	@Test
	private void tc2() {
		SoftAssert a =new SoftAssert();
		
		HelperPojo q = new HelperPojo();
		valuePass(q.getTxtpass(),"123");
		
		String attribute = q.getTxtpass().getAttribute("value");
		a.assertEquals(attribute, "123", "12");
		System.out.println("soft assert passed");
		
		a.assertAll();
	}
	
	@AfterClass
	private void tc4() {
		HelperPojo q = new HelperPojo();
		btnClick(q.getLoginbtn());
	}
	
	@DataProvider(name = "datas") 
	private Object[][] getdat() {
		
		return new Object [][] {
			{"java","123"},
			{"python","789"},
			{"selinium","696"}
		};

	}

}
