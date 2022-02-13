package kisok;

/**
 * The type Time.
 *
 * @author Anshul Prasad , Alexander Reyes
 */
public class Time implements Comparable<Time> {
    private int hour;
    private int minute;

    /**
     * Is valid boolean.
     *
     * @return the boolean
     */
    public boolean isValid() {

        if (hour > 24 || minute >= 60) {
            return false;
        }
        return hour >= 0 && minute >= 0;
    }

    /**
     * Instantiates a new Time.
     * Initialize Time with string value invalid format result ikn all fields being -1
     *
     * @param time the time
     */
    public Time(String time) {
        String[] a = time.split(":");
        try {
            this.hour = Integer.parseInt(a[0]);
            this.minute = Integer.parseInt(a[1]);

        } catch (NumberFormatException e) {
            this.hour = -1;
            this.minute = -1;

        } catch (ArrayIndexOutOfBoundsException e) {
            this.hour = -1;
            this.minute = -1;

        }
        if (!this.isValid()) {
            this.hour = -1;
            this.minute = -1;
        }
    }

    /**
     * Instantiates a new Time.
     */
    public Time() {

    }

    /**
     * Instantiates a new Time.
     * Initialize time with integers
     *
     * @param hour   the hour
     * @param minute the minute
     */
    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }


    /**
     * Turns Time into string format
     * @return Time in string format
     */

    @Override
    public String toString() {
        String minute = "";
        if (this.minute > 9) {
            minute = Integer.toString(this.minute);
        } else {
            minute = "0" + this.minute;
        }


        String hour = "";

        if (this.hour > 9) {
            hour = Integer.toString(this.hour);
        } else {
            hour = "0" + this.hour;
        }

        String result = hour + ":" + minute;
        return result;

    }

    /**
     * Implementation for the compareTo for Time, return distance in date, Integer.MAX_Value if either is invalid
     * @param time
     * @return
     */

    @Override
    public int compareTo(Time time) {
        if(!this.isValid() || !time.isValid()){
            return Integer.MAX_VALUE;
        }

        int diff_hour = this.hour - time.hour;
        int diff_min = this.minute - time.minute;

        if (diff_min == 0 && diff_hour == 0) {
            return 0;
        }


        return diff_hour * 60 + diff_min;
    }
}
