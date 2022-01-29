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

    }
    public void setDob(String l) {
        Calendar cal = Calendar.getInstance();
        java.util.Date today =  cal.getTime();

        dob.setMonth(today.getMonth()+1);
        dob.setDay(today.getDay() + 1);
        dob.setYear(today.getYear()+1900);
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
