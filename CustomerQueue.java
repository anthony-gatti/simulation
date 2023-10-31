/*
Anthony Gatti
Assignment 4
This program simulates the operation of a store to provide the owner with insight
Created using VS Code
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CustomerQueue {

    private Queue<Customer> customers;

    public CustomerQueue() {
        customers = new LinkedList<Customer>();
    }

    /**
     * returns the next customer
     * 
     * @return Customer
     */
    public Customer getNextCustomer() {
        return customers.poll();
    }

    /**
     * updates the waiting time of each customer in the queue
     */
    public void updateWaitingTime() {
        Queue<Customer> temp = new LinkedList<Customer>();
        for (int i = 0; i < customers.size(); i++) {
            temp.add(customers.poll());
            temp.peek().incrementWaitingTime();
        }
        customers.clear();
        for (int i = 0; i < temp.size(); i++) {
            customers.add(temp.poll());
        }
    }

    /**
     * adds a customer to the queue
     * 
     * @param c
     */
    public void addCustomer(Customer c) {
        customers.add(c);
    }

    /**
     * checks if the queue is empty
     * 
     * @return boolean
     */
    public boolean isEmpty() {
        if (customers.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * returns the size of the queue
     * 
     * @return int
     */
    public int size() {
        return customers.size();
    }

    /**
     * prints the formatted number of people left in the queue
     * 
     * @return String
     */
    public String toString() {
        return "Number of customers left in queue: " + customers.size();
    }
}