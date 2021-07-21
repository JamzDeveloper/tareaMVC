/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Iterator;
import model.Client;
import model.Customers;
import view.*;

/**
 *
 * @author User
 */
public class Controller implements ActionListener {

    Client cliente;
    Customers arrayClient = new Customers();
    Main principal = new Main();
    Table tableData = new Table();
    Form form = new Form();

    public Controller(Main vista) {
        this.principal = vista;
        this.principal.jbtnAdd.addActionListener(this);
        this.principal.jbtnData.addActionListener(this);
        this.principal.jbtnExit.addActionListener(this);

        this.form.jbtnSubmit.addActionListener(this);

    }

    @Override

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.principal.jbtnAdd) {

            this.principal.jDesktop.remove(tableData);
            System.out.println("antes de setDefa");
            tableData.setDefaultCloseOperation(tableData.EXIT_ON_CLOSE);//
            System.out.println("antes de add from");

            this.principal.jDesktop.add(form);
            System.out.println("antes de form.setSize");
            form.setSize(this.principal.jDesktop.getWidth(), this.principal.jDesktop.getHeight());
            //tableData.setVisible(false);
            form.setVisible(true);
            // tableData.dispose();

        }

        if (e.getSource() == this.principal.jbtnData) {

            form.setDefaultCloseOperation(tableData.EXIT_ON_CLOSE);//
            // form.dispose();
            //form.setVisible(false);
            this.principal.jDesktop.remove(form);
            this.principal.jDesktop.add(tableData);
            tableData.setSize(this.principal.jDesktop.getWidth(), this.principal.jDesktop.getHeight());
            tableData.setVisible(true);
        }
        if (e.getSource() == this.form.jbtnSubmit) {

            System.out.println("enviar");
            String name = this.form.jtextName.getText();
            short years = Short.parseShort(this.form.jspinnerYears.getValue().toString());
            int DNI = Integer.parseInt(this.form.jtextDni.getText());
            int mobile = Integer.parseInt(this.form.jtextPhone.getText());
            String sex = (String) this.form.jcomboSex.getSelectedItem();
            String address = this.form.jtextDireccion.getText();
            cliente = new Client(name, years, DNI, mobile, sex, address);

            arrayClient.setAddClient(cliente);
            showData();

        }
        if (e.getSource() == this.principal.jbtnExit) {
            this.principal.dispose();

        }

    }

    private void showData() {
        //insert data in table
        System.out.println("table");

        HashSet<Client> dataClient = arrayClient.getCustomers();

        String matris[][] = new String[dataClient.size()][6];

        Client cli = null;
        Iterator<Client> iterador = dataClient.iterator();

        int i = 0;

        while (iterador.hasNext()) {

            cli = iterador.next();
            matris[i][0] = "" + cli.getDNI();
            matris[i][1] = "" + cli.getName();
            matris[i][2] = "" + cli.getYears();
            matris[i][3] = "" + cli.getSex();
            matris[i][4] = "" + cli.getMobile();
            matris[i][5] = "" + cli.getAddress();
            i++;
        }
        tableData.jtableData.setModel(new javax.swing.table.DefaultTableModel(
                matris,
                new String[]{
                    "DNI", "Nombre", "Edad", "Sexo", "numero celular", "direccion"
                }
        ));

    }

}
