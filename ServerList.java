/*
Anthony Gatti
Assignment 4
This program simulates the operation of a store to provide the owner with insight
Created using VS Code
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ServerList {

    private ArrayList<Server> servers;

    public ServerList(int numServers) {
        servers = new ArrayList<Server>();
        for (int i = 0; i < numServers; i++) {
            Server server = new Server();
            servers.add(server);
        }
    }

    /**
     * returns a free server
     * 
     * @return int
     */
    public int getFreeServer() {
        for (int i = 0; i < servers.size(); i++) {
            if (servers.get(i).isFree()) {
                return i;
            }
        }
        return -1;
    }

    /**
     * sets a customer to a server and sets the server busy
     * 
     * @param i
     * @param c
     * @param serviceTime
     */
    public void setServerBusy(int i, Customer c, int serviceTime) {
        if (servers.get(i).isFree()) {
            servers.get(i).setBusy();
            servers.get(i).setCurrentCustomer(c);
            servers.get(i).setServiceTime(serviceTime);
        } else {
            System.out.println("Server is already busy");
        }
    }

    /**
     * updates the service time of all servers
     */
    public void updateServiceTime() {
        for (int i = 0; i < servers.size(); i++) {
            if (!servers.get(i).isFree()) {
                servers.get(i).decrementServiceTime();
                if (servers.get(i).getServiceTime() == 0) {
                    servers.get(i).setFree();
                }
            }
        }
    }

    /**
     * returns the number of busy servers
     * 
     * @return int
     */
    public int getBusyServers() {
        int busyServers = 0;
        for (int i = 0; i < servers.size(); i++) {
            if (!servers.get(i).isFree()) {
                busyServers++;
            }
        }
        return busyServers;
    }

    /**
     * prints the formateed number of servers
     * 
     * @return String
     */
    public String toString() {
        return "Number of servers: " + servers.size();
    }
}