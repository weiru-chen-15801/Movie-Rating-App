import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MovieRating {
	public static final String[] options = { "add a movie", "remove a movie", "display movies alphabetically", "display movies >= a certain rating", "display movies in a specified genre", "list all movies with a specified actor/actress", "list all movies the user has yet to see", "quit" };

	  public static void main(String[] args) {
	      boolean exit = false;
		  while (exit != true) {  
		      JFrame frame = new JFrame("JOptionPane showMessageDialog example");
		    
		      JOptionPane.showMessageDialog(frame,
		          "Welcome to the Movie Rating App!");
		    
	          JFrame some = new JFrame("Input Dialog Example 3");
	          String optionForMovie = (String) JOptionPane.showInputDialog(some, 
	            "Select an option below",
	            "Options",
	            JOptionPane.QUESTION_MESSAGE, 
	            null, 
	            options, 
	            options[0]);

	    
	          System.out.printf("Your option is %s.\n", optionForMovie);
	          if (optionForMovie.equals("add a movie")) {
	        	  JFrame a = new JFrame("InputDialog Example #1");

	        	  String title = JOptionPane.showInputDialog(a, "Type in the title:");

	        	  System.out.printf("The movie's title is '%s'.\n", title);
	        	  
	        	  JFrame b = new JFrame("InputDialog Example #2");

	        	  String ratingString = JOptionPane.showInputDialog(b, "Type in the rating (1-5):");
	        	  int rating = Integer.parseInt(ratingString);

	        	  System.out.printf("The movie's rating is '%s'.\n", ratingString);
	        	  
	        	  JFrame c = new JFrame("InputDialog Example #1");

	        	  String movieDescription = JOptionPane.showInputDialog(c, "Type in the movie description:");

	        	  System.out.printf("The movie's description is '%s'.\n", movieDescription);
	        	  
	        	  JFrame d = new JFrame("InputDialog Example #1");

	        	  String genreString = JOptionPane.showInputDialog(d, "Type in the genre of this movie form below (type in number): \n 1:ACTION, 2:ROMANCE, 3:COMEDY, 4:DRAMA, 5:DOCUMENTARY, 6:ANIME");
	        	  
	        	  int genre = Integer.parseInt(genreString);
	        	  
	        	  JFrame e = new JFrame("InputDialog Example #1");

	        	  String haveSeenString = JOptionPane.showInputDialog(e, "Have you seen the movie yet? (yes / no)");

	        	  boolean haveSeen;
				  if (haveSeenString.equals("yes"))
					  haveSeen = true;
				  else
					  haveSeen = false;
				  JFrame f = new JFrame("InputDialog Example #1");

	        	  String actorString = JOptionPane.showInputDialog(f, "Please list the main actors and actresses of this movie (e.g. Emma Watson, Benedict Cumberbatch):");
	        	  String[] actorList = actorString.split(",");
				  Movie.addMovie(title, rating, movieDescription, genre, haveSeen, actorList);

	          }
	          else if (optionForMovie.equals("remove a movie")) {
	        	  JFrame a = new JFrame("InputDialog Example #1");

	        	  String removeTitle = JOptionPane.showInputDialog(a, "Type in the title of movie that you want to remove:");
	        	  Movie.removeMovie(removeTitle);
	          }
	          else if (optionForMovie.equals("display movies alphabetically")) {
	        	  Movie.displayAlphabetically();
	          }
	          else if (optionForMovie.equals("display movies >= a certain rating")) {
	        	  JFrame a = new JFrame("InputDialog Example #1");
	        	  String certainRatingString = JOptionPane.showInputDialog(a, "Type in the rating for movies that you want to show:");
	        	  int certainRating = Integer.parseInt(certainRatingString);
	        	  Movie.displayGreaterThanRating(certainRating);
	          }
	          else if (optionForMovie.equals("display movies in a specified genre")) {
	        	  JFrame a = new JFrame("InputDialog Example #1");
	        	  String specifiedGenreString = JOptionPane.showInputDialog(a, "Type in the genre in integer (1.ACTION 2.ROMANCE 3.COMEDY 4.DRAMA 5.DOCUMENTARY 6.ANIME):");
	        	  int specifiedGenre = Integer.parseInt(specifiedGenreString);
	        	  Movie.displaySpecifiedGenre(specifiedGenre);
	          }
	          else if (optionForMovie.equals("list all movies with a specified actor/actress")) {
	        	  JFrame a = new JFrame("InputDialog Example #1");

	        	  String specifiedActor = JOptionPane.showInputDialog(a, "Type in the actor or actress specified:");
	        	  Movie.listSpecifiedActorMovies(specifiedActor);
	          }
	          else if (optionForMovie.equals("list all movies the user has yet to see")) {
	        	  JFrame a = new JFrame("InputDialog Example #1");
	        	  Movie.listMoviesYetToSee();
	          }
	          else if (optionForMovie.equals("quit")) {
	        	  int n = JOptionPane.showConfirmDialog(
	        	            null,
	        	            "Are you sure you want to quit? - all your data will be lost.",
	        	            "Quit Question",
	        	            JOptionPane.YES_NO_OPTION);

	        	        if (n == 1){
	        	            JOptionPane.showMessageDialog(null, "Hello");
	        	        }
	        	        else {
	        	            JOptionPane.showMessageDialog(null, "Bye~");
	        	            exit = true;
	        	            System.exit(0);
	        	        }

	        	       
	          }
	          
		  }
	  }

}
