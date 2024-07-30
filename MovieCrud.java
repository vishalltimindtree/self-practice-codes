import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.time.LocalDate;

public class MovieCrud {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the movie release year (YYYY): ");
        int releaseYear = scanner.nextInt();
        try {
            Connection conn = MovieDbConnection.getConnection();
            String sql = "SELECT * FROM Movie WHERE YEAR(movieReleasedYear) = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, releaseYear);
            ResultSet rs = pstmt.executeQuery();
            boolean found = false;
            while (rs.next()) {
                found = true;
                int id = rs.getInt("movieId");
                String name = rs.getString("movieName");
                LocalDate releaseDate = rs.getDate("movieReleasedYear").toLocalDate();
                System.out.printf("ID: %d, Name: %s, Release Date: %s%n", id, name, releaseDate);
            }
            
            if (!found) {
                System.out.println("No movies found for the year " + releaseYear);
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}