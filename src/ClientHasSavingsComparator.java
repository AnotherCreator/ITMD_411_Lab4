import java.util.Comparator;

public class ClientHasSavingsComparator implements Comparator<BankRecords> {

    @Override
    public int compare(BankRecords o1, BankRecords o2) {
        return o1.getClientSaveActStatus().compareTo(o2.getClientSaveActStatus());
    }
}