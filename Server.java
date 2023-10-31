/*
Anthony Gatti
Assignment 4
This program simulates the operation of a store to provide the owner with insight
Created using VS Code
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Server {

    private Customer currentCustomer;
    private boolean status;
    private int serviceTime = 0;

    public Server() {
        status = true;
    }

    /**
     * returns if a server is free
     * 
     * @return boolean
     */
    public boolean isFree() {
        return status;
    }

    /**
     * sets a server busy
     */
    public void setBusy() {
        status = false;
    }

    public void setFree() {
        status = true;
    }

    /**
     * gets the service time
     * 
     * @return int
     */
    public int getServiceTime() {
        return serviceTime;
    }

    /**
     * sets the service time
     * 
     * @param sTime
     */
    public void setServiceTime(int sTime) {
        serviceTime = sTime;
    }

    /**
     * decrements the service time by 1
     */
    public void decrementServiceTime() {
        serviceTime -= 1;
    }

    /**
     * sets a server's current customer
     * 
     * @param c
     */
    public void setCurrentCustomer(Customer c) {
        currentCustomer = c;
    }

    /**
     * returns a servers current customer
     * 
     * @return Customer
     */
    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    /**
     * prints the formatted server assignment
     * 
     * @param s
     * @return String
     */
    public String toString(int s) {
        return "Customer " + currentCustomer.getCustomerNo() + " assigned to server " + s;
    }

}