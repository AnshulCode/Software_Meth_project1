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
    public Patient(String fname,String lname,String dob){
        this.fname = fname;
        this.lname = lname;
        this.dob = new Date(dob);
    }

    public String getLname() {
        return this.lname;
    }

    public String getFname() {
        return this.fname;
    }

    public void setDob(String l) {
        this.dob = new Date(l);
    }
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
