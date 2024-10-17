/*Node class
Defines a Node object to build a Linked List
*/
public class NHLStats<T>{
	private T data;
	private NHLStats<T> next;
    
	public NHLStats(T data, NHLStats<T> next){
		this.data = data;
		this.next = next;
	}
    
	public T getData(){
		return data;
	}
    
	public NHLStats<T> getNext(){
		return this.next;
	}
    
	public void setData(T data){
		this.data = data;
	}
    
	public void setNext(NHLStats<T> next){
		this.next = next;
	}
}
