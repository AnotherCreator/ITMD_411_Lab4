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
    public static void main(String[] args) throws SQLException {
        LoanProcessing records = new LoanProcessing();
        records.readClientData();
        records.processClientData();

        // Database handling
        Dao DBAccess = new Dao();
        DBAccess.createTable();
        DBAccess.insertRecords(bankEntry);
        ResultSet rs = DBAccess.retrieveRecords();

        // Iterate and print result set
        System.out.println("ID:\t\tINCOME:\t\tPEP:");
        while (rs.next()) {

        }

        rs.close();
    }
}
