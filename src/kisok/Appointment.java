package kisok;

/**
 * The type Appointment.
 *
 * @author Anshul Prasad , Alexander Reyes
 */
public class Appointment {
    private Patient patient;
    private Timeslot slot;
    private Location location;

    /**
     * Instantiates a new Appointment.
     *
     * @param patient  the patient
     * @param slot     the slot
     * @param location the location in string formant, not enum
     */
// constructor for Appointment
    public Appointment(Patient patient, Timeslot slot, String location) {

        if (location.equalsIgnoreCase(Location.MIDDLESEX.county)) {
            this.location = Location.MIDDLESEX;
            this.patient = patient;
            this.slot = slot;

        } else if (location.equalsIgnoreCase(Location.MERCER.county)) {
            this.location = Location.MERCER;
            this.patient = patient;
            this.slot = slot;
        } else if (location.equalsIgnoreCase(Location.MORRIS.county)) {
            this.location = Location.MORRIS;
            this.patient = patient;
            this.slot = slot;
        } else if (location.equalsIgnoreCase(Location.SOMERSET.county)) {
            this.location = Location.SOMERSET;
            this.patient = patient;
            this.slot = slot;
        } else if (location.equalsIgnoreCase(Location.UNION.county)) {
            this.location = Location.UNION;
            this.patient = patient;
            this.slot = slot;
        }
    }

    /**
     * Instantiates a new Appointment.
     *
     * @param patient the patient,used only for removeAll method in Schedule
     */
    public Appointment(Patient patient) {
        this.patient = patient;
        this.slot = null;
        this.location = Location.UNION;
    }

    /**
     * Instantiates a new Appointment.
     */
//base constructor
    public Appointment() {

    }

    /**
     * Gets slot.
     *
     * @return the slot
     */
    public Timeslot getSlot() {
        return slot;
    }

    /**
     * Gets paitent.
     *
     * @return the paitent
     */
    public Patient getPaitent() {
        return this.patient;
    }

    /**
     * Gets location.
     *
     * @return the location
     */
    public Location getLocation() {
        return location;
    }


    /**
     * Converts Appointment to string format
     * @return Appointment in string format
     */
    @Override
    public String toString() {

        return patient.toString() + " Appointment detail: " + slot.toString() + " " +
                location.cites + " " + location.zip + "," + location.county;
    }

    /**
     * Sees if appointment are equal
     * @param o
     * @return True if equal , false otherwise
     */

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        Appointment check = (Appointment) o;

        return (this.patient.equals(check.getPaitent()) && this.location.county.
                equals(check.getLocation().county)
                && this.slot.compareTo(check.getSlot()) == 0);
    }
}
