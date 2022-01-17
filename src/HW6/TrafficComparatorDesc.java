package HW6;

import java.util.Comparator;

public class TrafficComparatorDesc implements Comparator<Phone> {
    @Override
    public int compare(Phone o1, Phone o2) {
        // return positive value in case when o1 < o2
        if (o1.getInternetTraffic() < o2.getInternetTraffic()) {
            return 1;
        } else if (o1.getInternetTraffic() > o2.getInternetTraffic()) {
            return -1;
        } else {
            return 0;
        }
    }
}
