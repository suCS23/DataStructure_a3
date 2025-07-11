
package cs1_2339863_a3;

public class Stack <T>{
    
    private node <T> top;

    public Stack() {
    }
    
    public boolean isEmpty(){
        return top == null;
    }
    
    public void push(T data){
        this.top = new node(data, top);
    }
    
    public T pop(){
        T temp;
 
        if(!isEmpty()){
           temp = top.data;
           top = top.next;
           return temp;     
        }      
    return null;
    }
    
    public node <T> peek(){
        
        if(!isEmpty())
           return top;    
        
    return null;  
    }
    
    
    
    
}
