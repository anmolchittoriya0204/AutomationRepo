package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import executer.AssProjectExecuter;

public class AssProjectTestCases extends AssProjectExecuter {
	@Test(priority = 1, description = Des_verifyLoginAppTC, alwaysRun = true)
	private void verifyLoginAppTC() throws Exception {
		boolean check = verifyLoginWithOTP();
		Assert.assertEquals(check, true);
	}


}
