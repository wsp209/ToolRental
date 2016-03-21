package ToolRental;

import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author W
 */
public class RentalDetailsTest {
    
    String[] codes = {"LADW","CHNS","JAKD","JAKR","JAKR"};
    String[] types = {"Ladder","Chainsaw","Jackhammer","Jackhammer","Jackhammer"};
    String[] brands = {"Werner","Stihl","DeWalt","Ridgid","Ridgid"};
    int[] rentalDays = {5,5,6,4,5};
    String[] outputCheckouts = {"9/3/15","7/2/15","9/3/15","7/2/20","9/3/15"};
    String[] outputDueDates = {"9/8/15","7/7/15","9/9/15","7/6/20","9/8/15"};
    String[] outputDailyCharges = {"$1.99","$1.49","$2.99","$2.99","$2.99"};
    int[] chargeDays = {5,3,3,1,2};
    String[] outputChargeBeforeDiscount = {"$9.95","$4.47","$8.97","$2.99","$5.98"};
    int[] outputDiscount = {10,25,0,50,101};
    String[] outputDiscountAmount = {"$1.00","$1.12","$0.00","$1.50",""};
    String[] outputChargeAfterDiscount = {"$8.95","$3.35","$8.97","$1.49",""};
    
    /**
     * Test of setRentalDetails method, of class RentalDetails.
     */
    @Test
    public void testSetRentalDetails1() throws Exception {
        System.out.println("setRentalDetails1");
        String inputToolCode = codes[0];
        String inputCheckoutDate = outputCheckouts[0];
        int inputRentalDays = rentalDays[0];
        int discount = outputDiscount[0];
        RentalDetails instance = new RentalDetails(inputToolCode, inputCheckoutDate, inputRentalDays, discount);
        RentalDetails expResult = null;
        String getToolCode =  instance.rentedTool.code;
        String getToolType = instance.rentedTool.type;
        String getToolBrand = instance.rentedTool.brand;
        int getRentalDays = instance.rentalDays;
        String getCheckoutDate = instance.outputCheckout;
        String getDueDate = instance.outputDueDate;
        String getDailyCharge = instance.outputDailyCharge;
        int getChargeDays = instance.chargeDays;
        String getChargeBeforeDiscount = instance.outputChargeBeforeDiscount;
        String getOutputDiscount = instance.outputDiscount;
        String getDiscountAmount = instance.outputDiscountAmount;
        String getChargeAfterDiscount = instance.outputChargeAfterDiscount;

        assertEquals(getToolCode, inputToolCode);
        assertEquals(getToolType, types[0]);
        assertEquals(getToolBrand, brands[0]);
        assertEquals(getRentalDays, rentalDays[0]);
        assertEquals(getCheckoutDate, inputCheckoutDate);
        assertEquals(getDueDate, outputDueDates[0]);
        assertEquals(getDailyCharge, outputDailyCharges[0]);
        assertEquals(getChargeDays, chargeDays[0]);
        assertEquals(getChargeBeforeDiscount, outputChargeBeforeDiscount[0]);
        assertEquals(getOutputDiscount, discount+"%");
        assertEquals(getDiscountAmount, outputDiscountAmount[0]);
        assertEquals(getChargeAfterDiscount, outputChargeAfterDiscount[0]);        
    }
    
    
    @Test
    public void testSetRentalDetails2() throws Exception {
        System.out.println("setRentalDetails2");
        String inputToolCode = codes[1];
        String inputCheckoutDate = outputCheckouts[1];
        int inputRentalDays = rentalDays[1];
        int discount = outputDiscount[1];
        RentalDetails instance = new RentalDetails(inputToolCode, inputCheckoutDate, inputRentalDays, discount);
        RentalDetails expResult = null;
        String getToolCode =  instance.rentedTool.code;
        String getToolType = instance.rentedTool.type;
        String getToolBrand = instance.rentedTool.brand;
        int getRentalDays = instance.rentalDays;
        String getCheckoutDate = instance.outputCheckout;
        String getDueDate = instance.outputDueDate;
        String getDailyCharge = instance.outputDailyCharge;
        int getChargeDays = instance.chargeDays;
        String getChargeBeforeDiscount = instance.outputChargeBeforeDiscount;
        String getOutputDiscount = instance.outputDiscount;
        String getDiscountAmount = instance.outputDiscountAmount;
        String getChargeAfterDiscount = instance.outputChargeAfterDiscount;

        assertEquals(getToolCode, inputToolCode);
        assertEquals(getToolType, types[1]);
        assertEquals(getToolBrand, brands[1]);
        assertEquals(getRentalDays, rentalDays[1]);
        assertEquals(getCheckoutDate, inputCheckoutDate);
        assertEquals(getDueDate, outputDueDates[1]);
        assertEquals(getDailyCharge, outputDailyCharges[1]);
        assertEquals(getChargeDays, chargeDays[1]);
        assertEquals(getChargeBeforeDiscount, outputChargeBeforeDiscount[1]);
        assertEquals(getOutputDiscount, discount+"%");
        assertEquals(getDiscountAmount, outputDiscountAmount[1]);
        assertEquals(getChargeAfterDiscount, outputChargeAfterDiscount[1]);        
    }
    
    
    @Test
    public void testSetRentalDetails3() throws Exception {
        System.out.println("setRentalDetails3");
        String inputToolCode = codes[2];
        String inputCheckoutDate = outputCheckouts[2];
        int inputRentalDays = rentalDays[2];
        int discount = outputDiscount[2];
        RentalDetails instance = new RentalDetails(inputToolCode, inputCheckoutDate, inputRentalDays, discount);
        RentalDetails expResult = null;
        String getToolCode =  instance.rentedTool.code;
        String getToolType = instance.rentedTool.type;
        String getToolBrand = instance.rentedTool.brand;
        int getRentalDays = instance.rentalDays;
        String getCheckoutDate = instance.outputCheckout;
        String getDueDate = instance.outputDueDate;
        String getDailyCharge = instance.outputDailyCharge;
        int getChargeDays = instance.chargeDays;
        String getChargeBeforeDiscount = instance.outputChargeBeforeDiscount;
        String getOutputDiscount = instance.outputDiscount;
        String getDiscountAmount = instance.outputDiscountAmount;
        String getChargeAfterDiscount = instance.outputChargeAfterDiscount;

        assertEquals(getToolCode, inputToolCode);
        assertEquals(getToolType, types[2]);
        assertEquals(getToolBrand, brands[2]);
        assertEquals(getRentalDays, rentalDays[2]);
        assertEquals(getCheckoutDate, inputCheckoutDate);
        assertEquals(getDueDate, outputDueDates[2]);
        assertEquals(getDailyCharge, outputDailyCharges[2]);
        assertEquals(getChargeDays, chargeDays[2]);
        assertEquals(getChargeBeforeDiscount, outputChargeBeforeDiscount[2]);
        assertEquals(getOutputDiscount, discount+"%");
        assertEquals(getDiscountAmount, outputDiscountAmount[2]);
        assertEquals(getChargeAfterDiscount, outputChargeAfterDiscount[2]);        
    }
    
    
    @Test
    public void testSetRentalDetails4() throws Exception {
        System.out.println("setRentalDetails4");
        String inputToolCode = codes[3];
        String inputCheckoutDate = outputCheckouts[3];
        int inputRentalDays = rentalDays[3];
        int discount = outputDiscount[3];
        RentalDetails instance = new RentalDetails(inputToolCode, inputCheckoutDate, inputRentalDays, discount);
        RentalDetails expResult = null;
        String getToolCode =  instance.rentedTool.code;
        String getToolType = instance.rentedTool.type;
        String getToolBrand = instance.rentedTool.brand;
        int getRentalDays = instance.rentalDays;
        String getCheckoutDate = instance.outputCheckout;
        String getDueDate = instance.outputDueDate;
        String getDailyCharge = instance.outputDailyCharge;
        int getChargeDays = instance.chargeDays;
        String getChargeBeforeDiscount = instance.outputChargeBeforeDiscount;
        String getOutputDiscount = instance.outputDiscount;
        String getDiscountAmount = instance.outputDiscountAmount;
        String getChargeAfterDiscount = instance.outputChargeAfterDiscount;
       
        assertEquals(getToolCode, inputToolCode);
        assertEquals(getToolType, types[3]);
        assertEquals(getToolBrand, brands[3]);
        assertEquals(getRentalDays, rentalDays[3]);
        assertEquals(getCheckoutDate, inputCheckoutDate);
        assertEquals(getDueDate, outputDueDates[3]);
        assertEquals(getDailyCharge, outputDailyCharges[3]);
        assertEquals(getChargeDays, chargeDays[3]);
        assertEquals(getChargeBeforeDiscount, outputChargeBeforeDiscount[3]);
        assertEquals(getOutputDiscount, discount+"%");
        assertEquals(getDiscountAmount, outputDiscountAmount[3]);
        assertEquals(getChargeAfterDiscount, outputChargeAfterDiscount[3]);        
    }
    
    
    @Test
    public void testSetRentalDetails5() throws Exception {
        System.out.println("setRentalDetails5");
        String inputToolCode = codes[4];
        String inputCheckoutDate = outputCheckouts[4];
        int inputRentalDays = rentalDays[4];
        int discount = outputDiscount[4];
        RentalDetails instance = new RentalDetails(inputToolCode, inputCheckoutDate, inputRentalDays, discount);
        RentalDetails expResult = null;
        String getToolCode =  instance.rentedTool.code;
        String getToolType = instance.rentedTool.type;
        String getToolBrand = instance.rentedTool.brand;
        int getRentalDays = instance.rentalDays;
        String getCheckoutDate = instance.outputCheckout;
        String getDueDate = instance.outputDueDate;
        String getDailyCharge = instance.outputDailyCharge;
        int getChargeDays = instance.chargeDays;
        String getChargeBeforeDiscount = instance.outputChargeBeforeDiscount;
        String getOutputDiscount = instance.outputDiscount;
        String getDiscountAmount = instance.outputDiscountAmount;
        String getChargeAfterDiscount = instance.outputChargeAfterDiscount;

        assertEquals(getToolCode, inputToolCode);
        assertEquals(getToolType, types[4]);
        assertEquals(getToolBrand, brands[4]);
        assertEquals(getRentalDays, rentalDays[4]);
        assertEquals(getCheckoutDate, inputCheckoutDate);
        assertEquals(getDueDate, outputDueDates[4]);
        assertEquals(getDailyCharge, outputDailyCharges[4]);
        assertEquals(getChargeDays, chargeDays[4]);
        assertEquals(getChargeBeforeDiscount, outputChargeBeforeDiscount[4]);
        assertEquals(getOutputDiscount, discount+"%");
        assertEquals(getDiscountAmount, outputDiscountAmount[4]);
        assertEquals(getChargeAfterDiscount, outputChargeAfterDiscount[4]);        
    }
    
}
