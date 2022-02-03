package kisok;

public class Schedule {
    private Appointment[] appointments;
    private int numAppts;

    private int find(Appointment appt){
        for(int i = 0; i < this.appointments.length; i++){
            if(this.appointments[i] == appt){
                return i;
            }
        }
        return -1;
    }

    private void grow(){
        if(this.numAppts == this.appointments.length){
            Appointment[] newAppts=new Appointment[numAppts+4];
            for(int i  = 0; i<this.numAppts; i++){
                newAppts[i] = this.appointments[i];
            }
            this.appointments = newAppts;
        }
    }
    public boolean add(Appointment appt){
        return false;
    }

    public void print(){
        for(int i = 0; i<this.appointments.length; i++){
            if(this.appointments[i] != null) {
                System.out.println(this.appointments[i].toString());
            }
        }
    }
    public void printByZip(){

    }

    public void printByPatient(){

    }
}
