package cpcs204_a3

public class node <T>{
    
    protected T data;
    protected node <T> next;
    
    public node(T data, node <T> next){
        this.data = data;
        this.next = next;
    }
     
    public node(T data){
        this(data, null);
    }
    
}
