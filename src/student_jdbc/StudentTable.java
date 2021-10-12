/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.DatabaseHandler;

/**
 *
 * @author poramet
 */
public class StudentTable {

    public static int updateStudent(DatabaseHandler dbHandler, Student stu) {
        String sql = "update Student set name=?, gpa=? where id=?";
        int rowUpdated;
        try {
            rowUpdated = dbHandler.update(sql, stu.getName(), stu.getGPA(), stu.getID());
        } catch (SQLException ex) {

            rowUpdated = 0;
        }

        return rowUpdated;
    }

    public static int removeStudent(DatabaseHandler dbHandler, Student stu) {
        String sql = "delete from Student where id = ?";

        int rowDeleted;
        try {
            rowDeleted = dbHandler.update(sql, stu.getID());
        } catch (SQLException ex) {
            rowDeleted = 0;
        }
        return rowDeleted;
    }

    public static int insertStudent(DatabaseHandler dbHandler, Student stu) {
        String sql = "insert into Student (id, name, gpa)"
                + " values (?,?,?)";

        int rowInserted;
        try {
            rowInserted = dbHandler.update(sql, stu.getID(), stu.getName(), stu.getGPA());
        } catch (SQLException ex) {
            rowInserted = 0;
        }
        return rowInserted;
    }

    public static Student findStudentById(DatabaseHandler dbHandler, int id) throws SQLException {
        String sql = "select * from Student where id = ?";
        ResultSet rs;
        Student stu = null;
        rs = dbHandler.query(sql, id);
        if (rs.next()) {
            stu = new Student();
            stu.setID(rs.getInt("id"));
            stu.setName(rs.getString("name"));
            stu.setGPA(rs.getDouble("gpa"));
        }
        return stu;

    }

    public static ArrayList<Student> findStudentByName(DatabaseHandler dbHandler, String name) throws SQLException {
        String sql = "select * from Student where name = ?";
        ResultSet rs;
        ArrayList<Student> studentList = null;
        rs = dbHandler.query(sql, name);
        studentList = extractStudent(rs);
        return studentList;

    }

    public static ArrayList<Student> findAllStudent(DatabaseHandler dbHandler) throws SQLException {
        String sql = "select * from Student order by id";
        ResultSet rs;
        ArrayList<Student> studentList = null;
        rs = dbHandler.query(sql);
        studentList = extractStudent(rs);
        return studentList;
    }

    private static ArrayList<Student> extractStudent(ResultSet rs) {
        ArrayList<Student> studentList = new ArrayList<>();
        try {
            while (rs.next()) {
                Student studentObj = new Student();
                try {
                    studentObj.setID(rs.getInt("id"));
                    studentObj.setName(rs.getString("name"));
                    studentObj.setGPA(rs.getDouble("gpa"));
                } catch (SQLException ex) {
                    Logger.getLogger(StudentTable.class.getName()).log(Level.SEVERE, null, ex);
                }

                studentList.add(studentObj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (studentList.size() == 0) {
            studentList = null;
        }
        return studentList;
    }
}
