package ru.st.selenium;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class EditFilmTest extends TestBase{
	
	@Test
	public void checkEditFilm() throws Exception {
		String movieTitle = "Девчата";
		String imdbNumber = "0134614";
		String alsoKnowAs = "Devchata";
		String duration = "92";
		String rating = "8.362";
		String pathToImage = "C:/Users/Evgenia/Pictures/devchata.jpg";
		String linkTrailer = "https://www.youtube.com/watch?v=LaCUkjlQuVw";
		String year = "1961";
		
		driver.get(baseUrl + "/php4dvd/");
		WebDriverWait wait = new WebDriverWait(driver,30);
		WebElement userName = driver.findElement(By.cssSelector("input#username"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement login = driver.findElement(By.name("submit"));
		userName.sendKeys("admin");
		password.sendKeys("admin");
		login.click();
		
		WebElement movie = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#results div[title='" + movieTitle + "']")));
		movie.click();
		
		WebElement edit = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#content nav ul li:nth-child(3) a")));
		edit.click();
		WebElement imdbidField = driver.findElement(By.name("imdbid"));
		imdbidField.sendKeys(imdbNumber);
		WebElement akaField = driver.findElement(By.name("aka"));
		akaField.sendKeys(alsoKnowAs);
		WebElement durationField = driver.findElement(By.name("duration"));
		durationField.sendKeys(duration);
		WebElement ratingField = driver.findElement(By.name("rating"));
		ratingField.sendKeys(rating);
		WebElement fileInput = driver.findElement(By.id("cover"));
		fileInput.sendKeys(pathToImage);
		WebElement trailerField = driver.findElement(By.name("trailer"));
		trailerField.sendKeys(linkTrailer);
		
		WebElement save = driver.findElement(By.id("submit"));
		save.click();
		
		WebElement h2Title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".maininfo h2")));
		assertEquals(h2Title.getText(), movieTitle + " (" + year + ")");
		driver.findElement(By.cssSelector("#content nav ul li:nth-child(6) a")).click();
		
		WebElement imdbidField2 = driver.findElement(By.name("imdbid"));
		WebElement akaField2 = driver.findElement(By.name("aka"));
		WebElement durationField2 = driver.findElement(By.name("duration"));
		WebElement ratingField2 = driver.findElement(By.name("rating"));
		WebElement trailerField2 = driver.findElement(By.name("trailer"));
		
		assertEquals(imdbidField2.getAttribute("value"), imdbNumber);
		assertEquals(akaField2.getText(), alsoKnowAs);
		assertEquals(durationField2.getAttribute("value"), duration);
		assertEquals(ratingField2.getAttribute("value"), rating);
		assertEquals(trailerField2.getAttribute("value"), linkTrailer);
	}
}
