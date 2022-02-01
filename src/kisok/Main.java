package kisok;

import java.util.HashMap;
import java.util.Map;
//import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {

        Date d1 = new Date();
        Date d2 = new Date("0208/2002");
        System.out.println(d1.getYear());
        System.out.println(d2.getYear());

        System.out.println(d1.compareTo(d2));


    }
}
