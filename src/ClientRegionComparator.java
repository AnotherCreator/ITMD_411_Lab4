import java.util.Comparator;

public class ClientRegionComparator implements Comparator<BankRecords> {

    @Override
    public int compare(BankRecords o1, BankRecords o2) {
        return o1.getClientRegion().compareTo(o2.getClientRegion());
    }
}
