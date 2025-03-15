/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.bloodapp;

/**
 * 15/03/2025
 *
 * @author Linru wang
 */
public class Blood {

    public String name;
    public String priority;
    public String gpDetails;

    //constructor
    public Blood(String name, String priority, String gpDetails) {
        this.name = name;
        this.priority = priority;
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

}
