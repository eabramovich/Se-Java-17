package ru.st.selenium.applogic1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import ru.st.selenium.applogic.ApplicationManager;
import ru.st.selenium.applogic.FilmHelper;
import ru.st.selenium.applogic.NavigationHelper;
import ru.st.selenium.applogic.UserHelper;

import ru.st.selenium.util.PropertyLoader;
import ru.stqa.selenium.factory.WebDriverFactory;

public class ApplicationManager1 implements ApplicationManager {
	
	private UserHelper userHelper;
	private FilmHelper filmHelper;
	private NavigationHelper navHelper;

	private WebDriver driver;
	private String baseUrl;
	private String gridHubUrl;
	
	public ApplicationManager1() {
		baseUrl = PropertyLoader.loadProperty("site.url");
		gridHubUrl = PropertyLoader.loadProperty("grid2.hub");
	
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName(PropertyLoader.loadProperty("browser.name"));
		capabilities.setVersion(PropertyLoader.loadProperty("browser.version"));
		String platform = PropertyLoader.loadProperty("browser.platform");
		if (!(null == platform || "".equals(platform))) {
			capabilities.setPlatform(Platform.valueOf(PropertyLoader.loadProperty("browser.platform")));
		}
	
		if (!(null == gridHubUrl || "".equals(gridHubUrl))) {
			driver = WebDriverFactory.getDriver(gridHubUrl, capabilities);
		} else {
			driver = WebDriverFactory.getDriver(capabilities);
		}
		
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		 userHelper = new UserHelper1(this);
		 filmHelper = new FilmHelper1(this);
		 navHelper = new NavigationHelper1(this);

		 getNavigationHelper().openMainPage();
	}


	@Override
	public UserHelper getUserHelper() {
	  return userHelper;
	}

	@Override
	public FilmHelper getFilmHelper() {
	  return filmHelper;
	}

	@Override
	public NavigationHelper getNavigationHelper() {
	  return navHelper;
	}

	protected WebDriver getWebDriver() {
	    return driver;
	}

	protected String getBaseUrl() {
	    return baseUrl;
	}


	@Override
	public void stop() {
		if (driver != null) {
			driver.quit();
		}
	}
}
