/*
Anthony Gatti
Assignment 4
This program simulates the operation of a store to provide the owner with insight
Created using VS Code
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Customer {

    private int customerNo;
    private int arrivalTime;
    private int waitingTime;

    public Customer(int cn, int at, int wt) {
        customerNo = cn;
        arrivalTime = at;
        waitingTime = wt;
    }

    /**
     * Gets the customer number
     * 
     * @return int
     */
    public int getCustomerNo() {
        return customerNo;
    }

    /**
     * gets the arrival time
     * 
     * @return int
     */
    public int getArrivalTime() {
        return arrivalTime;
    }

    /**
     * gets the waiting time
     * 
     * @return int
     */
    public int getWaitingTime() {
        return waitingTime;
    }

    /**
     * sets customer number
     * 
     * @param cn
     */
    public void setCustomerNo(int cn) {
        customerNo = cn;
    }

    /**
     * sets arrival time
     * 
     * @param at
     */
    public void setArrivalTime(int at) {
        arrivalTime = at;
    }

    /**
     * sets waiting time
     * 
     * @param wt
     */
    public void setWaitingTime(int wt) {
        waitingTime = wt;
    }

    /**
     * increments waiting time by 1
     */
    public void incrementWaitingTime() {
        waitingTime += 1;
    }

    /**
     * Prints the formatted customer arrival
     * 
     * @return String
     */
    public String toString() {
        return ("Customer " + customerNo + " arrived at time " + arrivalTime);
    }

}