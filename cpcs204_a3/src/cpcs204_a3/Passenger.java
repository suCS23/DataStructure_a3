
package cpcs204_a3

class Passenger {
    
    private String passengerID;
    private String name;

    public Passenger(String passengerID, String name) {
        this.passengerID = passengerID;
        this.name = name;
    }

    public String getPassengerID() {
        return passengerID;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String str = String.format("| %s            | %-10s", passengerID, name);
        return str;
    }
    
    
}
