import java.time.LocalDate;

public class Movie {
    private int movieId;
    private String movieName;
    private LocalDate movieReleasedYear;
    
    public Movie(int movieId, String movieName, LocalDate movieReleasedYear) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieReleasedYear = movieReleasedYear;
    }

    public int getMovieId() {
        return movieId;
    }
    
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
    
    public String getMovieName() {
        return movieName;
    }
    
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    
    public LocalDate getMovieReleasedYear() {
        return movieReleasedYear;
    }
    
    public void setMovieReleasedYear(LocalDate movieReleasedYear) {
        this.movieReleasedYear = movieReleasedYear;
    }
}
