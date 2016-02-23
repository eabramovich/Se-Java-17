package eabramovich;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SearchFilmFromCatalog extends TestBase {
	
	@Test
	public void checkAddFilmFromCatalog() throws Exception {
		
		driver.get(baseUrl + "/php4dvd/");
		WebDriverWait wait = new WebDriverWait(driver,30);
		WebElement userName = driver.findElement(By.cssSelector("input#username"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement login = driver.findElement(By.name("submit"));
		userName.sendKeys("admin");
		password.sendKeys("admin");
		login.click();
		
		String movieTitle = "”несЄнные ветром";
		WebElement addMovie = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href='./?go=add']")));
		addMovie.click();
		
		WebElement imdbsearchField = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("imdbsearch")));
		imdbsearchField.sendKeys(movieTitle);
		driver.findElement(By.cssSelector("input[value='Search']")).click();
		
		WebElement movie = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("table.imdbmovies tr:nth-child(1)")));
		String year = driver.findElement(By.cssSelector("table.imdbmovies tr:nth-child(1) td.year")).getText();
		movie.click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("form#updateform")));
		WebElement save =driver.findElement(By.id("submit"));
		save.click();
		
		WebElement h2Title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".maininfo_full h2")));

		System.out.println(movieTitle + " (" + year + ")");
		assertEquals(h2Title.getText(), movieTitle + " (" + year + ")");
	}

}
