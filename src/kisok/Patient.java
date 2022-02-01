package kisok;

import java.util.Calendar;

public class Patient implements Comparable<Patient> {
    private String fname;
    private String lname;
    private Date dob;

    public void setFname(String fname){
        this.fname = fname;
    }
    public void setLname(String l){
        this.lname = l;
    }
    public String getLname() {
        return this.lname;
    }

    public String getFname() {
        return this.fname;
    }
    public void setDob(){
        Calendar cal = Calendar.getInstance();
        dob.setMonth(cal.get(Calendar.MONTH));
        dob.setDay(cal.get(Calendar.DAY_OF_MONTH));
        dob.setYear(cal.get(Calendar.YEAR));
    }
    public void setDob(String l) {
        this.dob = new Date(l);
    }
    public Date getDob() {
        return this.dob;
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    public int compareTo(Patient patient) {
        if(this.fname == patient.fname && this.lname == patient.lname && this.dob == patient.dob){
            return 1;
        }
        return 0;
    }

}
