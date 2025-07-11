
package cpcs204_a3

public class Train {
    
    private String trainID;
    private int capacity;
    private int availableSeats;

    public Train(String trainID, int capacity) {
        this.trainID = trainID;
        this.capacity = capacity;
        this.availableSeats = capacity;
    }

    public String getTrainID() {
        return trainID;
    }
    
    public String bookSeat(Passenger passenger){
        
        if(availableSeats>0){
            availableSeats--;     
        }     
        else
            return "No seats for "+passenger.getName()+" (ID: "+passenger.getPassengerID()+"), added to waiting list.";
    return "Booking confirmed for Passenger "+passenger.getName()+" (ID: "+passenger.getPassengerID()+").";
    }
    
    public String cancelSeat(Passenger passenger){
        
        if(availableSeats == capacity){
            return "There are no reservations!!";     
        }     
        else
            availableSeats++;
  
    return "Booking cancelled for Passenger "+passenger.getName()+" (ID: "+passenger.getPassengerID()+").";
    }   
}
