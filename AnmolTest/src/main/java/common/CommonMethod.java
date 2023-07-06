package common;

import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

import main.BaseClass;

public class CommonMethod extends BaseClass {
	Faker faker = new Faker();

	public void click(By element) throws Exception, RuntimeException {
		wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOfElementLocated(element),

				ExpectedConditions.elementToBeClickable(element)));

//		scrollToElement(element);

		driver.findElement(element).click();
	}

	public void clearData(By element) throws Exception, RuntimeException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		driver.findElement(element).clear();
	}

	public void waitForStalness(By element) {
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(element))));	}
	
	public boolean isEnable(By element) throws Exception, RuntimeException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		return driver.findElement(element).isEnabled();
	}

	public void selectDropDownDataByCLick(By dropdown, By data) throws Exception, RuntimeException {
		wait.until(ExpectedConditions.elementToBeClickable(dropdown));
		driver.findElement(dropdown).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(data));
		wait.until(ExpectedConditions.elementToBeClickable(data));
		driver.findElement(data).click();
		Thread.sleep(500);

	}

	public boolean waitForElementToBeDisplayed(By element) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
		return displayed(element);
	}

	public boolean waitForElementToBeDisplayed(By element, int timeout) {
		wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
		return displayed(element);
	}

	public void scrollToElement(By element) throws InterruptedException {
		WebElement we = driver.findElement(element);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", we);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		Thread.sleep(1000); // For Animation
	}

	public void setData(By element, String data) throws Exception, RuntimeException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		Thread.sleep(500);
		driver.findElement(element).clear();
		driver.findElement(element).sendKeys(data);
		Thread.sleep(500);
	}
	public void setData(By element, Keys data) throws Exception, RuntimeException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		Thread.sleep(500);
		driver.findElement(element).clear();
		driver.findElement(element).sendKeys(data);
		Thread.sleep(500);
	}
	public void waitForAnimation() throws InterruptedException {
		Thread.sleep(1000);
	}
	public void waitForInvisibility(By element) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(element));

	}

	public void selectDropdownDataBySelectBox(By element, String text) throws Exception, RuntimeException {
//		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		Select objSelect = new Select(driver.findElement(element));
		objSelect.selectByVisibleText(text);
	}
	public void dragAndDrop(By from, By to) throws InterruptedException {
		Thread.sleep(500);
		Actions action = new Actions(driver);
		WebElement source = driver.findElement(from);
		WebElement target = driver.findElement(to);

		action.dragAndDrop(source, target).build().perform();

		Action dragAndDrop = action.clickAndHold(source).moveToElement(target).release(target).build();

		dragAndDrop.perform();
		Thread.sleep(500);
	}


	
	public boolean displayed(By element) {
		try {
			if (driver.findElement(element).isDisplayed()) {
				return true;
			} else {
				return false;
			}

		} catch (NoSuchElementException ignore) {
			return false;
		} catch (RuntimeException e) {
			return false;
		} catch (Exception e) {
			return false;
		}

	}

	public String getText(By element) throws InterruptedException {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			String text = driver.findElement(element).getAttribute("textContent").trim();
			if (text.isEmpty()) {
				text = driver.findElement(element).getAttribute("value").trim();
			}

			if (text.isEmpty()) {
				text = driver.findElement(element).getText();
			}
			if (text.isEmpty()) {
				text = driver.findElement(element).getAttribute("innerHTML").trim();
			}
			return text.trim();

		} catch (RuntimeException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public String getText(WebElement element) throws InterruptedException {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			String text = element.getAttribute("textContent").trim();
			if (text.isEmpty()) {
				text = element.getAttribute("value").trim();
			}

			if (text.isEmpty()) {
				text = element.getText();
			}
			if (text.isEmpty()) {
				text = element.getAttribute("innerHTML").trim();
			}
			return text.trim();

		} catch (RuntimeException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public void getUrl(String url) {
		driver.get(url);
	}

}
