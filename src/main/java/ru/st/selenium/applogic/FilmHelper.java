package ru.st.selenium.applogic;

import java.util.List;

import ru.st.selenium.model.Film;
import ru.st.selenium.pages.MoviePage;

public interface FilmHelper {

	void create(Film film);
	void delete(Film film);
	List<Film> search(String title);
	boolean isMovieTitleFieldRequired();
	boolean isMovieYearFieldRequired();
	MoviePage goToMoviePage();

}
