package HW6;

import java.util.Comparator;
public class WholeInfoComparator implements Comparator<Phone>{

    @Override
    public int compare(Phone o1, Phone o2) {
        return o1.getWholeInfo().compareTo(o2.getWholeInfo());
    }
}
