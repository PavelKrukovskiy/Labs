import java.util.Comparator;

public class MyComparator implements Comparator {

    public int compare(Object o1, Object o2)
    {
        Integer into1=(Integer) o1;
        Integer into2=(Integer) o2;
        if(into1>into2)
            return -1;
        else if(into1<into2)
            return 1;
        return 0;

    }
}
