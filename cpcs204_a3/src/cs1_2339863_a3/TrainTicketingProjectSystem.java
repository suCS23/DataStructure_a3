
package cs1_2339863_a3;

import java.io.*;

public class TrainTicketingProjectSystem {
    
    private Queue <Passenger> passengerQ;
    private Stack <Ticket> confirmedS;
    private Queue <Ticket> waitingQ;
    private Train train;
    PrintWriter pw;

    public TrainTicketingProjectSystem() throws FileNotFoundException {
        
        this.passengerQ = new Queue<> ();
        this.confirmedS = new Stack <> ();
        this.waitingQ = new Queue <> ();
        pw = new PrintWriter(new File("C:\\Users\\PC\\OneDrive\\Desktop\\FCIT23\\3rd term\\CPCS204\\ASSINGMENTS\\3\\CPCS204A3output.txt"));
    }
    
    public void addTrain(String trainID, int capacity){
        
        train = new Train(trainID, capacity);
        pw.println("Train "+trainID+" with capacity "+capacity+" has been added.");  
        
    }
    
    public void addPassanger(String passangerID, String name){
        
        passengerQ.enQueue(new Passenger(passangerID, name));
        pw.println("Passenger "+name+" (ID: "+passangerID+")"+" has been added to the system.");
        
    }
    
    public void bookSeat(String passengerID){

        Passenger passenger = findPassengerByID(passengerID);
        String ans = train.bookSeat(passenger);
        pw.println(ans);
        
        if(ans.matches(".*confirmed.*"))
            confirmedS.push(new Ticket(passenger, train));
        else
            waitingQ.enQueue(new Ticket(passenger, train));  
    }
    
    public void cancleBooking(String passengerID){
        
        Passenger passenger = findPassengerByID(passengerID);
        String ans = train.cancelSeat(passenger);
        pw.println(ans);
        
        bookSeat(removePassengerFromConfirmed(passenger).getPassenger().getPassengerID());
    }
 
    public void showWaitingTickets(){
  
        pw.println("------------------WAITING PASSENGER--------------------\n"
                 + "| Passenger ID    | Name            | Train ID        |\n"
                 + "| --------------- | --------------- | --------------- |");
        
        node <Ticket> ptr = waitingQ.peek();
        
        while (ptr != null){
            
            pw.println(ptr.data.toString());
            
            ptr = ptr.next;
        }         
    }
        
    public void showConfirmedTickets(){
        
        pw.println("------------------CONFIRMED PASSENGER------------------\n"
                 + "| Passenger ID    | Name            | Train ID        |\n"
                 + "| --------------- | --------------- | --------------- |");
        
        node <Ticket> ptr = confirmedS.peek();
        
        while (ptr != null){
            
            pw.println(ptr.data.toString());
            
            ptr = ptr.next;
        }
    }
    
    public Passenger findPassengerByID(String passengerID){
        
        node <Passenger> ptr = passengerQ.peek();
        
        while (ptr != null){
         
            if(ptr.data.getPassengerID().matches(".*"+passengerID+".*"))
                return ptr.data;
            
        ptr = ptr.next;
        }
        return null;
    }
    
    public Ticket removePassengerFromConfirmed(Passenger passenger){
        
        node <Ticket> ptr = confirmedS.peek();
        
        while (ptr.next != null){
            
            if(ptr.data.getPassenger().equals(passenger))
                ptr.next = ptr.next.next;
            
                
            if(ptr.next.data.getPassenger().equals(passenger))
                ptr.next = ptr.next.next;
             
            ptr = ptr.next;
        }
        
        if(!waitingQ.isEmpty()){
            return waitingQ.deQueue();
        }
        return null;
    }

    public void closePW(){
        pw.flush();
        pw.close();
    }
    
}



