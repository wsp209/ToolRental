package ToolRental;
import java.math.*;
import java.util.*;
import java.text.*;

/**
 * @author Will Pedicone
 */

public class RentalDetails {
    Tool rentedTool;
    Calendar checkoutCalendar;
    Calendar dueDateCalendar;
    int rentalDays;
    int chargeDays;
    double chargeBeforeDiscount;    
    double discountAmount;    
    double chargeAfterDiscount;
    String outputCheckout;
    String outputDueDate;
    String outputDiscount;
    String outputDailyCharge;
    String outputChargeBeforeDiscount;
    String outputDiscountAmount;
    String outputChargeAfterDiscount;  
    
        
   
    public RentalDetails (String inputToolCode, String inputCheckoutDate, int inputRentalDays, int discount) throws ParseException, Exception {
        setRentalDetails(inputToolCode, inputCheckoutDate, inputRentalDays, discount);
    }
            
    private void setRentalDetails (String inputToolCode, String inputCheckoutDate, int inputRentalDays, int discount) throws ParseException, Exception {
        //Set tool code
        rentedTool = new Tool(inputToolCode);  
        //Set rental days
        rentalDays = inputRentalDays;
        //Set output discount
        outputDiscount = discount+"%";
        //Determine if discount is acceptable
        if (discount < 0 || discount > 100) {     
            discountException();
        } 
        // Determine if rental days are acceptable
        if (rentalDays < 1) {
            rentalDaysException();
        }
        //Set Checkout Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yy");
        Date checkoutDate = dateFormat.parse(inputCheckoutDate);
        checkoutCalendar = Calendar.getInstance();
        checkoutCalendar.setTime(checkoutDate);
        
        //Initialize due date
        dueDateCalendar = Calendar.getInstance();
        Calendar dayAfterDueDate = Calendar.getInstance(); 
        
        //Set due date and determine day after due date
        dayAfterDueDate = setDueDate(inputRentalDays, dateFormat, dayAfterDueDate); 
        
        //Set checkout and due dates in MM/dd/yy format
        outputCheckout = dateFormat.format(checkoutCalendar.getTime());
        outputDueDate = dateFormat.format(dueDateCalendar.getTime());
        
        //Set total charge days to rental days before deducting weekend/holiday days
        chargeDays = inputRentalDays;
        
        //Determine holiday days between checkout date and day after due date
        int holidayDays = getTotalHolidayDays(dayAfterDueDate);
        
        //Determine weekend days between checkout date and day after due date
        int weekendDays = getTotalWeekendDays(dayAfterDueDate);
        
        //If tool does not charge for holidays, substract from charge days
        if (!rentedTool.chargesForHolidays()){
            chargeDays -= holidayDays;
        }
        //If tool does not charge for weekends, substract from charge days
        if (!rentedTool.chargesForWeekends()){
            chargeDays -= weekendDays;
        }
        
        //Calculate charge before discount, rounded to two decimal places 
        chargeBeforeDiscount = round(rentedTool.getDailyCharge()*chargeDays, 2, BigDecimal.ROUND_HALF_UP);
        
        //Calculate total discount amount, rounded to two decimal places 
        discountAmount = round(chargeBeforeDiscount*discount, 2, BigDecimal.ROUND_HALF_UP)/100; 
        discountAmount = round(discountAmount, 2, BigDecimal.ROUND_HALF_UP);
        
        //Calculate charge after discount, rounded to two decimal places 
        chargeAfterDiscount = chargeBeforeDiscount-discountAmount;
        
        //Set charge amount strings for output
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        outputDailyCharge = "$"+decimalFormat.format(rentedTool.getDailyCharge());
        outputChargeBeforeDiscount = "$"+decimalFormat.format(chargeBeforeDiscount);
        outputDiscountAmount = "$"+decimalFormat.format(discountAmount);
        outputChargeAfterDiscount = "$"+decimalFormat.format(chargeAfterDiscount);
        
    }
        
    
    
    //Set due date and return day after due date
    private Calendar setDueDate (int rentalDays, SimpleDateFormat dateFormat, Calendar dayAfterDueDate){
        //one day in milliseconds
        long oneDay = 86400000L;
        //get time in milliseconds of checkout date
        long timeOfCheckout = checkoutCalendar.getTimeInMillis();
        //get total rental time in milliseconds
        long totalRentalTime = oneDay*rentalDays;
        //get time in milliseconds of due date
        long timeOfDueDate = timeOfCheckout+totalRentalTime;
        //get time in milliseconds of day after due date
        long timeOfDayAfter = timeOfDueDate+oneDay;
        
        //Set day after due date based on time in milliseconds
        dayAfterDueDate.setTimeInMillis(timeOfDayAfter);
        //Set due date based on time in milliseconds
        dueDateCalendar.setTimeInMillis(timeOfDueDate);
        
        //Return day after due date
        return dayAfterDueDate;
    }
    
    
    
    //Get total holiday days between checkout date and day after due date
     private int getTotalHolidayDays (Calendar dayAfterDueDate){
        //Number of holiday days encompassed by date range
        int totalHolidayDays = 0;
        
        //Get the years from the checkout date and due date
        int yearFrom = checkoutCalendar.get(Calendar.YEAR);
        int yearTo = dayAfterDueDate.get(Calendar.YEAR);
        
        // Between checkout and due date year, get each holiday date and add to total if it is within the dates
        for (int i = yearFrom; i<= yearTo; i++){
            //Get observed 4th of July date for year
            Calendar july4thObservance = july4thObserved(i);
            //Get observed Labor Day date for year
            Calendar laborDayObservance = laborDayObserved(i);
            
            //Add to holiday total if date of holiday is between checkout date and day after due date
            if (july4thObservance.before(dayAfterDueDate) && july4thObservance.after(checkoutCalendar)) {
                totalHolidayDays++;
            }
            if (laborDayObservance.before(dayAfterDueDate) && laborDayObservance.after(checkoutCalendar)) {
                totalHolidayDays++;
            }
        } 
        //Return the total number of holiday days in date range
        return totalHolidayDays;
    }
     
     
     
    //Get total weekend days between checkout date and day after due date 
    private int getTotalWeekendDays (Calendar dayAfterDueDate){
        //Number of weekend days encompassed by date range
        int totalWeekendDays = 0;
        
        //Date to work with, starting on checkout date
        Calendar workCalendarDate = (Calendar)checkoutCalendar.clone();
        
        //Return 0 weekend days if checkout and due dates are the same
        if (checkoutCalendar.getTimeInMillis() == dueDateCalendar.getTimeInMillis()) {
            return 0;
        } 
 
        do { //Add up all weekend days from after checkout date through due date
            workCalendarDate.add(Calendar.DAY_OF_MONTH, 1);
            if (workCalendarDate.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY 
                || workCalendarDate.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                 totalWeekendDays++;
            }
        } while (workCalendarDate.getTimeInMillis() < dayAfterDueDate.getTimeInMillis());
        
        //Return the total number of weekend days in date range
        return totalWeekendDays;
    }    
        

    

    //Get the observed holiday date of July 4th based on the year
    public static Calendar july4thObserved (int inputYear){        
        int indexOfMonth = 6; //July
        Calendar dateOfObservance = Calendar.getInstance();
        //Set initial observed date as July 4th of input year        
        dateOfObservance.set(inputYear, indexOfMonth, 4); 
        //Get day of week based on initial observed date
        int dayOfWeek = dateOfObservance.get(Calendar.DAY_OF_WEEK);
        
        //Set the July 4th observed date based on July 4th day of the week 
        switch(dayOfWeek){
            case 1 : // Sunday
                dateOfObservance = Calendar.getInstance();
                dateOfObservance.set(inputYear, indexOfMonth, 5);
                return dateOfObservance;
            case 2 : // Monday
            case 3 : // Tuesday
            case 4 : // Wednesday
            case 5 : // Thursday
            case 6 : // Friday
                dateOfObservance = Calendar.getInstance();
                dateOfObservance.set(inputYear, indexOfMonth, 4);
                return dateOfObservance;
            default : // Saturday                    
                dateOfObservance = Calendar.getInstance();
                dateOfObservance.set(inputYear, indexOfMonth, 3);
                return dateOfObservance;
        }
    } 

  
    //Get the observed holiday date of Labor Day based on the year
    public static Calendar laborDayObserved (int inputYear){        
        int indexOfMonth = 8; // September
        Calendar dateOfObservance = Calendar.getInstance();
        //Set initial observed date as September 1st of input year   
        dateOfObservance.set(inputYear, indexOfMonth, 1);
        //Get day of week based on initial observed date
        int dayOfWeek = dateOfObservance.get(Calendar.DAY_OF_WEEK);
        
        //Set the Labor Day date based on September 1st day of the week 
        switch(dayOfWeek){
            case 1 : // Sunday
               dateOfObservance = Calendar.getInstance();
               dateOfObservance.set(inputYear, indexOfMonth, 2);
               return dateOfObservance;
            case 2 : // Monday
               dateOfObservance = Calendar.getInstance();
               dateOfObservance.set(inputYear, indexOfMonth, 1);
               return dateOfObservance;
            case 3 : // Tuesday
               dateOfObservance = Calendar.getInstance();
               dateOfObservance.set(inputYear, indexOfMonth, 7);
               return dateOfObservance;
            case 4 : // Wednesday
               dateOfObservance = Calendar.getInstance();
               dateOfObservance.set(inputYear, indexOfMonth, 6);
               return dateOfObservance;
            case 5 : // Thursday
               dateOfObservance = Calendar.getInstance();
               dateOfObservance.set(inputYear, indexOfMonth, 5);
               return dateOfObservance;
            case 6 : // Friday
               dateOfObservance = Calendar.getInstance();
               dateOfObservance.set(inputYear, indexOfMonth, 4);
               return dateOfObservance;
            default : // Saturday
               dateOfObservance = Calendar.getInstance();
               dateOfObservance.set(inputYear, indexOfMonth, 3);
               return dateOfObservance;
        }
    }
    
    //Round a (double) number to a specified number of decimal places
    public static double round(double unrounded, int precision, int roundingMode) {       
        BigDecimal roundedDouble = BigDecimal.valueOf(unrounded);
        BigDecimal rounded = roundedDouble.setScale(precision, roundingMode);
        return rounded.doubleValue();
    }
    
    private void rentalDaysException() throws Exception {
        throw new Exception("Please enter a number of rental days greater than zero.");
    }
    
    private void discountException() throws Exception {
        throw new Exception("Please enter a discount percentage between 0 and 100.");
    }

}
