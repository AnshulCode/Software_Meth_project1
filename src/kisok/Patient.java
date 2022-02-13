package kisok;

import java.util.Calendar;

/**
 * The type Patient.
 *
 * @author Anshul Prasad , Alexander Reyes
 */
public class Patient implements Comparable<Patient> {
    private String fname;
    private String lname;
    private Date dob;

    /**
     * Set fname.
     *
     * @param fname the fname
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * Set lname.
     *
     * @param l the l
     */
    public void setLname(String l) {
        this.lname = l;
    }

    /**
     * Instantiates a new Patient.
     *
     * @param fname the fname
     * @param lname the lname
     * @param dob   the date of birth in string format, creates date with date object
     */
    public Patient(String fname, String lname, String dob) {
        this.fname = fname;
        this.lname = lname;
        this.dob = new Date(dob);
    }

    /**
     * Gets last name.
     *
     * @return the lname
     */
    public String getLname() {
        return this.lname;
    }

    /**
     * Gets first name .
     *
     * @return the fname
     */
    public String getFname() {
        return this.fname;
    }

    /**
     * Sets date of birth.
     *
     * @param l the l
     */
    public void setDob(String l) {
        this.dob = new Date(l);
    }

    /**
     * Gets date of birth
     *
     * @return the dob
     */
    public Date getDob() {
        return this.dob;
    }

    /**
     * Converts Patient to readable format
     *
     * @return Patient information in readable string
     */
    @Override
    public String toString() {
        return this.fname + " " + this.lname + "," + " DOB: " + this.dob.toString() + ",";
    }

    /**
     * @param patient
     * @return compare patient. If lname+fname not equal, return Integer.MAX_VALUE, else return difference of Date of birth
     */

    @Override
    public int compareTo(Patient patient) {

        String name1 = this.lname + this.fname;
        String name2 = patient.lname + patient.fname;
        if (name1.compareTo(name2) != 0) {
            return Integer.MAX_VALUE;
        }

        return this.dob.compareTo(patient.getDob());

    }

    /**
     * @param o cast as Patient
     * @return True if equal
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        Patient check = (Patient) o;

        return (this.dob.compareTo(check.getDob()) == 0 && this.lname.equals(check.getLname()) &&
                this.fname.equals(check.getFname()));
    }


}
