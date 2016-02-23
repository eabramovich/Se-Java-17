package eabramovich;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class RemoveFilmTest extends TestBase {
	
	@Test
	public void checkRemoveFilm() throws Exception {
		
		driver.get(baseUrl + "/php4dvd/");
		WebDriverWait wait = new WebDriverWait(driver,30);
		WebElement userName = driver.findElement(By.cssSelector("input#username"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement login = driver.findElement(By.name("submit"));
		userName.sendKeys("admin");
		password.sendKeys("admin");
		login.click();
		
		String movieTitle = "Девчата";
		String year = "1961";
		WebElement movie = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#results img[title='" + movieTitle + "']")));
		movie.click();
		
		WebElement h2Title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".maininfo h2")));
		AssertJUnit.assertEquals(h2Title.getText(), movieTitle + " (" + year + ")");
		driver.findElement(By.cssSelector("#content nav ul li:nth-child(7) a")).click();
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#results")));
		assertEquals(0, driver.findElements(By.cssSelector("#results img[title='" + movieTitle + "']")).size());
		
	}
}
