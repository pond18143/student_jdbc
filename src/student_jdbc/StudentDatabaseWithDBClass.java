/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import utilities.DatabaseDriver;
import utilities.DatabaseHandler;

/**
 *
 * @author poramet
 */
public class StudentDatabaseWithDBClass {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String driver = "org.apache.derby.jdbc.ClientDriver";
        String url = "jdbc:derby://localhost:1527/Student";
        String user = "app";
        String passwd = "app";
        /*String driver = "com.mysql.cj.jdbc.Driver";
        //String url="jdbc:mysql://localhost:3306/employee?serverTimezone=UTC";
        String user = "root";
        String passwd = "root";*/
        DatabaseDriver dbDriver = new DatabaseDriver(driver, url, user, passwd);
        DatabaseHandler dbHandler = new DatabaseHandler(dbDriver);
        Student stu1 = new Student(1, "John", 12345);
        Student stu2 = new Student(2, "Marry", 45678);
        StudentTable.insertStudent(dbHandler, stu1);
        StudentTable.insertStudent(dbHandler, stu2);
        //StudentTable.updateStudent(dbHandler, stu1);
        //StudentTable.updateStudent(dbHandler, stu2);
        //StudentTable.removeStudent(dbHandler, stu1);
        //StudentTable.removeStudent(dbHandler, stu2);       

        ArrayList<Student> studentList = StudentTable.findAllStudent(dbHandler);
        if (studentList != null) {
            printAllStudent(studentList);
        }
        dbHandler.closeConnection();
    }

    public static void printAllStudent(ArrayList<Student> stuList) {
        for (int i = 0; i < stuList.size(); i++) {
            System.out.print(stuList.get(i).getID() + " ");
            System.out.print(stuList.get(i).getName() + " ");
            System.out.println(stuList.get(i).getGPA() + " ");
        }

    }
}
