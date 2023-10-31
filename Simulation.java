/*
Anthony Gatti
Assignment 4
This program simulates the operation of a store to provide the owner with insight
Created using VS Code
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Simulation {

    public static void main(String[] args) {
        int simulationTime = 0;
        int numServers = 0;
        int serviceTime = 0;
        int arrivalRate = 0;
        Scanner scan = new Scanner(System.in);
        boolean valid = false;
        int totWaitTime = 0;
        int customersServed = 0;
        int numCustomers = 0;
        double avgCustomers = 0;

        while (!valid) {
            System.out.println("Enter the simulation time in minutes: ");
            if (scan.hasNextInt()) {
                simulationTime = scan.nextInt();
                if (simulationTime > 0) {
                    valid = true;
                } else {
                    System.out.println("Invalid time.");
                }
            } else {
                System.out.println("Invalid time.");
            }
        }
        valid = false;
        while (!valid) {
            System.out.println("Enter the number of servers: ");
            if (scan.hasNextInt()) {
                numServers = scan.nextInt();
                if (numServers > 0) {
                    valid = true;
                } else {
                    System.out.println("Invalid number of servers.");
                }
            } else {
                System.out.println("Invalid number of servers.");
            }
        }
        valid = false;
        while (!valid) {
            System.out.println("Enter the customer arrival rate (customers/hour): ");
            if (scan.hasNextInt()) {
                arrivalRate = scan.nextInt();
                if (arrivalRate > 0) {
                    valid = true;
                } else {
                    System.out.println("Invalid arrival rate.");
                }
            } else {
                System.out.println("Invalid arrival rate.");
            }
        }
        valid = false;
        while (!valid) {
            System.out.println("Enter the service time in minutes: ");
            if (scan.hasNextInt()) {
                serviceTime = scan.nextInt();
                if (serviceTime > 0) {
                    valid = true;
                } else {
                    System.out.println("Invalid service time.");
                }
            } else {
                System.out.println("Invalid service time.");
            }
        }

        System.out.println();
        System.out.println("Simulation started...");
        ServerList list = new ServerList(numServers);
        CustomerQueue customers = new CustomerQueue();
        for (int clock = 0; clock < simulationTime; clock++) {
            list.updateServiceTime();

            if (!customers.isEmpty()) {
                customers.updateWaitingTime();
            }

            double p = Math.random();
            if (p < (arrivalRate / 60.0)) {
                Customer n = new Customer(numCustomers + 1, clock, 0);
                customers.addCustomer(n);
                System.out.println(n.toString());
                numCustomers++;
            }

            if (!customers.isEmpty()) {
                if (list.getFreeServer() >= 0) {
                    Customer c = customers.getNextCustomer();
                    System.out.println("Customer " + c.getCustomerNo() + " assigned to server " + list.getFreeServer());
                    list.setServerBusy(list.getFreeServer(), c, serviceTime);
                    totWaitTime += c.getWaitingTime();
                    customersServed++;
                }
            }
        }

        System.out.println("Simulation completed.");

        System.out.println();

        System.out.println("The simulation ran for " + simulationTime + " minutes");
        System.out.println(list.toString());
        System.out.println("Average service time: " + serviceTime);
        avgCustomers = numCustomers / 60.0;
        System.out
                .println("Average number of customers: " + (((int) (avgCustomers * 100)) / 100.0) + " customers/hour");

        System.out.println();

        System.out.println("Total number of customers: " + numCustomers);
        System.out.println("Number of customers served: " + customersServed);
        System.out.println(customers.toString());
        System.out.println("Number of customers being served: " + list.getBusyServers());

        System.out.println();

        System.out.println("Total waiting time: " + totWaitTime + " minutes");
        double avg = ((double) totWaitTime) / ((double) numCustomers);
        System.out.println("Average waiting time: " + (((int) (avg * 100)) / 100.0) + " minutes");

    }
}