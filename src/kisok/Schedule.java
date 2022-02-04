package kisok;

public class Schedule {
    private Appointment[] appointments;
    private int numAppts;
    private final int NOT_FOUND = -1;

    private int find(Appointment appt){
        for(int i = 0; i < this.appointments.length; i++){
            if(this.appointments[i] == appt){
                return i;
            }
        }
        return NOT_FOUND;
    }

    private void grow(){
        if(this.numAppts == this.appointments.length){
            Appointment[] newAppts=new Appointment[numAppts+4];
            for(int i  = 0; i<this.numAppts-1; i++){
                newAppts[i] = this.appointments[i];
            }
            this.appointments = newAppts;
        }
    }
    public boolean remove(Appointment appt){
        if(this.find(appt) == NOT_FOUND || numAppts == 0){
            return false;
        }
        appointments[this.find(appt)] = null;
        numAppts -= 1;
        return true;
    }
    public boolean add(Appointment appt){
        this.grow();
        if(this.find(appt) != NOT_FOUND){
            return false;
        }
        for (int i = 0; i < this.appointments.length; i++) {
            if(this.appointments[i] == null){
                this.appointments[i] = appt;
                numAppts += 1;
                return true;
            }
        }

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
        Appointment[] sortArray = new Appointment[numAppts];
        int addIndex = 0;
        for(int i = 0; i<this.appointments.length; i++){
            if(this.appointments[i] != null){
                sortArray[addIndex] = this.appointments[i];
                addIndex++;
            }
        }

        for (int i = 0; i < numAppts; i++) {
            int swap = 0;
            for (int j = 0; j < numAppts-i-1; j++){
                if(sortArray[j].getLocation().zip.compareTo(sortArray[j+1].getLocation().zip)>0){
                    Appointment tmp = sortArray[j];
                    sortArray[j] = sortArray[j+1];
                    sortArray[j+1] = tmp;
                    swap++;
                }
            }
            if(swap == 0){
                break;
            }
        }
        for(int i = 0; i<sortArray.length; i++){
            System.out.println(sortArray[i].toString());
        }
    }

    public void printByPatient(){

        Appointment[] sortArray = new Appointment[numAppts];
        int addIndex = 0;
        for(int i = 0; i<this.appointments.length; i++){
            if(this.appointments[i] != null){
                sortArray[addIndex] = this.appointments[i];
                addIndex++;
            }
        }

        for (int i = 0; i < numAppts; i++) {
            int swap = 0;
            for (int j = 0; j < numAppts-i-1; j++){
                if(sortArray[j].getPaitent().compareTo(sortArray[j+1].getPaitent())>0){
                    Appointment tmp = sortArray[j];
                    sortArray[j] = sortArray[j+1];
                    sortArray[j+1] = tmp;
                    swap++;
                }
            }
            if(swap == 0){
                break;
            }
        }
        for(int i = 0; i<sortArray.length; i++){
            System.out.println(sortArray[i].toString());
        }

    }
}
