/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.bloodapp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 15/03/2025 Priority Queue manage patients
 *
 * @author Linru wang
 */
public class Scheduler implements SchedulerInterface {

    private PriorityQueue<Blood> patientQueue;

    //constructor
    public Scheduler() {
        patientQueue = new PriorityQueue<>(new Comparator<Blood>() {
            @Override
            public int compare(Blood b1, Blood b2) {
                //patients from a hospital ward get higher priority (1)
                if (b1.isWard() && !b2.isWard()) {
                    return -1;
                }

                if (!b1.isWard() && b2.isWard()) {
                    return 1;
                }

                //older patients get priority (2)
                int ageComparison = Integer.compare(b2.getAge(), b1.getAge());
                if (ageComparison != 0) {
                    return ageComparison;
                }

                //priority level Urgent - Medium - Low (3)
                return Integer.compare(getPriorityValue(b1.getPriority()), getPriorityValue(b2.getPriority()));
            }
        });
    }

    //w3school https://www.w3schools.com/java/java_switch.asp
    private int getPriorityValue(String priority) {
        switch (priority.toLowerCase()) {
            case "urgent":
                return 1;
            case "medium":
                return 2;
            case "low":
                return 3;
            default:
                return 4;
        }
    }

    //getter for patients list
    public List<Blood> getPatients() {
        return new ArrayList<>(patientQueue);
    }

    @Override
    //check if the queue empty.
    public boolean isEmpty() {
        return patientQueue.isEmpty();
    }

    @Override
    public int size() {
        return patientQueue.size();
    }

    @Override
    public Object frontElement() {
        return patientQueue.peek();
    }

    //add a new patient
    @Override
    public void enqueue(Blood patient) {
        patientQueue.add(patient);
    }

    @Override
    //to next patient
    public Blood dequeue() {
        return patientQueue.poll();
    }

}
