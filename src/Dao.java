import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {
    // Init DB Objects
    DbConnect conn;
    Statement stmt = null;

    // Constructor
    public Dao() { // Create DB object instance
        conn = new DbConnect();
    }

    public void createTable() {
        try {
            System.out.println("Connecting to a selected database to create a table. . .");
            System.out.println("Connected to database successfully. . .");
            System.out.println("Creating table in given database. . .");
            stmt = conn.connect().createStatement();

            String sql = "CREATE TABLE j_regi_tab " +
                    "(pid INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY, "+
                    "id VARCHAR(10), " +
                    "income NUMERIC(8,2), " +
                    "pep VARCHAR(4))";

            stmt.executeUpdate(sql);
            System.out.println("Created table in given database. . .");
            conn.connect().close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public void insertRecords(BankRecords[] bankEntry) {
        try {
            System.out.println("Inserting records into the table. . .");
            stmt = conn.connect().createStatement();
            String sql;

            for (BankRecords bankRecords : bankEntry) { // Insert values (id, income, pep)
                sql = "INSERT INTO j_regi_tab(id, income, pep) " +
                "VALUES ('"+bankRecords.getClientID()+"', '"+bankRecords.getClientIncome()+"', '"+bankRecords.getClientPepStatus()+"')";

                stmt.executeUpdate(sql);
            }
            conn.connect().close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public ResultSet retrieveRecords() {
        try {
            System.out.println("Attempting to retrieve data from table. . .");
            stmt = conn.connect().createStatement();
            ResultSet rs;

            String sql = "SELECT * FROM j_regi_tab ORDER BY pep DESC";

            rs = stmt.executeQuery(sql);
            conn.connect().close();
            return rs;
        } catch (SQLException se) {
            System.out.println("Failed to retrieve data from table. . .");
            se.printStackTrace();
        }
        return null;
    }
}
