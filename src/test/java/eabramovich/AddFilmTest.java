package eabramovich;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddFilmTest extends TestBase {
		
		@Test
		public void checkRequiredFields() throws Exception {
			driver.get(baseUrl + "/php4dvd/");
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement userName = driver.findElement(By.cssSelector("input#username"));
			WebElement password = driver.findElement(By.name("password"));
			WebElement login = driver.findElement(By.name("submit"));
			userName.sendKeys("admin");
			password.sendKeys("admin");
			login.click();
			
			WebElement addMovie = driver.findElement(By.cssSelector("a[href='./?go=add']"));
			addMovie.click();
			
			String movieTitle = "Девчата";
			WebElement inputTitle = driver.findElement(By.name("name"));
			String error = "This field is required";
			WebElement errorTitle = driver.findElement(By.cssSelector("label[for='name']"));
			String errorTitleText = errorTitle.getText();
			WebElement errorYear = driver.findElement(By.cssSelector("label[for='year']"));
			String errorYearText = errorYear.getText();
		    assertEquals(error, errorTitleText);
			assertEquals(error, errorYearText);
			
			inputTitle.sendKeys(movieTitle);
			assertEquals(false, errorTitle.isDisplayed());
			assertEquals(true, errorYear.isDisplayed());
			
			WebElement save =driver.findElement(By.id("submit"));
			save.click();
			
			assertEquals(true, errorYear.isDisplayed());
			String year = "1961";
			WebElement  yearInput= driver.findElement(By.name("year"));
			yearInput.sendKeys(year);
			save.click();
			
			WebElement h2Title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".maininfo_full h2")));

			System.out.println(movieTitle + " (" + year + ")");
			assertEquals(h2Title.getText(), movieTitle + " (" + year + ")");
		}
		
}
