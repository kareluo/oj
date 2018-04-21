package util;

import java.util.Collection;
import java.util.Iterator;

public class AssertUtils {

    public static <E> boolean equalsCollection(Collection<E> es1, Collection<E> es2) {
        if (equals(es1, es2)) {
            return true;
        }
        if (es1.size() != es2.size()) {
            return false;
        }

        Iterator<E> itr1 = es1.iterator();
        Iterator<E> itr2 = es2.iterator();
        while (itr1.hasNext() && itr2.hasNext()) {
            if (!equals(itr1.next(), itr2.next())) {
                return false;
            }
        }

        return true;
    }

    public static boolean equals(Object obj1, Object obj2) {
        return (obj1 == obj2) || (obj1 != null && obj1.equals(obj2));
    }
}
