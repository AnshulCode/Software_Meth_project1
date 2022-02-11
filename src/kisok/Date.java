package kisok;
import java.util.Calendar;


/**
 * The type Date.
 */
public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;
    public static final int QUADRENNIAL = 4;
    public static final int CENTENNIAL = 100;
    public static final int QUATERCENTENNIAL = 400;


    /**
     * Instantiates a new Date.
     *
     * @param date String of date, everything set to 0 if invalid
     */

    public Date(String date){
        String a[] = date.split("/");


        // catches error in data is whack
        try {

            this.year = Integer.parseInt(a[2]);
            this.month = Integer.parseInt(a[0]);
            this.day = Integer.parseInt(a[1]);

        }catch (NumberFormatException e){

            this.year = QUADRENNIAL;
            this.month = QUATERCENTENNIAL;
            this.day = CENTENNIAL;
        }catch(ArrayIndexOutOfBoundsException e){

            this.year = 0;
            this.month = 0;
            this.day = 0;
        }


    }

    /**
     * Instantiates a new Date with current date.
     */
// Auto sets date top current date, default
    public Date(){
        Calendar cal = Calendar.getInstance();


        this.month = cal.get(Calendar.MONTH)+1;
        this.day = cal.get(Calendar.DAY_OF_MONTH);
        this.year = cal.get(Calendar.YEAR);




    }

    // get/set methods for Day,Month, Year


    /**
     * Gets day.
     *
     * @return the day
     */
    public int getDay() {
        return this.day;
    }

    /**
     * Gets month.
     *
     * @return the month
     */
    public int getMonth() {
        return this.month;
    }

    /**
     * Gets year.
     *
     * @return the year
     */
    public int getYear() {
        return this.year;
    }

    /**
     * IChecks if year is leap yearr
     *
     * @return the boolean
     */
//checks if year is leap year
    public boolean isLeapYear(){
        if(this.year % QUADRENNIAL == 0 || this.year % QUATERCENTENNIAL == 0 ){
            if(this.year % CENTENNIAL != 0){
                return true;
            }

        }
        return false;

    }

    /**
     * Is valid boolean.
     *
     * @return the boolean
     */
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
            return true;
        }
        if(this.month == 4 || this.month  == 6 || this.month == 9 || this.month == 11){
            if(this.day>30){
                return false;
            }
        }
        return true;
    }

    /**
     * To days int.
     *
     * @return the int
     */
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


    public int compareTo(Date date){

        if(!this.isValid() || !date.isValid()){
            return Integer.MAX_VALUE;
        }
        return this.toDays()-date.toDays();
    }
    private static void main(String[] args) {

    }
}
