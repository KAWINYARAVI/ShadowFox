import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookManager {
    public static void addBook(String title, String author, String isbn) {
        String sql = "INSERT INTO books(title, author, isbn) VALUES(?, ?, ?)";
        
        try (Connection conn = DatabaseHelper.connect(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.setString(3, isbn);
            pstmt.executeUpdate();
            System.out.println("Book added successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void viewBooks() {
        String sql = "SELECT * FROM books";
        
        try (Connection conn = DatabaseHelper.connect(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Author: " + rs.getString("author"));
                System.out.println("ISBN: " + rs.getString("isbn"));
                System.out.println("-----------");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Add methods for updateBook and deleteBook here if necessary
}
