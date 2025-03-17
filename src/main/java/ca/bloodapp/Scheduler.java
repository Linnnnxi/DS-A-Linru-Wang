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
                //from a hospital ward get higher priority (1)
                if (b1.isWard() && !b2.isWard()) {//if b1 is true and b2 is false
                    return -1;
                }

                if (!b1.isWard() && b2.isWard()) {
                    return 1;
                }

                //age(2)
                if (b1.getAge() != b2.getAge()) {
                    return Integer.compare(b2.getAge(), b1.getAge());
                }

                //Urgent - Medium - Low (3)
                int priorityComparison = Integer.compare(getPriorityValue(b1.getPriority()), getPriorityValue(b2.getPriority()));
                if (priorityComparison != 0) {
                    return priorityComparison;
                }
                return 0;
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

    //before displaying the patient list in GUI ensure the patient list is sorted correctly)
    public List<Blood> getPatients() {
        List<Blood> patientsL = new ArrayList<>(patientQueue);

        //Ensure the list is correctly
        patientsL.sort(new Comparator<Blood>() {
            @Override
            public int compare(Blood b1, Blood b2) {
                //(1)
                if (b1.isWard() && !b2.isWard()) {
                    return -1;
                }
                if (!b1.isWard() && b2.isWard()) {
                    return 1;
                }
                //(2)
                if (b1.getAge() != b2.getAge()) {
                    return Integer.compare(b2.getAge(), b1.getAge());
                }
                //(3)
                return Integer.compare(getPriorityValue(b1.getPriority()), getPriorityValue(b2.getPriority()));
            }
        });
        System.out.println("Patient List:");
        for (Blood patient : patientsL) {
            System.out.println(patient.getName() + " (Age: " + patient.getAge()
                    + ", Priority: " + patient.getPriority()
                    + ", Hospital ward: " + (patient.isWard() ? "Yes" : "No") + ")");
        }
        return patientsL;
    }
}
