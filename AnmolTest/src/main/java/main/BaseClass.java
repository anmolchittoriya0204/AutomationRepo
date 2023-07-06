package main;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import constant.AppConstant;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass implements AppConstant {
	public static WebDriver driver;
	public static WebDriverWait wait;

	@SuppressWarnings("deprecation")
	@BeforeTest
	@Parameters({ "browser", "headless" })
	public void browserSetup(String browser) {
		if (driver != null) {
			driver.quit();
		}
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		if (browser == "chomre") {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);

		}
		else {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(options);

		}


		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 30);
		driver.get(WEB_URL);

	}

	@AfterTest
	public void quitDriver() {
		driver.quit();
	}

}







