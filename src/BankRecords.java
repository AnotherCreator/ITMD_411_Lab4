import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Child-class of parent-class Client
public class BankRecords extends Client {
    // Variables
    static BankRecords[] bankEntry = new BankRecords[600];
    static ArrayList<List<String>> bankAccDetails = new ArrayList<>(600);

    private String clientID;
    private int clientAge;
    private String clientSex;
    private String clientRegion;
    private double clientIncome;
    private String clientMarriageStatus;
    private int clientChildAmount;
    private String clientCarStatus;
    private String clientSaveActStatus;
    private String clientCurrentActStatus;
    private String clientMortgageStatus;
    private String clientPepStatus;

    // Setters
    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public void setClientAge(int clientAge) {
        this.clientAge = clientAge;
    }

    public void setClientSex(String clientSex) {
        this.clientSex = clientSex;
    }

    public void setClientRegion(String clientRegion) {
        this.clientRegion = clientRegion;
    }

    public void setClientIncome(double clientIncome) {
        this.clientIncome = clientIncome;
    }

    public void setClientMarriageStatus(String clientMarriageStatus) {
        this.clientMarriageStatus = clientMarriageStatus;
    }

    public void setClientChildAmount(int clientChildAmount) {
        this.clientChildAmount = clientChildAmount;
    }

    public void setClientCarStatus(String clientCarStatus) {
        this.clientCarStatus = clientCarStatus;
    }

    public void setClientSaveActStatus(String clientSaveActStatus) {
        this.clientSaveActStatus = clientSaveActStatus;
    }

    public void setClientCurrentActStatus(String clientCurrentActStatus) {
        this.clientCurrentActStatus = clientCurrentActStatus;
    }

    public void setClientMortgageStatus(String clientMortgageStatus) {
        this.clientMortgageStatus = clientMortgageStatus;
    }

    public void setClientPepStatus(String clientPepStatus) {
        this.clientPepStatus = clientPepStatus;
    }

    // Getters
    public String getClientID() {
        return clientID;
    }

    public int getClientAge() {
        return clientAge;
    }

    public String getClientSex() {
        return clientSex;
    }

    public String getClientRegion() {
        return clientRegion;
    }

    public double getClientIncome() {
        return clientIncome;
    }

    public String getClientMarriageStatus() {
        return clientMarriageStatus;
    }

    public int getClientChildAmount() {
        return clientChildAmount;
    }

    public String getClientCarStatus() {
        return clientCarStatus;
    }

    public String getClientSaveActStatus() {
        return clientSaveActStatus;
    }

    public String getClientCurrentActStatus() {
        return clientCurrentActStatus;
    }

    public String getClientMortgageStatus() {
        return clientMortgageStatus;
    }

    public String getClientPepStatus() {
        return clientPepStatus;
    }

    @Override
    public void readClientData() {
        BufferedReader br;
        String line;

        // Attempt to read file and set each .csv row as a comma-separated array
        try {
            br = new BufferedReader(new FileReader("bank-Detail.csv"));
            while ((line = br.readLine()) != null) {
                bankAccDetails.add(Arrays.asList(line.split(",")));
            }
            processClientData();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void processClientData() {
        int i = 0;

        // Go through each entry in 'bankAccDetails' and create a new bankEntry obj while populating
        // each field appropriately
        for (List<String> rowData: bankAccDetails) {
            bankEntry[i] = new BankRecords();
            bankEntry[i].setClientID(rowData.get(0));
            bankEntry[i].setClientAge(Integer.parseInt(rowData.get(1)));
            bankEntry[i].setClientSex(rowData.get(2));
            bankEntry[i].setClientRegion(rowData.get(3));
            bankEntry[i].setClientIncome(Double.parseDouble(rowData.get(4)));
            bankEntry[i].setClientMarriageStatus(rowData.get(5));
            bankEntry[i].setClientChildAmount(Integer.parseInt(rowData.get(6)));
            bankEntry[i].setClientCarStatus(rowData.get(7));
            bankEntry[i].setClientSaveActStatus(rowData.get(8));
            bankEntry[i].setClientCurrentActStatus(rowData.get(9));
            bankEntry[i].setClientMortgageStatus(rowData.get(10));
            bankEntry[i].setClientPepStatus(rowData.get(11));
            i++;
        }
    }

    @Override
    public void printClientData() {
        System.out.println(
                "CLIENT ID | CLIENT AGE | CLIENT SEX | CLIENT REGION | CLIENT INCOME | CLIENT MARRIED " +
                        "| CLIENT CHILDREN # | CLIENT CAR | CLIENT SAVE ACT | CLIENT CURRENT ACT | CLIENT MORTGAGE | CLIENT PEP");

        for (int i = 0; i < 25; i++) {
            System.out.printf("%-15s %-10d %-12s %-15s %.2f  \t\t\t%-15s\t%-18d %-7s \t\t%-12s \t\t%-12s \t\t%-15s %-5s\n",
                    bankEntry[i].getClientID(), bankEntry[i].getClientAge(), bankEntry[i].getClientSex(),
                    bankEntry[i].getClientRegion(), bankEntry[i].getClientIncome(), bankEntry[i].getClientMarriageStatus(),
                    bankEntry[i].getClientChildAmount(), bankEntry[i].getClientCarStatus(), bankEntry[i].getClientSaveActStatus(),
                    bankEntry[i].getClientCurrentActStatus(), bankEntry[i].getClientMortgageStatus(), bankEntry[i].getClientPepStatus());
        }
    }
}
