package zero_waste;

/**
 *
 * @author Wasi
 */

class VolunteerOfferHelpInfo {
    
    private int event_id;
    private String phone,email,username,event_name,event_for,event_time,event_location;
 
public  VolunteerOfferHelpInfo(String username,String email, String phone,int event_id,String event_name, String event_time,String event_location,String event_for ) {
        
        this.event_id=event_id;
        this.event_name = event_name;
        this.event_for = event_for;  
        this.event_time= event_time;
        this.event_location = event_location;
        this.username=username;
        this.email=email;
        this.phone=phone;
        
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
   public int getevent_id() {
        return event_id;
    }   
    public String getevent_name() {
        return event_name;
    }
    public String getevent_for() {
        return event_for;
    }
 public String getevent_time() {
        return event_time;
    }
 public String getevent_location() {
        return event_location;
    }  
}

    
    
   
