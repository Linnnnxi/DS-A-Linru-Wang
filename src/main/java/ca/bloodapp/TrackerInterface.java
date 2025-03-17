/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ca.bloodapp;

/**
 *
 * @author Linru Wang
 */
public interface TrackerInterface {

    public void push(Blood patient);

    public Object pop();

    boolean isEmpty();

    int size();

    public void emptyStack();

}
