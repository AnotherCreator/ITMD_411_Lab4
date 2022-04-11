/*
Josh Reginaldo
ITMD-411

Lab 4 - Database Implementation

Use a database to store and present loan analysis information
Driver class to deal with the database
*/

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoanProcessing extends BankRecords {
    public static void main(String[] args) {
        LoanProcessing records = new LoanProcessing();
        records.readClientData();
        records.processClientData();

        // Database handling
        try {
            Dao DBAccess = new Dao();
            DBAccess.createTable();
            DBAccess.insertRecords(bankEntry);
            ResultSet rs = DBAccess.retrieveRecords();

            // Iterate and print result set
            System.out.println("ID:\t\t\tINCOME:\t\t\tPEP:");
            while (rs.next()) {
                String ID = rs.getString("id");
                double income = rs.getDouble("income");
                String pep = rs.getString("pep");

                System.out.printf("\n%s \t%.2f \t\t%s", ID, income, pep);
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
