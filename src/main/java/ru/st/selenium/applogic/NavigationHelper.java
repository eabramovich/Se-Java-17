package ru.st.selenium.applogic;

import ru.st.selenium.pages.MoviePage;

public interface NavigationHelper {

  void openMainPage();
  void openRelativeUrl(String url);
  void gotoUserProfilePage();
  void gotoUserManagementPage();
  void goToAddMoviePage();

}
