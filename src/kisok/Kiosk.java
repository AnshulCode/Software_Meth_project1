package kisok;
import java.util.Scanner;
import java.util.StringTokenizer;


/**
 * The type Kiosk.
 */
public class Kiosk {



    /**
     * This method runs the kiosk and starts the process of getting input from the user.
     * If the input becomes Q then the kiosk stops running and the program is finished.
     */
    public void run() {
        String input = "";
        Scanner scan = new Scanner(System.in);

        System.out.print("Kiosk running. Ready to process transactions\n");
        Schedule schedule = new Schedule();

        while(!input.equals("Q")){
            input = scan.nextLine();
            //System.out.println("command recived" + input);
            if(input.equals("Q")){
                break;
            }

            System.out.println(commandCheck(input,schedule));

        }
        System.out.print("Kiosk session ended");

    }

    /**
     * This method will check to make sure the command that was inputed is a correct command.
     * If it is not correct it will give back that this command was invalid
     *
     * @param commandGiven This is the command given by the user in the console.
     * @param s            the s
     * @return the string
     */
    public String commandCheck(String commandGiven , Schedule s) {
        if(commandGiven.isEmpty()){
            return "Invalid Command!\n";
        }
        String[] array = this.splitString(commandGiven);
        if(!(array[0].equals("Q") ||array[0].equals("B") || array[0].equals("CP") || array[0].equals("C")  || array[0].equals("PZ")  || array[0].equals("PP") || array[0].equals("P") )) {
            return "Invalid Command!\n";
        }else if(!array[0].equals("B")  && s.isEmpty()){
            return "Invalid Command!\n";
        }

        if ((array[0].equals("Q")||array[0].equals("P") ||array[0].equals("PP")|| array[0].equals("PZ") ) && array.length >1) {
            return "Invalid Command!\n";
        }
        if(array[0].equals("B") ){
            if(array.length !=7){
                return "Invalid Command!\n";
            }

            String DOB = array[1];
            String fname = array[2];
            String lname = array[3];
            String appointmentDate = array[4];
            String appointmentTime = array[5];
            String location = array[6];
            Date dob = new Date(DOB);

            if(!dob.isValid()){
                return "Date of Birth Invalid";
            }

            Date curr = new Date();

            Date appt = new Date(appointmentDate);
            if(!appt.isValid()){
                return "Invalid appointment date!";
            }

            if(appt.compareTo(curr) <0){
                return "Appointment date invalid -> it is a future date";

            }
            Patient p = new Patient(fname,lname,DOB);

            Time t = new Time(appointmentTime);
            Date a = new Date(appointmentDate);
            Timeslot ts = new Timeslot(t,a);
            Appointment add = new Appointment(p,ts,location);


            if(add.getLocation() == null){
                return "Invalid Location!";
            }
            if(s.isThere(add)){
                return "Same Appointment exists in the schedule!";
            }
            if(s.add(add)) {
                return "Appointment booked and added to the schedule";
            }
            return s.whyAddFailed(add);

        }
        if(array[0].equals("C")){
            if(array.length !=7){
                return "Invalid Command!\n";
            }

            String DOB = array[1];
            String fname = array[2];
            String lname = array[3];
            String appointmentDate = array[4];
            String appointmentTime = array[5];
            String location = array[6];
            Date dob = new Date(DOB);
            if(!dob.isValid()){
                return "Invalid DOB";
            }



            Date curr = new Date();
            if(dob.compareTo(curr) >= 0){
                return "Date Birth Invalid -> it is a future date";
            }
            Date appt = new Date(appointmentDate);
            if(!appt.isValid()){
                return "Invalid Appointment";
            }
            if(appt.compareTo(curr) <0){
                return "Appointment date invalid -> it is a future date";

            }
            Patient p = new Patient(fname,lname,DOB);

            Time t = new Time(appointmentTime);
            Date a = new Date(appointmentDate);
            Timeslot ts = new Timeslot(t,a);
            Appointment rm = new Appointment(p,ts,location);


            if(rm.getLocation() == null){
                return "Invalid Location!";
            }
            if(!rm.getSlot().getDate().isValid()){
                return "Invalid appointment date!";
            }
            if(s.remove(rm)) {
                return "Appointment cancelled.";
            }else{
                return "Not cancelled, appointment does not exist";
            }

        }
        if(array[0].equals("CP")){
            if(array.length != 4 ){
                return "Invalid Command!";
            }
            String DOB = array[1];
            String fname = array[2];
            String lname = array[3];
            Patient p = new Patient(fname,lname,DOB);
            Appointment check = new Appointment(p);
            if(!s.removeAll(check)){
                return "Patient Does not exist";
            }
            return "All appointments for  "+" "+DOB+" "+fname+" "+lname +" have been canceled";

        }
        if(array[0].equals("P")){
            s.print();
            return "";
        }
        if(array[0].equals("PZ")){
            s.printByZip();
            return "";
        }
        if(array[0].equals("PP")){
            s.printByPatient();
            return "";
        }


        return "Valid command";
    }

    /**
     * This method takes the input given from the user and splits it to its parts.
     * This will be done using the string tokenizer library.
     * @param inputGiven This is the input given from the user in the console
     * @return an array of strings that is the input from the console split into singular Strings
     */
    private String[] splitString(String inputGiven) {
        StringTokenizer st = new StringTokenizer(inputGiven);
        String[] details = new String[st.countTokens()];
        int arrPos = 0;
        while (arrPos < details.length) {
            details[arrPos] = st.nextToken();
            arrPos++;
        }
        return details;

    }
}

