import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Records extends BankRecords {
    static FileWriter writer = null;

    public Records() {
        try {
            writer = new FileWriter("bankrecords.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Prints first 25 client data
        Records clientRecords = new Records();
        clientRecords.readClientData();

        clientAvgIncome();
        clientHasSavings();
        clientChildPerRegion();

        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void clientAvgIncome() { // - Average income for males vs. females
        Arrays.sort(bankEntry, new ClientSexComparator());

        int clientMales = 0;
        int clientFemales = 0;
        double maleIncome = 0;
        double femaleIncome = 0;

        for (BankRecords bankRecords : bankEntry) {
            if (bankRecords.getClientSex().equals("FEMALE")) {
                ++clientFemales;
                femaleIncome += bankRecords.getClientIncome();
            } else {
                ++clientMales;
                maleIncome += bankRecords.getClientIncome();
            }
        }

        System.out.print("\n==================================================");
        System.out.printf("\nAvg Male Income: %.2f", (maleIncome / clientMales));
        System.out.printf("\nAvg Female Income: %.2f", (femaleIncome / clientFemales));

        try { // Write to file
            writer.write("Avg Male Income: $" + (maleIncome / clientMales));
            writer.write("\nAvg Female Income: $" + (femaleIncome / clientFemales));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void clientHasSavings() { // - Number of females with a mortgage and savings account
        Arrays.sort(bankEntry, new ClientHasSavingsComparator());
        int femWithSaveAndMort = 0;

        for (BankRecords bankRecords : bankEntry) {
            if (bankRecords.getClientSex().equals("FEMALE")) {
                if (bankRecords.getClientSaveActStatus().equals("YES")
                        && (bankRecords.getClientMortgageStatus().equals("YES"))) {
                    ++femWithSaveAndMort;
                }
            }
        }

        System.out.print("\n==================================================");
        System.out.printf("\nFemales With Savings & Mortgage: %d", (femWithSaveAndMort));

        try { // Write to file
            writer.write("\n\nFemales With Savings & Mortgage: " + femWithSaveAndMort);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void clientChildPerRegion() { // Find Males with 1 car + 1 child
        Arrays.sort(bankEntry, new ClientRegionComparator());

        int innerCity = 0;
        int rural = 0;
        int suburban = 0;
        int town = 0;

        for (BankRecords bankRecords : bankEntry) {
            if (bankRecords.getClientSex().equals("MALE")) {
                if ((bankRecords.getClientRegion().equals("INNER_CITY"))
                        && (bankRecords.getClientChildAmount() == 1)
                        && (bankRecords.getClientCarStatus().equals("YES"))) {
                    ++innerCity;
                }
                else if ((bankRecords.getClientRegion().equals("RURAL"))
                        && (bankRecords.getClientChildAmount() == 1)
                        && (bankRecords.getClientCarStatus().equals("YES"))) {
                    ++rural;
                }
                else if ((bankRecords.getClientRegion().equals("SUBURBAN"))
                        && (bankRecords.getClientChildAmount() == 1)
                        && (bankRecords.getClientCarStatus().equals("YES"))) {
                    ++suburban;
                }
                else if ((bankRecords.getClientRegion().equals("TOWN"))
                        && (bankRecords.getClientChildAmount() == 1)
                        && (bankRecords.getClientCarStatus().equals("YES"))) {
                    ++town;
                }
            }
        }

        System.out.print("\n==================================================\n");
        System.out.printf("""
                        InnerCity Males W/ 1 Car + 1 Child: %d
                        Rural Males W/ 1 Car + 1 Child: %d
                        Suburban Males W/ 1 Car + 1 Child: %d
                        Town Males W/ 1 Car + 1 Child: %d""",
                        innerCity, rural, suburban, town);
        System.out.print("\n==================================================");

        try { // Write to file
            writer.write("\n\nInnerCity Males W/ 1 Car + 1 Child: " + innerCity);
            writer.write("\nRural Males W/ 1 Car + 1 Child: " + rural);
            writer.write("\nSuburban Males W/ 1 Car + 1 Child: " + suburban);
            writer.write("\nTown Males W/ 1 Car + 1 Child: " + town);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
