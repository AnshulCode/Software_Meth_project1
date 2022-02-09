package kisok;
import java.util.Calendar;


public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;


    // Date constructor that accepts string date input, all fields zero if string is whack
    public Date(String date){
        String a[] = date.split("/");


        // catches error in data is whack
        try {

            this.year = Integer.parseInt(a[2]);
            this.month = Integer.parseInt(a[0]);
            this.day = Integer.parseInt(a[1]);
            System.out.println(this.getMonth());
        }catch (NumberFormatException e){

            this.year = 0;
            this.month = 0;
            this.day = 0;
        }catch(ArrayIndexOutOfBoundsException e){

            this.year = 0;
            this.month = 0;
            this.day = 0;
        }


    }

    // Auto sets date top current date, default
    public Date(){
        Calendar cal = Calendar.getInstance();


        this.month = cal.get(Calendar.MONTH)+1;
        this.day = cal.get(Calendar.DAY_OF_MONTH);
        this.year = cal.get(Calendar.YEAR);




    }

    // get/set methods for Day,Month, Year


    public int getDay() {
        return this.day;
    }
    public int getMonth() {
        return this.month;
    }
    public int getYear() {
        return this.year;
    }

    //checks if year is leap year
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

    // checks if Date is valid
    public boolean isValid(){
        if(this.year <=0 || this.month <= 0 || this.day <= 0  || this.month>12 || this.day >31){
            return false;
        }
        if(this.month == 2){
            if(this.day>29){
                return false;
            }
            if(this.day == 29){
               return this.isLeapYear();

            }
        }
        return true;
    }

    // converts the date to days
    public int toDays(){
        int year = this.year;
        int month = this.month;
        if(this.month <=2){
            year = year - 1;
            month = month +12;
        }
        return ((1461*year)/4)+((153*month)/5)+this.day;

    }

    @Override
    public String toString() {
        String dateStr = Integer.toString(this.month)+"/"+Integer.toString(this.day)+"/"+Integer.toString(this.year);

        return dateStr;

    }

    // compareTo implementation for date returns Integer.MAX_VALUE if either date is invalid
    public int compareTo(Date date){

        if(!this.isValid() || !date.isValid()){
            return Integer.MAX_VALUE;
        }
        return this.toDays()-date.toDays();
    }

}
