package kisok;

import java.util.Calendar;

/**
 * The type Patient.
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
    public void setFname(String fname){
        this.fname = fname;
    }

    /**
     * Set lname.
     *
     * @param l the l
     */
    public void setLname(String l){
        this.lname = l;
    }

    /**
     * Instantiates a new Patient.
     *
     * @param fname the fname
     * @param lname the lname
     * @param dob   the dob
     */
    public Patient(String fname,String lname,String dob){
        this.fname = fname;
        this.lname = lname;
        this.dob = new Date(dob);
    }

    /**
     * Gets lname.
     *
     * @return the lname
     */
    public String getLname() {
        return this.lname;
    }

    /**
     * Gets fname.
     *
     * @return the fname
     */
    public String getFname() {
        return this.fname;
    }

    /**
     * Sets dob.
     *
     * @param l the l
     */
    public void setDob(String l) {
        this.dob = new Date(l);
    }

    /**
     * Gets dob.
     *
     * @return the dob
     */
    public Date getDob() {
        return this.dob;
    }

    @Override
    public String toString() {
        return this.fname+" "+this.lname+","+" DOB: "+this.dob.toString()+",";
    }

    @Override
    public int compareTo(Patient patient) {

        String name1 = this.lname+this.fname;
        String name2 =  patient.lname+patient.fname;
        if(name1.compareTo(name2) != 0){
            return name1.compareTo(name2);
        }

        return this.dob.compareTo(patient.getDob());

    }

    @Override
    public boolean equals(Object o){
        if(o == null){
            return false;
        }
        if(this == o){
            return true;
        }
        Patient check = (Patient)o;

        return (this.dob.compareTo(check.getDob()) == 0 && this.lname.equals(check.getLname()) && this.fname.equals(check.getFname()));
    }


}
