package ru.st.selenium;

import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.Test;

import ru.st.selenium.model.User;

public class AddNewUser extends TestBase {
	
	@Test
	public void addNewUserOk() {
		String username = "user" + System.currentTimeMillis();
		User user = new User()
			.setLogin(username)
			.setPassword("password")
			.setEmail(username + "@test.com");
		
		app.getUserHelper().loginAs(ADMIN);
		app.getUserHelper().createUser(user);
		app.getUserHelper().logout();
		app.getUserHelper().loginAs(user);
		assertTrue(app.getUserHelper().isLoggedInAs(user));
		
	}
}
