package kisok;

import java.util.Scanner;


/**
 * The type Kiosk, User interface for the program.
 *
 * @author Anshul Prasad , Alexander Reyes
 */
public class Kiosk {


    /**
     * This method runs the kiosk and starts the process of getting input from the user.
     * If the input becomes Q then the kiosk stops running and the program is finished.
     */
    public void run() {
        String input = "";
        Scanner scan = new Scanner(System.in);

        System.out.println("Kiosk running. Ready to process transactions");
        Schedule schedule = new Schedule();
        while (!input.equals("Q")) {
            input = scan.nextLine();
            MyArrayList cmds = new MyArrayList();
            this.multiCommandCheck(input, cmds);

            String[] a = cmds.getArray();
            for (String cmd : a) {
                if (cmd != null) {
                    if (cmd.equals("Q")) {
                        System.out.print("Kiosk session ended");
                        return;
                    }

                    System.out.println(this.commandCheck(cmd, schedule));
                }
            }


        }


    }

    /**
     * Multi command check.
     *
     * @param command input from command line
     * @param m       the m
     */
    public void multiCommandCheck(String command, MyArrayList m) {
        String test = command;
        String delimiter = " ";
        String cmd = "";
        int place_holder = -1;
        String[] array = test.split(delimiter);
        for (int i = 0; i < array.length; i++) {


            if (array[i].equals("PP") || array[i].equals("P") || array[i].equals("PZ") || array[i].equals("Q")) {
                //execute command

                m.add(array[i]);
                cmd = "";
            } else if (array[i].equals("B") || array[i].equals("C") || array[i].equals("CP")) {

                cmd = cmd + array[i] + " ";

                int j = 0;

                for (j = i + 1; j < array.length; j++) {

                    if (array[j].equals("PP") || array[j].equals("P") || array[j].equals("B") || array[j].equals("C") || array[j].equals("CP") || array[j].equals("PZ") || array[j].equals("Q")) {
                        break;
                    }


                    cmd = cmd + array[j] + " ";


                }
                m.add(cmd);

                if (array[j - 1].equals("PP") || array[j - 1].equals("PZ") || array[j - 1].equals("Q") || array[j - 1].equals("P")) {
                    m.add(array[j]);
                }


                place_holder = 0;
                i = j;


                cmd = "";
            } else {
                m.add(array[i]);
                cmd = "";
            }

        }

    }

    /**
     * This method will check to make sure the command that was inputed is a correct command.
     * If it is not correct it will give back that this command was invalid
     *
     * @param commandGiven This is the command given by the user in the console.
     * @param s            the s
     * @return the string
     */
    public String commandCheck(String commandGiven, Schedule s) {

        if (commandGiven.isEmpty()) {
            return "Invalid command!";
        }
        String[] array = commandGiven.split(" ");
        if (!(array[0].equals("Q") || array[0].equals("B") || array[0].equals("CP") || array[0].equals("C") || array[0].equals("PZ") || array[0].equals("PP") || array[0].equals("P"))) {
            return "Invalid command!";
        } else if (!(array[0].equals("B") || array[0].equals("C") || array[0].equals("CP")) && s.isEmpty()) {
            return "Invalid command!";
        }

        if ((array[0].equals("Q") || array[0].equals("P") || array[0].equals("PP") || array[0].equals("PZ")) && array.length > 1) {
            return "Invalid command!";
        }
        if (array[0].equals("B")) {
            if (array.length != 7) {

                return "Invalid command!";
            }

            String DOB = array[1];
            String fname = array[2];
            String lname = array[3];
            String appointmentDate = array[4];
            String appointmentTime = array[5];
            String location = array[6];
            Date dob = new Date(DOB);

            if (!dob.isValid()) {
                return "Date of Birth Invalid";
            }

            Date currDate = new Date();

            Time apptTime = new Time(appointmentTime);
            Date apptDate = new Date(appointmentDate);
            if (!apptDate.isValid()) {
                return "Invalid appointment date!";
            }

            if (apptDate.compareTo(currDate) < 0) {
                return "Appointment date invalid -> it is a future date";

            }
            if(!apptTime.isValid()){
                return "Invalid appointment time!";
            }
            Patient patient = new Patient(fname, lname, DOB);


            Timeslot timeSlot = new Timeslot(apptTime, apptDate);
            Appointment add = new Appointment(patient, timeSlot, location);


            if (add.getLocation() == null) {
                return "Invalid Location!";
            }
            if (s.isThere(add)) {
                return "Same Appointment exists in the schedule!";
            }
            if (s.add(add)) {
                return "Appointment booked and added to the schedule";
            }
            return s.whyAddFailed(add);

        }
        if (array[0].equals("C")) {

            if (array.length != 7) {
                return "Invalid Command!";
            }

            String DOB = array[1];
            String fname = array[2];
            String lname = array[3];
            String appointmentDate = array[4];
            String appointmentTime = array[5];
            String location = array[6];
            Date dob = new Date(DOB);
            if (!dob.isValid()) {
                return "Invalid date of birth.";
            }


            Date curr = new Date();
            if (dob.compareTo(curr) >= 0) {
                return "Date Birth Invalid -> it is a future date.";
            }
            Date appt = new Date(appointmentDate);
            if (!appt.isValid()) {
                return "Invalid appointment";
            }
            if (appt.compareTo(curr) < 0) {
                return "Appointment date invalid -> it must be a future date.";

            }
            Patient p = new Patient(fname, lname, DOB);

            Time t = new Time(appointmentTime);
            Date a = new Date(appointmentDate);
            Timeslot ts = new Timeslot(t, a);
            Appointment rm = new Appointment(p, ts, location);


            if (rm.getLocation() == null) {
                return "Invalid location!";
            }
            if (!rm.getSlot().getDate().isValid()) {
                return "Invalid appointment date!";
            }
            if (s.isEmpty()) {
                return "Not cancelled, appointment does not exist.";
            }
            if (s.remove(rm)) {
                return "Appointment cancelled.";
            } else {
                return "Not cancelled, appointment does not exist.";
            }

        }
        if (array[0].equals("CP")) {
            if (array.length != 4) {
                return "Invalid Command!";
            }
            String DOB = array[1];
            String fname = array[2];
            String lname = array[3];
            Patient p = new Patient(fname, lname, DOB);
            Appointment check = new Appointment(p);
            if (!s.removeAll(check)) {
                return "Patient Does not exist";
            }
            return "All appointments for  " + " " + DOB + " " + fname + " "
                    + lname + " have been canceled";

        }
        if (array[0].equals("P")) {
            s.print();
            return "";
        }
        if (array[0].equals("PZ")) {
            s.printByZip();
            return "";
        }
        if (array[0].equals("PP")) {
            s.printByPatient();
            return "";
        }


        return "Invalid command!";

    }


}