package ToolRental;

/**
 * @author Will Pedicone
 */

public class Tool {
    String type;
    String brand;
    String code;        
    
    public Tool (String inputCode){
        code = inputCode;
        getBrandAndType();
    }        
    
    //Determine charge amount for tool type
    public float getDailyCharge (){
        float dailyChargeAmount = 0;
        
        switch (type) {
            case "Jackhammer":
                dailyChargeAmount = 2.99f;
                break;
            case "Chainsaw":
                dailyChargeAmount = 1.49f;   
                break;
            case "Ladder":
                dailyChargeAmount = 1.99f;
                break;
            default:
                break;
        }
        return dailyChargeAmount;
    } 
   
    
    //Determine if tool charges for holidays
    public boolean chargesForHolidays (){
        boolean holidayCharge = false;
        
        if (type.equals("Chainsaw") || type.equals("Ladder")){
            holidayCharge = true;
        }

        return holidayCharge;
    } 
    
    
     //Determine if tool charges for weekends
    public boolean chargesForWeekends (){
        boolean weekendsCharge = false;
        
        if (type.equals("Ladder")){
            weekendsCharge = true;
        }

        return weekendsCharge;
    } 
    
    //Determine tool's brand and type based on code
    private void getBrandAndType (){        
        switch (code) {
            case "LADW":
                type = "Ladder";
                brand = "Werner";
                break;
            case "CHNS":
                type = "Chainsaw";
                brand = "Stihl";
                break;
            case "JAKR":
                type = "Jackhammer";
                brand = "Ridgid";
                break;
            case "JAKD":
                type = "Jackhammer";
                brand = "DeWalt";
                break;
            default:
                break;
        }
    }     
}
