/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardinalgrp.shopinventorynb;

import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Table;

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.io.File;

public class DatabaseConnection {
    private Database db = null;

    public DatabaseConnection()
    {
        try {

            File dbFile = new File("C:/Users/Slim7/OneDrive/Shop/Shop_Inventory.accdb");

            if(dbFile.exists() && !dbFile.isDirectory()) {
                try {
                    db = DatabaseBuilder.open(dbFile);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(new JFrame("Error"), "Can't Open " + dbFile.toString() + "!", "Open Error", JOptionPane.ERROR_MESSAGE);
                }
                System.out.println("Database Exists");
            } else {
                try {
                    db = DatabaseBuilder.create(Database.FileFormat.V2007, dbFile);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(new JFrame("Error"), "Can't Create " + dbFile.toString() + "!", "Creation Error", JOptionPane.ERROR_MESSAGE);
                }
                System.out.println("Created");
            }
            System.out.println("Success");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame("Error"), e.getMessage(), "Inaccessible", JOptionPane.ERROR_MESSAGE);
        }
    }


    private Table[] GetTables()
    {

        int tableNum = 0;
        for (Table t : db)
        {
            tableNum++;
        }
        Table[] tables = new Table[tableNum];
        tableNum = 0;
        for (Table t : db)
        {
            tables[tableNum] = t;
            System.out.println(tableNum + " iteration; Table title = " + t.getName());
            tableNum++;
        }
        return tables;
    }
}

