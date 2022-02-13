package kisok;

/**
 * The type Timeslot.
 *
 * @author Anshul Prasad , Alexander Reyes
 */
public class Timeslot implements Comparable<Timeslot> {
    private final Time time;
    private final Date date;

    /**
     * Gets date object.
     *
     * @return the date
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * Gets time object.
     *
     * @return the time
     */
    public Time getTime() {
        return this.time;
    }

    /**
     * Instantiates a new Timeslot.
     *
     * @param t the time object
     * @param d the date object
     */
    public Timeslot(Time t, Date d) {
        this.time = t;
        this.date = d;
    }

    /**
     * Return Date in string format
     * @return Date in string format
     */

    @Override
    public String toString() {

        return this.date.toString() + " " + this.time.toString();
    }

    /**
     * Compares distance between timeslots in minutes
     * @param slot
     * @return dinstacne in bnetween timeslots, Integer.Max_Value if either the date or the time is invalid
     */
    @Override
    public int compareTo(Timeslot slot) {
        if(!this.time.isValid() || !slot.getTime().isValid()) {
            return Integer.MAX_VALUE;
        }
        if(!this.date.isValid() || !slot.getDate().isValid()) {
            return Integer.MAX_VALUE;
        }
        int date_diff = this.date.compareTo(slot.date);
        int time_diff = this.time.compareTo(slot.time);
        return (24 * 60 * date_diff) + time_diff;
    }

    /**
     * Test bed main for Timeslot
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        // creating variables for test
        Time t1 = new Time(9,40);
        Date d1 = new Date("9/20/2020");
        Timeslot one = new Timeslot(t1,d1);

        // test case 1 , one > two
        Time t2 = new Time(9,40);
        Date d2 = new Date("9/01/2020");
        Timeslot two = new Timeslot(t2,d2);
        System.out.println("Output: " + one.compareTo(two));

        //  test case 2 , one == two
        t2 = new Time(9,40);
        d2 = new Date("9/20/2020");
        two = new Timeslot(t2,d2);
        System.out.println("Output: " + one.compareTo(two));

        // test case 3 one < two
        t2 = new Time(7,4);
        d2 = new Date("9/30/2020");
        two = new Timeslot(t2,d2);
        System.out.println("Output: " + one.compareTo(two));

        //  test case 4 , two has invalid time must return Integer.MAX_VALUE
        t2 = new Time(9,90);
        d2 = new Date("9/30/2020");
        two = new Timeslot(t2,d2);
        System.out.println("Output: " + one.compareTo(two));

        // test case 5 two has invalid date must return Integer.MAX_VALUE
        t2 = new Time(9,30);
        d2 = new Date("9/320");
        two = new Timeslot(t2,d2);
        System.out.println("Output: " + one.compareTo(two));

        // test case 7 one has invalid date must return Integer.MAX_VALUE
        t2 = new Time(9,30);
        d2 = new Date("9/30/2020");
        two = new Timeslot(t2,d2);
        d1 = new Date("90/90/90");
        t1 = new Time(9,30);
        one = new Timeslot(t1,d1);
        System.out.println("Output: " + one.compareTo(two));






    }
}
