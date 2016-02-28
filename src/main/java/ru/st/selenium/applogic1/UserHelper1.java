package ru.st.selenium.applogic1;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import ru.st.selenium.applogic.UserHelper;
import ru.st.selenium.model.User;
import ru.st.selenium.pages.UserProfilePage;

public class UserHelper1 extends DriverBasedHelper implements UserHelper {

  private ApplicationManager1 manager;

  public UserHelper1(ApplicationManager1 manager) {
	  super(manager.getWebDriver());
  }

  @Override
  public void loginAs(User user) {
    pages.loginPage.ensurePageLoaded()
      .setUsernameField(user.getLogin())
      .setPasswordField(user.getPassword())
      .clickSubmitButton();
  }

  @Override
  public void logout() {
    pages.internalPage.ensurePageLoaded()
      .clickLogoutLink();
  }

  @Override
  public boolean isLoggedIn() {
    return pages.internalPage.waitPageLoaded();
  }

  @Override
  public boolean isLoggedInAs(User user) {
    return isLoggedIn()
        && getLoggedUser().getLogin().equals(user.getLogin());
  }

  @Override
  public boolean isNotLoggedIn() {
    return pages.loginPage.waitPageLoaded();
  }
  
  private User getLoggedUser() {
    UserProfilePage userProfile = pages.internalPage.ensurePageLoaded()
      .clickUserProfilePage()
      .ensurePageLoaded();
    return new User()
      .setLogin(userProfile.getUsername())
      .setEmail(userProfile.getEmail())
      .setRole(userProfile.getRole());
  }

  @Override
  public void createUser(User user) {
	pages.internalPage.clickUserManagementLink().ensurePageLoaded()
	.setUsernameField(user.getLogin())
	.setEmailField(user.getEmail())
	.setPassword(user.getPassword())
	.setPassword2(user.getPassword())
	.clickSubmitButton();
	
  }

}
