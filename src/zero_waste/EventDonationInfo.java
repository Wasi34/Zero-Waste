package zero_waste;

/**
 *
 * @author Wasi
 */

class EventDonationInfo {
    
    private int donation_id;
    private String username,email,phone,location,ngo,food_type,date_of_cooking,quantity;
 
public  EventDonationInfo(int donation_id,String username,String email, String phone,String location,String ngo,String food_type,String date_of_cooking,String quantity) {
        
        this.donation_id=donation_id;
        this.username=username;
        this.email = email;
        this.phone = phone; 
        this.location=location;
        this.ngo=ngo;
        this.food_type=food_type;
        this.date_of_cooking=date_of_cooking;
        this.quantity=quantity;
        
        
    }
public int getdonation_id() {
        return donation_id;
    } 
 public String getusername() {
        return username;
    } 
  public String getemail() {
        return email;
    } 
    public String getphone() {
        return phone;
    } 

 public String getlocation() {
        return location;
    }  
  public String getngo() {
        return ngo;
    } 
  public String getfood_type() {
        return food_type;
    }  
  public String getdate_of_cooking() {
        return date_of_cooking;
    } 
  public String getquantity() {
        return quantity;
    }  
}

    
    
   
