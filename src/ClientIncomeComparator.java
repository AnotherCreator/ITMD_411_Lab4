import java.util.Comparator;

public class ClientIncomeComparator implements Comparator<BankRecords> {

    @Override
    public int compare(BankRecords o1, BankRecords o2) {
        return Double.compare(o1.getClientIncome(), o2.getClientIncome());
    }
}
