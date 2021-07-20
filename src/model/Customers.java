/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.*;

/**
 *
 * @author User
 */
public class Customers {

    HashSet<Client> dataClient = new HashSet<>();

    public void setAddClient(Client cli) {
        dataClient.add(cli);
    }

    public void removeClient(String name) {

        dataClient.remove(getClient(name));
    }

    public HashSet getCustomers() {
        return dataClient;
    }

    public Client getClient(String name) {
        Client cli = null;
        Iterator<Client> iterador = this.dataClient.iterator();

        boolean located = false;
        while (iterador.hasNext() && !located) {
            cli = iterador.next();

            if (name.equalsIgnoreCase(cli.getName())) {

                located = true;
                return cli;
            }
        }
        return null;
    }

    public Client EditClient(Client client) {
        Client cli = null;

        Iterator<Client> iterador = this.dataClient.iterator();

        boolean located = false;
        while (iterador.hasNext() && !located) {
            cli = iterador.next();

            if (client.getName().equalsIgnoreCase(cli.getName())) {

                cli = client;
                located = true;
                return cli;
            }
        }
        return null;
    }

    public void showClients() {
        Client cli = null;

        Iterator<Client> iterador = this.dataClient.iterator();

        /*System.out.println("llego a comprobar "name);*/
        boolean located = false;
        while (iterador.hasNext() && !located) {
            cli = iterador.next();
            System.out.println(cli.getName() + "   " + cli.getMobile());
        }

    }

}
