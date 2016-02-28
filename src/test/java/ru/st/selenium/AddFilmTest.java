package ru.st.selenium;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.st.selenium.model.Film;
import ru.st.selenium.model.User;

public class AddFilmTest extends TestBase {
		
		@Test
		public void checkRequiredFields() throws Exception {
			//Film film = null;
			app.getUserHelper().loginAs(ADMIN);
			app.getNavigationHelper().goToAddMoviePage();
			app.getFilmHelper().isMovieTitleFieldRequired();
			app.getFilmHelper().isMovieYearFieldRequired();
			
			
			
			/*String movieTitle = "Девчата";
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
			assertEquals(h2Title.getText(), movieTitle + " (" + year + ")");*/
		}
		
}
