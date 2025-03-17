/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.bloodapp;

import java.util.ArrayList;

/**
 * 15/03/2025 
 * use stack to track the last 5 noshow patients
 * @author Linru wang
 */
public class Tracker {

    private ArrayList<Blood> theStack;

    //from MySatck example 
    //Create a new instance of Stack
    public Tracker() {
        theStack = new ArrayList<Blood>();
    }

    public int size() {
        return theStack.size();

    }

    public boolean isEmpty() {
        return theStack.isEmpty();
    }

    //puts an item onto the top of the stack
    public void push(Blood newPatient) {
        if (theStack.size() >= 5) {
            //remove the oldest entry if more than 5
            theStack.remove(0);
        }
        theStack.add(newPatient);
    }

    //removes the item from the top of the stack and returns it
    public Object pop() {
        if (!theStack.isEmpty()) {
            return theStack.remove(theStack.size() - 1);
        }
        return null;
    }

    // removes all elements from the stack
    public void emptyStack() {
        theStack.clear();
    }

    public String displayStack() {
        if (theStack.isEmpty()) {
            return "No patients.";
        }
        StringBuilder sMessage = new StringBuilder("Last 5 NOSHOW Patients:\n");
        for (int i = theStack.size() - 1; i >= 0; i--) {
            Blood patient = theStack.get(i);
            sMessage.append(patient.getName()).append(" (").append(patient.getPriority()).append(")\n");
        }
        return sMessage.toString();
    }

    public ArrayList<Blood> getLastNoShows() {
        //return a copy to avoid modification
        return new ArrayList<>(theStack); 
    }

}
