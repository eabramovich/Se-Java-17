package ru.st.selenium.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MoviePage extends InternalPage {

	public MoviePage(PageManager pages) {
		super(pages);
	}
	
	public MoviePage ensurePageLoaded() {
	    super.ensurePageLoaded();
	    wait.until(presenceOfElementLocated(By.name("imdbid")));
	    return this;
	}
	
	@FindBy(css = "label[for='name']")
	private WebElement errorMovieTitle;
	
	@FindBy(css = "label[for='year']")
	private WebElement errorMovieYear;
	
	public String getMovieTitleError() {
		return errorMovieTitle.getText();
	}
	
	public String getMovieYearError() {
		return errorMovieYear.getText();
	}
}
