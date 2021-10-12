/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_jdbc;

/**
 *
 * @author poramet
 */
public class Student {

    private int ID;
    private String name;
    private double GPA;

    public Student() {
    }

    public Student(int id, String name, double salary) {
        this.ID = id;
        this.name = name;
        this.GPA = salary;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

}
