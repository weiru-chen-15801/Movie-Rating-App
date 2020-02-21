import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Movie {
	
	public static final int ACTION = 1;
	public static final int ROMANCE = 2;
	public static final int COMEDY = 3;
	public static final int DRAMA = 4;
	public static final int DOCUMENTARY = 5;
	public static final int ANIME = 6;
	
	private String title;
	private int rating;
	private String movieDescription;
	private int genre;
	private boolean haveSeen;
	private String[] actorList;
	public static Movie[] movieList = new Movie[0];
	
	public Movie() {
		
	}
	
	public Movie(String newTitle, int newRating, String newMovieDescription, int
			newGenre, boolean newHaveSeen, String[] newActorList) {
		this.title = newTitle;
		this.rating = newRating;
		this.movieDescription = newMovieDescription;
		this.genre = newGenre;
		this.haveSeen = newHaveSeen;
		this.actorList = newActorList;
	}
	
	public String getTitle() {
		return this.title;
	}
	public int getRating() {
		return this.rating;
	}
	public String getMovieDescription() {
		return this.movieDescription;
	}
	public String getGenre() {
		String genreString = "";
		if (this.genre == ACTION)
			genreString =  "ACTION";
		else if (this.genre == ROMANCE)
			genreString = "ROMANCE";
		else if (this.genre == COMEDY)
			genreString = "COMEDY";
		else if (this.genre == DRAMA)
			genreString = "DRAMA";
		else if (this.genre == DOCUMENTARY)
			genreString = "DOCUMENTARY";
		else if (this.genre == ANIME)
			genreString = "ANIME";
		return genreString;
	}
	public boolean getHaveSeen() {
		return this.haveSeen;
	}
	public String[] getActorList() {
		return this.actorList;
	}
	
	public static void sortAlphabetically(Movie[] newMovieList) {
		for (int i = 0; i < newMovieList.length; i++) {
			swap(newMovieList, i, findMinimumIndex(i, newMovieList));
		}
	}
	
	public static int findMinimumIndex(int startIndex, Movie[] newMovieList) {
		int minIndex = startIndex;
		for (int i = startIndex; i < newMovieList.length; i++) {
			if (newMovieList[i].title.charAt(0) < newMovieList[minIndex].title.charAt(0))
				minIndex = i;
		}
		return minIndex;
			
	}
	
	public static void swap(Movie[] newMovieList, int current, int minimum) {
		Movie temp = newMovieList[current];
		newMovieList[current] = newMovieList[minimum];
		newMovieList[minimum] = temp;
	}
	
	public static void addMovie(String title, int rating, String movieDescription, int genre, boolean
			haveSeen, String[] actorList) {
		Movie[] previous = movieList;
		movieList = new Movie[previous.length+1];
		for (int i = 0; i < previous.length; i++) {
			movieList[i] = previous[i];
		}
	    movieList[previous.length] = new Movie(title, rating, movieDescription, genre, haveSeen, actorList);
		sortAlphabetically(movieList);
	}
	
	public static void removeMovie(String removeTitle) {
		sortAlphabetically(movieList);
		int removeIndex = -1;
		for (int i = 0; i < movieList.length; i++) {
			if (movieList[i].title.equals(removeTitle))
				removeIndex = i;
		}
		if (removeIndex == -1) {
			
			JFrame frame = new JFrame("JOptionPane showMessageDialog example");
		    JOptionPane.showMessageDialog(frame,
		          "There is no such movie in the list!");
		}
		else {
			Movie[] previous = movieList;
			movieList = new Movie[previous.length-1];
			for (int j = 0; j < removeIndex; j++) {
				movieList[j] = previous[j];
			}
			for (int k = removeIndex+1; k < previous.length; k++) {
				movieList[k-1] = previous[k];
			}
		}
	}
	
	public static String toString(String[] actorList) {
		String actorString = "";
		for (int i = 0; i < actorList.length-1; i++) {
			actorString = actorString + actorList[i] + ", ";
		}
		actorString = actorString + actorList[actorList.length-1] + ".";
		return actorString;
	}
	
	public static void displayAlphabetically() {
		sortAlphabetically(movieList);
		for (int i = 0; i < movieList.length; i++) {
			JFrame a = new JFrame("JOptionPane showMessageDialog example");
			if (movieList[i].haveSeen == true) {
		        JOptionPane.showMessageDialog(a,
		    		"Title: " + movieList[i].title.toString() + "\n" +
		    		"Rating: " + movieList[i].rating + "\n" +
		    		"MovieDescription: " + movieList[i].movieDescription.toString() + "\n" +
		    		"Genre: " + movieList[i].getGenre().toString() + "\n" +
		    		"Have seen the movie? Yes\n" +
		    		"Actors and actresses: " + toString(movieList[i].actorList));
			}
			else {
				JOptionPane.showMessageDialog(a,
			    		"Title: " + movieList[i].title.toString() + "\n" +
			    		"Rating: " + movieList[i].rating + "\n" +
			    		"MovieDescription: " + movieList[i].movieDescription.toString() + "\n" +
			    		"Genre: " + movieList[i].getGenre().toString() + "\n" +
			    		"Have seen the movie? No\n" +
			    		"Actors and actresses: " + toString(movieList[i].actorList));
			}
		}
	}
	
	public static void displayGreaterThanRating(int certainRating) {
		sortAlphabetically(movieList);
		for (int i = 0; i < movieList.length; i++) {
			if (movieList[i].rating >= certainRating) {
			    JFrame a = new JFrame("JOptionPane showMessageDialog example");
			    if (movieList[i].haveSeen == true) {
		            JOptionPane.showMessageDialog(a,
		    		      "Title: " + movieList[i].title.toString() + "\n" +
		    		      "Rating: " + movieList[i].rating + "\n" +
		    		      "MovieDescription: " + movieList[i].movieDescription.toString() + "\n" +
		    		      "Genre: " + movieList[i].getGenre().toString() + "\n" +
		    		      "Have seen the movie? Yes\n" +
		    		      "Actors and actresses: " + toString(movieList[i].actorList));
			    }
			    else {
				    JOptionPane.showMessageDialog(a,
			    		  "Title: " + movieList[i].title.toString() + "\n" +
			    		  "Rating: " + movieList[i].rating + "\n" +
			    		  "MovieDescription: " + movieList[i].movieDescription.toString() + "\n" +
			    		  "Genre: " + movieList[i].getGenre().toString() + "\n" +
			    		  "Have seen the movie? No\n" +
			    		  "Actors and actresses: " + toString(movieList[i].actorList));
			    }
			}
		}
	}
	
    public static void displaySpecifiedGenre(int specifiedGenre) {
    	sortAlphabetically(movieList);
		for (int i = 0; i < movieList.length; i++) {
			if (movieList[i].genre == specifiedGenre && movieList[i].haveSeen == false) {
				JFrame a = new JFrame("JOptionPane showMessageDialog example");
			    JOptionPane.showMessageDialog(a,
			          "Title: " + movieList[i].title.toString() + "\n" +
			    	  "Rating: " + movieList[i].rating + "\n" +
			    	  "MovieDescription: " + movieList[i].movieDescription.toString() + "\n" +
			          "Genre: " + movieList[i].getGenre().toString() + "\n" +
			    	  "Have seen the movie? No\n" +
			    	  "Actors and actresses: " + toString(movieList[i].actorList));
			    
		
			}
		}
	}
    
    public static void listSpecifiedActorMovies(String specifiedActor) {
    	for (int i = 0; i < movieList.length; i++) {
    		if (toString(movieList[i].actorList).toUpperCase().contains(specifiedActor.toUpperCase())) {
    			JFrame a = new JFrame("JOptionPane showMessageDialog example");
			    if (movieList[i].haveSeen == true) {
		            JOptionPane.showMessageDialog(a,
		    		      "Title: " + movieList[i].title.toString() + "\n" +
		    		      "Rating: " + movieList[i].rating + "\n" +
		    		      "MovieDescription: " + movieList[i].movieDescription.toString() + "\n" +
		    		      "Genre: " + movieList[i].getGenre().toString() + "\n" +
		    		      "Have seen the movie? Yes\n" +
		    		      "Actors and actresses: " + toString(movieList[i].actorList));
			    }
			    else {
				    JOptionPane.showMessageDialog(a,
			    		  "Title: " + movieList[i].title.toString() + "\n" +
			    		  "Rating: " + movieList[i].rating + "\n" +
			    		  "MovieDescription: " + movieList[i].movieDescription.toString() + "\n" +
			    		  "Genre: " + movieList[i].getGenre().toString() + "\n" +
			    		  "Have seen the movie? No\n" +
			    		  "Actors and actresses: " + toString(movieList[i].actorList));
			    }
    		}	
    	}
    }
    
    public static void listMoviesYetToSee() {
    	sortAlphabetically(movieList);
    	int highestRatingIndex = movieList.length-1;
    	for (int k = movieList.length-1; k >= 0; k--) {
    		if (movieList[k].haveSeen == false)
    			highestRatingIndex = k;
    	}
    	for (int j = highestRatingIndex; j < movieList.length; j++) {
    		if (movieList[j].haveSeen == false && movieList[j].rating > movieList[highestRatingIndex].rating)
    			highestRatingIndex = j;
    	}
		for (int i = 0; i < movieList.length; i++) {
			if (movieList[i].haveSeen == false) {
				JFrame a = new JFrame("JOptionPane showMessageDialog example");
			    JOptionPane.showMessageDialog(a,
			          "Title: " + movieList[i].title.toString() + "\n" +
			    	  "Rating: " + movieList[i].rating + "\n" +
			    	  "MovieDescription: " + movieList[i].movieDescription.toString() + "\n" +
			          "Genre: " + movieList[i].getGenre().toString() + "\n" +
			    	  "Have seen the movie? No\n" +
			    	  "Actors and actresses: " + toString(movieList[i].actorList));
		
			}
		}
		JFrame b = new JFrame("JOptionPane showMessageDialog example");
		JOptionPane.showMessageDialog(b, "We recommend seeing: " + movieList[highestRatingIndex].title);
		
    }
}