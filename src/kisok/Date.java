package kisok;
import java.util.Calendar;


public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;

    public Date(String date){
        String a[] = date.split("/");
        this.year = Integer.parseInt(a[2]);
        this.month = Integer.parseInt(a[0]);
        this.day = Integer.parseInt(a[1]);
    }
    public Date(){
        Calendar cal = Calendar.getInstance();
        java.util.Date today =  cal.getTime();

        this.month = today.getMonth()+1;
        this.day = today.getDay() + 1;
        this.year = today.getYear()+1900;



    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return this.day;
    }
    public int getMonth() {
        return this.month;
    }
    public int getYear() {
        return this.year;
    }

    public boolean isLeapYear(){
        if(this.year % 4 == 0){
            if(this.year % 100 == 0){
                if(this.year % 400 == 0){
                    return true;
                }
            }
            return false;
        }
        return false;

    }
    public boolean isValid(){
        if(this.year <0 || this.month < 0 || this.day < 0  || this.month>12 || this.day >31){
            return false;
        }
        if(this.month == 2){
            if(this.day>29){
                return false;
            }
            return this.isLeapYear();
        }
        return true;
    }
    public int convertToDay() {
        return 0;
    }
    public int compareTo(Date date){
        if(!this.isValid() || !date.isValid()){
            return -100000000;
        }


        return 0;
    }
}
