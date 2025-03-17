/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ca.bloodapp;

/**
 * 15/03/2025
 *
 * @author Linru wang Interface for scheduler
 */
public interface SchedulerInterface {

    //checks the queue empty
    public boolean isEmpty();

    public int size();
    
    public Object frontElement();
    //add a patient to the queue
    public void enqueue(Blood patient);

    //remove and return the patient the front of the queue
    public Object dequeue();


}


