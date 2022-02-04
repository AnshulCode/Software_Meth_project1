package kisok;

public class Main {

    public static void main(String[] args) {


        Patient patient2 = new Patient();
        patient2.setFname("jon");
        patient2.setLname("doe");
        patient2.setDob("12/13/1970");

        Date date = new Date("12/02/22");
        Time t = new Time();
        t.setMinute(10);
        t.setHour(10);
        Timeslot slot = new Timeslot(t,date);
        Location l = Location.MERCER;
        Appointment test = new Appointment(patient2,slot,"MERCER");
        System.out.println(test.toString());
       // System.out.println(patient2.compareTo(patient2));



    }
}
