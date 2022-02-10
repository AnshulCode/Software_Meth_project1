package kisok;



public class Schedule {
    private Appointment[] appointments;
    private int numAppts;
    private final int NOT_FOUND = -1;

    public boolean isEmpty(){
        return (numAppts == 0);
    }

    private int find(Appointment appt) {
        for (int i = 0; i < this.numAppts; i++) {
            if (this.appointments[i] != null) {
                if (this.appointments[i].equals(appt)) {
                    return i;
                }
            }
        }
        return NOT_FOUND;
    }

    public Schedule() {
        this.appointments = new Appointment[0];
        this.numAppts = 0;

    }

    private void grow() {
        if (this.numAppts == this.appointments.length) {
            Appointment[] newAppts = new Appointment[this.numAppts + 4];
            for (int i = 0; i < this.numAppts; i++) {
                newAppts[i] = this.appointments[i];
            }
            this.appointments = newAppts;
        }
    }

    public boolean removeAll(Appointment appt){
        Appointment[] del = new Appointment[this.appointments.length];
        for (int i = 0; i < del.length; i++) {
            if(this.appointments[i] != null) {
                if (this.appointments[i].getPaitent().equals(appt.getPaitent())) {
                    del[i] = this.appointments[i];
                }
            }
        }
        boolean d = false;
        for (int i = 0; i < del.length; i++) {
            if(del[i]!= null){
                boolean removed = this.remove(del[i]);
                if(!removed){
                    d = true;
                }
            }
        }
        if(!d){
            return false;
        }

        return true;
    }
    public boolean remove(Appointment appt) {
        if (this.find(appt) == NOT_FOUND || this.numAppts == 0) {
            return false;
        }

        int index_found = this.find(appt);
        this.appointments[index_found] = null;

        for (int i = index_found + 1; i < this.appointments.length; i++) {
            this.appointments[i - 1] = this.appointments[i];
        }
        numAppts -= 1;



        return true;
    }


    public boolean isThere(Appointment appt){
        for (int i = 0; i < this.numAppts; i++) {
            if (this.appointments[i] != null) {
                if (this.appointments[i].equals(appt)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean add(Appointment appt) {
        if (this.find(appt) != NOT_FOUND) {
            return false;
        }
        Date current = new Date();
        if (appt.getSlot().getDate().compareTo(current) < 0) {
            System.out.println("Date Fallacyt");
            return false;
        }
        Time upper = new Time(9, 0);
        Time lower = new Time(16, 45);
        if (appt.getSlot().getTime().compareTo(upper) < 15 || appt.getSlot().getTime().compareTo(lower) > 0) {
            System.out.println("Date Wrong");
            return false;
        }


        for (int i = 0; i < this.appointments.length; i++) {
            if (this.appointments[i] != null) {
                if (appt.getPaitent().equals(this.appointments[i].getPaitent())) {
                    if (Integer.parseInt(this.appointments[i].getLocation().zip) == (Integer.parseInt(appt.getLocation().zip))) {
                        if (Math.abs(appt.getSlot().compareTo(this.appointments[i].getSlot())) < 15) {
                            System.out.println("15 min fault");
                            return false;
                        }
                    }else if(this.appointments[i].getSlot().getDate().compareTo(appt.getSlot().getDate()) == 0){
                        System.out.println("15 min fault 2");
                        return false;
                    }
                }
                if (Integer.parseInt(this.appointments[i].getLocation().zip) == (Integer.parseInt(appt.getLocation().zip))) {
                    System.out.println("Compare TO" +Math.abs(appt.getSlot().compareTo(this.appointments[i].getSlot())));
                    if (Math.abs(appt.getSlot().compareTo(this.appointments[i].getSlot())) < 15) {
                        System.out.println("15 min fault 3");
                        return false;
                    }
                }
            }
        }

        this.grow();


        for (int i = 0; i < this.appointments.length; i++) {
            if (this.appointments[i] == null) {
                this.appointments[i] = appt;
                this.numAppts++;
                return true;
            }
        }


        return true;
    }

    public void print() {

        for (int i = 0; i < this.appointments.length; i++) {
            if (this.appointments[i] != null) {
                System.out.println(this.appointments[i].toString());

            }


        }
    }

    public void printByZip() {
        for (int i = 0; i < this.numAppts; i++) {
            int swap = 0;
            for (int j = 0; j < this.numAppts - 1 - i; j++) {
                if (this.appointments[j] != null && this.appointments[j + 1] != null) {

                    if (Integer.parseInt(this.appointments[j].getLocation().zip) > (Integer.parseInt(this.appointments[j + 1].getLocation().zip))) {
                        Appointment tmp = this.appointments[j];
                        this.appointments[j] = this.appointments[j + 1];
                        this.appointments[j + 1] = tmp;
                        swap++;

                    } else if (Integer.parseInt(this.appointments[j].getLocation().zip) == (Integer.parseInt(this.appointments[j + 1].getLocation().zip))) {
                        if (this.appointments[j].getSlot().compareTo(this.appointments[j + 1].getSlot()) > 0) {
                            Appointment tmp = this.appointments[j];
                            this.appointments[j] = this.appointments[j + 1];
                            this.appointments[j + 1] = tmp;
                            swap++;
                        }
                    }
                }
            }
            if (swap == 0) {
                break;
            }
        }
        this.print();
    }

    public void printByPatient() {
        for (int i = 0; i < this.numAppts; i++) {
            int swap = 0;
            for (int j = 0; j < this.numAppts - 1 - i; j++) {
                if(!this.appointments[j].getPaitent().equals(this.appointments[j+1].getPaitent())){
                    String name1 = this.appointments[j].getPaitent().getLname();
                    String name2 = this.appointments[j+1].getPaitent().getLname();
                    if(name1.compareTo(name2)>0){
                        Appointment tmp = this.appointments[j];
                        this.appointments[j] = this.appointments[j + 1];
                        this.appointments[j + 1] = tmp;
                        swap++;
                    }else if(name1.compareTo(name2)==0){
                        name1 = this.appointments[j].getPaitent().getFname();
                        name2 = this.appointments[j+1].getPaitent().getFname();
                        if(name1.compareTo(name2)>0) {
                            Appointment tmp = this.appointments[j];
                            this.appointments[j] = this.appointments[j + 1];
                            this.appointments[j + 1] = tmp;
                            swap++;
                        }else if(name1.compareTo(name2)==0){
                            if(this.appointments[j].getPaitent().getDob().compareTo(this.appointments[j+1].getPaitent().getDob())>0){
                                Appointment tmp = this.appointments[j];
                                this.appointments[j] = this.appointments[j + 1];
                                this.appointments[j + 1] = tmp;
                                swap++;
                            }
                        }
                    }
                }
            }
            if (swap == 0) {
                break;
            }

        }

        this.print();

    }




}

