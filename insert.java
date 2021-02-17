package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class insert {
   private static final String URL = "jdbc:mysql://localhost:8080/books";
   private static final String USER = "dave";
   private static final String PASSWORD = "dave";
   
   private PreparedStatement insertNewPerson = null;
   private PreparedStatement selectAuthorByAuthorID = null;
   private PreparedStatement selectAllAuthors = null;
   private PreparedStatement deleteAuthor = null;
   private PreparedStatement updateAuthor = null;
   private Connection connection = null;
   
   public insert() {
       try {
           connection = DriverManager.getConnection(URL, USER, PASSWORD);
           selectAuthorByAuthorID = connection.prepareStatement(
                   "select * from authors where authorID = ?"
           );
           insertNewPerson = connection.prepareStatement(
                   "insert into authors" + 
                           "(authorID, firstName, lastName)" +
                    "values(?, ?, ?)");
           selectAllAuthors = connection.prepareStatement(
                   "select * from authors"
           );
           deleteAuthor = connection.prepareStatement(
                   "delete from authors where authorID = ?");
           updateAuthor = connection.prepareStatement (
                   "update authors set authorID = ?, firstName = ?, lastName = ? where authorID = ?" );
       }
       catch (SQLException exc) {
           JOptionPane.showMessageDialog(null, exc, "Database error", JOptionPane.ERROR_MESSAGE);
       }
   }
   
   public int addPerson(
           int id, String fname, String lname) {
       int result = 0;
       
       try {
           
           insertNewPerson.setInt(1, id);
           insertNewPerson.setString(2, fname);
           insertNewPerson.setString(3, lname);
           result = insertNewPerson.executeUpdate();
       }
       catch(SQLException exc) {
           JOptionPane.showMessageDialog(null, exc, "Database error", JOptionPane.ERROR_MESSAGE);
       }
       
       return result;
   }
   
   public List< IndividualAuthor > getAuthorByAuthorID ( String name ) {
       List< IndividualAuthor > results = null;
       ResultSet resultSet  = null;
       
       try {
           selectAuthorByAuthorID.setString(1, name);
           resultSet = selectAuthorByAuthorID.executeQuery();
           results = new ArrayList <IndividualAuthor> ();
           
           while( resultSet.next()) {
               results.add(new IndividualAuthor(
                       resultSet.getInt("authorID"),
                       resultSet.getString("firstName"),
                       resultSet.getString("lastName")));
           }
       } 
       catch (SQLException exc) {
           JOptionPane.showMessageDialog(null, exc, "Database error", JOptionPane.ERROR_MESSAGE);
       }
       finally {
           try {
               resultSet.close();
           }
           catch (SQLException exc) {
               JOptionPane.showMessageDialog(null, exc, "Database error", JOptionPane.ERROR_MESSAGE);
           }
       }
       return results;
   }
   
   public int  deleteAuthor (int authorID) {
       int result = 0;
       try {
           deleteAuthor.setInt(1, authorID);
           result = deleteAuthor.executeUpdate();
       }
       catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
       }
       return result;
   }
   
   public int updateAuthor( int authorID, String firstName, String lastName, int AuthorID) {
       int result = 0;
       try {
           updateAuthor.setInt(1, authorID);
           updateAuthor.setString(2, firstName);
           updateAuthor.setString(3, lastName);
           updateAuthor.setInt(4, AuthorID);
           result = updateAuthor.executeUpdate();
       }
       catch(SQLException e) {
           JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
       }
       return result;
   }
   
   public List< IndividualAuthor > getAllAuthors() {
       List < IndividualAuthor > results = null;
       ResultSet resultSet  = null;
       
       try {
           resultSet = selectAllAuthors.executeQuery();
           results  = new ArrayList < IndividualAuthor >();
           
           while (resultSet.next()) {
               results.add(new IndividualAuthor (
                       resultSet.getInt("authorID"),
                       resultSet.getString("firstName"),
                       resultSet.getString("lastName")
               ));
           }
       }
       catch (SQLException exc) {
           JOptionPane.showMessageDialog(null, exc, "Database error", JOptionPane.ERROR_MESSAGE);
       }
       finally {
           try {
               resultSet.close();
           }
           catch (SQLException exc) {
               JOptionPane.showMessageDialog(null, exc, "Datbase error", JOptionPane.ERROR_MESSAGE);
           }
       }
       return results;
   }
}
