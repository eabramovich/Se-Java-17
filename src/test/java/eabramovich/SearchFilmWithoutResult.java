package eabramovich;

import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SearchFilmWithoutResult extends TestBase {
	
	@SuppressWarnings("deprecation")
	@Test
	public void testSearchFilmWithoutResult() throws Exception {
		driver.get(baseUrl + "/php4dvd/");
		WebDriverWait wait = new WebDriverWait(driver,30);
		WebElement userName = driver.findElement(By.cssSelector("input#username"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement login = driver.findElement(By.name("submit"));
		userName.sendKeys("admin");
		password.sendKeys("admin");
		login.click();
		
		String movieTitle = "По этому запросу я ничего не найду";
		WebElement addMovie = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href='./?go=add']")));
		addMovie.click();
		
		WebElement imdbsearchField = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("imdbsearch")));
		imdbsearchField.sendKeys(movieTitle);
		driver.findElement(By.cssSelector("input[value='Search']")).click();
		
		WebElement resultNotFound = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#content .content div")));
		wait.until(ExpectedConditions.textToBePresentInElement(resultNotFound, "No movies where found."));
		
		assertEquals(resultNotFound.getText(), "No movies where found.");
	}
}
