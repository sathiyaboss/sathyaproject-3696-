package org.alltestng;

import org.supportpack.HelperPojo;
import org.supportpack.UtilClass;
import org.testng.annotations.Test;

public class SuitLevelClass extends UtilClass{
	
	@Test()
	private void tc1() {
		browserLaunch("edge");
		launchURL("https://www.facebook.com/");
		HelperPojo q = new HelperPojo();
		valuePass(q.getTxtemail(),"java" );
	}
	@Test()
	private void tc2() {
		HelperPojo q = new HelperPojo();
		valuePass(q.getTxtpass(), "123987");
	}
	


	}



