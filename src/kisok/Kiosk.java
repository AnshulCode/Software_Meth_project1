package kisok;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Kiosk {

    private String input = "";
    private String command = "";
    private String[] appointmentInfo = new String[7];
    private int day;
    private int month;
    private int year;

    /**
     * This method runs the kiosk and starts the process of getting input from the user.
     * If the input becomes Q then the kiosk stops running and the program is finished.
     */
    public void run() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Kiosk running. Ready to process transactions\n");
        Schedule schedule = new Schedule();

        while(!input.equals("Q")){
            input = scan.nextLine();
            //System.out.println("command recived" + input);

            commandCheck(input,schedule);

        }
        System.out.print("Kiosk session ended");

    }

    /**
     * This method will check to make sure the command that was inputed is a correct command.
     * If it is not correct it will give back that this command was invalid
     * @param commandGiven This is the command given by the user in the console.
     */
    public String commandCheck(String commandGiven , Schedule s) {
        String[] array = this.splitString(commandGiven);
        if(array[0] != "Q" ||array[0] != "B" || array[0] !="CP" || array[0] != "C" || array[0] !="PZ" || array[0] !="PP" || array[0] !="P" ) {
            return "Invalid Command\n";
        }else if(array[0] != "B"  && s.isEmpty()){
            return "Invalid Command\n";
        }
        String date = "";
        String Fname = "";
        String Lname = "";
        String Location = "";
        String dob= "";




        return "";
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

/**
 *
 */