package com.motorny.ss.chemistryservice;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        String connectionURL = "jdbc:sqlserver://localhost:53005;encrypt=true;trustServerCertificate=true;database=HouseholdChemistryDB;username=sa;password=mypass";

        try {
            System.out.print("Connecting to the server......\n");
            try (Connection connection = DriverManager.getConnection(connectionURL))   {
                System.out.println("Connected to the Server.");
            }
        } catch (Exception e){
            System.out.println("I am not connected to the Server");
            e.printStackTrace();
        }

    }
}
