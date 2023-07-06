package executer;


import java.util.ArrayList;

import com.github.javafaker.Faker;

//import Utils.EmailToken;
import common.CommonMethod;
import common.ReadCSVData;
import config.AssProjectLocatorsAndConstant;
import constant.AppConstant;

public class AssProjectExecuter extends CommonMethod
		implements AssProjectLocatorsAndConstant, AppConstant {

	Faker faker = new Faker();
//	EmailToken email = new EmailToken();

	public boolean verifyLoginWithOTP() throws RuntimeException, Exception {
		click(SIGN_UP_WITH_EMAIL_BUTTON);
		setData(LOGIN_EMAIL_EDITBOX, getemail().toString());
		setData(FULLNAME__EDITBOX, getname().toString());
		dragAndDrop(SLIDER_BUTTON, SIGN_UP_BUTTON);
		setData(PASSWORD_EDIT_BOX, getpassword().toString());
		setData(VERIFICATION_CODE_EDITBOX, "53453");
		return true;

	}
	
	public String[] getemail() throws Exception {
		ReadCSVData csv = new ReadCSVData();
				ArrayList<String[]> data = csv.getCSVData("testdata");
					return data.get(1);
	}

	public String[] getname() throws Exception {
		ReadCSVData csv = new ReadCSVData();
				ArrayList<String[]> data = csv.getCSVData("testdata");
					return data.get(1);
	}
	public String[] getpassword() throws Exception {
		ReadCSVData csv = new ReadCSVData();
				ArrayList<String[]> data = csv.getCSVData("testdata");
					return data.get(1);
	}
}