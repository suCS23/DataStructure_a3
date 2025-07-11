
package cs1_2339863_a3;

public class Queue <T>{
    
    private node <T> front;
    private node <T> rear;

    public Queue(){
    }
    
    public boolean isEmpty(){
        return front == null; 
    }
    
    public void enQueue(T data){      
        if(isEmpty()){
            front = new node<> (data,front);
            rear = front;  
        }else{
            rear.next = new node<> (data,rear.next);
            rear = rear.next;
        }
    }
    
    public T deQueue(){       
        if(!isEmpty()){
            T temp = front.data;
            front = front.next;
            return temp;    
        }else 
            if(front.next == null){
                front = front.next;
                rear = rear.next;
            }   
    return null;
    }
    
    public node <T> peek(){
        return (isEmpty())?null:front;
    }
    
    public void clear(){
        while(!isEmpty()){
            deQueue();
        }
        
    }
    
    
}
