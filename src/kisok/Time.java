package kisok;

public class Time implements Comparable<Time>{
    private int hour;
    private int minute;

    // checks if date is valid
    public boolean isValid(){

        if(hour > 24 || minute >= 60){
            return false;
        }
        if(hour < 0 || minute <0){
            return false;
        }

        return true;
    }

    // get/set methods for Time Class

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getMinute() {
        return this.minute;
    }

    public int getHour() {
        return this.hour;
    }

    // turns Time to string
    @Override
    public String toString() {

        String minute = Integer.toString(this.minute);
        String hour = Integer.toString(this.hour);
        String result = minute + ":" + hour;
        return result;

    }

    // implementation for compareTo function for Comparable interface
    @Override
    public int compareTo(Time time) {

        int diff_hour = this.hour -time.hour;
        int diff_min = this.minute-time.minute;

        if(diff_min == 0 && diff_hour == 0){
            return 0;
        }


        return diff_hour*60+diff_min;
    }
}
