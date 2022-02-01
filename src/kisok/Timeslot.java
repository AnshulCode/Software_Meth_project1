package kisok;

public class Timeslot implements Comparable<Timeslot> {
    private Time time;
    private Date date;

    @Override
    public String toString() {

        return this.date.toString()+" "+this.time.toString();
    }
    @Override
    public int compareTo(Timeslot slot){
        int date_diff = this.date.compareTo(slot.date);
        int time_diff = this.time.compareTo(slot.time);
        return (24*60*date_diff)+time_diff;
    }
}
