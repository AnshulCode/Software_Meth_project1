package kisok;

public class Main {

    public static void main(String[] args) {

        Patient patient = new Patient();
        patient.setFname("john");
        patient.setLname("doe");
        patient.setDob("12/13/1970");

        Patient patient2 = new Patient();
        patient2.setFname("john");
        patient2.setLname("doe");
        patient2.setDob("12/13/1970");
        System.out.println(patient.compareTo(patient2));



    }
}
