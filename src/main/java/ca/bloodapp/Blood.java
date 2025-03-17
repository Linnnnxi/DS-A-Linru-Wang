/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.bloodapp;

/**
 * 15/03/2025
 * get patient details
 * @author Linru wang
 */
public class Blood {

    private String name;
    private String priority;
    private String gpDetails;
    private int age;
    private boolean ward;


    //constructor
    public Blood(String name, String priority, String gpDetails, int age, boolean ward) {    
        this.name = name;
        this.priority = priority;
        this.gpDetails = gpDetails;
        this.age = age;
        this.ward = ward;
    }

    //setters
    public void setAge(int age) {
        this.age = age;
    }

    public void setWard(boolean ward) {
        this.ward = ward;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setGpDetails(String gpDetails) {
        this.gpDetails = gpDetails;
    }

    //getters
    public String getName() {
        return name;
    }

    public String getPriority() {
        return priority;
    }

    public String getGpDetails() {
        return gpDetails;
    }
    
    public int getAge() {
        return age;
    }

    public boolean isWard() {
        return ward;
    }

}
