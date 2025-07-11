
package cs1_2339863_a3;

import java.util.*;
import java.io.*;

public class bookingMainPage{
    
    public static void main(String[] args) throws Exception{
        
        Scanner in = new Scanner(new File("C:\\Users\\PC\\OneDrive\\Desktop\\FCIT23\\3rd term\\CPCS204\\ASSINGMENTS\\3\\CPCS204A3input.txt"));
        
        TrainTicketingProjectSystem TTPS = new TrainTicketingProjectSystem();
        
        while(in.hasNext()){
            
            String line = in.next();
            
            switch(line){
                case ("add_train"): TTPS.addTrain(in.next(), in.nextInt()); break; 
                
                case ("add_passenger"): TTPS.addPassanger(in.next(), in.next()); break; 
                
                case ("book"): TTPS.bookSeat(in.next()); break; 
                
                case ("cancel"): TTPS.cancleBooking(in.next()); break; 
                
                case ("show_waiting"): TTPS.showWaitingTickets(); break; 
                
                case ("show_confirmed"): TTPS.showConfirmedTickets(); break;
                
                default : System.out.println("Something is wrong with the input files!!");
            }
            
            if(in.hasNextLine())
                line = in.nextLine();
        }
        
        in.close();
        TTPS.closePW();
    }
    
}
