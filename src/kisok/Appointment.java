package kisok;

public class Appointment {
    private Patient patient;
    private Timeslot slot;
    private Location location;

    // constructor for Appointment
    public Appointment(Patient patient,Timeslot slot,String location){

            if(location.equals(Location.MIDDLESEX.county)){
                this.location = Location.MIDDLESEX;
                this.patient = patient;
                this.slot = slot;

            }else if(location.equals(Location.MERCER.county)){
                this.location = Location.MERCER;
                this.patient = patient;
                this.slot = slot;
            }else if (location.equals(Location.MORRIS.county)) {
                this.location = Location.MERCER;
                this.patient = patient;
                this.slot = slot;
            }else if (location.equals(Location.SOMERSET.county)) {
                this.location = Location.MERCER;
                this.patient = patient;
                this.slot = slot;
            }else if (location.equals(Location.UNION.county)) {
                this.location = Location.UNION;
                this.patient = patient;
                this.slot = slot;
            }

    }
    //base constructor
    public Appointment(){

    }

    public Timeslot getSlot() {
        return slot;
    }

    public Patient getPaitent() {
        return this.patient;
    }
    public Location getLocation() {
        return location;
    }
    @Override
    public String toString(){
        if(patient == null){
            return "invalid location";
        }
        Date Current = new Date();
        if(this.slot.getDate().compareTo(Current)>0){
            return "invalid timeslot";
        }
        if(patient.getDob().compareTo(Current)>=0){
            return "Invalid appointment";
        }
        Time lower = new Time();

        return patient.toString()+" Appointment detail: "+slot.toString()+" "+location.cites+" "+location.zip+","+location.county;
    }

    @Override
    public boolean equals(Object o){
        if(o == null){
            return false;
        }
        if(this == o){
            return true;
        }
        Appointment check = (Appointment)o;

        return (this.patient.equals(check.getPaitent()) && this.location == check.getLocation() && this.slot == check.getSlot());
    }
}
