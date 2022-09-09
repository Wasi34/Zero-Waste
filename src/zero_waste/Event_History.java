package zero_waste;


class Event_History {
    
    private int event_id,userid;
    private String event_name,event_for,food_type,date_time,quantity,location,name;
 

    public Event_History(int event_id,String event_name, String event_for ,String food_type,String date_time,String location,String quantity) {
        this.event_id=event_id;
        this.event_name = event_name;
        this.event_for = event_for;  
        this.food_type = food_type;
        this.date_time= date_time;
        this.location = location;
        this.quantity=quantity;
        
        
    
    }
   public int getevent_id() {
        return event_id;
    }   
public String getname() {
        return name;
    }
    public String getevent_name() {
        return event_name;
    }
    public String getevent_for() {
        return event_for;
    }
 public String getfood_type() {
        return food_type;
    }
 public String getdate_time() {
        return date_time;
    }
 public String getlocation() {
        return location;
    }   
 public String getquantity() {
        return quantity;
    }

}

    
    
   
