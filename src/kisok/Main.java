package kisok;

public class Main {

    public static void main(String[] args) {
        Schedule s = new Schedule();

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
        Appointment test = new Appointment(patient2,slot,l.county);


        Patient patient = new Patient();

        patient.setFname("john");
        patient.setLname("denver");
        patient.setDob("12/13/1970");
        Date date2 = new Date("12/10/22");
        Time t2 = new Time();
        t2.setMinute(10);
        t2.setHour(10);
        Timeslot slot2 = new Timeslot(t2,date2);
        Location l2 = Location.UNION;
        Appointment test2 = new Appointment(patient,slot2,l2.county);

        Patient patient3 = new Patient();

        patient3.setFname("john");
        patient3.setLname("denver");
        patient3.setDob("12/13/1970");
        Date date3= new Date("12/10/22");
        Time t3 = new Time();
        t3.setMinute(10);
        t3.setHour(10);
        Timeslot slot3 = new Timeslot(t3,date3);
        Location l3 = Location.MIDDLESEX;
        Appointment test3 = new Appointment(patient3,slot3,l3.county);




        System.out.println(s.add(test));
        System.out.println(s.add(test2));
        System.out.println((s.add(test3)));

        s.printByPatient();



    }
}
