package AmusementPark;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB {

    private final String userName = "root";
    private final String password = "";
    private final String dbName = "amusementpark";

    protected Connection con;

    public DB() {
        try {
            //Loading the jdbc driver
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            //Get a connection to database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, userName, password);
        } catch (Exception e) {
            System.err.println("DATABASE CONNECTION ERROR: " + e.toString());
        }
    }
}

//    public void addStudent(Student s) {
//        try {
//            Statement stmt = con.createStatement();
//            stmt.executeUpdate("insert into students values('" + s.getName() + "', " + s.getGPA() + ")");
//            System.out.println("Student added");
//        } catch (Exception e) {
//            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
//        }
//    }
//
//    public void deleteStudent(String name) {
//        try {
//            Statement stmt = con.createStatement();
//            stmt.executeUpdate("delete from students where name = '" + name + "'");
//            System.out.println("Student deleted");
//        } catch (Exception e) {
//            System.err.println("DATABASE DELETION ERROR: " + e.toString());
//        }
//    }
//
//    public void updateGPA(String name, double newGPA) {
//        try {
//            Statement stmt = con.createStatement();
//            stmt.executeUpdate("update students set gpa = " + newGPA + "where name = '" + name + "'");
//            System.out.println("Student updated");
//        } catch (Exception e) {
//            System.err.println("DATABASE UPDATE ERROR: " + e.toString());
//        }
//    }
//
//    public Student getStudentByName(String name) {
//        try {
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery("select * from students where name = '" + name + "'");
//            if (rs.first()) {
//                return new Student(rs.getString("name"), rs.getDouble("gpa"));
//            }
//        } catch (Exception e) {
//            System.err.println("DATABASE QUERY ERROR: " + e.toString());
//        }
//        return null;
//    }
//
//    public ArrayList<Student> getAllStudents() {
//        ArrayList<Student> result = new ArrayList();
//        try {
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery("select * from students");
//            while (rs.next()) {
//                result.add(new Student(rs.getString("name"), rs.getDouble("GPA")));
//            }
//        } catch (Exception e) {
//            System.err.println("DATABASE QUERY ERROR: " + e.toString());
//        }
//        return result;
//    }
//    
//}
