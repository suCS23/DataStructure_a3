
package cs1_2339863_a3;

class Ticket {
    
    private Passenger passenger;
    private Train train;

    public Ticket(Passenger passenger, Train train) {
        this.passenger = passenger;
        this.train = train;
    }
    
    public Passenger getPassenger(){
        
    return passenger;
    }
    
    public Train getTrain(){
        
    return train;
    }

    @Override
    public String toString() {
        return passenger.toString() +"      | "+ train.getTrainID()+"        |";
    }  
    
}
