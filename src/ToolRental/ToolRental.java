package ToolRental;
import java.text.*;

/**
 * @author Will Pedicone
 */

public class ToolRental {

    /**
     * @param args the command line arguments
     * args[0]: Tool Code (ex: LADW)
     * args[1]: Checkout date (ex: 9/3/15)
     * args[2]: Rental Days (ex: 5)
     * args[3]: Discount Percentage (ex: 10)
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException, Exception {
        // Set tool code
        String checkoutToolCode = args[0];
        // Set entered date
        String checkoutDate = args[1];
        // Set integer value of rental days parameter
        int rentalDays = Integer.parseInt((args[2]));
        // Set integer value of discount percentage parameter
        int checkoutDiscount = Integer.parseInt((args[3]));
        
        boolean skipRental = false; 
        // Rental days less than one are invalid. Request a valid number.
        if (rentalDays < 1) {
            System.out.println("Please enter a number of rental days greater than zero.");
            skipRental = true;
        }
        // Discount percentages outside the range of 0-100 are invalid. Request a valid number.
        if (checkoutDiscount < 0 || checkoutDiscount > 100) {
            System.out.println("Please enter a discount percentage between 0 and 100.");
            skipRental = true;
        }
        
        // Skip the rental agreement process if the entered rental days or discount percentage is invalid.
        if (!skipRental) {
            RentalDetails rentalAgreement = new RentalDetails(checkoutToolCode, checkoutDate, rentalDays, checkoutDiscount);

            //Print rental agreement information
            System.out.println("Tool code:\t\t"+rentalAgreement.rentedTool.code);
            System.out.println("Tool type:\t\t"+rentalAgreement.rentedTool.type);
            System.out.println("Tool brand:\t\t"+rentalAgreement.rentedTool.brand);
            System.out.println("Rental Days:\t\t"+rentalAgreement.rentalDays);
            System.out.println("Checkout date:\t\t"+rentalAgreement.outputCheckout);
            System.out.println("Due date:\t\t"+rentalAgreement.outputDueDate);
            System.out.println("Daily Rental charge:\t"+rentalAgreement.outputDailyCharge);
            System.out.println("Charge Days:\t\t"+rentalAgreement.chargeDays);
            System.out.println("Pre-discount charge:\t"+rentalAgreement.outputChargeBeforeDiscount);
            System.out.println("Discount percent:\t"+rentalAgreement.outputDiscount);
            System.out.println("Discount Amount:\t"+rentalAgreement.outputDiscountAmount);
            System.out.println("Final Charge:\t\t"+rentalAgreement.outputChargeAfterDiscount);
        }
    }
    
}
