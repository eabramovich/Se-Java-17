package ru.st.selenium.applogic0;

import java.util.List;

import ru.st.selenium.applogic.FilmHelper;
import ru.st.selenium.model.Film;
import ru.st.selenium.pages.MoviePage;

public class FilmHelper0 implements FilmHelper {

  @Override
  public void create(Film film) {
    // TODO Auto-generated method stub

  }

  @Override
  public void delete(Film film) {
    // TODO Auto-generated method stub

  }

  @Override
  public List<Film> search(String title) {
    // TODO Auto-generated method stub
    return null;
  }

	@Override
	public boolean isMovieTitleFieldRequired() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean isMovieYearFieldRequired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MoviePage goToMoviePage() {
		// TODO Auto-generated method stub
		return null;
	}

}
